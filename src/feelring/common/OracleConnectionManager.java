package feelring.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class OracleConnectionManager {	

	public OracleConnectionManager() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
			System.out.println("1111" + e.toString());
		}
	}
	
	public Connection getConnectionBiz() throws java.sql.SQLException {
	    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@211.115.75.243:1521:FRDB", "bizring", "bizringappuser");
	    con.setAutoCommit(false);
	    return con;
	}
	
	public Connection getConnectionFeel() throws java.sql.SQLException {
	    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@211.115.75.243:1521:FRDB", "onion", "oniondb");
	    con.setAutoCommit(false);
	    return con;
	}
	
	public void freeConnection(Connection conn) {
		try {
		    if(conn != null) {
			    conn.close();
			    conn = null;
            }			    
        } catch(SQLException e) { 
        	System.out.println("freeConnection SQLException : " + e.toString());
        }
	}
}
			
//
//package feelring.common;
//
//import java.sql.*;
//import javax.naming.*;
//import javax.sql.*;
//
///**
//*
//* <p>Title: OracleConnectionManager <br></p>
//*
//* <p>Description: DB 연결의 효율성을 위해 작성	 <br></p>
//*
//* <p>Copyright: Copyright (c) 2008</p>
//*
//* <p>Company: Wincom </p>
//*
//* @version 1.0
//*/
//public class OracleConnectionManager {	
//	private DataSource ds   = null;
//	
//	
//	//public static int nPoolCnt = 0;	
//	
//	public OracleConnectionManager() {	    
//        Context ic = null;
//        
//		try {
//            ic = new InitialContext();
//            ds = (DataSource) ic.lookup("java:comp/env/jdbc/FRDB");
//		}
//		catch(javax.naming.NamingException ne) {
//		    ne.printStackTrace();
//		}
//	}
//	
//	/**
//	 * 데이터베이스 연결을 제공 
//	 * @return Connection 커넥션 객체 
//	 * @throws java.sql.SQLException
//	 */
//	public Connection getConnection() throws java.sql.SQLException {
//	    //nPoolCnt ++;
//		return (Connection)ds.getConnection();
//	}
//	
//	/**
//	 * 데이터베이스 연결을 해제 
//	 * @param conn
//	 */
//	public void freeConnection(Connection conn) {
//		try {
//		    if(conn != null) {
//		        //nPoolCnt --;
//			    conn.close();
//			    conn = null;
//            }			    
//        } catch(SQLException e) { }
//	}
//}
//			
