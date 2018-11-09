package com.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 영역구하기2583 {
    static boolean[][] isVisited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int m;
    static int n;
    static int k;
    static int[][] grid;

    static public class Position {
        int x;
        int y;
        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        m = Integer.parseInt(st.nextToken());   // 행
        n = Integer.parseInt(st.nextToken());   // 열
        k = Integer.parseInt(st.nextToken());

        grid = new int[m][n];

        for(int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            for(int row=startY; row<endY; row++) {
                for(int col=startX; col<endX; col++) {
                    grid[row][col] = 1;
                }
            }
        }

        isVisited = new boolean[m][n];
        PriorityQueue<Integer> answerQ = new PriorityQueue<>();

        for(int row=0; row<m; row++) {
            for(int col=0; col<n; col++) {
                if(grid[row][col] == 0) {
                    int width = dfs(new Position(col, row));

                    if( width != 0) {
                        answerQ.add(width);
                    }
                }
            }
        }

        System.out.println(answerQ.size());
        while(!answerQ.isEmpty()) {
            System.out.print(answerQ.poll()+ " ");
        }

    }

    public static int dfs(Position p) {
        int count = 0;
        Queue<Position> queue = new LinkedList<>();
        if (isVisited[p.y][p.x] || grid[p.y][p.x] == 1) {
            return count;
        }
        isVisited[p.y][p.x] = true;
        queue.add(p);

        while(!queue.isEmpty()) {
            Position p1 = queue.poll();

            for(int i=0; i<4; i++) {
                int nextY = p1.y + dy[i];
                int nextX = p1.x + dx[i];

                if(nextY >=0 && nextY<m && nextX >=0 && nextX<n) {
                    if(!isVisited[nextY][nextX] && grid[nextY][nextX] == 0) {
                        isVisited[nextY][nextX] = true;
                        queue.add(new Position(nextX, nextY));
                        count += 1;
                    }
                }
            }
        }   // while()
        return count + 1;
    }
}
