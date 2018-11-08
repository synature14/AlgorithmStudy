package com.study181113;

// 백트래킹

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 비숍1799 {
    static Queue<Position> queue;
    static int[][] chess;
    static boolean[][] isPromising;
    static int n;

    public static class Position {
        int x;
        int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        chess = new int[n][n];
        queue = new LinkedList<>();
        isPromising = new boolean[n][n];

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<n; j++) {
                chess[i][j] = Integer.parseInt(st.nextToken());

                if(chess[i][j] == 1) {
                    queue.add(new Position(i, j));
                }
            }
        }

        while(!queue.isEmpty()) {
            Position bishop = queue.poll();
            isPromising[bishop.y][bishop.x] = true;

            dfs(bishop.x, bishop.y, 1);
        }
    }

    public static void dfs(int x, int y, int count) {
        if(isPromising[y][x] == false) {

        } else {

            for(int row=0; row<n; row++) {
                if(row % 2 == 0) {  // 짝수 행이라면,

                }
            }
        }

    }
}
