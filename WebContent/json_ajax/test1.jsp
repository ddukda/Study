<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.parser.ParseException"%>
<%@page import="java.net.URLEncoder, java.util.*, feelring.common.*" %>
<%@page import="java.sql.*, java.util.ArrayList.*, jino.study.A20130626.*" %>
<%@page import="org.json.simple.parser.JSONParser,org.json.simple.JSONArray"%>
<jsp:useBean id="listHandler" scope="page" class="jino.study.A20130626.Db_Conn"/> 
<%
String szPage =  ConvUtil.nullToSpace(request.getParameter("resPage")) ;
ArrayList<TestModel> list = new ArrayList<TestModel>();
TestModel tm = new TestModel();
JSONArray jarr = new JSONArray();
JSONObject jobj = new JSONObject();

try{
	list = listHandler.testList(szPage);
	
	for (int i=0;i<list.size();i++) {
		tm = new TestModel();
		jobj = new JSONObject();
	    tm = list.get(i);
	    jobj.put("id", tm.getId());
	    jobj.put("data", tm.getData_name());
	    jarr.add(jobj);
	}

}catch(Exception e){
	out.println(e.toString());
}
out.println(jarr);

%>