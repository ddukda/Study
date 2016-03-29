<%@page language="java" contentType="text/html; charset=euc-kr"%>
<html>
<script>
function ffocus(){
	document.frm.test.focus();
}
</script>
<body>
<form id="frm" name="frm" method="get" action="./test2.jsp">
º¸³»ÀÚ : <input type="text" id="test" name="test" />
<input type="submit" value="send"/>
</form>
</body>
</html>
