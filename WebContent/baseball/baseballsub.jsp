<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
 String id=request.getParameter("id");
%>
<div style="width: 400px;height: 200px;background-color: orange;">
	 <h4><%=id %></h4>
	 <h2>Ajax 연습</h2>
	 <p>jQuery 로 ajax 구현하기</p>
 </div>