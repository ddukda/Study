<%@page language="java" contentType="text/html; charset=euc-kr"%>
<html>
<%
	session = request.getSession(true);
	String id = request.getParameter("id");
	request.getSession().setAttribute("id", id);
%>
<body>
	<h3>Session ����</h3>
	���ο� ������ �����Ǿ����ϴ�.
	<BR> ����ID :
	<%=session.getId()%><BR>
	<a href="test2.jsp">���ǳ��뺸��<BR>
</body>
</html>
