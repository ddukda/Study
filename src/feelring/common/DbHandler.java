package feelring.common;

import java.sql.*;
import java.util.ArrayList;

public class DbHandler {

	public ArrayList<DbItem> list(int nPage, int nPageSize) {
		
		int nStartPage      	= 0;
        int nEndPage        	= 0;
       
		int nTotRow = getCnt();
		
        if(nTotRow == 0) {
            nStartPage = 1;
            nEndPage = 1;
        }else {
            nStartPage = (nPage * nPageSize) + 1;
            nEndPage   = (nPage * nPageSize) +  nPageSize;
        }
        
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<DbItem> arrayitem = new ArrayList<DbItem>();
		OracleConnectionManager oramgr = new OracleConnectionManager();
		StringBuffer szQuery	= new StringBuffer();
		int nId = 0;
	    String szType = "";
	    String szName = "";
	    String szObject = "";
	    String szDataName = "";
	    String szDataValue = "";
	    String szRegDate = "";
		
		try {
			szQuery.append("\n   SELECT     ");
			szQuery.append("\n   		ID, TYPE, NAME, OBJECT, DATA_NAME, DATA_VALUE,    ");
			szQuery.append("\n   		TO_CHAR(REG_DATE, 'YYYY-MM-DD') REG_DATE    ");
			szQuery.append("\n   FROM    ");
			szQuery.append("\n   (  SELECT ROW_NUMBER() OVER (  ");
			szQuery.append("\n 		ORDER BY ID ASC)   "); 
			szQuery.append("\n      RNUM, ID, TYPE, NAME, OBJECT, DATA_NAME, DATA_VALUE, REG_DATE  ");
			szQuery.append("\n      FROM TBL_BIZRING_TDD     ");
			szQuery.append("\n   )    ");
			szQuery.append("\n   WHERE RNUM BETWEEN ? AND ?  ");
			
			conn = oramgr.getConnectionBiz();
			pstmt = conn.prepareStatement(szQuery.toString());
			
			pstmt.setInt(1, nStartPage);
			pstmt.setInt(2, nEndPage);
			
			rs = pstmt.executeQuery();
			System.out.println("nStartPage : "  + nStartPage);
			System.out.println("nPageSize : "  + nPageSize);
			while (rs.next()) {
				
				DbItem item = new DbItem();
				nId = rs.getInt("ID");
	       	  	szType = rs.getString("TYPE");
	       	    szName = rs.getString("NAME");
	       	    szObject =rs.getString("OBJECT");
	       	    szDataName = rs.getString("DATA_NAME");
	       	    szDataValue = rs.getString("DATA_VALUE");
	       	    szRegDate = rs.getString("REG_DATE");
	        	
	        	item.setNId(nId);
	        	item.setSzType(szType);
	        	item.setSzName(szName);
	        	item.setSzObject(szObject);
	        	item.setSzDataName(szDataName);
	        	item.setSzDataValue(szDataValue);
	        	item.setSzRegDate(szRegDate);
	        	
	        	arrayitem.add(item);
	        	
	        	
			
			}
		} catch (SQLException sqle) {
			System.out.println(sqle);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {rs.close();} catch (Exception e) {}
			try {pstmt.close();} catch (Exception e) {}
			oramgr.freeConnection(conn);
		}
		
		return arrayitem;
	}
	
	public int getCnt() {
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String szQuery = "";
		OracleConnectionManager oramgr = new OracleConnectionManager();
		int nTotCnt = 0; 
		
		try {
			szQuery = " SELECT count(*) FROM TBL_BIZRING_TDD ";

			conn = oramgr.getConnectionBiz();
			pstmt = conn.prepareStatement(szQuery);
			rs = pstmt.executeQuery();
			
			if (rs.next())
				nTotCnt = rs.getInt(1);
			
		} catch (SQLException sqle) {
			System.out.println(sqle);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {rs.close();} catch (Exception e) {}
			try {pstmt.close();} catch (Exception e) {}
			oramgr.freeConnection(conn);
		}
		
		return nTotCnt;
	}
	

}
