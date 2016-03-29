
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Flick Navigation</title>
<link rel="stylesheet" href="common.css" type="text/css" />
<style type="text/css">
h1 { font-size:16px; font-weight:bold; }
h2 { margin-top:10px; text-align:center; }


#touchSlider0 { width:100%; height:150px; margin:0 auto; background:#ccc; position:relative; overflow:hidden; }
#touchSlider0 ul { width:99999px; height:150px; position:absolute; top:0; left:0; overflow:hidden; }
#touchSlider0 ul li { float:left; width:100%; height:150px; background:#9C9; font-size:14px; color:#fff; }


.btn_area { background:#f5f5f5; overflow:hidden; }
.btn_area button { display:block; width:100px; height:36px; background:#000; font-size:16px; color:#fff; font-weight:bold; }
.btn_area button.btn_prev { float:left; }
.btn_area button.btn_next { float:right; }
.btn_area .btn_page { display:inline-block; width:10px; height:10px; margin:3px; font-size:0px; line-height:0; text-indent:-9999px; background:#3399CC; }
.btn_area .btn_page.on { background:#ff0000; }
</style>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
<script type="text/javascript" src="jquery.event.drag-2.2.js"></script>
<script type="text/javascript" src="jquery.touchslider.min.js"></script>
<script type="text/javascript">
//<![CDATA[
$(document).ready(function() {
	$("#touchSlider0").touchSlider({
		flexible : true,
		btn_prev : $("#touchSlider0").next().find(".btn_prev"),
		btn_next : $("#touchSlider0").next().find(".btn_next"),
		counter : function (e) {
			$("#count0").html("current : " + e.current + ", total : " + e.total);
		}
	});
	
	
	
   $.ajax({      
        type:"POST",  
        url:"ajax1.jsp",      
 
        success:function(data){   
        	$("#ajax1").after(data);
        },   
        error:function(e){  
            alert(e.responseText);  
        }  
    });  
    
   $.ajax({      
       type:"POST",  
       url:"ajax2.jsp",      

       success:function(data){   
       	$("#ajax2").after(data);
       },   
       error:function(e){  
           alert(e.responseText);  
       }  
   }); 
   
   $.ajax({      
  	 type:"POST",  
	 url:"ajax3.jsp",      

	 success:function(data){   
	   	$("#ajax3").after(data);
	   },   
	   error:function(e){  
	       alert(e.responseText);  
	   }  
	});  
	
   $.ajax({      
	  	 type:"POST",  
		 url:"ajax4.jsp",      
		 success:function(data){   
		   	$("#ajax4").after(data);
		   },   
		   error:function(e){  
		       alert(e.responseText);  
		   }  
		}); 

});
//]]>
</script>
</head>

<body>
<h1>Flick Navigation (jQuery.touchSlider, dohoons)</h1>
<p>좌우로 터치드래그~ </p>
<p>version	201507</p>
<h2>test</h2>
<div id="touchSlider0">
	<ul>
		<li>
			<div id="ajax1">
			</div>
		</li>
		<li style="background:#396">
			<div id="ajax2">
			</div>
		</li>
		<li style="background:#39C">
			<div id="ajax3">
			</div>
		</li>
		<li style="background:#33C">
			<div id="ajax4">
			</div>
		</li>
	</ul>
</div>
<div class="btn_area">
	<button type="button" class="btn_prev">prev</button>
	<button type="button" class="btn_next">next</button>
	<div id="count0" style="height:36px; font-size:16px; line-height:36px; text-align:center;">
	</div>
</div>

</body>
</html>
