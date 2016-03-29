<!doctype html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>jquery count down</title>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>

<style>

</style>
<script>
$(document).ready(function(){
	
	$("#btn_otp").click(function(){
		//초기값
		var minute = 10;
		var second = 0;
		
		// 초기화
// 		$(".countTimeMinute").html(minute);
// 		$(".countTimeSecond").html(second);
		
		var timer = setInterval(function () {
				
				
				if(second == 0 && minute == 0){
//	 				alert('타이머 종료.');
//	 				clearInterval(timer); /* 타이머 종료 */
				}else{
					second--;
// 					if(second.length == 1) second = "0" + second;
						
					// 분처리
					if(second < 0){
						minute--;
						second = 59;
					}
				}
				
				// 설정
				$(".countTimeMinute").html(minute);
				$(".countTimeSecond").html(second);
	    }, 1000); /* millisecond 단위의 인터벌 */
	});
	
	
});
</script>
<body>
	<div>
		<span class="countTimeMinute">00</span>분
		<span class="countTimeSecond">00</span>초
	</div>
	<input type="button" id="btn_otp" name="btn_otp" value="count start.." />
</body>
</html>