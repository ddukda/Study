<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>필링 검색 결과 리스트 테스트</title>
<style>
	article, aside, figure, footer, header, hgroup, menu, nav,
</style>
<script src="../common/googleAnalytics.js"></script>
<script src="../common/jquery/jquery-1.7.1.min.js"></script>
<script>
$(function(){
	$("#search_req").click(function(){
		$("#frm").submit();
 	});
});
</script>
<%@ page import="java.util.*, java.io.*, java.sql.*" %>
<%@ page import="feelring.common.*" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="searchHandler" scope="application" class="com.wincom.search.SearchHandler"/>
<%
request.setCharacterEncoding("UTF-8");
response.setContentType("text/html;charset=UTF-8");
	ArrayList<HashMap<String, String>> searchResultList  = new ArrayList<HashMap<String, String>>();	
	String szKeyword = request.getParameter("keyword"); //검색어
	System.out.println("search_list.jsp - keyword  : " + szKeyword);
	searchResultList = searchHandler.keywordSearch(szKeyword);
	

%>
</head>
<body>
	<p>필링 검색 결과 리스트 테스트</p>
	<div>
<%-- 		<%=searchResultList.get(0).get("result") %> --%>
		<%for(int i=1; i<searchResultList.size(); i++) {%>
		<%=searchResultList.get(i).get("CMID") %> / 
		<%=searchResultList.get(i).get("IMGPATH") %> / 
		<%=searchResultList.get(i).get("TITLE") %> / 
		<%=searchResultList.get(i).get("SINGER") %> / 
		<%=searchResultList.get(i).get("ALBUM") %>
		<br/>
		<%} %>
	
	</div>
</body>
</html>