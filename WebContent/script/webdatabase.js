function createDB() {
	var db = openDatabase("myDB", "1.0", "테스트용DB", 1024 * 1024);
	db.transaction(function(tx) {
		var sql = "create table baseball" +
		"(" +
		"  seq integer primary key" +
		", input " +
		", output " +
		")";
		tx.executeSql(sql);
		
		
		
	});
}


function insertData() {
	db.transaction(function(tx) {
		var sql = "insert into baseball (seq, input, output) values(?, ? ,?)";
			
		tx.executeSql(sql, [ seq.value, input.value, output.value ]);
	});
}

function selectData() {
	db.transaction(function(tx) {
		tx.executeSql("select * from baseball", [],

		function(tx, result) {
			for ( var i = 0; i < result.rows.length; i++) {
				var row = result.rows.item(i);
				document.getElementById("tbody").innerHTML += "<tr><td>"
						+ row["id"] + "</td><td>" + row["input"] + "</td><td>" + row["output"] + "</td></tr>";
			}

		});

	});
}

function deleteData(seq) {
	db.transaction(function(tx) {
		tx.executeSql("delete from BaseBall where seq = ?", [ seq.value ]);
	});
}