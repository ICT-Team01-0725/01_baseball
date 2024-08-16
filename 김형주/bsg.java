package abc;

import java.util.Random;
import java.util.Scanner;

public class bsg {

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int com1, com2, com3;
        int user1, user2, user3;
        int gameCnt;
        int strikeCnt;
        int ballCnt;

        while (true) {
            // 3개의 난수를 중복되지 않도록 생성
            com1 = random.nextInt(9) + 1; 
            com2 = random.nextInt(9) + 1;
            com3 = random.nextInt(9) + 1;

            while (com1 == com2 || com2 == com3 || com3 == com1) {
                com2 = random.nextInt(9) + 1; 
                com3 = random.nextInt(9) + 1;
            }

            strikeCnt = 0; 
            gameCnt = 0; 

            while (true) {
                System.out.println("3개의 정수를 입력하세요(1~9)");
                System.out.println("숫자를 하나씩 입력할 때마다 Enter를 눌러주세요");
                user1 = scanner.nextInt();
                user2 = scanner.nextInt();
                user3 = scanner.nextInt();

                gameCnt++;

                strikeCnt = 0; 
                ballCnt = 0;

                if (com1 == user1) strikeCnt++;
                if (com2 == user2) strikeCnt++;
                if (com3 == user3) strikeCnt++;

                if (com1 == user2 || com1 == user3) ballCnt++;
                if (com2 == user1 || com2 == user3) ballCnt++;
                if (com3 == user1 || com3 == user2) ballCnt++;

                if (strikeCnt == 3) {
                    System.out.println("3스트라이크! 게임 종료");
                    System.out.println(gameCnt + "회를 시도하셨습니다.");
                    break;
                } else {
                    if (strikeCnt == 0 && ballCnt == 0) {
                        System.out.println("아웃입니다");
                    } else {
                        System.out.println(strikeCnt + "스트라이크, " + ballCnt + "볼");
                    }
                }
            }

            // 게임 재시작 여부를 숫자로만 입력받는 코드 추가
            int restart;
            while (true) {
                System.out.println("한 게임 더 하시겠습니까?(0: 종료, 1: 재시작)");
                String input = scanner.next();

                try {
                    restart = Integer.parseInt(input);
                    if (restart == 0 || restart == 1) {
                        break; 
                    } else {
                        System.out.println("0 또는 1을 입력하세요.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("유효하지 않은 입력입니다. 숫자만 입력하세요.");
                }
            }

            if (restart == 0) {
                System.out.println("게임이 종료되었습니다.");
                break;
            } else if (restart == 1) {
                System.out.println("게임을 다시 시작합니다.");
            }
        }
    }
}
