package com.study181113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 스도쿠2580 {
    static int[][] game;
    public static class Position {
        int x, y;
        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        game = new int[10][10];
        Queue<Position> zeroQueue = new LinkedList<>();

        for(int i=0; i<9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<9; j++) {
                game[i][j] = Integer.parseInt(st.nextToken());
                if(game[i][j] == 0) {
                    zeroQueue.add(new Position(j, i));
                }
            }
        }
        br.close();

        while(!zeroQueue.isEmpty()) {
            Position p1 = zeroQueue.poll();

            for(int num=1; num<10; num++) {
                // // 가로, 세로줄에 num과 중복되지 않는 숫자가 있는지, 3*3 영역
                if(block(num, p1.x, p1.y)){
                    game[p1.y][p1.x] = num;
                    break;
                }
            }
        }

        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                System.out.print(game[i][j]+ " ");
            }
            System.out.println();
        }

    }
    public static boolean block(int num, int x, int y) {
        boolean isAvailable = true;

        for(int j=0; j<9; j++) {
            if(game[j][x] == num || game[j][y] == num) {
                return !isAvailable;
            }
        }

        int startY = y / 3 * 3;
        int startX = x / 3 * 3;
        for(int i=startY; i<startY+3; i++) {
            for(int j=startX; j<startX+3; j++) {
                if(game[i][j] == num) {
                    return !isAvailable;
                }
            }
        }

        return isAvailable;
    }
}
