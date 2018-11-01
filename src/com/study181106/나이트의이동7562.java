package com.study181106;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 나이트의이동7562 {
    public static class Position {
        int x;
        int y;
        int count;

        Position(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int[] answers = new int[T];
        int[] dx = {1, -1, 2, -2, 2, -2, 1, -1};
        int[] dy = {-2, -2, -1, -1, 1, 1, 2, 2};

        Queue<Position> queue;

        while(T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            boolean[][] visited = new boolean[n][n];

            st = new StringTokenizer(br.readLine(), " ");
            Position start = new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
            st = new StringTokenizer(br.readLine(), " ");
            Position dest = new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);

            queue = new LinkedList<>();
            queue.add(start);

            while(!queue.isEmpty()) {
                Position current = queue.poll();
                int count = current.count;

                if (current.y == dest.y && current.x == dest.x) {
                    System.out.println(count);
                    break;
                }

                for(int i=0; i<8; i++) {
                    int nextY = current.y + dy[i];
                    int nextX = current.x + dx[i];

                    if(nextX>= 0 && nextX < n && nextY>=0 && nextY < n && !visited[nextY][nextX]) {
                        visited[nextY][nextX] = true;
                        queue.add(new Position(nextX, nextY, count+1));
                    }
                }
            }
        }

    }
}
