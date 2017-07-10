function inputCheck(){
	if($.trim($("#inputnum").val()) == "")
	{
		alert("3자리 숫자를 입력 해 주십시오.");
		$("#inputnum").val("");
		$("#inputnum").focus();
		return false;
		
	}
	
	if($("#inputnum").val().length < 3)
	{
		alert("3자리 숫자를 입력 해 주십시오.");
		$("#inputnum").val("");
		$("#inputnum").focus();
		return false;
		
	}
	
	
	var charpos = $("#inputnum").val().search("[^0-9\]"); 
	if( charpos >= 0) 
	{ 
	 	alert("3자리 숫자를 입력 해 주십시오.");
	 	$("#inputnum").val("");
		$("#inputnum").focus();
	    return false;
	}
	
	
	var num1 = $("#inputnum").val().substr(0, 1);
	var num2 = $("#inputnum").val().substr(1, 1);
	var num3 = $("#inputnum").val().substr(2, 1);
	
	if(num1 == num2 || num1 == num3 || num2 == num3){
		alert("서로 다른 3자리 숫자를 입력 해 주십시오.");
		$("#inputnum").val("");
		$("#inputnum").focus();
		    return false;
	}
	
	var inputData = $("#inputnum").value();
	
	$.ajax({
		url: "./baseballsub.jsp",
		type: "POST",
		data: {id : inputData},
		dataType: "html",
		success : function(data) {
			alert("성공");
		},
		error : function(xhr, status, error) {
			alert("에러발생");
		}
	});
	    
	    
	return true;
}

