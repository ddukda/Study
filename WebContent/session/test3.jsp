<%@page language="java" contentType="text/html; charset=euc-kr"%>
<%
	session = request.getSession(false);
	if (session != null) {
		session.invalidate();
	}

	response.sendRedirect("index.jsp");
%>
