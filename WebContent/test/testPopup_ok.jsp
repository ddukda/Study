<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script language="javascript"> 
<!--

function fnGoToPage(url){
	var frm = document.frmRegist;
// 	frm.target = "_parent";
	frm.action = url;
	frm.submit();
}
</script>

<form name="frmRegist" method="post">
	
</form>

<%
		out.println("<script language='javascript'>");
		out.println("alert('필링 에티켓 설정 되었습니다.');");
		out.println("fnGoToPage('./testPopup.jsp');");
		out.println("</script>");
%>
</html>