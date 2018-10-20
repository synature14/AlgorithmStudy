package com.company;
// https://www.acmicpc.net/problem/2156

import java.util.Scanner;
import static java.lang.Math.max;

public class TestingWine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = scan.nextInt();
        int[] array = new int[num+1];

        for(int i=1; i<=num; i++) {
            array[i] = scan.nextInt();
        }

        System.out.println(maxAmountWine(array, num));
    }

    public static int maxAmountWine(int[] wine, int size) {
        int[][] dp = new int[size+1][3];
        dp[1][0] = 0;   // 연속으로 0번 마심
        dp[1][1] = wine[1];     // 첫번째 잔 마심
        dp[1][2] = 0;       // 첫번째잔만 마신 상태에서 2번 연속으로 먹은 상태일수가 없

        for(int i=2; i<=size; i++) {
            for(int status=0; status<=2; status++) {
                if (status == 0) {
                    dp[i][status] = max( dp[i-1][0], max( dp[i-1][1], dp[i-1][2] ));
                }

                if (status == 1) {
                    dp[i][status] = dp[i-1][0] + wine[i];
                }

                if(status == 2) {
                    dp[i][status] = dp[i-1][1] + wine[i];
                }
            }
        }
        return max( max(dp[size][0], dp[size][1]), dp[size][2] );
    }
}
