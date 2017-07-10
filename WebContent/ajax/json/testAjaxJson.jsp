<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Base Ball Game</title>
<!-- <link rel="stylesheet" href="./baseball.css"> -->
<style>

</style>
<!-- <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script> -->
<!-- <script src="../script/baseball.js"></script> -->
<script src="../../script/jquery-1.7.2.js"></script>

<script>
	       
$(document).ready(function() {
	
	$('#part02').click(function() {
		
		$.getJson('./testAjax.json' ,
		
			function(data) {
				$('#content').empty();
				
				$.each(data, function(entryIndex, entry) {
					var html = '<h2>' + entry['listN'] + '</h2>';	
						html += '<h3>' + entry['summary'] + '</h3>';
						html += '<div>' + entry['definition'] +'</div>';
					$('#content').append(html);
				});
				
				alert("success");
			}
		);
		
		return false;
	});
	
	$('#part01').click(function() {
		$('#content').empty();
		$('#content').load('./about.jsp');
	    return false;
	});
});
	
</script>
<script src="../common/googleAnalytics.js"></script></head>
<body>
	<h1>BASE BALL GAME</h1>
	<!-- 숫자 입력 -->
	<form method="post" id="frm" name="frm" action="">
		<fieldset>
			<legend>숫자 입력 부분</legend>
			<div>
				<h2>숫자 입력</h2>
				<label for="inputnum">숫자 입력 : </label> 
				<input type="text" id="inputnum" name="inputnum" maxlength="3" /> 
				<input type="button" id="btnInsert" name="btnInsert" onclick="javascript:inputCheck();" value="확인 " />
			</div>
		</fieldset>
	</form>

	<!-- 결과 보기 -->
	<div style="margin-top: 30px;">
		<h3>결과</h3>
		<table summary="야구 게임 결과 정보 제공">
			<caption>야구 게임 결과 표</caption>
			<colgroup>
				<col width="20%" />
				<col width="30%" />
				<col width="*" />
			</colgroup>
			<thead>
				<tr>
					<th scope="col">회</th>
					<th scope="col">숫자</th>
					<th scope="col">결과</th>
				</tr>
			</thead>
			<tbody id="tbody">

				<tr>
					<td class="tablecenter">1</td>
					<td class="tablecenter">3 6 9</td>
					<td class="tablecenter">STRIKE : , BALL : , OUT :</td>
				</tr>

			</tbody>
		</table>
	</div>
	
	
	<div id="wrapper">
	<h1>jquery를 이용한 ajax 데이터로드_01</h1>
		<div id="siadebar">
			<ul>
				<li id="part01"><a href="#">html 삽입</a></li>
				<li id="part02"><a href="#">JSON 삽입</a></li>
				<li></li>
				<li></li>
			</ul>
		</div>
	<div id="content"><p>로드된 데이터가 들어올자리</p></div>
	</div>
</body>
</html>