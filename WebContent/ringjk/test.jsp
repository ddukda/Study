<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title></title>
<%@ page  import="java.util.*, java.text.*, org.json.simple.*"%>
<%
	// --- array list set
	List<HashMap<String, String>> list = new ArrayList<HashMap<String,String>>();
	HashMap<String, String> map = new HashMap<String,String>();
	map.put("name", "양진호");
	map.put("age", "29");
	list.add(map);
	
	map = new HashMap<String,String>();
	map.put("name", "이수연");
	map.put("age", "26");
	list.add(map);
	
	map = new HashMap<String,String>();
	map.put("name", "심재혁");
	map.put("age", "29");
	list.add(map);
	
	// ArrayList -> JsonArray
	JSONArray jsonArray = new JSONArray();
	for(int i=0; i<list.size(); i++){
		jsonArray.add(list.get(i));
	}
	
	
%>
<script>
	function Send(){
		document.frm.list.value = '<%=jsonArray%>';
		document.frm.submit();
	}
</script>
<script src="../common/googleAnalytics.js"></script></head>
<body>
<form action="./testok.jsp" method="post" id="frm" name="frm">
<input type="hidden" id="list" name="list" value="" />
<input type="button" id="btn" value="보내라" onclick="javascript:Send();"/>
</form>
</body>
</html>