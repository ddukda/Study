<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>AJAX01</title>
<script src="../script/jquery-1.7.2.js"></script>
<script>
	       
$(document).ready(function() {
	
	$("#btnAjax").click(function(){
		$.ajax({
			type: "post",
			dataType : "json",
			url: "./testAjax.json",
			success: reqSuccess,
			error: reqError
		});
	});
	
	function reqSuccess(data) {
		console.log("Success..");
		
		$.each(data.items, function(key, val){
			alert("1. firstName : " + val.firstName + ", lastName : " + val.lastName);
		});
		
		$.each(data.items2, function(key, val){
			alert("2. firstName : " + val.firstName + ", lastName : " + val.lastName);
		});
		
		console.log(data);
	}
	
	function reqError(){
		alert("Ajax Fail..");
	}
	
	
	
	
// 	function reqError( jqXHR, textStatus, errorThrown){
//		console.log("textStatus : " + textStatus);
//		console.log("errorThrown : " + errorThrown);
//	}
	
	var arr = ["one", "two", "three", "four", "five"];
	var arr2 = {"a" : "에이", "b" : "비", "c" : "씨", "d" : "디"};
	$("#btnTest").click(function(){
// 		$.each(arr, function() {
// 			alert(this);
// 		});
		$.each(arr2, function(index, value) {
			alert(index + " " + value);
		});
	});
	
	$("#btnClear").click(function(){
		$("#result").empty();
	});
	
});
	
</script>
<script src="../common/googleAnalytics.js"></script></head>
<body>
	<h1>AJAX STUDY 01</h1>
	<div>
		<input type="button" id="btnAjax" name="btnAjax" value="Run" />
		<!-- input type="button" id="btnClear" name="btnClear" value="Clear" /-->
	</div>		

	<div>
		<input type="button" id="btnTest" name="btnTest" value="Test.." />
	</div>
</body>
</html>