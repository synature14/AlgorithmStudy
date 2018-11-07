package com.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이친수2193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] dp = new long[91];

        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 3;
        dp[5] = 5;
        dp[6] = 8;

        for(int i=7; i<=90; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        int n = Integer.parseInt(br.readLine());
        System.out.println(dp[n]);

    }
}
