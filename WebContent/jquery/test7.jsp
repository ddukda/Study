<!doctype html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>jquery test7</title>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>

<!-- <script src="http://code.jquery.com/ui/1.10.3/themes/v4/js/jquery.js"></script> -->
<script src="http://code.jquery.com/ui/1.10.3/themes/v4/js/jquery.tabs.pack.js"></script>
<style>
body {
	margin:0; padding:0;
	font: .75em/1.5 "AppleGothic", "Malgun Gothic", dotum, sans-serif;
}

#readMore02 {
	position:absolute; top:50%; left:50%;
	width:350px;
	margin:-120px 0 0 -180px;
	border:1px solid #ccc;
}

#readMore02 h2,
#readMore02 h3 { display:none; }
#readMore02 ul {
	margin:0; padding:5px 0 0 2px;
	height:26px;
	border-bottom:1px solid #ccc;
	background:#eee;
}
#readMore02 ul li {
	list-style:none;
	float:left;
	margin:0 0 0 3px; padding:0;
	position:relative; top:1px;
}
#readMore02 ul li a {
	display:block;
	padding:.25em .75em;
	border:1px solid #ccc;
	line-height:1.5; text-decoration:none;
	background:#aaa; color:#fff;
}
#readMore02 ul li a:hover,
#readMore02 ul li a:focus,
#readMore02 ul li.tabs-selected a {
	border-bottom:1px solid #fff;
	background:#fff; color:#f60;
}

#readMore02 div {clear:left;padding-top:1em;} /* IE6 마진 버그 */
#readMore02 div.tabs-selected { display:block; }
#readMore02 div.tabs-hide { display:none; }
#readMore02 ol { margin-top:0; } /* IE6 마진 버그 */
#readMore02 ol li { line-height:2; }
</style>
<script>
	$(function () {
		$("#first, #second").hide();
		
		$("a[href=#first], a[href=#second]").click(function(){
			var myHref = $(this).attr("href");
			$(myHref).toggle();
			return false;
		});
		
		$('#readMore02').tabs({ fxSlide: true, fxFade: true, fxSpeed: 'normal' });
	});
</script>
<script src="../common/googleAnalytics.js"></script></head>
<body>
	<header>
		LEFT MENU TEST
	</header>
	
	<nav>
		<div id="readMore02">
			<h2>또 다른 읽을거리</h2>
			<ul class="tabs-nav">
				<li class="tabs-selected"><a href="#relatedPost">Related Post</a></li>
				<li><a href="#randomPost">Random Post</a></li>
				<li><a href="#recentPost">Lasted Post</a></li>
			</ul>
			
			<div id="relatedPost" class="tabs-selected ">
				<h3>Related Post</h3>
				<ol>
					<li><a href="#">웹표준의 득과 실</a></li>
					<li><a href="#">브라우저 업그레이드 캠페인</a></li>
					<li><a href="#">Hooney.net 리뉴얼 계획-1</a></li>
					<li><a href="#">올블로그의 플래시 네비게이션</a></li>
					<li><a href="#">아직 메인시안도 미완성이네..</a></li>
				</ol>
			</div>
			<div id="randomPost">
				<h3>Random Post</h3>
				<ol>
					<li><a href="#">세계 비보이 대회 한국 개최, 그리고 잡담</a></li>
					<li><a href="#">KWAG 7회 워크샵</a></li>
					<li><a href="#">CSS, 웹표준 실무 적용 워크샵 2006</a></li>
					<li><a href="#">Global Web Expert 실무 워크샵</a></li>
					<li><a href="#">변경된 구글 코리아의 첫 화면을 뜯어 보자.</a></li>
				</ol>
			</div>
			<div id="recentPost">
				<h3>Recent Post</h3>
				<ol>
					<li><a href="#">블로그 4번째 리뉴얼</a></li>
					<li><a href="#">Fujitsu ColorSelector 사용기</a></li>
					<li><a href="#">W3C의 마크업 유효성 검사 서비스 디자인</a></li>
					<li><a href="#">Fujitsu 웹 접근성 보조도구</a></li>
					<li><a href="#">구글 페이지 랭크 7점 획득</a></li>
				</ol>
			</div>
		</div>
	</nav>
	
	<section id="contents">
		
		<div id="firstTest">
			<p><a href="#first">MENU 1</a></p>
			<div id="first">
				<p>menu 1-1</p>
				<p>menu 1-2</p>
			</div>
		</div>
		
		<div id="secondTest">
			<p><a href="#second">MENU 2</a></p>
			<div id="second">
				<p>menu 2-1</p>
				<p>menu 2-2</p>
			</div>
		</div>
		
	</section>
</body>
</html>