package com.study181030;

// 다익스트라 알고리즘 with PriorityQueue

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ShortestPath1753 {
    static int nVertex;
    static int nEdge;
    static int start;

    public static class Pair implements Comparable<Pair> {
        int source;
        int weight;

        Pair(int src, int w) {
            this.source = src;
            this.weight = w;
        }

        @Override
        public int compareTo(Pair o) {      // 우선순위 큐를 사용하기 위해선 Comparable 인터페이스를 따라야함. 안그러면 NullPointerException 발생
            return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        nVertex = Integer.parseInt(st.nextToken());
        nEdge = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());
        int[] distance = new int[nVertex+1];    // i까지의 최단경로
        Pair[][] graph = new Pair[nVertex+1][nVertex+1];  // row: 시작점, column: 인점한 정점 저장

        for(int i=1; i<=nVertex; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[from][to] = new Pair(to, cost);   // ex) graph[2][3] = Pair(3, 4) : 5->1로가는 간선의 가중치는 1
            distance[i] = 100;
        }

        distance[start] = 0;     // 시작점 ~ 자기 자신까지의 경로는 0개

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(start, 0));

        while(!pq.isEmpty()) {
            int sourceIndex = pq.peek().source;
            int weight = pq.peek().weight;
            pq.poll();

            if(distance[sourceIndex] < weight ) continue;       // start~source까지의 가중치 < 방금 찾은 가중치 : 무시하면 되는 케이스

            for(int i=1; i<=nVertex; i++) {
                if(graph[sourceIndex][i] != null) {      // sourceIndex -> i로 가는 경로가 있다면
                    int destIndex = graph[sourceIndex][i].source;   // 사실상 'i' equals to 'destIndex' 임!
                    int nextDistance = weight + graph[sourceIndex][i].weight;    // 정점 i까지 도착하는 비용구하고,

                    // 기존에 저장해 놓은 것 보다 더 짧은 경로 발견하면
                    if(distance[destIndex] > nextDistance) {
                        distance[destIndex] = nextDistance;
                        pq.add(new Pair(destIndex, nextDistance));      // destination
                    }
                }
            }
        }

        System.out.println();
        for(int i=1; i<distance.length; i++) {
            if (distance[i] == 100) {   // 초기화한 값이 그대로 남아있다면 경로를 못찾음것임!
                System.out.println("INF");
            } else {
                System.out.println(distance[i]);
            }
        }

    }
}
