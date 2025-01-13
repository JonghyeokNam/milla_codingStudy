package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Day1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());

        int ballPos = 1;

        for (int i = 0; i < M; i++) {
            String[] str = br.readLine().split(" ");
            int X = Integer.parseInt(str[0]);
            int Y = Integer.parseInt(str[1]);

            if (X == ballPos) {
                ballPos = Y;
            }
            else if (Y == ballPos) {
                ballPos = X;
            }
        }

        if (ballPos == 1 || ballPos == 2 || ballPos == 3)
            System.out.println(ballPos);
        else
            System.out.println(-1);
    }
}
