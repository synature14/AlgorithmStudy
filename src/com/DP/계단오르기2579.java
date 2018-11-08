package com.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Math.max;

public class 계단오르기2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int nStair = Integer.parseInt(br.readLine());
        int[] stair = new int[nStair+1];

        for(int i=1; i<=nStair; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[nStair+1];

        for(int i=1; i<=3 && i<=nStair; i++) {
            if(i == 3) {
                dp[i] = max(stair[i] + stair[i-1], dp[i-2] + stair[i]);
            } else {
                dp[i] = dp[i-1] + stair[i];
            }
        }

        int max = 0;
        for(int i=4; i<=nStair; i++) {
             dp[i] = max(dp[i-3] + stair[i-1] + stair[i], dp[i-2] + stair[i]);

             if(max < dp[i]) {
                 max = dp[i];
             }
        }

        System.out.println(max);

    }
}
