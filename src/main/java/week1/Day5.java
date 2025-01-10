package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Day5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 줄: M, N
        String[] str = br.readLine().split(" ");
        int M = Integer.parseInt(str[0]);
        int N = Integer.parseInt(str[1]);

        // 보드 입력
        char[][] board = new char[M][N];
        for (int i = 0; i < M; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        // 가능한 모든 8×8 영역을 순회하면서 최소값 구하기
        int answer = Integer.MAX_VALUE;
        for (int startRow = 0; startRow <= M - 8; startRow++) {
            for (int startCol = 0; startCol <= N - 8; startCol++) {

                // 이 8×8 블록에서
                // 패턴 A(W 시작)와 패턴 B(B 시작) 중 어느 쪽이 더 적게 칠하나?
                int countA = 0;  // (0,0) = W
                int countB = 0;  // (0,0) = B

                for (int r = 0; r < 8; r++) {
                    for (int c = 0; c < 8; c++) {
                        // 실제 보드에서 (startRow + r, startCol + c)
                        char currentColor = board[startRow + r][startCol + c];

                        // (r + c)가 짝수냐 홀수냐에 따라 체스판 패턴이 달라진다
                        // 패턴 A(W 시작): 짝수 칸은 W, 홀수 칸은 B
                        if ((r + c) % 2 == 0) { // 짝수인 경우
                            // 패턴 A: W가 와야 함
                            if (currentColor != 'W') countA++;
                            // 패턴 B: B가 와야 함
                            if (currentColor != 'B') countB++;
                        } else { // (r+c)가 홀수
                            // 패턴 A: B가 와야 함
                            if (currentColor != 'B') countA++;
                            // 패턴 B: W가 와야 함
                            if (currentColor != 'W') countB++;
                        }
                    }
                }

                // 이 8×8 블록에서 필요한 최소 변경 횟수
                int localMin = Math.min(countA, countB);

                if (localMin < answer) {
                    answer = localMin;
                }
            }
        }

        System.out.println(answer);
    }
}
