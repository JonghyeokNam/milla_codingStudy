package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Day3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 5x5 빙고판
        int[][] bingo = new int[5][5];
        // 사회자가 부르는 숫자(5줄 x 5개 = 25개)
        int[][] arr = new int[5][5];
        // 체크 배열
        int[][] check = new int[5][5];

        // check 배열 0으로 초기화 (2차원 배열에 대해서는 이렇게 해야 함)
        for (int i = 0; i < 5; i++) {
            Arrays.fill(check[i], 0);
        }

        // 빙고판 입력
        for (int i = 0; i < 5; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                bingo[i][j] = Integer.parseInt(input[j]);
            }
        }

        // 사회자가 부르는 숫자 입력
        for (int i = 0; i < 5; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        // line(빙고줄) 개수, 몇 번째 숫자인지
        int line = 0;
        int countCall = 0; // 부른 횟수

        // arr[k][l]은 (k*5 + l+1)번째로 부른 숫자
        // -> 5줄을 전부 순회하면서 총 25개 숫자 순서대로 처리
        outerLoop:
        for (int k = 0; k < 5; k++) {
            for (int l = 0; l < 5; l++) {
                int calledNum = arr[k][l];  // 이번에 부른 숫자
                countCall++;               // 부른 횟수 +1

                // (i, j)를 돌면서 bingo에서 calledNum과 같은 위치를 찾으면 check표시
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        if (bingo[i][j] == calledNum) {
                            check[i][j] = 1;
                            break; // 찾았으면 내부 루프 탈출(한 번만 찍으면 됨)
                        }
                    }
                }

                // 이제 빙고 줄(행, 열, 대각선) 확인
                line = getLineCount(check);

                // 빙고 줄이 3줄 이상이면 결과 출력 후 종료
                if (line >= 3) {
                    System.out.println(countCall);
                    break outerLoop;
                }
            }
        }
    }

    // check 배열을 보고 빙고 줄이 몇 개인지 세는 메서드
    private static int getLineCount(int[][] check) {
        int lineCount = 0;

        // 1) 가로줄
        for (int i = 0; i < 5; i++) {
            boolean isBingo = true;
            for (int j = 0; j < 5; j++) {
                if (check[i][j] == 0) {
                    isBingo = false;
                    break;
                }
            }
            if (isBingo) lineCount++;
        }

        // 2) 세로줄
        for (int j = 0; j < 5; j++) {
            boolean isBingo = true;
            for (int i = 0; i < 5; i++) {
                if (check[i][j] == 0) {
                    isBingo = false;
                    break;
                }
            }
            if (isBingo) lineCount++;
        }

        // 3) 대각선 1 (왼쪽 위 -> 오른쪽 아래)
        boolean isBingo = true;
        for (int i = 0; i < 5; i++) {
            if (check[i][i] == 0) {
                isBingo = false;
                break;
            }
        }
        if (isBingo) lineCount++;

        // 4) 대각선 2 (오른쪽 위 -> 왼쪽 아래)
        isBingo = true;
        for (int i = 0; i < 5; i++) {
            if (check[i][4 - i] == 0) {
                isBingo = false;
                break;
            }
        }
        if (isBingo) lineCount++;

        return lineCount;
    }
}
