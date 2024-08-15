package prac01;

public class Prac01 {

	public static void main(String[] args) {
		// 1+(-2)+3+(-4)+... 과 같은 식으로 계속 더해나갔을 때
		// 몇까지 더해야 총합이 100 이상이 되는지 구하시오 
		
		// for 문을 이용한 풀이 _ Prac01
		
		int sum = 0;
        int num = 1;
        
        for (int i = 1; ; i++) {	// 1부터 숫자 입력하여    
            if (i % 2 == 0) {
                sum -= i;  			// 짝수를 찾아 음수로 취급함  
            } else {
                sum += i;  			// 짝수를 제외한 수, 즉 홀수를 양수로 취급함  
            }
            
            if (sum >= 100) {		
                num = i;
                break;  			// 위의 규칙에 맞게 수의 총합이 100이상이 되는 지점을 찾으면 종료 (break)    
            }
        }
        System.out.println("총합이 100 이상이 되는 지점의 숫자 : " + num);
        
	}
}
