<!doctype html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>jquery test6</title>
<style>
body { color: #666; font-size:12px; margin:20px; font-family:Dotum;}
a{color:#333}
.tabBox{ position:relative; padding:30px 0px 0 0px; width:500px;}
.tabBox .ctn{}
.tabBox .ctn h3{ position:absolute; top:0px;margin:0px; padding:0px; font-size:12px; font-weight:normal; }
.tabBox .ctn h3 a{ display:block; padding:5px; height:19px; width:90px; line-height:20px; background:#FFF; text-align:center;border-radius:5px 5px 0 0; border:#ccc solid 1px; border-bottom:none; text-decoration:none; }
.tabBox .ctn .box{ border:#ccc solid 1px; display:none; padding:0; margin:0; height:100px; padding:15px; border-radius:0px 5px 5px 5px;}
.tabBox .ctn .btnMore{ position:absolute; right:4px; top:8px; display:none;}
.tabBox .ctn1 h3{ left:0px;}
.tabBox .ctn2 h3{ left:103px;}
.tabBox .ctn3 h3{ left:206px;}
.tabBox .ctnOn h3 a{ height:20px; font-weight:bold; font-size:16px; line-height:22px;}
.tabBox .ctnOn .btnMore{ display:block;}
.tabBox .ctnOn .box{display:block;}
</style>
<script src="../script/jquery-1.7.2.js"></script>
<script>
$(document).ready(function () {
    //탭형식컨텐츠
    $(".tabBox h3 a").on("click focus" , function() {
        $(".tabBox .ctn").removeClass("ctnOn");
        $(this).parent().parent().addClass("ctnOn");
    }); 
});
</script>
<script src="../common/googleAnalytics.js"></script></head>
<body><br>
<br>
<br>

<div class="tabBox">
    <div class="ctn ctn1 ctnOn">
        <h3><a href="javascript:;">타이틀1</a></h3>
        <p class="box"><a href="javascript:;">내용1내용1내용1</a></p>
        <a class="btnMore" href="javascript:;">More1</a>
    </div>
    <div class="ctn ctn2">
        <h3><a href="javascript:;">타이틀2</a></h3>
        <p class="box"><a href="javascript:;">내용2내용2내용2</a></p>
        <a class="btnMore" href="javascript:;">More2</a>
    </div>
    <div class="ctn ctn3">
        <h3><a href="javascript:;">타이틀3</a></h3>
        <p class="box"><a href="javascript:;">내용3내용3내용3</a></p>
        <a class="btnMore" href="javascript:;">More3</a>
    </div>
</div>
</body>
</html>