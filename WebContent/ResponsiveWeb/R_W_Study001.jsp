<!doctype html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>CSS Tutorial | Layout - Responsive</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
#jb-header {
	padding: 2%;
	margin-bottom: 2%;
	border: 1px solid #bcbcbc;
}

#jb-container {
	width: 90%;
	margin: 0 auto;
	padding: 3%;
	border: 1px solid #bcbcbc;
}

#jb-content {
	width: 60%;
	padding: 2%;
	margin-bottom: 2%;
	float: left;
	border: 1px solid #bcbcbc;
}

#jb-sidebar {
	width: 30%;
	padding: 2%;
	margin-bottom: 2%;
	float: right;
	border: 1px solid #bcbcbc;
}

#jb-footer {
	clear: both;
	padding: 2%;
	border: 1px solid #bcbcbc;
}

@media all and (min-width:480px) and (max-width:640px) {
	#jb-container {
		width: auto;
	}
	#jb-content {
		color: blue;
		float: none;
		width: auto;
	}
	#jb-sidebar {
		float: none;
		width: auto;
	}
}

@media all and (max-width:480px) {
	#jb-container {
		width: auto;
	}
	#jb-content {
		color: red;
		float: none;
		width: auto;
	}
	#jb-sidebar {
		float: none;
		width: auto;
	}
}
</style>
<script src="../common/googleAnalytics.js"></script></head>
<body>
	<div id="jb-container">
		<div id="jb-header">
			<h1>Responsive Layout</h1>
		</div>
		<div id="jb-content">
			<h2>Content</h2>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
				Aenean nec mollis nulla. Phasellus lacinia tempus mauris eu laoreet.
				Proin gravida velit dictum dui consequat malesuada. Aenean et nibh
				eu purus scelerisque aliquet nec non justo. Aliquam vitae aliquet
				ipsum. Etiam condimentum varius purus ut ultricies. Mauris id odio
				pretium, sollicitudin sapien eget, adipiscing risus.</p>
		</div>
		<div id="jb-sidebar">
			<h2>Sidebar</h2>
			<ul>
				<li>Lorem</li>
				<li>Ipsum</li>
				<li>Dolor</li>
			</ul>
		</div>
		<div id="jb-footer">
			<p>Copyright</p>
		</div>
	</div>
</body>
</html>