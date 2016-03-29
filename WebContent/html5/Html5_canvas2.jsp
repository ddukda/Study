<!DOCTYPE html>
<html lang="ko">
<head>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<meta charset="UTF-8"> 
<title>HTML5_CANVAS</title>
<script src="../common/coco.js"></script>
<script src="../common/coco2.js"></script>
<script src="../common/coco3.js"></script>
<script>


	var canvasWidth=600;
	var canvasHeight=480;
	for(var i=0;i<100;i++){
	    var ballImg = cocoApp.addImage('../images/common/ico_cir1.gif',0,-10,false);
	    ballImg.position.x = Math.round(Math.random() * canvasWidth );
	    ballImg.position.y = Math.round(Math.random() * canvasHeight );
	    ballImg.drift = Math.random();
	    ballImg.speed = Math.round(Math.random() * 5) + 1;
	    ballImg.addSchedule({method:function(){
	        this.speed = Math.round(Math.random() * 3) + 1;
	        if(this.position.y <= canvasHeight){
	            this.position.y =  this.position.y+this.speed;
	            if(this.position.y > canvasHeight){
	                this.position.y = -5;
	            }
	            this.position.x+=this.drift;
	            if(this.position.x > canvasWidth){
	                this.position.x=0
	            }
	        }
	    },target:ballImg,interval:0,paused:false});
	}

</script>
<style>
	
</style>
<script src="../common/googleAnalytics.js"></script></head>
<body>
	<div id="psmon-demo" style="width: 800px; height: 600px;float: left;"></div>
</body>
</html>