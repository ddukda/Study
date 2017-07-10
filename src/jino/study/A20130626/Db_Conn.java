package jino.study.A20130626;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Db_Conn {

	public Db_Conn(){
		
	}
	
	public Connection getConnection() {
		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@211.115.75.243:1521:FRDB";

			String user = "bizring";
			String pwd = "bizringappuser";

			conn = DriverManager.getConnection(url, user, pwd);

		} catch (Exception e) {
			System.out.println("getConnection : " + e.toString());
		}
		
		
		return conn;
	}

	
	
	public ArrayList<TestModel> testList(String szPage) throws ClassNotFoundException{
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement   pstmt   = null; 

		ArrayList<TestModel> list = new ArrayList<TestModel>();
		Db_Conn db = new Db_Conn();
		
		
		try {

			String sql = "select id, type, name, object, data_name, data_value from tbl_bizring_tdd where id between ? and ?";
					
			conn  = db.getConnection(); 
        	pstmt = conn.prepareStatement(sql);
        	pstmt.setString(1, szPage);
        	pstmt.setString(2, szPage);   
        	rs    = pstmt.executeQuery(); 
        	
			
			while (rs.next()) {
				TestModel tm = new TestModel();
				tm.setId(rs.getString("id"));
				tm.setType(rs.getString("type"));
				tm.setName(rs.getString("name"));
				tm.setObject(rs.getString("object"));
				tm.setData_name(rs.getString("data_name"));
				tm.setData_value(rs.getString("data_value"));

				list.add(tm);
				
			}
		} catch (SQLException e) {
			System.out.println("testList() : " + e.toString());
		} finally {
			try {
				rs.close();
			} catch (Exception e) {
			}
			try {
				pstmt.close();
			} catch (Exception e) {
			}
			try {
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
			}

		}
		
		return list;
	}
	
	
}
