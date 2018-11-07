package com.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class 유기농배추1012 {
    static boolean[][] isVisited;
    static int[][] cabage;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int m;
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
        StringTokenizer st;

        int nTestCase = Integer.parseInt(br.readLine());
        Queue<Integer> answerQ = new LinkedList<>();

        while(nTestCase-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int nCabage = Integer.parseInt(st.nextToken());

            cabage = new int[m][n];
            isVisited = new boolean[m][n];
            Stack<Position> originStack = new Stack<>();

            for(int i=0; i<nCabage; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());

                cabage[y][x] = 1;
                originStack.push(new Position(x, y));
            }

            int wormCnt = 0;


            while(!originStack.isEmpty()) {
                Position p1 = originStack.pop();
                if(isVisited[p1.y][p1.x]) continue;
                wormCnt++;

                Queue<Position> cabageQueue = new LinkedList<>();
                cabageQueue.add(p1);

                while(!cabageQueue.isEmpty()) {
                    Position p2 = cabageQueue.poll();

                    for(int i=0; i<4; i++) {
                        int nextY = dy[i] + p2.y;
                        int nextX = dx[i] + p2.x;

                        if(nextX>=0 && nextY >= 0 && nextY<m && nextX<n &&
                                cabage[nextY][nextX] == 1) {

                            if(isVisited[nextY][nextX]) {
                                continue;
                            }
                            isVisited[nextY][nextX] = true;
                            cabageQueue.add(new Position(nextX, nextY));
                        }
                    }
                } // while(stack.empty)
            }

            answerQ.add(wormCnt);
        }

        int nAnswer = answerQ.size();
        for(int i=0; i<nAnswer; i++) {
            System.out.println(answerQ.poll());
        }

    }

}
