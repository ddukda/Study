<!DOCTYPE html>
<html lang="ko">
<head>
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script> 
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.min.js"></script> 
<script src="http://nunbi.co.kr/plugin/rolling/jq.rolling.js"></script> 
<link type="text/css" href="http://nunbi.co.kr/plugin/rolling/jq.rolling.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HTML5_rolling</title>
<style>
input[type=checkbox].custom-check{ 
    position: absolute; overflow:hidden; width:1px;height:1px; 
    clip:rect(0 0 0 0);margin:-1px;padding:0;border:0; 
} 
input[type=checkbox].custom-check + label.custom-check{ 
    display:inline-block; 
    padding-left:1em; 
} 
input[type=checkbox].custom-check:checked + label.custom-check:before{ 
    position:absolute;margin-left:-1em; 
    content:'✔'; 
} 

</style>
<script src="../common/googleAnalytics.js"></script></head>
<body>
	 

    
	<input type="checkbox" id="chk1" name="chk" class="custom-check"/> 
	<label for="chk1" class="custom-check">체크 1</label> 
	<input type="checkbox" id="chk2" name="chk" class="custom-check"/> 
	<label for="chk2" class="custom-check">체크2</label> 

</body>
</html>