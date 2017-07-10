<!DOCTYPE html>
<html lang="ko">
<head>
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script> 
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.min.js"></script> 
<script src="http://nunbi.co.kr/plugin/rolling/jq.rolling.js"></script> 
<link type="text/css" href="http://nunbi.co.kr/plugin/rolling/jq.rolling.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HTML5_rolling</title>

<script src="../common/googleAnalytics.js"></script></head>
<body>
	 

<div>    
    <div id="rolling">        
        <ul>            
            <li><img src="http://img.1300k.com/screen/0002/154/scr_154_92343.jpg"></li> 
            <li><img src="http://img.1300k.com/screen/0002/155/scr_155_91542.jpg"></li> 
            <li><img src="http://img.1300k.com/screen/0002/156/scr_156_91991.jpg"></li> 
        </ul> 
    </div>    
    <ul class="pages"></ul> 
</div> 

<script> 
$("#rolling").rolling(490,290,{ 
    delay: 1500 
}); 
</script> 
</body>
</html>