<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>흥</title>
<script type="text/javascript">
<!--
function a(){

	document.domain = "wincom.co.kr";

	window.open('./testPopup.jsp','','scrollbars=no,status=no,menubar=no,toolbar=no,resizable=yes,width=300,height=200,left=0,top=0');

}
function b(){

	document.domain = "wincom.co.kr";

	window.open('./testPopup.jsp','','scrollbars=no,status=no,menubar=no,toolbar=no,resizable=yes,width=300,height=200,left=0,top=0');

}
// menubar=no  //메뉴바 없애기
// toolbar=no // 툴바 없애기
// location=no  //주소표시줄 없애기
// status=no //상태표시줄 없애기
// scrollbars=no //스크롤바 없애기

// window.onunload = function() {
// 	alert("새로고침");
// }
// window.onload = function(){//이미 로드된 함수가 있다면 둘다 호출
//     b();
//     c();
// };

// function b(){
// 	alert("abc");
// }
// function c(){
// 	alert("efg");
// }

//-->
</script>
<script src="../common/googleAnalytics.js"></script></head>
<body>
<form action="./testNextPage.jsp" method="post" id="frm" name="frm">
여기는 opener 입니다.
<br />
<input type="button" id="popup1" value="팝업 호출 location yes" onclick="javascript:a();"/><br/>
<input type="button" id="popup1" value="팝업 호출 location no" onclick="javascript:b();"/><br/>
<input type="submit" id="go1" value="다음 페이지로"/>
</form>
</body>
</html>