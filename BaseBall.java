package number_baseball;

import java.util.Scanner;

public class BaseBall {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (true) {
			// 임의의 값을 생성
			int[] computer = new int[3];
			for (int i = 0; i < computer.length; i++) {
				computer[i] = (int)(Math.random()*9)+1;
				for(int j = 0; j < i; j++) {
					// 비교해서 같으면 i --
					// 같은 무작위 값을 가지지 않게 넣어준다.
					if(computer[i] == computer[j]) {
						i--;
						break;
					}
				}
			}
			// 카운트
			int cnt = 0;
			while(true) {
				// 숫자를 맞춰본다
				System.out.println("숫자를 맞춰보세요");
				int input = scan.nextInt();
				int strike = 0;
				int ball = 0;
				for (int i = 0; i < computer.length; i++) {
					// 100의 자리수 비교
					if(input/100 == computer[i]) {
						if(i==0) {
							strike++;
						}else {
							ball++;
						}
					}
					// 10의 자리수 비교
					if((input%100)/10 == computer[i]) {
						if(i==1) {
							strike++;
						}else {
							ball++;
						}
					}
					// 1의 자리수 비교
					if(input%10 == computer[i]) {
						if(i==2) 
							strike++;
						else 
							ball++;
					}
				}
			// 결과 : res
			String res = "";
			if(strike==0&&ball==0) {
				res = "아웃";
			}else { // 스트라이크 수랑 볼 수 종합
				res = strike+"S"+ball+"B";
			}			
			System.out.println("입력한 숫자는 "+res);
			// 카운트 증가
			cnt++;
			// 다 맞을경우 탈출
			if(strike == computer.length) {
				System.out.println("정답입니다.");
				break;
			}
		}
		System.out.println("시도한 횟수 : "+cnt);
		// 지속 여부 확인
		System.out.println("계속 하시겠습니까(y/n)?");
		String str = scan.next();
		if(str.equalsIgnoreCase("y")) 
			continue;
		else break;
	}
	System.out.println("수고하셨습니다.");
	}
}