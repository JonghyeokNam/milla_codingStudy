package week1;

import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int result = 0; // 생성자 초기화

        // 0부터 N-1까지 모든 자연수 M을 탐색
        for(int i = 0; i < N; i++) {
            int number = i;
            int sum = 0;	// 각 자릿수 합 변수

            // 현재 숫자 i의 각 자릿수를 더함
            while(number != 0) {
                sum += number % 10;
                number /= 10;
            }

            // i 값과 각 자릿수 누적합이 같을 경우 (생성자를 찾았을 경우)
            if(sum + i == N) {
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}
