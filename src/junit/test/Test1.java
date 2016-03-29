package junit.test;


import junit.framework.TestCase;

public class Test1 extends TestCase {
	
//		http://211.115.75.243:8081/web2/svc/ban/ban.jsp?id=abc
//		http://211.115.75.243:8081/web2/svc/con_list/cate_list.jsp?hpEziCon=01057402473&intgWbmbId=&seq=a&page=b&main_genre=c&sub_genre=d
//		http://211.115.75.243:8081/web2/svc/con_list/list_best.jsp?mid=2047&hpEziCon=01057402473&intgWbmbId=&page=a
//		http://211.115.75.243:8081/web2/svc/con_list/list_name.jsp?hpEziCon=01057402473&intgWbmbId=&page=a
//		http://211.115.75.243:8081/web2/svc/con_list/list_new.jsp?hpEziCon=01057402473&intgWbmbId=&page=a
//		http://211.115.75.243:8081/web2/svc/etiquette/intro_etiquette_ok.jsp?hpEziCon=01057402473&intgWbmbId=&etiquette=1&feelEtiquette=1&feelring=1
//		http://211.115.75.243:8081/web2/svc/etiquette/intro_etiquette_session.jsp?hpEziCon=01057402473&intgWbmbId=&etiqStatus=1
//		http://211.115.75.243:8081/web2/svc/etiquette/intro_etiquette.jsp?hpEziCon=01057402473&intgWbmbId=&sessionValue=1&etiqStatus=2&introSetUpValue=3
//		http://211.115.75.243:8081/web2/svc/etiquette/regist_etiquette.jsp?hpEziCon=01057402473&etiquette=1&feelEtiquette=2
//		http://211.115.75.243:8081/web2/svc/guide/guide_intro.jsp?hpEziCon=01057402473&intgWbmbId=&resLoginErr=a
//		http://211.115.75.243:8081/web2/svc/inc/popAgntBlock.jsp?resEtiqErr=1
//		http://211.115.75.243:8081/web2/svc/myintrofeelring/cnip_delete_ok.jsp?hpEziCon=01057402473&intgWbmbId=&szSeq=
//		http://211.115.75.243:8081/web2/svc/myintrofeelring/cnip_delete_ok.jsp?hpEziCon=01057402473&intgWbmbId=&szSeq=a
//		http://211.115.75.243:8081/web2/svc/myintrofeelring/cnip_modify_ok.jsp?hpEziCon=01057402473&intgWbmbId=&szSeq=&chgCnipPhone=
//		http://211.115.75.243:8081/web2/svc/myintrofeelring/cnip_modify_ok.jsp?hpEziCon=01057402473&intgWbmbId=&szSeq=a&chgCnipPhone=a
//		http://211.115.75.243:8081/web2/svc/myintrofeelring/cnip_modify.jsp?hpEziCon=01057402473&intgWbmbId=&szSeq=&szCtn=
//		http://211.115.75.243:8081/web2/svc/myintrofeelring/cnip_modify.jsp?hpEziCon=01057402473&intgWbmbId=&szSeq=a&szCtn=a
//		http://211.115.75.243:8081/web2/svc/myintrofeelring/gift_delete_ok.jsp?hpEziCon=01057402473&intgWbmbId=&szSeq=
//		http://211.115.75.243:8081/web2/svc/myintrofeelring/gift_delete_ok.jsp?hpEziCon=01057402473&intgWbmbId=&szSeq=a211.115.75.243:8081/web2/svc/myintrofeelring/my_introfeelring_history_basering.jsp?szCtn=&page=
//		http://211.115.75.243:8081/web2/svc/myintrofeelring/my_introfeelring_history_basering.jsp?szCtn=a&page=a
//		http://211.115.75.243:8081/web2/svc/myintrofeelring/my_introfeelring_history_cnipring.jsp?szCtn=&seq=&page=
//		http://211.115.75.243:8081/web2/svc/myintrofeelring/my_introfeelring_history_cnipring.jsp?szCtn=ads&seq=a&page=a211.115.75.243:8081/web2/svc/myintrofeelring/my_introfeelring_history_etiquettering.jsp?szCtn=&seq=&page=
//		http://211.115.75.243:8081/web2/svc/myintrofeelring/my_introfeelring_history_etiquettering.jsp?szCtn=ads&seq=a&page=a211.115.75.243:8081/web2/svc/myintrofeelring/my_introfeelring_history_giftdelring.jsp?szCtn=&seq=&page=
//		http://211.115.75.243:8081/web2/svc/myintrofeelring/my_introfeelring_history_giftdelring.jsp?szCtn=a&seq=a&page=a211.115.75.243:8081/web2/svc/myintrofeelring/my_introfeelring_history_giftring.jsp?szCtn=&seq=&page=
//		http://211.115.75.243:8081/web2/svc/myintrofeelring/my_introfeelring_history_giftring.jsp?szCtn=a&seq=a&page=a211.115.75.243:8081/web2/svc/myintrofeelring/my_introfeelring_history_timering.jsp?szCtn=&seq=&page=
//		http://211.115.75.243:8081/web2/svc/myintrofeelring/my_introfeelring_history_timering.jsp?szCtn=a&seq=a&page=a211.115.75.243:8081/web2/svc/myintrofeelring/time_modify_ok.jsp?chgTime1=&chgTime2=
//		http://211.115.75.243:8081/web2/svc/myintrofeelring/time_modify_ok.jsp?chgTime1=abc&chgTime2=dfvb
//		http://211.115.75.243:8081/web2/svc/myintrofeelring/time_modify.jsp?szCtn=
//		http://211.115.75.243:8081/web2/svc/myintrofeelring/time_modify.jsp?szCtn=a211.115.75.243:8081/web2/svc/regist/getOtp.jsp?resChangSoc=&nMsgType=&nSubType=
//		http://211.115.75.243:8081/web2/svc/regist/getOtp.jsp?resChangSoc=a&nMsgType=a&nSubType=a
//		http://211.115.75.243:8081/web2/svc/regist/intro_multiline_chk.jsp?mode=a&newMemCtn=a&oldMemCtn=a&status=1
//		http://211.115.75.243:8081/web2/svc/regist/intro_multiline_list.jsp?mode=%EC%9C%BC%ED%95%98%ED%95%98
//		http://211.115.75.243:8081/web2/svc/regist/join_serviceum_ok.jsp?nMsgType=&resOtp=
//		http://211.115.75.243:8081/web2/svc/regist/join_serviceum_ok.jsp?nMsgType=%E3%85%81&resOtp=%E3%85%81
//		http://211.115.75.243:8081/web2/svc/regist/pop_join_ok.jsp?err_code=%E3%85%81
//		http://211.115.75.243:8081/web2/svc/regist/pop_join_otp.jsp?resChangSoc=&nMsgType=&nSubType=
//		http://211.115.75.243:8081/web2/svc/regist/pop_join_otp.jsp?resChangSoc=%ED%85%8C%EC%8A%A4%ED%8A%B8&nMsgType=%ED%85%8C%EC%8A%A4%ED%8A%B8&nSubType=%ED%85%8C%EC%8A%A4%ED%8A%B8
//		http://211.115.75.243:8081/web2/svc/setup/intro_voice.jsp?page=a&cate_code=ahttp://211.115.75.243:8081/web2/svc/setup/prelisten_ok.jsp?szVoice=a&szChange_Tone=a&szServiceType=ahttp://211.115.75.243:8081/web2/svc/setup/PreListen.jsp?szConCode=a&szCpCode=a&szVoiceImo=a&szServiceType=a&szSeq=ahttp://211.115.75.243:8081/web2/svc/setup/setup_base_result.jsp?nErr=test&szSeq=testhttp://211.115.75.243:8081/web2/svc/setup/setup_base_resultIn.jsp?szVoice=%ED%85%8C%EC%8A%A4%ED%8A%B8&szChange_Tone=%ED%85%8C%EC%8A%A4%ED%8A%B8&szConCode=%ED%85%8C%EC%8A%A4%ED%8A%B8&szCpCode=%ED%85%8C%EC%8A%A4%ED%8A%B8&szNCode=%ED%85%8C%EC%8A%A4%ED%8A%B8&szServiceType=%ED%85%8C%EC%8A%A4%ED%8A%B8&szPhoneInPut=%ED%85%8C%EC%8A%A4%ED%8A%B8&szSeq=%ED%85%8C%EC%8A%A4%ED%8A%B8http://211.115.75.243:8081/web2/svc/setup/setup_base.jsp?szVoice=%ED%85%8C%EC%8A%A4%ED%8A%B8&szChange_Tone=%ED%85%8C%EC%8A%A4%ED%8A%B8&szConCode=%ED%85%8C%EC%8A%A4%ED%8A%B8&szCpCode=%ED%85%8C%EC%8A%A4%ED%8A%B8&szServiceType=%ED%85%8C%EC%8A%A4%ED%8A%B8&szPhoneInPut=%ED%85%8C%EC%8A%A4%ED%8A%B8&szSeq=%ED%85%8C%EC%8A%A4%ED%8A%B8&szNCode=%ED%85%8C%EC%8A%A4%ED%8A%B8http://211.115.75.243:8081/web2/svc/setup/setup_friend_result.jsp?nErr=%ED%85%8C%EC%8A%A4%ED%8A%B8&szSeq=%ED%85%8C%EC%8A%A4%ED%8A%B8http://211.115.75.243:8081/web2/svc/setup/setup_friend_resultIn.jsp?szVoice=%ED%85%8C%EC%8A%A4%ED%8A%B8&szChange_Tone=%ED%85%8C%EC%8A%A4%ED%8A%B8&cnip_phone=%ED%85%8C%EC%8A%A4%ED%8A%B8&szConCode=%ED%85%8C%EC%8A%A4%ED%8A%B8&szCpCode=%ED%85%8C%EC%8A%A4%ED%8A%B8&szNCode=%ED%85%8C%EC%8A%A4%ED%8A%B8&szServiceType=%ED%85%8C%EC%8A%A4%ED%8A%B8&szPhoneInPut=%ED%85%8C%EC%8A%A4%ED%8A%B8&szSeq=%ED%85%8C%EC%8A%A4%ED%8A%B8
//		http://211.115.75.243:8081/web2/svc/setup/setup_friend.jsp?szVoice=%ED%85%8C%EC%8A%A4%ED%8A%B8&szChange_Tone=%ED%85%8C%EC%8A%A4%ED%8A%B8&szConCode=%ED%85%8C%EC%8A%A4%ED%8A%B8&szCpCode=%ED%85%8C%EC%8A%A4%ED%8A%B8&szServiceType=%ED%85%8C%EC%8A%A4%ED%8A%B8&szPhoneInPut=%ED%85%8C%EC%8A%A4%ED%8A%B8&szSeq=%ED%85%8C%EC%8A%A4%ED%8A%B8&szNCode=%ED%85%8C%EC%8A%A4%ED%8A%B8http://211.115.75.243:8081/web2/svc/setup/setup_gift_result.jsp?szVoice=%ED%85%8C%EC%8A%A4%ED%8A%B8&szChange_Tone=%ED%85%8C%EC%8A%A4%ED%8A%B8&nErr=%ED%85%8C%EC%8A%A4%ED%8A%B8&szGift_phone=%ED%85%8C%EC%8A%A4%ED%8A%B8&szConCode=%ED%85%8C%EC%8A%A4%ED%8A%B8&szNCode=%ED%85%8C%EC%8A%A4%ED%8A%B8&szCpCode=%ED%85%8C%EC%8A%A4%ED%8A%B8&szServiceType=%ED%85%8C%EC%8A%A4%ED%8A%B8&szPhoneInPut=%ED%85%8C%EC%8A%A4%ED%8A%B8&szCtn=%ED%85%8C%EC%8A%A4%ED%8A%B8http://211.115.75.243:8081/web2/svc/setup/setup_gift_resultIn.jsp?gift_phone=%ED%85%8C%EC%8A%A4%ED%8A%B8&szConCode=%ED%85%8C%EC%8A%A4%ED%8A%B8&szCpCode=%ED%85%8C%EC%8A%A4%ED%8A%B8&szNCode=%ED%85%8C%EC%8A%A4%ED%8A%B8&szServiceType=%ED%85%8C%EC%8A%A4%ED%8A%B8&szPhoneInPut=%ED%85%8C%EC%8A%A4%ED%8A%B8&szVoice=%ED%85%8C%EC%8A%A4%ED%8A%B8&szChange_Tone=%ED%85%8C%EC%8A%A4%ED%8A%B8http://211.115.75.243:8081/web2/svc/setup/setup_gift.jsp?szConCode=%ED%85%8C%EC%8A%A4%ED%8A%B8&szCpCode=%ED%85%8C%EC%8A%A4%ED%8A%B8&szServiceType=%ED%85%8C%EC%8A%A4%ED%8A%B8&szPhoneInPut=%ED%85%8C%EC%8A%A4%ED%8A%B8&szSeq=%ED%85%8C%EC%8A%A4%ED%8A%B8&szNCode=%ED%85%8C%EC%8A%A4%ED%8A%B8&szVoice=%ED%85%8C%EC%8A%A4%ED%8A%B8&szChange_Tone=%ED%85%8C%EC%8A%A4%ED%8A%B8http://211.115.75.243:8081/web2/svc/setup/setup_time_result.jsp?nErr=%ED%85%8C%EC%8A%A4%ED%8A%B8&szSeq=%ED%85%8C%EC%8A%A4%ED%8A%B8http://211.115.75.243:8081/web2/svc/setup/setup_time_resultIn.jsp?szVoice=%ED%85%8C%EC%8A%A4%ED%8A%B8&szChange_Tone=%ED%85%8C%EC%8A%A4%ED%8A%B8&szTime1=%ED%85%8C%EC%8A%A4%ED%8A%B8&szTime2=%ED%85%8C%EC%8A%A4%ED%8A%B8&szConCode=%ED%85%8C%EC%8A%A4%ED%8A%B8&szCpCode=%ED%85%8C%EC%8A%A4%ED%8A%B8&szNCode=%ED%85%8C%EC%8A%A4%ED%8A%B8&szServiceType=%ED%85%8C%EC%8A%A4%ED%8A%B8&szPhoneInPut=%ED%85%8C%EC%8A%A4%ED%8A%B8&szSeq=%ED%85%8C%EC%8A%A4%ED%8A%B8http://211.115.75.243:8081/web2/svc/setup/setup_time.jsp?szVoice=%ED%85%8C%EC%8A%A4%ED%8A%B8&szChange_Tone=%ED%85%8C%EC%8A%A4%ED%8A%B8&szConCode=%ED%85%8C%EC%8A%A4%ED%8A%B8&szCpCode=%ED%85%8C%EC%8A%A4%ED%8A%B8&szServiceType=%ED%85%8C%EC%8A%A4%ED%8A%B8&szPhoneInPut=%ED%85%8C%EC%8A%A4%ED%8A%B8&szSeq=%ED%85%8C%EC%8A%A4%ED%8A%B8&szNCode=%ED%85%8C%EC%8A%A4%ED%8A%B8
//		http://211.115.75.243:8081/web2/svc/setup/setupTTS_ok.jsp?szConCode=%ED%85%8C%EC%8A%A4%ED%8A%B8&szCpCode=%ED%85%8C%EC%8A%A4%ED%8A%B8&szServiceType=%ED%85%8C%EC%8A%A4%ED%8A%B8&szPhoneInPut=%ED%85%8C%EC%8A%A4%ED%8A%B8&szSeq=%ED%85%8C%EC%8A%A4%ED%8A%B8&szVoice=%ED%85%8C%EC%8A%A4%ED%8A%B8&szChange_Tone=%ED%85%8C%EC%8A%A4%ED%8A%B8http://211.115.75.243:8081/web2/svc/setup/setupTTSGift_ok.jsp?szConCode=%ED%85%8C%EC%8A%A4%ED%8A%B8&szCpCode=%ED%85%8C%EC%8A%A4%ED%8A%B8&szServiceType=%ED%85%8C%EC%8A%A4%ED%8A%B8&szPhoneInPut=%ED%85%8C%EC%8A%A4%ED%8A%B8&szSeq=%ED%85%8C%EC%8A%A4%ED%8A%B8&szVoice=%ED%85%8C%EC%8A%A4%ED%8A%B8&szChange_Tone=%ED%85%8C%EC%8A%A4%ED%8A%B8http://211.115.75.243:8081/web2/svc/intro_search_list.jsp?page=%ED%85%8C%EC%8A%A4%ED%8A%B8&resFlag=%ED%85%8C%EC%8A%A4%ED%8A%B8

	public void test1(){
		
		
		try{

		}catch(Exception e){
			System.out.println("Exception : " + e.toString());
		}
		
		
		
		
	}

	
}
