<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>��</title>
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
// menubar=no  //�޴��� ���ֱ�
// toolbar=no // ���� ���ֱ�
// location=no  //�ּ�ǥ���� ���ֱ�
// status=no //����ǥ���� ���ֱ�
// scrollbars=no //��ũ�ѹ� ���ֱ�

// window.onunload = function() {
// 	alert("���ΰ�ħ");
// }
// window.onload = function(){//�̹� �ε�� �Լ��� �ִٸ� �Ѵ� ȣ��
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
����� opener �Դϴ�.
<br />
<input type="button" id="popup1" value="�˾� ȣ�� location yes" onclick="javascript:a();"/><br/>
<input type="button" id="popup1" value="�˾� ȣ�� location no" onclick="javascript:b();"/><br/>
<input type="submit" id="go1" value="���� ��������"/>
</form>
</body>
</html>