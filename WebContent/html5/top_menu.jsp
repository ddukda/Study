<!doctype html>
<html >
<head>
<meta charset="utf-8">
<title>CSS 드롭다운메뉴</title>


  <style type="text/css">
  
    body, div, ul, li{margin:0; padding:0}

	body{font-size:12px; font-family:"맑은 고딕", arial}

	ul{list-style:none}
	a{color:#000; text-decoration:none}

    .gnb{
	   width:640px; height:85px; margin:auto; margin-top:50px; 
	}

    /* 메인메뉴 영역 */
    .gnb>ul{
	  width:620px; height:30px; background:#ccc; 
	  padding:20px 0 0 20px; 
	}

	.gnb>ul>li{
	  float:left; width:100px; height:30px; margin-right:5px;
	  position:relative;
	}

	.gnb>ul>li>a{
	  display:block; width:100%; height:100%;
	  font:bold 13px/30px "맑은 고딕", arial;
	  text-align:center; color:#fff; background:black; 
	}

	.gnb ul li a:hover{color:#000; background:#fc0}


    /* 서브메뉴 영역*/
    .gnb ul ul{display:none}

	.gnb>ul>li:hover ul{
	   display:block; width:100px; height:25px;
	   position:absolute; left:0; top:30px;
	}

	.gnb li li{width:100px; height:25px; background-color:red; text-align:center;}

    .gnb li li a{
	  display:block; width:100%; height:100%;
	  font:bold 12px/25px "맑은 고딕", arial;
	}

    .gnb li li a:hover{
	  color:white; background:none;
	}
  
  </style>

</head>

<body>


  <div class="gnb">
     
     <ul>
        <li><a href="#">주메뉴1</a>
		    <ul>
               <li><a href="#">서브메뉴1</a></li>
			   <li><a href="#">서브메뉴2</a></li>
			   <li><a href="#">서브메뉴3</a></li>
			   <li><a href="#">서브메뉴4</a></li>
			</ul>
		</li>

		<li><a href="#">주메뉴2</a>
		    <ul>
               <li><a href="#">서브메뉴1</a></li>
			   <li><a href="#">서브메뉴2</a></li>
			   <li><a href="#">서브메뉴3</a></li>
			</ul>
		</li>
	</ul>

		<table width="640" height="300" bgcolor="yellow">
			<tr>
				<td align="center">안녕하세요 늑대털쓴양입니다.</td>
			</tr>
		</table>

	</div>


</body>
</html>