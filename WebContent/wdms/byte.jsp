<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
	
	function OntextCheck(obj) {
		var str = new String(obj.value);
		var stringByteLength = 0;
		var cnt = 0;
		stringByteLength = (function(s, b, i, c) {
			for (b = i = 0; c = s.charCodeAt(i++); b += c >> 11 ? 2 : c >> 7 ? 2 : 1)
				cnt++;
			return b;
		})(str);
		
		document.getElementById("txtbyte").value = stringByteLength;
		document.getElementById("cnt").value = cnt;
		if(stringByteLength > 100){
			document.getElementById("Text1").value = str.substr(0,cnt-2);
		}
	}
	
</script>
<script src="../common/googleAnalytics.js"></script></head>
<body>

	<input type="text" id="Text1" onkeyUp="OntextCheck(this);"
		style="width: 300px;">
	<br />
	<input type="text" id="txtbyte" style="width: 50px;" readonly>/500byte<br/>
	<input type="text" id="cnt" style="width: 50px;" readonly>
</body>
</html>