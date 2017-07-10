<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Drag &amp; Drop</title>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<script>
</script>
<style>
	.product { width:100px; height:100px; border:1px solid red; display:inline-block; }
	#theDrop { width:200px; height:200px; border:1px solid red; }
</style>
<script>
$(function () {
    $('#theDrags').children().draggable(); 
    
    $('#theDrop').droppable({
        drop: function (event, ui) {
            ui.draggable.hide("explode", "slow");
        }
    });
});
</script>
<script src="../common/googleAnalytics.js"></script></head>
<body>
<h1>jQuery UI Interactions</h1>
    <h3>Drag &amp; Drop</h3>

    <div id="theDrags">
        <div class="product">상품1</div>
        <div class="product">상품2</div>
        <div class="product">상품3</div>
    </div>

    <div id="theDrop">
		장바구니
    </div>
</body>
</html>