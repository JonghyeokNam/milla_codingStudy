package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Day3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int arr[] = new int[N];
        int tri[] = new int[45];

        for (int i = 1; i < 45; i++) {
            tri[i] = i * (i + 1) / 2;
        }

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());

            int result = eureka(arr[i], tri);
            System.out.println(result);
        }
    }

    public static int eureka(int N, int[] tri) {

        for (int i = 1; i < 45; i++) {
            for (int j = 1; j < 45; j++) {
                for (int k = 1; k < 45; k++) {
                    if ((tri[i] + tri[j] + tri[k]) == N) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }
}
