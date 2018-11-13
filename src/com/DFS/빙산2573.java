package com.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 빙산2573 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] meltingArr;
    static int[][] iceberg;
    static boolean[][] visited;
    static int n;
    static int m;

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

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        Queue<Position> queue = new LinkedList<>();

        iceberg = new int[n][m];
        meltingArr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < m; j++) {
                iceberg[i][j] = Integer.parseInt(st.nextToken());

                if(iceberg[i][j] > 0) {
                    queue.add(new Position(j, i));
                }
            }
        }

        while(!queue.isEmpty()) {
            Position p1 = queue.poll();

            for(int i=0; i<4; i++) {
                int nextY = p1.y + dy[i];
                int nextX = p1.x + dx[i];

                if(nextX >= 0 && nextX < m && nextY >=0 && nextY < n) {
                    if(iceberg[nextY][nextX] == 0) {
                        meltingArr[p1.y][p1.x] += 1;
                    }
                }
            }
        }

        // 빙산 높이 업데이
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                iceberg[i][j] = (iceberg[i][j]-meltingArr[i][j]) >= 0 ? iceberg[i][j]-meltingArr[i][j] : 0;
            }

            // 빙산 개수
            int count = 0;
//            for(int k=0; k<n; k++) {
//                for(int l=0; l<m; l++) {
//                    if(iceberg[k][l] != 0 && !visited[i][j]) {
//                        visited[i][j] = true;
//                        count++;
//                        dfs(i, j);
//                    }
//                }
//
//                if(count > 1){
//                    break;
//                }
//            }
        }


    }

    public static void dfs(int y, int x) {
        for(int i=0; i<4; i++) {
            int nextY = dy[i] + y;
            int nextX = dx[i] + x;

            if(nextX<0 || nextX >=n || nextY<0 || nextY>=m) continue;

            if(iceberg[nextY][nextX] != 0 && !visited[nextY][nextX]) {
                visited[nextY][nextX] = true;
                dfs(nextY, nextX);
            }
        }
        return;
    }

}
