<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>file download servlet test...</title>
<style>
	article, aside, figure, footer, header, hgroup, menu, nav,
</style>
<script src="../common/googleAnalytics.js"></script>
<script src="../common/jquery/jquery-1.7.1.min.js"></script>
<script>
$(function(){
	$(".download").click(function(){
		var index = $(".download").index(this);
		
		alert(index);
		$("#flag").val(index);
		$("#frm").submit();
		
<%-- 		location.href = "<%=request.getContextPath() %>/servlet/jino.study.file.FileDownloadUtil"; --%>
 	});
});
</script>
</head>
<body>
	<p>FILE DOWNLOAD</p>
	<form id="frm" name="frm" method="post" action="<%=request.getContextPath() %>/servlet/jino.study.file.FileDownloadUtil">
		<input type="hidden" id="flag" name="flag" value="" />
		<button class="download">파일 다운로드 요청_1</button>
		<button class="download">파일 다운로드 요청_2</button>
	</form>
</body>
</html>