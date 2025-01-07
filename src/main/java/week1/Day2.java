package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Day2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[9];
        int sum = 0;

        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        Arrays.sort(arr);

        int n1 = 0, n2 = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (sum - arr[i] - arr[j] == 100) {
                    n1 = arr[i];
                    n2 = arr[j];
                    break;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != n1 && arr[i] != n2)
                System.out.println(arr[i]);
        }
    }
}
