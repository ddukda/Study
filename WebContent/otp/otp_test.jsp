<!doctype html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>jquery count down</title>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>

<style>

</style>
<script>
</script>
<body>
당신의 키는 → ${encodedKey } 입니다. <br>
당신의 바코드 주소는 → ${url } 입니다. <br><br>
 
<form action="<%=request.getContextPath() %>/servlet/com.jino.study.google_otp_ok" method="get">
    code : <input type="text" name="user_code"><br><br>
     
    <input type="hidden" name="encodedKey" value="${encodedKey }" readonly="readonly"><br><br>
    <input type="submit" value="전송!">
     
</form>
</body>
</html>