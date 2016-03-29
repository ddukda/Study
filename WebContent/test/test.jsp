
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.jino.study.*"%>
<%@ page import="java.util.*"%>
<html>									
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<%
XmlParser xml = new XmlParser();
HashMap<String, Object> resultMap = new HashMap<String, Object>();
resultMap = xml.getMusicOnListenUrl("", "");
// xml.aaa();
%>
<script type="text/javascript" src="./jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="./jquery.jplayer.js"></script>
<script type="text/javascript" src="./listen.js"></script>
<script>
</script>
<body>
<%=resultMap.get("error") %><br/><br/>
<%=resultMap.get("streamming-url") %><br/><br/>
<%=resultMap.get("auth-key") %><br/><br/>
<%=resultMap.get("auth-key-encode") %><br/><br/>
<%=resultMap.get("listen_url") %><br/><br/>
<div id="container"></div>
<div>
	<input type="button" name="btn_play" onclick="player_start(this, '<%=resultMap.get("listen_url") %>', '60')" value="▶" />
	<input type="button" name="btn_stop" onclick="player_stop(this)" value="■" style="display: none;"/>
</div>
<div name="playTimePrint"></div>
</body>
</html>