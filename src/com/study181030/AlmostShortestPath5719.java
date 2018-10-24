package com.study181030;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AlmostShortestPath5719 {
    static int[][] matrix;
    static boolean[][] visited;
    static int n;
    static int destination;
    static int start;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String nm = br.readLine();
        StringTokenizer st = new StringTokenizer(nm, " ");
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String sd = br.readLine();
        st = new StringTokenizer(sd, " ");
        start = Integer.parseInt(st.nextToken());
        destination = Integer.parseInt(st.nextToken());
        matrix = new int[n][n];
        visited = new boolean[n][n];

        for(int i=0; i<m; i++) {
            String road = br.readLine();
            st = new StringTokenizer(road, " ");
            int row = Integer.parseInt(st.nextToken());
            int column = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            matrix[row][column] = matrix[column][row] = weight;
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] pathArray = new int[m];     // S->D까지 모든 경로의 가중치 저장

        for(int i=0; i<n; i++) {
            if(matrix[start][i] != 0) {
                queue.add(i);
            }
        }

        for(int i=0; i<queue.size(); i++) {
            int next = queue.poll();      // start 다음에 갈 장소
            pathArray[i] = findPath(start, next);
            System.out.println(pathArray[i]);
        }

    }

    public static int findPath(int from, int to) {
        System.out.println("---------findPath--------");
        System.out.println("from : " + from + ", to : " + to + " -- matrix[from][to] : " + matrix[from][to]);
        int weight = 0;
        if (visited[from][to]) return 0;

        if(to == destination) {
            weight += matrix[from][to];
        } else {
            for(int next=0; next<n; next++) {
                if (matrix[to][next] != 0 && visited[to][next] == false) {
                    visited[to][next] = visited[next][to] =true;
                    weight += findPath(to, next);
                }
            }
        }
        return weight;
    }
}
