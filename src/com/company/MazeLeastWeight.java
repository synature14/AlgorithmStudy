package com.company;// https://www.acmicpc.net/problem/2178

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


class MazePoint {
    public int x, y;
    int depth = 0;

    MazePoint(int x, int y, int depth) {
        this.x = x;
        this.y = y;
        this.depth = depth;
    }
}

public class MazeLeastWeight {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String rowAndColumn = scan.nextLine();
        String[] arr = rowAndColumn.split(" ");

        int row = Integer.parseInt(arr[0]);
        int column = Integer.parseInt(arr[1]);
        int[][] mazeWeight = new int[row+1][column+1];

        for(int i=0; i<row; i++) {
            String eachRow = scan.nextLine();
            char[] charArray = eachRow.toCharArray();
            for(int j=0; j<column; j++) {
                mazeWeight[i][j] = charArray[j] - '0';
            }
        }
        bfsLeastWeight(row, column, mazeWeight);
    }

    public static void bfsLeastWeight (int row, int column, int[][] maze) {
        Queue<MazePoint> queue = new LinkedList<>();
        queue.add(new MazePoint(0,0, 1));

        boolean[][] visited = new boolean[row+1][column+1];
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        while(!queue.isEmpty()) {
            MazePoint p1 = queue.poll();

            if(visited[p1.y][p1.x]){
                continue;
            }
            else{
                visited[p1.y][p1.x] = true;
            }

            // 출구
            if (p1.y == row-1 && p1.x == column - 1) {
                System.out.println(p1.depth);
                break;
            }

            for(int i=0; i<4; i++) {
                int nextY = p1.y + dy[i];       // 행
                int nextX = p1.x + dx[i];       // 열

                if (nextX >= 0 && nextX < column && nextY >= 0 && nextY < row
                        && !visited[nextY][nextX] && maze[nextY][nextX] == 1) {
                    queue.add(new MazePoint(nextX, nextY, p1.depth+1));
                }
            }
        }
    }
}
