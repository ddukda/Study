<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>AJAX01</title>

<style>

</style>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>

<script>
	       
$(document).ready(function() {
	
});
	
</script>
<%
	String input1 = request.getParameter("input1"); 
	String input2 = request.getParameter("input2");
%>
<script src="../common/googleAnalytics.js"></script></head>
<body>
	<b>
	<%=input1 %> , <%=input2 %>
	</b>
</body>
</html>