<%@page language="java" contentType="text/html; charset=euc-kr"%>
<html>
<body>
	<h3>Session 정보</h3>
	<%
		String szRst = "";
	
		if (session != null) {
			session.invalidate();
		}
	
// 		session = request.getSession(true); // 세션이 존재하면 이전 세션을 리턴, 없으면 새로세션을 생성
		
		if(session != null) {
			szRst = "session is not null.."	;
		}
		
	%>
	
	
	
<%-- 	Attribute id 값 : <%=(String) request.getSession().getAttribute("id")%><br/> --%>
		

	
<%-- 	isNew() : <%=session.isNew()%><br/>  --%>
	
	
	세션ID : <%=session.getId()%><br/>
	
	세션 상태 : <%=szRst %>!!<br/>
		
	
	<br/><br/><br/><br/>
<%-- 	세션생성시간:<%=new java.util.Date(session.getCreationTime()).toString()%><br/> --%>
<%-- 	세션마지막접속시간:<%=new java.util.Date(session.getLastAccessedTime()).toString()%><br/> --%>
	

	
	
	
	<a href="test3.jsp">세션삭제하기</a>
</body>
</html>
