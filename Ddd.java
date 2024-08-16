package number_baseball;

public class Ddd {
	// 초기값
	private int[] computer = new int[3];
	private int strike = 0;
	private int ball = 0;
	private int cnt = 0;
	private String res = "";
	// 생성자 생성시 랜덤 3자리 수 저장
	Ddd() {
		for(int i = 0 ; i <computer.length; i++) {
			computer[i] = (int)(Math.random()*9+1);
			for(int j = 0; j < i ; j++) {
				if(computer[i]==computer[j]) {
					i--;
					break;
				}
			}
		}
	}
	// play01 메서드 실행
	public String play01(int k){
		// strike ball 값 초기화
		strike = 0;
		ball = 0;
		for (int i = 0; i < computer.length; i++) {
			// 100의자리 비교후 strike ball 증감
			if(k/100 == computer[i]) {
				if(i==0) {
					strike++;
					continue;
				}
				else {
					ball ++;
					continue;
				}
			}
			// 10의자리 비교후 strike ball 증감
			if((k%100)/10 == computer[i]) {
				if(i==1) {
					strike++;
					continue;
				}else {
					ball++;
					continue;
				}
			}
			// 1의자리 비교후 strike ball 증감
			if(k%10 == computer[i]) {
				if(i==2) {
					strike++;
					continue;
				}else {
					ball++;
					continue;
				}
			}
		}
		// strike ball 모두 0이면 아웃
		if(strike==0 && ball==0) {
			res = "아웃";	
		}else {
			// strike ball 갯수를 res에 저장
			res = strike + "S"+ ball + "B";
		}
		// 카운트 증가
		cnt++;
		return res;
	}
	public int[] getComputer() {
		return computer;
	}
	public void setComputer(int[] computer) {
		this.computer = computer;
	}
	public int getStrike() {
		return strike;
	}
	public void setStrike(int strike) {
		this.strike = strike;
	}
	public int getBall() {
		return ball;
	}
	public void setBall(int ball) {
		this.ball = ball;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public String getRes() {
		return res;
	}
	public void setRes(String res) {
		this.res = res;
	}
}
