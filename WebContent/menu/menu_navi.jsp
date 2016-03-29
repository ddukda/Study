<!DOCTYPE html>
<html lang="ko">
<head>
<%@ page import="java.util.*, java.io.*, java.sql.*" %>
<meta charset="UTF-8">
<title>MENU NAVI</title>
<link rel="stylesheet" href="../css/menu.css" />
<link rel="stylesheet" href="../common/jquery-easyui/themes/default/easyui.css">
<link rel="stylesheet" href="../common/jquery-easyui/themes/icon.css">
<script src="../common/jquery/jquery-1.7.1.min.js"></script>
<script src="../common/jquery-easyui/jquery.easyui.min.js"></script>
<script>
$(document).ready(function(){
	
	/* Event 처리 */
	$('#cmsMenuTree').tree({
		onClick:function(node){
			var url = "./admin_site_menu.jsp";
			//var url = "./MenuGrantInfo.jsp";
			var nodeData = $('#cmsMenuTree').tree("getData", node.target);
			if ( nodeData.id > 0) {
				parent.menu_info.location.href = url + "?mid=" + nodeData.id ;
			}
		}        		
	});
	
	/* root 만 expand 되게 처리 */
  	var root = $('#cmsMenuTree').tree('getRoot');
  	
  	$('#cmsMenuTree').tree('collapseAll');
  	$('#cmsMenuTree').tree('expand', root.target);
  	$('#cmsMenuTree').show();
});
</script>
<script src="../common/googleAnalytics.js"></script></head>
<%!
	String indentTab(int nNum){
		String retVal ="\t";
		for(;0<nNum;nNum--) retVal += "\t";
		
		return retVal;
	}
%>
<body>

	<!-- title -->
	<div>
		<h1>MENU NAVI</h1>
	</div>
	

	<ul id="cmsMenuTree" class="easyui-tree" data-options="animate:false,dnd:false" style="display:none">
		
		<li><span>필링 CMS 그룹 관리</span>
			<ul>
				<li id=1><span>TP</span></li>
				<li id=2><span>BP</span></li>
				<li id=3><span>일반 CP</span></li>
				<li id=4><span>오토Long CP</span></li>
				<li id=5><span>VM CP</span></li>
				<li id=6><span>외부 CP</span></li>
				<li id=0><span>기본</span></li>
				<li id=7><span>그룹TEST1</span></li>
				<li id=8><span>테스트</span></li>
				<li id=9><span>기업필링CP</span></li>
				<li id=11><span>test<span class='fc_r'> (비사용)</span></span></li>
				<li id=10><span>ina1<span class='fc_r'> (비사용)</span></span></li>
				<li id=12><span>필링TEST<span class='fc_r'> (비사용)</span></span></li>
				<li id=13><span>test11<span class='fc_r'> (비사용)</span></span></li>
				<li id=14><span>ina<span class='fc_r'> (비사용)</span></span></li>
				<li id=15><span>inas1<span class='fc_r'> (비사용)</span></span></li>
				<li id=16><span>소호링 대행사</span></li>
				<li id=17><span>소호링 제작사</span></li>
				<li id=18><span>test020202</span></li>
			</ul>
		</li>
		
	</ul>	
</body>
</html>