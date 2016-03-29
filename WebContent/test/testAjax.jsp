<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {

		$("#btnAjax").click(function() {
			jQuery.ajax({
				type : "GET",
				url : "./testNextPage.jsp",
				success : function(data) {
					alert("success");
					$("#resultDIV").html(data);
				},
				error : function(xhr, status, error) {
					alert(error + " error");
				}
			});
		});
	});
</script>
<script src="../common/googleAnalytics.js"></script></head>
<body>
	<input type="button" id="btnAjax" name="btnAjax" value="AJAX TEST" />
	<div id="resultDIV">
		
	</div>
</body>
</html>