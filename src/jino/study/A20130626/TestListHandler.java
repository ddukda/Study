package jino.study.A20130626;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TestListHandler {
	public Connection getConnection() {
		// TODO Auto-generated method stub
		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@211.115.75.243:1521:FRDB";

			String user = "bizring";
			String pwd = "bizringappuser";

			conn = DriverManager.getConnection(url, user, pwd);

		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("접속완료");
		return conn;
	}
	
	
	public List<TestModel> testList(){
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		List<TestModel> list = new ArrayList<TestModel>();
//		TestListHandler db = new TestListHandler();
		
		try {

			String sql = "select id, type, name, object, data_name, data_value from tbl_bizring_tdd";
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				// TODO 자동 생성된 catch 블록
				e.printStackTrace();
			}
			String url = "jdbc:oracle:thin:@211.115.75.243:1521:FRDB";

			String user = "bizring";
			String pwd = "bizringappuser";

			conn = DriverManager.getConnection(url, user, pwd);
			
//			conn = db.getConnection();

			st = conn.createStatement();
			
			rs = st.executeQuery(sql);
			
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
		} finally {
			try {
				rs.close();
			} catch (Exception e) {
			}
			try {
				st.close();
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
		
		for(int i=0; i < list.size(); i++)
			printList(list, i);
		
		return list;
	}
	
	private static void printList(List<TestModel> list, int num) {
		// TODO 자동 생성된 메소드 스텁
		
		TestModel getTm = new TestModel();
		getTm = (TestModel) list.get(num);
		System.out.println(getTm.getId() + "\t" + getTm.getType() + "\t"
				+ getTm.getName() + "\t" + getTm.getObject() + "\t"
				+ getTm.getData_name() + "\t" + getTm.getData_value()

		);
		
	}
}
