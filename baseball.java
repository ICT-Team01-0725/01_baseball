package notepad;


import java.util.Random;
import java.util.Scanner;

public class baseball {

	public static void main(String[] args) {

		Random ran = new Random();
		Scanner scan = new Scanner(System.in);

		int com1 = ran.nextInt(9) + 1; // 1부터 9까지의 랜덤한 수
		int com2;
		do {
			com2 = ran.nextInt(9) + 1; // 부터 9까지의 랜덤한 수
		} while (com2 == com1); // 첫 번째 수와 중복되는 경우 다시 뽑기

		int com3;
		do {
			com3 = ran.nextInt(9) + 1; // 부터 9까지의 랜덤한 수
		} while (com3 == com1 || com3 == com2); // 첫 번째와 두 번째 수와 중복되는 경우 다시 뽑기

		int[] computer = new int[3];
		computer[0] = com1;
		computer[1] = com2;
		computer[2] = com3;

		System.out.println("랜덤으로 생성된 세 자리 숫자: " + com1 + com2 + com3);

		System.out.println();

		System.out.println("=================게임시작==================");
		System.out.println("=================중복없음==================");

		System.out.println();

//            해야할것 비교.
//            com1, com2, com3 이랑 user1, user2, user3 이랑 비교를 해야함.
//            for 문 ? com1,com2,com3 이 돌아가면서 user 1, 2, 3, 을 비교해야함 
//            com1 과 user 1 2 3 을 비교. 
//            만약에 com1 = user1 같다면 1S, com1 = user2 || com1 = user3 다면 1B
//            else 1OUT
//            com2도 마찬가지임.
//            반복문을 통해서 20번의 기회를 제공함.
//              
//            결과 도출.
		int left = 20;

		while (true) {

			// 사용자가 숫자 입력
			System.out.print("첫번째 : ");
			int user1 = scan.nextInt();
			System.out.print("두번쨰 : ");
			int user2 = scan.nextInt();
			System.out.print("세번째 : ");
			int user3 = scan.nextInt();
			// 사용자 입력값 출력
			System.out.println("입력한 숫자 " + user1 + user2 + user3);

			// 야구게임 룰 출력
			if (com1 == user1) {
				System.out.print(" 1S ");
			} else if (com1 == user2 || com1 == user3) {
				System.out.print(" 1B ");
			} else {
				System.out.print(" 1OUT ");
			}

			if (com2 == user2) {
				System.out.print(" 1S ");
			} else if (com2 == user1 || com2 == user3) {
				System.out.print(" 1B ");
			} else {
				System.out.print(" 1OUT ");
			}

			if (com3 == user3) {
				System.out.print(" 1S ");
			} else if (com3 == user1 || com3 == user2) {
				System.out.print(" 1B ");
			} else {
				System.out.print(" 1OUT ");
			}
		

		// 유저가 이겼을때의 조건.
		boolean chk = false;
	
		for (int i = 0; i < computer.length; i++) {
            if(user1 % computer[0] == 0 || user2 % computer[1] == 0 || user3 % computer[2] == 0)
             chk = true;
            System.out.println();
			System.out.println("3S 정답입니다.");
			System.out.println("사용자가 이겼습니다.");
		
		
		}
		if (chk) {
			break;
		}

		// 계씩 진행 여부.
		System.out.println("계속하시겠습니까 ? (Y/N)");
		String str = scan.next();

		if (str.equalsIgnoreCase("y")) {
			continue;
		} else {
			break;
		}

	

	}
	}
}
