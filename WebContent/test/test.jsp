
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
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
<script>
// window.open("/advrManage/checkJungbok.do?flag=advrNm&val=" + $("#advr_name").val(), "", "scrollbars=1,resizable=no,width=380,height=400, top=100,left=200");
	$(function(){	
		$("#group_open1").click(function(){
			window.open("http://bizring.uplus.co.kr/groupRing/login_main.do?lgNAME=ua7B9sf2&ctn=MDEwLTgwODAtNjc1Ng==&brand=TEcgVSs=", "", "scrollbars=1,resizable=no,width=380,height=400, top=100,left=200");
// 			window.open("http://222.231.13.106/groupRing/login_main.do?lgNAME=ua7B9sf2&ctn=MDEwLTgwODAtNjc1Ng==&brand=TEcgVSs=", "", "scrollbars=1,resizable=no,width=380,height=400, top=100,left=200");
		});
		
		$("#group_open2").click(function(){
// 			window.open("http://bizring.uplus.co.kr/groupRing/login_main.do?lgNAME=ua7B9sf2&ctn=MDEwLTgwODAtNjc1Ng==&brand=TEcgVSs=", "", "scrollbars=1,resizable=no,width=380,height=400, top=100,left=200");
			window.open("http://222.231.13.106/groupRing/login_main.do?lgNAME=ua7B9sf2&ctn=MDEwLTgwODAtNjc1Ng==&brand=TEcgVSs=", "", "scrollbars=1,resizable=no,width=380,height=400, top=100,left=200");
		});
		
	});
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

<!-- <div class="section">			 -->
<!-- 		<!-- <div class="eventcont">  검은줄이 생겨서 주석처리함--> -->
<!-- 		<iframe id="externalFrame" title="인기 TOP100" src="http://222.231.13.106/groupRing/login_main.do?lgNAME=ua7B9sf2&ctn=MDEwLTgwODAtNjc1Ng==&brand=TEcgVSs=" name="ifrm" width="100%" height="3000" marginwidth="0" marginheight="0" frameborder="0" scrolling="no"></iframe> -->
<!-- 		<!-- </div> 검은줄이 생겨서 주석처리함 -->			 -->
<!-- 	</div> -->

<div name="test"><button id="group_open1">그룹링 팝업(상용)</button></div>
<div name="test"><button id="group_open2">그룹링 팝업(검수)</button></div>

</body>
</html>