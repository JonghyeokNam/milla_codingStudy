package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Day4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 영학이가 가진 두 장
        String[] strs = br.readLine().split(" ");
        int A = Integer.parseInt(strs[0]);
        int B = Integer.parseInt(strs[1]);
        // 전체 카드(1~10 각각 2장) 구성
        ArrayList<Integer> deck = new ArrayList<>();
        for (int num = 1; num <= 10; num++) {
            deck.add(num);
            deck.add(num);
        }

        // 영학이가 가진 카드 A, B를 deck에서 제거
        removeOneCard(deck, A);
        removeOneCard(deck, B);

        // 이제 deck에는 18장 남음
        // 상대방이 뽑는 2장 모든 경우의 수(조합)를 확인하기
        int totalCases = 0;   // 상대가 뽑을 수 있는 모든 경우 (18C2 = 153)
        int winCount = 0;    // 영학이가 이기는 경우의 수

        // 영학이의 족보 등급
        int myRank = getRank(A, B);

        // deck에서 2장을 뽑는 모든 조합 순회
        for (int i = 0; i < deck.size(); i++) {
            for (int j = i + 1; j < deck.size(); j++) {
                totalCases++;

                int c1 = deck.get(i);
                int c2 = deck.get(j);

                // 상대 패의 족보 등급
                int opponentRank = getRank(c1, c2);

                // 영학이 > 상대방 인지 비교
                if (myRank > opponentRank) {
                    winCount++;
                }
            }
        }

        // 이길 확률 = (이기는 경우의 수) / (전체 경우의 수)
        double winProbability = (double) winCount / totalCases;

        // 소수점 셋째 자리까지 반올림하여 출력 (뒤에 0도 유지)
        System.out.printf("%.3f\n", winProbability);
    }

    // 카드 족보 등급을 반환
    // 땡이면 100 + 숫자 (예: 10땡=110, 9땡=109, ..., 1땡=101)
    // 땡이 아니면 (card1 + card2) % 10
    // 즉, 땡 > 9끗 > 8끗 ... > 0끗 순으로 비교 가능
    private static int getRank(int card1, int card2) {
        if (card1 == card2) {
            return 100 + card1; // 땡
        } else {
            return (card1 + card2) % 10; // 끗
        }
    }

    // deck에서 특정 숫자 카드를 하나만 제거하는 함수
    private static void removeOneCard(ArrayList<Integer> deck, int card) {
        for (int i = 0; i < deck.size(); i++) {
            if (deck.get(i) == card) {
                deck.remove(i);
                return;
            }
        }
    }
}
