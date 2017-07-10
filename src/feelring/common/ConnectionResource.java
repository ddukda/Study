package feelring.common;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
*
* <p>Title: Connection 관련 <br></p>
*
* <p>Description: ConnectionResource 클래스는 데이터베이스 커넥션 풀 연결을 제공한다 <br></p>
*
* <p>Copyright: Copyright (c) 2008</p>
*
* <p>Company: Wincom </p>
*
* @version 1.0
*/
public class ConnectionResource
{
    private static final String datasource = "jdbc/FRDB";

    private static DataSource ds = null;

    private java.sql.Connection conn = null;

    public ConnectionResource() throws Exception {
        synchronized ( ConnectionResource.class ) {
            if ( ds == null ) {
                Context env = (Context) new InitialContext().lookup("java:comp/env");
                ds = (DataSource) env.lookup(datasource);
            }
        }    
        conn =  ds.getConnection();
    }
    
    /**
     * 데이터베이스 연결을 제공 
     * @return 커넥션 객체 
     * @throws SQLException
     */
    public Connection getConnection() throws SQLException {
        if ( conn == null ) throw new SQLException("Connection is NOT avaiable !!");
        return conn;
    }
    
    /**
     * 데이터베이스 연결을 해제 
     *
     */
    public void freeConnection(){
        if ( conn != null ) try { conn.close(); }catch(SQLException e){}
        conn = null;
    }
}
