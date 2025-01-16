package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Day4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N + 1];
        int[] P = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            String[] input = br.readLine().split(" ");
            T[i] = Integer.parseInt(input[0]);
            P[i] = Integer.parseInt(input[1]);
        }

        int[] dp = new int[N + 2]; // dp[i]: i일째부터 시작할 때 얻을 수 있는 최대 이익

        for (int i = N; i >= 1; i--) {
            if (i + T[i] - 1 > N) { // 상담이 퇴사일을 초과하면 상담 불가
                dp[i] = dp[i + 1];
            } else { // 상담을 선택하거나 선택하지 않는 경우 중 최대 이익 선택
                dp[i] = Math.max(dp[i + 1], P[i] + dp[i + T[i]]);
            }
        }

        System.out.println(dp[1]); // 1일째부터 시작할 때의 최대 이익
    }
}
