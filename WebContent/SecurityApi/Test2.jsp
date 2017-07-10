<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="lguplus.security.vulner.SecurityModule"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR" />
<title>JAVA_SECURITY_API TEST</title>
<script src="../common/googleAnalytics.js"></script></head>
<body>
<%
try{
	
	
	String szResult = "";
	String szParam = "";
	
	
	szParam = request.getParameter("word");
	
	out.println("szParam : " + szParam + "<br/>");
	
	szResult = lguplus.security.vulner.SecurityModule.VulnerabilityChek(szParam, 1, "common", "blockword|xss");
	
 	out.println("szResult : " + szResult);

}catch(Exception e){
	out.println("Exception : " + e.toString());
}



%>
<input type="button" value="뒤로" onclick="javascript:history.go(-1)"/>
</body>
</html>