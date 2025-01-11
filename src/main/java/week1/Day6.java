package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Day6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 입력 받기
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        // 숫자들을 저장할 2차원 char 배열
        char[][] board = new char[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        // 2. 브루트포스 탐색을 통해 최대 정사각형 찾기
        int maxArea = 1; // 최소 1×1은 항상 가능(모든 칸이 자기 자신만으로 정사각형)

        // (r, c) = 정사각형의 왼쪽 위 시작점
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {

                // k = 변 길이 - 1 (즉, 실제로는 k+1이 한 변의 칸 수)
                // r + k < N, c + k < M 범위 안에서만 탐색
                // 가장 긴 변의 길이는 min(N-r, M-c)
                int maxPossibleK = Math.min(N - r - 1, M - c - 1);

                for (int k = 1; k <= maxPossibleK; k++) {
                    // 네 꼭짓점이 같은 숫자인지 체크
                    char topLeft = board[r][c];
                    char topRight = board[r][c + k];
                    char bottomLeft = board[r + k][c];
                    char bottomRight = board[r + k][c + k];

                    // 모두 같다면, 넓이를 계산 후 maxArea 갱신
                    if (topLeft == topRight && topLeft == bottomLeft && topLeft == bottomRight) {
                        int sideLength = k + 1; // 실제 한 변의 길이
                        int area = sideLength * sideLength;
                        if (area > maxArea) {
                            maxArea = area;
                        }
                    }
                }
            }
        }

        // 3. 결과 출력
        System.out.println(maxArea);
    }
}

