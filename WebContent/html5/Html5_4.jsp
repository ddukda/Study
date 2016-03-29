<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>HTML5_4 + CSS</title>
<style>
	/*  .은 class */
	
	p.x {color:green; font-size:14pt;}
	.xx {color:blue;}
	.center{text-align:center;}
	
	/* 	# 은 id */
	
	#x {font-family:굴림; color:blue;}
	#y {font-family:바탕; color:red;}
	
	body {background-color:black;}
</style>
<script src="../common/googleAnalytics.js"></script></head>
<body>
		<p class="x">p.x 클래스는 p 태그에서만 사용 가능</p>
		<p class="xx">요건 p 태그의 xx 클래스</p>
		<h3 class="xx">요건 h3 태그의 xx 클래스</h3>
		<p class="center">요건 p 태그의 center 클래스</p>
		<h4 class="center">요건 h4 태그의 cetner 클래스</h4>
		<p id="x">요건 p 태그의 id x </p>
		<h4 id="x">요건 h4 태그의 id x</h4>
		<p id="y">요건 p 태그의 id y </p>
		<h4 id="y">요건 h4 태그의 id y</h4>
</body>
</html>