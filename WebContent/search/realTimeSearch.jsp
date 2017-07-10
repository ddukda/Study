<%@ page import="java.util.*, java.io.*, java.sql.*" %>
<%@ page import="feelring.common.*" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="searchHandler" scope="application" class="com.wincom.search.SearchHandler"/>
<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html;charset=UTF-8");

	String szKeyword = request.getParameter("keyword"); //검색어
	String szResult = searchHandler.realTimeSearch(szKeyword);
	
    out.println(szResult);
    
%>