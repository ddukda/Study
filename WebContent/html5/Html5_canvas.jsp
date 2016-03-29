<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8"> 
<title>HTML5_Audio</title>
<script>
// window.onload = function(){
// 	var playBtn = document.getElementById("play");
// 	var rewindBtn = document.getElementById("rewind");
// 	var fastforwardBtn = document.getElementById("fastforward");
// 	var playTime = document.getElementById("status");
// 	var myvideo = document.getElementById("myvideo");
	
// 	playBtn.onclick = function(){
// 		myvideo.play();
// 	};
	
// 	rewindBtn.onclick = function(){
// 		myvideo.playbackRate -= 1;
// 	};
	
// 	fastforwardBtn.onclick = function(){
// 		myvideo.playbackRate += 1;
// 	};
	
// 	if(typeof myvideo.ontimeupdate != "object"){
// 		myvideo.addEventListener( "timeupdate", updateTime);
// 	}else{
// 		myvideo.ontimeupdate = updateTime;
// 	}
// };

window.onload = function(){
	var playBtn = document.getElementById("play");
	var pauseBtn = document.getElementById("pause");
	var rewindBtn = document.getElementById("rewind");
	var fastforwardBtn = document.getElementById("fastforward");
	var playTime = document.getElementById("status");
	
	
	var audio = document.getElementById("audio");
	
	playBtn.onclick = function(){
		audio.play();
	};
	
	pauseBtn.onclick = function(){
		audio.pause();
	};
	
	rewindBtn.onclick = function(){
		audio.playbackRate -= 1;
	};
	
	fastforwardBtn.onclick = function(){
		audio.playbackRate += 1;
	};
	
	if(typeof myvideo.ontimeupdate != "object"){
		audio.addEventListener( "timeupdate", updateTime);
	}else{
		audio.ontimeupdate = updateTime;
	}
};

function updateTime(){
	var current = myvideo.currentTime;
	var duration = myvideo.duration;
	playTime.innerHtml = current + "/" + duration;
}
</script>
<style>
	
</style>
<script src="../common/googleAnalytics.js"></script></head>
<body>
	<h1>Html5 Audio</h1>
	
<!-- 	<div> -->
<!-- 		<video id="myvideo" controls="controls" width="640" height="360" poster="../image/test.jpg" > -->
<!-- 			<source src="../image/12032818000003.wav"></source> -->
<!-- 			<p>비디오 재생을 지원하지 않는 브라우저 입니다.</p> -->
<!-- 		</video> -->
<!-- 	</div> -->
	<div>
<!-- 		 <audio controls="controls" autoplay="autoplay" loop="loop" preload="auto"> -->
		 <audio id="audio" controls="controls" >
	    <source src="../image/12032818000003.wav" type="audio/mpeg" />
<!-- 	    <source src="exam.ogg" type="audio/ogg" /> -->
	    <p>죄송합니다. 지금 사용하고 계신 브라우저가 audio 태그를 지원하지 않습니다.</p>
  	</audio>
  </div>
	<div>
		<button id="play">play</button>
		<button id="pause">pause</button>
		<button id="rewind">&lt;&lt;</button>
		<button id="fastforward">&gt;&gt;</button>
		<span id="status"></span>
	</div>
</body>
</html>