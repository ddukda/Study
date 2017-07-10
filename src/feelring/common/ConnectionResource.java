package feelring.common;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
*
* <p>Title: Connection ���� <br></p>
*
* <p>Description: ConnectionResource Ŭ������ �����ͺ��̽� Ŀ�ؼ� Ǯ ������ �����Ѵ� <br></p>
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
     * �����ͺ��̽� ������ ���� 
     * @return Ŀ�ؼ� ��ü 
     * @throws SQLException
     */
    public Connection getConnection() throws SQLException {
        if ( conn == null ) throw new SQLException("Connection is NOT avaiable !!");
        return conn;
    }
    
    /**
     * �����ͺ��̽� ������ ���� 
     *
     */
    public void freeConnection(){
        if ( conn != null ) try { conn.close(); }catch(SQLException e){}
        conn = null;
    }
}
