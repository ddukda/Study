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
	(<%=szTest %>) : �̰� ���¾� �ٵ� Ʋ�� <br/>
	�׷��� �ڷ� �������� �ٵ� focus �ؾߵ�
	
	<input type="button" onclick="javascript:set()" />
</body>
</html>
