<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<jsp:useBean id="test" scope="page" class="com.test.TestOpenStream" />
<%
	String szResult = test.test1();
	out.println(szResult);
%>
<script src="../common/googleAnalytics.js"></script></head>
<body>
	
</body>
</html>