package com.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import static java.lang.Math.min;

public class 가장큰정사각형1915 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] array = new int[n+1][m+1];
        int[][] rectangle = new int[n+1][m+1];

        for(int i=0; i<n; i++) {
            String row = br.readLine();
            String[] rowArr = row.split("");

            for(int j=0; j<m; j++) {
                array[i][j] = Integer.parseInt(rowArr[j]);
                rectangle[i][j] = Integer.parseInt(rowArr[j]);
            }
        }

        int max = 0;
        for(int i=1; i<n; i++) {
            for(int j=1; j<m; j++) {
                if(array[i][j] == 0) continue;

                else if(array[i][j] == 1) {
                    rectangle[i][j] = min( min( rectangle[i-1][j], rectangle[i][j-1]) ,  rectangle[i-1][j-1]) + 1;
                    if(max < rectangle[i][j]) {
                        max = rectangle[i][j];
                    }
                }
            }
        }

        System.out.println(max * max);
    }
}
