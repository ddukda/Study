<%!
public static String nullToZero(String str){

	if (str == null || str.trim().equals("") || str.equals("null")){
		return "0";
	}
	return str.trim();
}
%><!doctype html>
<html lang="ko">
<head>
<%
//------paging setting--------------------------------
String pagingPrint	= "";
String szPageNo     = nullToZero(request.getParameter("resPage"));
String szStartPage  = nullToZero(request.getParameter("resStartPage"));
int nBlockPage		= 5;
int nPage      		= 0;
int nPageSize 		= 10;
int nTotRow			= 0;
int nStartPage      = 0;
// String szParam		= "resFlag="+szFlag+"&resModelSortingFlag="+szModelSortingFlag+"&resDateSortingFlag="+szDateSortingFlag;	// 넘길 파라미터 
String szUrl		= "test9.jsp?"; // + szParam;	// 페이징에 URL 세팅


if(szPageNo == null || szPageNo.equals("")) {szPageNo = "0";}
if(szStartPage == null || szStartPage.equals("")) {szStartPage = "0";}
nPage = Integer.parseInt(szPageNo) < 0 ? 0 : Integer.parseInt(szPageNo);
nStartPage = Integer.parseInt(szStartPage) < 0 ? 0 : Integer.parseInt(szStartPage);

//------//paging setting--------------------------------
%>
<meta charset="euc-kr">
<%@ page import="java.util.*, java.io.*, java.sql.*" %>
<%@ page import="feelring.common.*" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="EUC-KR"%>
<jsp:useBean id="handler" scope="application" class="feelring.common.DbHandler"/>
<jsp:useBean id="paging" scope="application" class="feelring.common.Paging"/>
<title>JQUERY TEST9</title>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<link rel="stylesheet" href="../css/common.css">
<link rel="stylesheet" href="../css/baseball.css">
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<script>
$(document).ready(function () {
	// 리스트 메인 AJAX
	$.ajax({
		type:"POST",
		url:"./test9_sub.jsp",
		data: "resPage=<%=nPage%>&resStartPage=<%=nPageSize%>", 
		success:function(html){
			$("#list").append(html);
		}
		,error:function(xhr, status, error){
			alert("error");
		}
	});
	
});


</script>
<%
nTotRow = handler.getCnt();
pagingPrint = paging.PagingPrint(nTotRow, nPage, szUrl, nStartPage);
%>

<script src="../common/googleAnalytics.js"></script></head>
<body>
	<header></header>
	<section>
		<div id="list"></div>
		<%= pagingPrint%>
	</section>
	<footer></footer>
	 
</body>
</html>