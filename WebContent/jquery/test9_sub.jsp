<!doctype html>
<html lang="ko">
<head>
<meta charset="euc-kr">
<%@ page import="java.util.*, java.io.*, java.sql.*" %>
<%@ page import="feelring.common.*" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="EUC-KR"%>
<jsp:useBean id="handler" scope="application" class="feelring.common.DbHandler"/>
<title>JQUERY TEST9</title>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<link rel="stylesheet" href="../css/common.css">
<link rel="stylesheet" href="../css/baseball.css">
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<%!
public static String nullToSpace(String str)
{
	if (str == null || str.trim().equals("") || str.equals("null"))
	{
		return "";
	}
	
	return str.trim();
}
%>

<%
String szResPage = nullToSpace(request.getParameter("resPage"));
String szStartPage = nullToSpace(request.getParameter("resStartPage"));
int nPage = Integer.parseInt(szResPage);
int nPageSize = Integer.parseInt(szStartPage);
ArrayList<DbItem> arrayitem = handler.list(nPage, nPageSize);
%>
<table>
		<tr>
			<td>ID</td>
			<td>TYPE</td>
			<td width="200px">NAME</td>
			<td width="200px">OBJECT</td>
			<td>DATA_NAME</td>
			<td width="200px">DATA_VALUE</td>
			<td>REG_DATE</td>
		</tr>
		
	<%for(int i=0; i<arrayitem.size(); i++){ %>
		<tr>
			<td><%=arrayitem.get(i).getNId() %>			</td>
			<td><%=arrayitem.get(i).getSzType() %>		</td>
			<td><%=arrayitem.get(i).getSzName() %>		</td>
			<td><%=arrayitem.get(i).getSzObject() %>	</td>
			<td><%=arrayitem.get(i).getSzDataName() %>	</td>
			<td><%=arrayitem.get(i).getSzDataValue() %>	</td>
			<td><%=arrayitem.get(i).getSzRegDate() %>	</td>
		</tr>
	<%} %>
</table>