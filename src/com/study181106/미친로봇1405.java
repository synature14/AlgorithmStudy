package com.study181106;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 미친로봇1405 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int n;
    static double ret = 0.0;
    static boolean[][] visited;
    static double[] possibility = new double[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        visited = new boolean[30][30];

        for(int i=0; i<4; i++) {
            possibility[i] = Double.parseDouble(st.nextToken()) / 100.0;
        }

        tracking(0, 1.0, 14, 14);
        System.out.println(ret);
    }

    static void tracking(int depth, double p, int x, int y) {
        visited[y][x] = true;

        if(depth == n) {
            ret = ret+p;
        }

        if(depth < n) {
            for(int i=0; i<4; i++) {
                int nextY = dy[i] + y;
                int nextX = dx[i] + x;

                if(!visited[nextY][nextX]) {
                    tracking(depth + 1, p * possibility[i], nextX, nextY);
                }
            }
        }

        // n만큼 이동 완료하고 나면, visited 초기화
        visited[y][x] = false;
    }

}
