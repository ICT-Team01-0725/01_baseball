package number_baseball;

import java.util.Scanner;

public class Base {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			// play 클래스 생성
			Ddd play = new Ddd();
			while(true) {
				System.out.println("숫자를 맞추세요.");
				// input 입력
				int input = scan.nextInt();
				// 결과값 res에 저장
				String res = play.play01(input);
				System.out.println("입력한 숫자는 "+res);
				// 정답일경우 while문 탈출
				if(play.getStrike()== play.getComputer().length) {
					System.out.println("정답입니다.");
					break;
				}
			}
			// 시행 횟수 출력
			System.out.println("시행 횟수 : "+play.getCnt());
			
			// 계속할지 여부 물음
			System.out.println("계속하시겠습니까?(y/n)");
			String tmp = scan.next();
			if(tmp.equalsIgnoreCase("y")) {
				continue;
			}else {
				break;
			}
		}
		System.out.println("고생하셨습니다.");
	}
}
