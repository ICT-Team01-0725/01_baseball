package com.ict.team01.baseball;

import java.util.Random;
import java.util.Scanner;

// Developers : 김경서 & 김우현 & 김형주 & 박영찬 & 박현자 & 홍태경
// 주석으로 파트별 아이데이션을 올린 분의 이름을 적었습니다.
// 자세한 과정이 궁금하신 분은 Request를 확인해주세요.

// [ 특징 ]
// 사용자의 숫자는 스페이스바를 이용하여 입력을 받습니다.
// for문, while문, if~else문을 복합적으로 활용합니다.
// 사용자와 컴퓨터의 3개의 숫자 배열이 출력되어 가시적으로 비교가 가능합니다.
// 게임의 총 횟수를 gameCount로 측정하고 출력합니다.
// 사용자와 컴퓨터의 승패여부와 게임추가진행여부를 묻습니다.

public class Baseball00 {

    public static void main(String[] args) {

// 00. import 설정 > 팀 전원
        Random random = new Random();          // 컴퓨터의 난수 생성
        Scanner scan = new Scanner(System.in); // 사용자의 입력기능 생성

        boolean continueLoop = true;           // 진행여부 판단

// 00. 게임 총괄 변수 지정 > 김우현 & 김형주 & 박현자
        int gameCount = 0;     // 게임 카운트
        int userWins = 0;      // 사용자의 승리 횟수

        while (userWins < 3) {
            int[] com = new int[3];

// 01. 컴퓨터의 난수 생성 > 박영찬
            for (int i = 0; i < com.length; i++) {
                com[i] = (int) (Math.random() * 9) + 1;
                for (int j = 0; j < i; j++) {
                    if (com[i] == com[j]) {
                        i--;
                        break;
                    }
                }
            }

            // 컴퓨터의 난수 출력
            System.out.println("컴퓨터의 숫자: " + com[0] + " " + com[1] + " " + com[2]);

// 02. 사용자 입력 > 김우현 & 김형주 & 박현자
            
            int[] user = new int[3];
            System.out.println("3개의 정수를 입력하세요 (1~9)");
            System.out.print("스페이스로 구분하시고 마지막에 Enter를 눌러주세요 : ");
            user[0] = scan.nextInt();
            user[1] = scan.nextInt();
            user[2] = scan.nextInt();

            // 게임카운트 1회 증가
            gameCount++;

// 03. strike, ball, out 판단 및 출력 > 김경서
            
            int strike = 0;
            int ball = 0;

            for (int i = 0; i < com.length; i++) {
                if (com[i] == user[i]) {
                    strike++;
                } else if (com[i] == user[(i + 1) % 3] || com[i] == user[(i + 2) % 3]) {
                    ball++;
                }
            }
            // 한 세트는 3개의 숫자
            // 배열 인덱스가 이동하면서 순환되도록 3으로 나눈 나머지값 이용
            System.out.println("스트라이크: " + strike + ", 볼: " + ball + ", 아웃: " + (3 - strike - ball));

// 04. 게임 종료 조건 > 팀 전원 
            if (strike == 3) {
                System.out.println("축하합니다! 승리하셨습니다.");
                userWins++;
            }

            // 04-1. 게임 총횟수 출력
            System.out.println("총 게임 횟수: " + gameCount);

            // 04-2. 사용자의 승리 횟수가 3번이 되면 게임 종료 
            if (userWins >= 3) {
                System.out.println("사용자가 3번 승리하여 게임을 종료합니다.");
                break;
            }

// 05. 진행여부 > 김경서 & 박영찬 & 홍태경
            while (true) {
                System.out.println("계속하시겠습니까? (Y/N)");
                String str = scan.next();

                if (str.equalsIgnoreCase("y")) {
                    break; 
                } else if (str.equalsIgnoreCase("n")) {
                    System.out.println("게임을 종료합니다.");
                    continueLoop = false; 
                    break; 
                } else {
                    System.out.println("올바른 알파벳을 입력하세요.");
                }
            }

            if (!continueLoop) {
                break; 
            }
        }

        scan.close();
    }
}
