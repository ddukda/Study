<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>필링 검색 테스트</title>
<style>
	article, aside, figure, footer, header, hgroup, menu, nav
	pop-sch-auto {width:100%;overflow: hidden; zoom:1;position:relative;}
.pop-sch-auto li {height:47px;position:relative;zoom:1;background:#fff;border-bottom:1px solid #e6e6e6;font-size:14px;color:#000;}
.pop-sch-auto li > a {display:block;height:47px;cursor: pointer;}
.pop-sch-auto li > a:hover, .pop-sch-auto li > a:focus, .pop-sch-auto li > a:active {
	text-decoration: none;
	background-color: #f0f0f0;
	cursor: pointer;
	border-bottom:1px solid #e6e6e6;}
.pop-sch-auto li p {padding:15px 15px 0;
    /*letter-spacing: -1px;*/
    line-height: 1.2;
    overflow: hidden;
    zoom: 1;
    text-overflow: ellipsis;
    white-space: nowrap;}
.pop-sch-auto li span {color:#ea482d;}
</style>
<script src="../common/jquery/jquery-1.7.1.min.js"></script>
<script>
$(function(){
	$(".download").click(function(){
		var index = $(".download").index(this);
		
		alert(index);
		$("#flag").val(index);
		$("#frm").submit();
		
<%-- 		location.href = "<%=request.getContextPath() %>/servlet/jino.study.file.FileDownloadUtil"; --%>
 	});
	
	$("#search").click(function(){
		$("#frm").submit();
 	});
});

function realTimeSearch(){
	// 검색어가 없으면 리턴
	if($('#keyword').val().trim() == ''){
		$('#keyword').focus();
		return;
	} 
			
	$.ajax({
		type	: "POST",
        url		: './realTimeSearch.jsp',
        dataType: "text",
		data    :{
			"keyword"	: $('#keyword').val(),			// 키워드
			"outmax"	: 8								// 출력 개수
			
		},
        success: function( data ) {
			var cnt = 0;
			var searchHtml = "";
			if(data == null){
				
			}else{
				var arrResult = data.split(",");	
				
				for(var i=0; i < arrResult.length; i++){
// 					console.log("arrResult[i] : " + arrResult[i].trim());
					var word = arrResult[i].trim(); 
					word = word.replace(/ /g, "&nbsp;").replace(/\"/gi, "");
// 					word = word.replace(/\"/gi, "");
					var item = word.toLowerCase().replace($('#keyword').val().toLowerCase(),'<span style=\"color:red\">' + $( '#keyword' ).val().toLowerCase() + '</span>');
					console.log("item : " + item);
					searchHtml += "<li>";
// 					searchHtml += "<a href='#' onclick=fn_keywordSet('"+word+"');>";
					searchHtml += "<p>";
					searchHtml += item;
// 					searchHtml += "</p></a></li>";
					searchHtml += "</p></li>";
				}	
				console.log("searchHtml : " + searchHtml);
				$('#searchResult').html(searchHtml);
				$('#list_srh').show();
			}	
			
		},   
        error:function(e){
            alert(e.responseText);  
        }
		    
	});
	
	
}
</script>
</head>
<body>
	<p>필링 검색 테스트</p>
	<form id="frm" name="frm" method="post" action="./search_list.jsp">
<!-- 		<input type="hidden" id="flag" name="flag" value="" /> -->
<!-- 		<button class="download">파일 다운로드 요청_1</button> -->
<!-- 		<button class="download">파일 다운로드 요청_2</button> -->

	<div class="layer" id="layer_sch">
		<div class="bg"></div>
		<div class="pop-layer-sch">
			<div class="pop-header">
				
				<div class="input_s">
					<input type="search" id="keyword" name="keyword" placeholder="검색어를 입력해 주세요." onkeyup="realTimeSearch()"/><button class="search">검색</button>
				</div>
			</div>
			<div id="list_srh" class="pop-container" style="display:none;">
				<div class="pop-conts">
					<div class="pop-sch-auto">
						<ul id="searchResult">
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
		
	</form>
</body>
</html>