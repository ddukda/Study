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

		$("button").click(function() {
// 			$.post('./test1.jsp', {
// 				text : 'my string',
// 				number : 23
// 			}, function() {
// 				alert('Your data has been saved.');
// 			});
			Date d = new Date ( );
			Calendar c = Calendar.getInstance ( );
			c.setTime ( d );
		});

	});
	
	Date d = new Date ( );
	Calendar c = Calendar.getInstance ( );
	c.setTime ( d );
</script>
<script src="../common/googleAnalytics.js"></script></head>
<body>
<button>Click me</button>
</body>
</html>