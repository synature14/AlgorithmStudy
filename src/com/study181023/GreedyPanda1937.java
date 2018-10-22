package com.study181023;

import java.util.Scanner;
import static java.lang.Math.max;

public class GreedyPanda1937 {
    static int size;
    static int[][] dp;
    static int[][] bambooMap;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static int searchBamboo(int positionY, int positionX) {
        if(dp[positionY][positionX] == 0) {
            dp[positionY][positionX] = 1;

            for(int i=0; i<4; i++) {
                int nextY = positionY + dy[i];        // 행
                int nextX = positionX + dx[i];        // 열

                if( nextY >= 0 && nextX>=0 && nextX<size && nextY<size) {  // 범위 내에 있다면
                    if (bambooMap[nextY][nextX] > bambooMap[positionY][positionX]) {    // 이전에 먹은 대나무 양보다 많은 대나무가 있으면
                        dp[positionY][positionX] = max(dp[positionY][positionX], searchBamboo(nextY, nextX) + 1);
                    }
                }
            }
        }
        return dp[positionY][positionX];
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Scanner scan = new Scanner(System.in);

        size = scan.nextInt();
        scan.nextLine();
        bambooMap = new int[size][size];
        dp = new int[size][size];

        for(int i=0; i<size; i++) {
            String bamboo = scan.nextLine();
            String[] bambooRow = bamboo.split(" ");
            for (int j = 0; j < size; j++) {
                bambooMap[i][j] = Integer.parseInt(bambooRow[j]);
            }
        }


        int maximum = 0;

        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                maximum = max(searchBamboo(i, j), maximum);
            }
        }
        System.out.println(maximum);

        long end = System.currentTimeMillis();
        System.out.println((end-start)/1000 +" 초 걸림");
    }
}
