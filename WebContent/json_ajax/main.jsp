<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>AJAX01</title>
<script src="../script/jquery-1.7.2.js"></script>
<script>
	
	function paging(page){
		
		$(document).ready(function() {
			$.ajax({
				type : "post",
				url : "./test1.jsp?resPage="+page,
				success : reqSuccess,
				error : reqError
			});
		
			function reqSuccess(data) {
				var list = $.parseJSON(data);
				var listLen = list.length;
				var content = "<table>";
				for (var i = 0; i < list.length; i++) {
					content += "<tr>";
					content += "<td>" + list[i].id + "</td>";
					content += "<td>" + list[i].data + "</td>";
					content += "</tr>";
				}

				content += "</table>";
				$("#ajaxList").html(content);

			}

			function reqError() {
				alert("Ajax Fail..");
			}
		});
	}
	
	
</script>
<script src="../common/googleAnalytics.js"></script></head>
<body>
	<h1>AJAX STUDY 01</h1>
	<div>
		<input type="button" id="btnAjax1" name="btnAjax" onclick="javascript:paging(this.value)" value="1" />
		<input type="button" id="btnAjax2" name="btnAjax" onclick="javascript:paging(this.value)" value="2" />
		<input type="button" id="btnAjax3" name="btnAjax" onclick="javascript:paging(this.value)" value="3" />
		<input type="button" id="btnAjax4" name="btnAjax" onclick="javascript:paging(this.value)" value="4" />
		<input type="button" id="btnAjax5" name="btnAjax" onclick="javascript:paging(this.value)" value="5" />
	</div>

	<div id="ajaxList"></div>

</body>
</html>