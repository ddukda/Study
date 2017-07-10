<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>HTML5_1</title>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<title>Insert title here</title>

<link rel="stylesheet" href="../script/jquery-easyui/themes/gray/easyui.css">
<link rel="stylesheet" href="../script/jquery-easyui/themes/icon.css">
<script src="../script/jquery-1.7.2.js"></script>
<script src="../script/jquery-easyui/jquery.easyui.min.js"></script>
<script src="../script/jquery-easyui/datagrid-detailview.js"></script>
<script>
	$(function() { // dom 이 로드 완료 되었을 때 호출 되는 ready 핸들러와 같다.
		$('#grid').datagrid({
			url : './test5_grid.jsp',
			idField : 'code',
			columns : [ [ // DataGrid 컬럼을 설정한다.
			{
				title : 'Base Information',
				colspan : 3
			}, {
				field : 'opt',
				title : 'Operation',
				width : 100,
				align : 'center',
				rowspan : 2,
				formatter : function(value, rec) {
					return '<span style="color:red">Edit Delete</span>';
				}
			} ], [ {
				field : 'name',
				title : 'Name',
				width : 120
			}, {
				field : 'addr',
				title : 'Address',
				width : 220,
				rowspan : 2,
				sortable : true,
				sorter : function(a, b) {
					return (a > b ? 1 : -1);
				}
			}, {
				field : 'col4',
				title : 'Col41',
				width : 150,
				rowspan : 2
			} ] ],
			toolbar : '#tb'
		}); // $('#grid').datagrid({
			
		$('#btnSearch').click(function(){
			$('#grid').datagrid('load', {
				startdate : $('#startdate').datebox('getValue'),
				enddate : $('#enddate').datebox('getValue'),
				itemid : $('#itemid').val()
			});
		});
		
	}); // $(function(){

	
		
	function doSearch() {
		$('#grid').datagrid('load', {
			startdate : $('#startdate').datebox('getValue'),
			enddate : $('#enddate').datebox('getValue'),
			itemid : $('#itemid').val()
		});
	}
</script>
<script src="../common/googleAnalytics.js"></script></head>
<body>
	<div id="tb" style="padding: 5px; height: auto">
		<div>
			시작일 <input id="startdate" class="easyui-datebox" style="width: 80px">
			종료일 <input id="enddate" class="easyui-datebox" style="width: 80px">
			제목 <input id="itemid" style="line-height: 26px; border: 1px solid #ccc"> 
			<button id="btnSearch" class="easyui-linkbutton" iconCls="icon-search">검색</button>
<!-- 			<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="doSearch()">검색</a> -->
<!-- 			<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="doSearch()">검색</a> -->
		</div>
	</div>

	<table id="grid"></table>
</body>
</html>