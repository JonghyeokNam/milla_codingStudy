package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Day2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int money = Integer.parseInt(br.readLine());

        int smCount = 0;
        int jhCount = 0;

        int smCash = 0;
        int jhCash = 0;

        jhCash = money;
        String[] str = br.readLine().split(" ");
        for (int i = 0; i < 14; i++) {
            if (jhCount == 0 && Integer.parseInt(str[i]) <= jhCash) {
                jhCount = jhCash / Integer.parseInt(str[i]);
                jhCash = jhCash % Integer.parseInt(str[i]);
            }
        }
        jhCash += Integer.parseInt(str[13]) * jhCount;

        smCash = money;
        for (int i = 3; i < 14; i++) {
            if (smCash >= Integer.parseInt(str[i]) && smCount == 0 && Integer.parseInt(str[i]) < Integer.parseInt(str[i - 1]) && Integer.parseInt(str[i - 1]) < Integer.parseInt(str[i - 2]) && Integer.parseInt(str[i - 2]) < Integer.parseInt(str[i - 3])) {
                smCount = smCash / Integer.parseInt(str[i]);
                smCash = smCash % Integer.parseInt(str[i]);
            }

            if (smCount != 0 && Integer.parseInt(str[i]) > Integer.parseInt(str[i - 1]) && Integer.parseInt(str[i - 1]) > Integer.parseInt(str[i - 2]) && Integer.parseInt(str[i - 2]) > Integer.parseInt(str[i - 3])) {
                smCash += Integer.parseInt(str[i]) * smCount;
                smCount = 0;
            }
        }
        if (smCount != 0) {
            smCash += Integer.parseInt(str[13]) * smCount;
        }

        if (jhCash > smCash) {
            System.out.println("BNP");
        }
        else if (jhCash < smCash) {
            System.out.println("TIMING");
        }
        else {
            System.out.println("SAMESAME");
        }
    }
}
