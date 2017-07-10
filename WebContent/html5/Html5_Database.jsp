<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HTML5_Database</title>
<script>
var results = [];

function resultReceiver(event) {
  results.push(parseInt(event.data));
  if (results.length == 2) {
    postMessage(results[0] + results[1]);
  }
}

function errorReceiver(event) {
  throw event.data;
}

onmessage = function(event) {
  var n = parseInt(event.data);

  if (n == 0 || n == 1) {
    postMessage(n);
    return;
  }

  for (var i = 1; i <= 2; i++) {
    var worker = new Worker("fibonacci.js");
    worker.onmessage = resultReceiver;
    worker.onerror = errorReceiver;
    worker.postMessage(n - i);
  }
};
</script>
<style>
</style>
<script src="../common/googleAnalytics.js"></script></head>
<body>
	<h1>피보나치 수열?</h1>
	<div id="result"></div>

  <script>

    var worker = new Worker("fibonacci.js");

    worker.onmessage = function(event) {
      document.getElementById("result").textContent = event.data;
      console.log("Got: " + event.data + "\n");
    };

    worker.onerror = function(error) {
      console.log("Worker error: " + error.message + "\n");
      throw error;
    };

    worker.postMessage("5");

  </script>
</body>
</html>