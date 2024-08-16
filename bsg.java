package abc;

import java.util.Random;
import java.util.Scanner;

public class bsg {

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int com1, com2, com3;
        int user1, user2, user3;
        int gamecnt;
        int strikecnt;
        int ballcnt;

        while (true) {
            // 3개의 난수를 중복되지 않도록 생성
            com1 = random.nextInt(9) + 1; // random클래스의 nextInt(9)은 0~8까지의 난수를 생성하므로 + 1
            com2 = random.nextInt(9) + 1;
            com3 = random.nextInt(9) + 1;

            while (com1 == com2 || com2 == com3 || com3 == com1) {
                com2 = random.nextInt(9) + 1; // 중복 시 재생성
                com3 = random.nextInt(9) + 1;
            }

            strikecnt = 0; // 스트라이크 카운트 초기화
            gamecnt = 0; // 게임 카운트 초기화

            while (true) {
                System.out.println("3개의 정수를 입력하세요(1~9)");
                System.out.println("스페이스로 구분하시고 마지막에 Enter를 눌러주세요");
                user1 = scanner.nextInt();
                user2 = scanner.nextInt();
                user3 = scanner.nextInt();

                // 게임 카운트 1회 증가
                gamecnt++;

                strikecnt = 0; // 스트라이크, 볼 카운트 초기화
                ballcnt = 0;

                // 스트라이크 (숫자가 같고, 위치도 같으면 스트라이크)
                if (com1 == user1) strikecnt++;
                if (com2 == user2) strikecnt++;
                if (com3 == user3) strikecnt++;

                // 볼 (숫자는 같지만 위치가 다르면 볼)
                if (com1 == user2 || com1 == user3) ballcnt++;
                if (com2 == user1 || com2 == user3) ballcnt++;
                if (com3 == user1 || com3 == user2) ballcnt++;

                // 스트라이크 카운트가 3개가 되면 게임 종료
                if (strikecnt == 3) {
                    System.out.println("3스트라이크! 게임 종료");
                    System.out.println(gamecnt + "회를 시도하셨습니다.");
                    break;
                } else {
                    // 하나도 못 맞추는 경우
                    if (strikecnt == 0 && ballcnt == 0) {
                        System.out.println("아웃입니다");
                    } else {
                        System.out.println(strikecnt + " 스트라이크, " + ballcnt + " 볼");
                    }
                }
            }

            System.out.println("한 게임 더 하시겠습니까?(0: 종료, 1: 재시작)");
            int restart = scanner.nextInt();
            if (restart == 0) {
                // 게임 종료
                System.out.println("게임이 종료되었습니다.");
                break;
            } else if (restart == 1) {
                // 게임 재시작(변수 초기화는 이미 위에서 했으므로 추가할 필요 없음)
                System.out.println("게임을 다시 시작합니다.");
            }
        }
    }
}

