<%@page language="java" contentType="text/html; charset=euc-kr"%>
<html>
<body>
	<h3>Session ����</h3>
	<%
		String szRst = "";
	
		if (session != null) {
			session.invalidate();
		}
	
// 		session = request.getSession(true); // ������ �����ϸ� ���� ������ ����, ������ ���μ����� ����
		
		if(session != null) {
			szRst = "session is not null.."	;
		}
		
	%>
	
	
	
<%-- 	Attribute id �� : <%=(String) request.getSession().getAttribute("id")%><br/> --%>
		

	
<%-- 	isNew() : <%=session.isNew()%><br/>  --%>
	
	
	����ID : <%=session.getId()%><br/>
	
	���� ���� : <%=szRst %>!!<br/>
		
	
	<br/><br/><br/><br/>
<%-- 	���ǻ����ð�:<%=new java.util.Date(session.getCreationTime()).toString()%><br/> --%>
<%-- 	���Ǹ��������ӽð�:<%=new java.util.Date(session.getLastAccessedTime()).toString()%><br/> --%>
	

	
	
	
	<a href="test3.jsp">���ǻ����ϱ�</a>
</body>
</html>
