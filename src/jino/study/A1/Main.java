package jino.study.A1;

public class Main {
	
	static Baseball baseball = new Baseball();
	
	
	public static void main(String[] args) {

		
		// 야구 게임 시작
		// 숫자 3개를 랜덤으로 생성한다.
		baseball.BaseBallRun();
		
		// 야구 게임 중
		baseball.BaseBallProc();
		
		// 야구 게임 종료
		baseball.BaseBallEnd();

	}
}
