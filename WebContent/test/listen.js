function player_start(obj, mp3url, time){
	var idx = -1; 
    if(obj.name == 'btn_play'){ 
        idx = $("input[name=btn_play]").index(obj); 
    } 
//    alert('idx : ' + idx + '\nmp3url : ' + mp3url + '\ntime : ' + time);
	$('#container').jPlayer('stop');
	$('#container').jPlayer("clearMedia");
	$('#container').jPlayer("destroy");
	
	$('#container').jPlayer({
		ready: function () {
			$(this).jPlayer("setMedia", {mp3 : mp3url}).jPlayer("play");
		},
		timeupdate: function(event) {
			$("div[name=playTimePrint]").eq(idx).text($.jPlayer.convertTime(event.jPlayer.status.currentTime));
			$("#playTime").text($.jPlayer.convertTime(event.jPlayer.status.currentTime));
			if (event.jPlayer.status.currentTime > time) {
		    	$(this).jPlayer('stop');
		    	$(this).jPlayer("clearMedia");
		    	$(this).jPlayer("destroy");
		    	$("input[name=btn_play]").eq(idx).css("display","");
				$("input[name=btn_stop]").eq(idx).css("display","none");
				$("div[name=playTimePrint]").eq(idx).css("display","none");
			}
		},
		solution : "flash,html",
		swfPath : "./Jplayer.swf", 
		supplied : "mp3",
		preload : "none",
		autohide : 0,
		ended : function() {
			$("input[name=btn_play]").eq(idx).css("display","");
			$("input[name=btn_stop]").eq(idx).css("display","none");
			$("div[name=playTimePrint]").eq(idx).css("display","none");
		},
		error : function(event) {
			switch (event.jPlayer.error.type) {
			case $.jPlayer.error.URL:
				alert('미리듣기가 파일 미존재.');
				$("input[name=btn_play]").eq(idx).css("display","");
				$("input[name=btn_stop]").eq(idx).css("display","none");
				$("div[name=playTimePrint]").eq(idx).css("display","none");
				return false;
				break;
			default:
				break;
			}
		}
	});
	
	$("input[name=btn_play]").css("display","");
	$("input[name=btn_stop]").css("display","none");
	$("div[name=playTimePrint]").css("display","none");
	$("input[name=btn_play]").eq(idx).css("display","none");
	$("input[name=btn_stop]").eq(idx).css("display","");
	$("div[name=playTimePrint]").eq(idx).css("display","");
}


function player_stop(obj){
	var idx = -1; 
    if(obj.name == 'btn_stop'){ 
    	idx = $("input[name=btn_stop]").index(obj);
    }
	$('#container').jPlayer('stop');
	$('#container').jPlayer("clearMedia");
	$('#container').jPlayer("destroy");
	$("input[name=btn_play]").eq(idx).css("display","");
	$("input[name=btn_stop]").eq(idx).css("display","none");
	$("div[name=playTimePrint]").eq(idx).css("display","none");
}
