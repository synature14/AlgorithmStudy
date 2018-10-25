package com.study181030;

// 1차시도 : 그래프를 2차원 배열로 표현!, visited표시, DFS로 탐색
// 2차시도 : 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
        Queue<Integer> answerQueue = new LinkedList<>();
        String nm;

        do {
            nm = br.readLine();
            if( nm.equals("0 0") ) {
                break;
            }

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
                matrix[row][column] = weight;
            }

            Queue<Integer> queue = new LinkedList<>();  // start와 맞닿아있는 간선을 카운팅하는 용도
            for(int i=0; i<n; i++) {
                if(matrix[start][i] != 0) {
                    queue.add(i);
                }
            }

            int nStartEdge = queue.size();      // start와 맞닿아있는 간선의 개수
            int[] pathArray = new int[nStartEdge];     // S->D까지 모든 경로의 가중치 저장

            for(int i=0; i<nStartEdge; i++) {
                pathArray[i] = findPath(start);     // start 다음에 갈 장소
            }

            Arrays.sort(pathArray);     // 오름차순으로 정렬
            if (pathArray.length > 1) {
                int min = pathArray[0];     // 최소값
                for(int i=0; i<nStartEdge; i++) {
                    if(min < pathArray[i]) {
                        answerQueue.add(pathArray[i]);   // 최소값보다 큰값을 찾자마자 break
                        break;
                    }
                }
            } else {        // 경로가 한개라면 최소값만 존재하므로 -1 출력
                answerQueue.add(-1);
            }
        } while(!nm.equals("0 0"));


        while(answerQueue.peek() != null) {
            System.out.println(answerQueue.poll());
        }

    }

    public static int findPath(int from) {
        int weight = 0;
         for(int next=0; next<n; next++) {
             if (matrix[from][next] != 0 && visited[from][next] == false) {
                 visited[from][next] = visited[next][from] = true;

                 weight = matrix[from][next];
                 if(next == destination) {
                     return weight;
                 } else {
                     return weight += findPath(next);
                 }
            }
        }
        return weight;
    }
}
