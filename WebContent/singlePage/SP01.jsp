<!DOCTYPE html>
<html ng-app="routerApp" lang="ko">
<head>
<meta charset="UTF-8">
<title>router demo 01</title>
<style>
</style>
<script type="text/javascript" src="../script/angular.js"></script>
<script type="text/javascript" src="../script/angular-route.js"></script>
<script type="text/javascript" src="routerApp.js"></script>  
</head>
<body>
	<div class="container">
		<div class="navbar">
			<div class="navbar-inner">
				<a class="brand" href="#">라우터 셈플</a>
				<ul class="nav">
					<li><a href="#home">홈</a></li>
					<li><a href="#userList">사용자 관리</a></li>
				</ul>
			</div>
		</div>
		<ng-view></ng-view>
	</div>
</body>
</html>