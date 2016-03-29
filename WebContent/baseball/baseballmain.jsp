<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Base Ball Game</title>
<link rel="stylesheet" href="./baseball.css">
<style>
	
</style>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
<script src="./baseball.js"></script>

<script>
//<![CDATA[
$(document).ready(function(){
 $("input[value='button1']").click(function(){
  //ajax로 서버에 데이터 받아오기
  $.ajax({
   url:'./baseballsub.jsp?id=test', //요청 서버 주소
   success:function(data){ //응답이 성공적으로 이루어지면 자동 수행
    //응답된 결과가 매개변수 data 에 자동 담긴다.
    $("#result").html(data); //div에 서버로부터 전송된 데이터 넣기
   }  
  });
 });
 $("input[value='button2']").click(function(){
  //서버에서 데이터를 받아와 바로 출력할때는 load 함수를 사용할 수 있다.
  //두번째 인자에 파라미터를 전송할 수 있다.
  $("#result").load("./baseballsub.jsp","id=song");
 });
});
// ]]>
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
					<td class="tablecenter">STRIKE : , BALL : , OUT : </td>
				</tr>
				
			</tbody>
		</table>
	</div>
	
	
	
	
	
	
	
	<div>
		<input type="button" value="button1"><br/>
		<input type="button" value="button2"><br/>
		<div>
			<h2>서버로부터 받아온 데이터</h2>
			<div id="result"></div>
		</div>
	</div>
</body>
</html>