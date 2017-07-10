<%@page language="java" contentType="text/html; charset=euc-kr"%>
<html>
<head>
<script>
	function idSubmit() {
		document.idForm.action = "test1.jsp";
		document.idForm.submit();
	}
</script>
<script src="../common/googleAnalytics.js"></script></head>
<body>
	<!-- Header -->
	<table width="100%">
		<form name="idForm" method="post">
			<tr>
				<td>ID : <input type="text" name="id" size="15"> <input
					type="button" value="È®ÀÎ" onClick="idSubmit()">
				</td>
			</tr>
		</form>
	</table>
</body>
</html>
