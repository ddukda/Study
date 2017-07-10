<%
/* 
*	웹 디자인 적용 
*	신기술 세미나
*	2015년 6월 3일
*	by 양진호
*/
%>
<%@ page language="java" contentType="text/html;charset=euc-kr" %>
<%@ page import="java.util.*, java.io.*, java.net.*" %> 
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="EUC-KR">
<title>LG U+ Feelring - Admin Site</title>
<style>
@font-face {
  font-family: 'Nanum Gothic';
  font-style: normal;
  font-weight: 800;
  src: url(//fonts.gstatic.com/ea/nanumgothic/v5/NanumGothic-ExtraBold.eot);
  src: url(//fonts.gstatic.com/ea/nanumgothic/v5/NanumGothic-ExtraBold.eot?#iefix) format('embedded-opentype'),
       url(//fonts.gstatic.com/ea/nanumgothic/v5/NanumGothic-ExtraBold.woff2) format('woff2'),
       url(//fonts.gstatic.com/ea/nanumgothic/v5/NanumGothic-ExtraBold.woff) format('woff'),
       url(//fonts.gstatic.com/ea/nanumgothic/v5/NanumGothic-ExtraBold.ttf) format('truetype');
}
p {
	font-family:'Nanum Gothic';
	font-size: 250%;
}

.image {
    position:relative;
    float:left; /* optional */
}
.image .text {
    position:absolute;
    top:20%; /* in conjunction with left property, decides the text position */
    left:30%;
    width:40%; /* optional, though better have one */
}
</style>
<body>
	<div class="image">
		<img width="100%" alt="배경" src="./image/feelring_main.jpg" />
		<div class="text">
			<p style="color: white;font-size: 100;">MAIN..</p>
		</div>
	</div>
</body>
</html>