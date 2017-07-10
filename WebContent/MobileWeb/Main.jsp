<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width, height=device-height">
<title>MobileWeb Main Page</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="./common/common.css">
<script src="./common/jquery-1.7.1.min.js"></script>
<script src="./common/jquery.event.drag-1.5.min.js"></script>
<script src="./common/jquery.touchSlider.js"></script>
<script>
$(function() {
	$( "#left_menu_button" ).toggle(
		function() {
			$( "#left_menu" ).animate({left: 0}, 300 );  
			$( "#left_menu_button" ).css({"background":"url(./images/left_menu_button2.gif)"});
		},
		function() {
			$( "#left_menu" ).animate({left: '-10%'}, 300 );
			$( "#left_menu_button" ).css({"background":"url(./images/left_menu_button1.gif)"});
		}
	);
	
	$("#touchSlider").touchSlider( {
		flexible : true
	});
});


</script>
</head>
<body background="./images/bg.PNG">
	<div id="wrap">
		<div id="div_header">
				U+ 필링
			<div id="left_menu">
			    <div id="left_menu_content">
					MENU
				</div>
				<div id="left_menu_button"></div>
			</div>
		</div>
		
		<div id="div_content">
			<div id="div_playfeelring">
				지금 재생중인 필링
				
			</div>
		
			<div id="div_etiq">
				에티켓
				
			</div>

			<div id="div_banner">
				상단 배너
				<div id="touchSlider">
					<ul>
						<li>
							<img src="./images/banner1.png" />
						</li>
					
						<li>
							<img src="./images/banner2.png" />
						</li>
					 </ul>
				</div>
				
			</div>
			
			<div id="list">
				리스트
			</div>
		</div>
	</div>
</body>
</html>