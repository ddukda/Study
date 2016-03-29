<!DOCTYPE html>

<html lang="ko">
<head>
<meta charset="utf-8">
<title>test</title>
<%@ page import="java.util.*, java.io.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="jino.study.A20130626.*" %>
<script src="../common/googleAnalytics.js"></script></head>
<body>

<% 
response.setContentType("text/html;charset=euc-kr");
// handle.testList();
// String test = handle.listTest();
List<TestModel> list = new ArrayList<TestModel>();

Connection conn = null;
Statement st = null;
ResultSet rs = null;

Db_Conn db = new Db_Conn();


try {

	String sql = "select id, type, name, object, data_name, data_value from tbl_bizring_tdd";

	conn = db.getConnection();
	st = conn.createStatement();
	rs = st.executeQuery(sql);
	int i = 0;
	while (rs.next()) {
		TestModel tm = new TestModel();
		tm.setId(rs.getString("id"));
		tm.setType(rs.getString("type"));
		tm.setName(rs.getString("name"));
		tm.setObject(rs.getString("object"));
		tm.setData_name(rs.getString("data_name"));
		tm.setData_value(rs.getString("data_value"));

		list.add(tm);
		
//		printList(list, i++);
	}
} catch (SQLException e) {
} finally {
	try {rs.close();	} catch (Exception e) {	}
	try {st.close();	} catch (Exception e) {	}
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

%>
<%!
private static void printList(List<TestModel> list, int num) {
	
	TestModel getTm = new TestModel();
	getTm = (TestModel) list.get(num);
	System.out.println(getTm.getId() + "\t" + getTm.getType() + "\t"
			+ getTm.getName() + "\t" + getTm.getObject() + "\t"
			+ getTm.getData_name() + "\t" + getTm.getData_value()

	);
	
}


%>
	<table style="border: 2px; border-color: black; width: 800px">

			<tr>      </tr>          	  

	</table>
</body>
</html>