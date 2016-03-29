<%@page language="java" contentType="text/html; charset=euc-kr"%>
<html>
<%
	session = request.getSession(true);
	String id = request.getParameter("id");
	request.getSession().setAttribute("id", id);
%>
<body>
	<h3>Session 积己</h3>
	货肺款 技记捞 积己登菌嚼聪促.
	<BR> 技记ID :
	<%=session.getId()%><BR>
	<a href="test2.jsp">技记郴侩焊扁<BR>
</body>
</html>
