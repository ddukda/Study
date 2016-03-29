<script type="text/javascript">
$(document).ready(function() {
   $("#naver").click(function() {
	   $.ajax({      
	  	 type:"POST",  
		 url:"ajax5.jsp",      
		 success:function(data){   
		   	$("#ajax4").after(data);
		   },   
		   error:function(e){  
		       alert(e.responseText);  
		   }  
		}); 
   });
});
</script>
AJAX4 PAGE

<input type="button" id="naver" name="naver" value="네이버"/>