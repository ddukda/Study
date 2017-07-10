<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Drag &amp; Drop</title>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<script src="../script/jquery.tablednd.js"></script>
<script>
</script>
<style>

.tableDemo th {
	background-color: #eee;
}
.tableDemo table {
/* 	width: auto; */
	width: 500px;
}
</style>
<script>
$(function () {
	$('#table-5').tableDnD({
	    onDrop: function(table, row) {
	        alert($('#table-5').tableDnDSerialize());
	    },
	    dragHandle: ".dragHandle"
	});	
});

$("#table-5 tr").hover(function() {
    $(this.cells[0]).addClass('showDragHandle');
}, function() {
    $(this.cells[0]).removeClass('showDragHandle');
});
</script>
<script src="../common/googleAnalytics.js"></script></head>
<body>
	<h1>jQuery UI Interactions</h1>
	<h3>Drag &amp; Drop List</h3>


	<div class="tableDemo">
		<table id="table-5" border="1" cellspacing="0" cellpadding="2">
			<tbody>
				<tr id="table5-row-1">
					<td class="dragHandle"></td>
					<td>1</td>
					<td>One</td>
					<td>some text</td>
				</tr>
				<tr id="table5-row-2">
					<td class="dragHandle"></td>
					<td>2</td>
					<td>Two</td>
					<td>some text</td>
				</tr>
				<tr id="table5-row-3">
					<td class="dragHandle"></td>
					<td>3</td>
					<td>Three</td>
					<td>some text</td>
				</tr>
				<tr id="table5-row-4">
					<td class="dragHandle"></td>
					<td>4</td>
					<td>Four</td>
					<td>some text</td>
				</tr>
				<tr id="table5-row-5">
					<td class="dragHandle"></td>
					<td>5</td>
					<td>Five</td>
					<td>some text</td>
				</tr>
				<tr id="table5-row-6">
					<td class="dragHandle"></td>
					<td>6</td>
					<td>Six</td>
					<td>some text</td>
				</tr>
			</tbody>
		</table>
	</div>

</body>
</html>