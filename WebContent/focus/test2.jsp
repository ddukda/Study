<%@page language="java" contentType="text/html; charset=euc-kr"%>
<html>
<%
	String szTest = request.getParameter("test");
	szTest=new String(szTest.getBytes("ISO-8859-1"),"EUC-KR"); 
%>
<script type="text/javascript">
function set(){
	window.parent.location.href="javascript:ffocus();";
	
}

</script>
<body>
	(<%=szTest %>) : 이걸 보냈어 근데 틀림 <br/>
	그래서 뒤로 보내보자 근데 focus 해야됨
	
	<input type="button" onclick="javascript:set()" />
</body>
</html>
