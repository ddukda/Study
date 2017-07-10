<!DOCTYPE html>
<html lang="ko">
<head>
<%@ page import="java.util.*, java.io.*, java.sql.*" %>
<meta charset="UTF-8">
<title>JINO STUDY INDEX PAGE</title>
<link rel="stylesheet" href="./css/menu.css" />
<link rel="stylesheet" href="./common/jquery-easyui/themes/default/easyui.css">
<link rel="stylesheet" href="./common/jquery-easyui/themes/icon.css">
<script src="./common/jquery/jquery-1.7.1.min.js"></script>
<script src="./common/jquery-easyui/jquery.easyui.min.js"></script>

<script>
$(document).ready(function(){
  	var root = $('#cmsMenuTree').tree('getRoot');
  	
  	$('#cmsMenuTree').tree('collapseAll');
  	$('#cmsMenuTree').show();
});
</script>
<style>
	*{ margin:0; padding:0; border:0;}
	body{ width:100%; margin:0 auto; }
	#header{ height: 10%; padding: 1%; }
	#wrapper{ }
	#left_menu{ width:18%; float:left; }
	#content{ width:80%; float:right; padding: 1%; }
</style>
</head>
<body>
	<div id="header">
		<h2>JINO STUDY PROJECT</h2>
		
	</div>
	<div id="wrapper">
		<div id="left_menu">
			<ul id="cmsMenuTree" class="easyui-tree" data-options="animate:false,dnd:false" style="display:none">
				<%
					String filePath = request.getRealPath("/");
					File f = new File(filePath);
					File[] files = f.listFiles();
					int nLen = files.length;
					int nCnt = 0;
					String[] firstTreeUrl = new String[10];
					for(int i=0; i<nLen; i++){
						File fJsp = new File(filePath+files[i].getName());
						File[] filesJsp = fJsp.listFiles();
						
						int pos = fJsp.getName().lastIndexOf(".");
						String fileExt = fJsp.getName().substring(pos+1);
						
						if(!fileExt.equals("jsp")){
							int nLenJsp = filesJsp.length;
				%>
							<li><span><%=fJsp.getName() %></span>
				<%
							for(int j=0; j<nLenJsp; j++){
								int pos2 = filesJsp[j].getName().lastIndexOf(".");
								String fileExt2 = filesJsp[j].getName().substring(pos2+1);
				
				%>
								<ul>
									<li><span><a href="./<%=fJsp.getName()+"/"+filesJsp[j].getName()%>"><%= filesJsp[j].getName()%></a></span></li>
									
								</ul>
				<%				
							}
						}else{
							
							firstTreeUrl[nCnt++] = fJsp.getName();
				%>	
							
				<%
						}
					}
					for(int i=0; i<nCnt; i++){
				%>
					<li><span><a href="./<%=firstTreeUrl[i]%>"><%= firstTreeUrl[i]%></a></span></li>
				<%						
					}
					
				%>
							</li>
			</ul>	
		</div>
		<div id="content">
			
		</div>
	</div>
</body>
</html>