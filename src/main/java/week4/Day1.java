package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Day1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] data = new int[n+1];
        for(int i = 1; i <= n; i++) {
            data[i]  = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n + 1];

        // n이 1, 2일 때는 바로 처리
        if(n == 1) {
            dp[1] = data[1];
        }
        else if (n == 2) {
            dp[1] = data[1];
            dp[2] = data[1] + data[2];
        }
        else {
            // 초기 설정
            dp[1] = data[1];
            dp[2] = data[1] + data[2];
            dp[3] = Math.max(data[1] + data[3], data[2] + data[3]);

            // i=4부터 점화식
            for(int i = 4; i <= n; i++) {
                dp[i] = Math.max(dp[i - 3] + data[i - 1] + data[i],
                        dp[i - 2] + data[i]);
            }
        }

        System.out.println(dp[n]);
    }
}
