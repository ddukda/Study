<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>우하하</title>
<script language="javascript"> 
<!--

// 	window.onbeforeunload = function() { 
	  
// 	alert("닫힙니다.");
// 	return "니 혹시 크롬이가?";
// 	}; 
// 	window.onunload = function() { 
// 	  alert("닫힙니다."); 
// 	};  // 크롬 안됨(onunload)

	function openerConfirm() {
		if (opener && !opener.closed) {
			try{
				if (document.domain.toString().indexOf("wincom.co.kr") != -1) document.domain="wincom.co.kr"; 
				window.opener.location.reload();
// 				parent.document.location.reload();
				alert("a");
				self.close();
				
				
			}catch(err){
				alert("b");
				self.close();
				
			}
		} else {
			alert("c");
			self.close();
		}
	}
//-->
</SCRIPT>
<script src="../common/googleAnalytics.js"></script></head>
<body>
	<form id="frm" action="./testPopup_ok.jsp" method="post">
		<input type="hidden" id="base_location_id" name="base_location_id" />
			여기는 팝업 페이지 입니다. 
		<input type="button" id="btn" value="opener 확인" onclick="javascript:openerConfirm();" />
		<input type="submit" id="ok" value="opener submit"/>
	</form>
</body>
</html>