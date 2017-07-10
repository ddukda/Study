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
	 #theDrags { width: 600px; height: 150px; background-color:Yellow; }
     .product { width:100px; height:100px; border:1px solid red; display:inline-block; background-color:Green; }
     #theDrop { width:200px; height:200px; border:5px solid red; }
     .redBorderStart { opacity:0.5; }
     .redBorder { opacity:1.0; }

</style>
<script>

	 $(function () {
         //$('#theDrags').children().draggable(); // 드래그 가능 요소 
         $('#product1').draggable({ axis: "x", stack: ".ui-draggable", revert: "invalid" }); // 축
         $('#product2').draggable({ axis: "y" });
         $('#product3').draggable({ containment: "#theDrags", helper: "clone" }); // 포함
         $('#product4').draggable({ grid: [50, 100], helper: function () {
                 return $('<div>가로 50픽셀, 세로 100픽셀 단위로 이동되죠?</div>');
             } 
         }); // 이동단위 설정
         $('#product5').draggable({
             snap: "#product4, #product3", handle: "a"
         }); // 특정 요소에 붙임
         // 특정 요소를 한꺼번에 주고자한다면?
         $('#product1, #product2, #product3').draggable("option", "stack", ".ui-draggable");

         // 드롭될 영역 설정
         $('#theDrop').droppable({
             accept: "#product4, #product5",
             activeClass: "redBorder",
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
        <div class="product" id="product1">상품1</div>
        <div class="product" id="product2">상품2</div>
        <div class="product" id="product3">상품3</div>
        <div class="product" id="product4">상품4</div>
        <div class="product" id="product5"><a href="#">상품5</a><p>좋은상품...</p></div>
    </div>

    <div id="theDrop" class="redBorderStart">
        장바구니
    </div>

</body>
</html>