package com.company;

// https://www.acmicpc.net/problem/14501

import java.util.Scanner;
import static java.lang.Math.max;

public class Resign14501 {
    static int[][] schedule;
    static int n;

    public static int maxIncome(int current) {

        if (schedule[current][0] > n-current) {
            return 0;
        } else {
            return max( maxIncome(current+schedule[current][0]) + schedule[current][1]
                    , maxIncome(current+1));    // 이동했을때 vs.
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();
        schedule = new int[n + 1][2];

        for (int i = 1; i <= n; i++) {
            schedule[i][0] = scan.nextInt();    // time
            schedule[i][1] = scan.nextInt();    // income
        }

        int answer = maxIncome(1);

        System.out.println(answer);
    }
}
