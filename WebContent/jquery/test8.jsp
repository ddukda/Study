<!doctype html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>jquery test8</title>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>

<style>
#slidemenu{background:#12cf3d;position:absolute;width:100px;top:50px;right:10px;}

#moveMenu{
 width:100px;
 height:200px;
 left:0px;
 top:0px;
 position:relative;
 background: olive;
}
</style>
<script>
	$(function () {
		$(document).mousedown(function(e){
			$(document).mousemove(function(e){
		      $('#status').html(e.pageX +', '+ e.pageY);
		      
		      
		      
		      var posX = e.pageX - parseInt($("#moveMenu").css("width"))/2 +50+ "px";
		      var posY = e.pageY - parseInt($("#moveMenu").css("height"))/2 +100+ "px";
		      
		      
		      //top좌표 설정
		      $("#moveMenu").css({"left":posX});
		      $("#moveMenu").css({"top":posY});
		 }); 
		}); 
		
		$(document).mouseup(function(e){
			$(document).unbind('mousemove');
	      });
	});
</script>
<script src="../common/googleAnalytics.js"></script></head>
<body>
	<header>
		<div id="moveMenu">
			<div id="firstTest" >
				<p><a href="#first">MENU 1</a></p>
				<div id="first">
					<p>menu 1-1</p>
					<p>menu 1-2</p>
				</div>
			</div>
			<div id="secondTest">
				<p><a href="#second">MENU 2</a></p>
				<div id="second">
					<p>menu 2-1</p>
					<p>menu 2-2</p>
				</div>
			</div>
		</div>
	</header>
	
	<nav>
		
	</nav>
	
	<section id="contents">
		
	</section>
	
	<aside>
		<div id="slidemenu">
			<p id="status">0,0</p>
		</div>
	</aside>
	
	
</body>
</html>