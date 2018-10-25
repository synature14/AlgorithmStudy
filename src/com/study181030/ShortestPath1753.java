package com.study181030;
// 다익스트라 알고리즘 with PriorityQueue
// 1차시도 : 배열 [nVertex+1][nVertex+1]로 풀어서 메모리초과
// 2차시도 : 이중 ArrayList 활용

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ShortestPath1753 {
    static int nVertex;
    static int nEdge;
    static int start;
    static int INF = 100;
    public static class Pair implements Comparable<Pair> {
        int source;
        int weight;

        Pair(int src, int w) {
            this.source = src;
            this.weight = w;
        }

        @Override
        public int compareTo(Pair o) {      // 우선순위 큐를 사용하기 위해선 Comparable 인터페이스를 따라야함. 안그러면 NullPointerException 발생
            return this.weight < o.weight ? -1 : 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        nVertex = Integer.parseInt(st.nextToken());
        nEdge = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());
        int[] distance = new int[nVertex+1];    // i까지의 최단경로
        ArrayList<Pair>[] graph = new ArrayList[nVertex+1];

        for(int i=0; i<=nVertex; i++) {
            distance[i] = INF;          // 초기화
            graph[i] = new ArrayList<>();
        }

        for(int i=1; i<=nEdge; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[from].add(new Pair(to, cost));
        }
        br.close();

        distance[start] = 0;     // 시작점 ~ 자기 자신까지의 경로는 0개

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(start, 0));

        while(!pq.isEmpty()) {
            Pair currentNode = pq.poll();
            int currentIndex = currentNode.source;

            if(distance[currentIndex] < currentNode.weight ) continue;       // start~source까지의 가중치 < 방금 찾은 가중치 : 무시하면 되는 케이스

            for(int i=0; i<graph[currentIndex].size(); i++) {
                // sourceIndex -> i로 가는 경로가 있다면
                Pair nextNode = graph[currentIndex].get(i);

                // 기존에 저장해 놓은 것 보다 더 짧은 경로 발견하면
                if(distance[nextNode.source] > nextNode.weight + distance[currentIndex]) {
                    distance[nextNode.source] = distance[currentIndex] + nextNode.weight;
                    pq.add(new Pair(nextNode.source, distance[nextNode.source]));      // destination
                }
            }
        }

        for(int i=1; i<distance.length; i++) {
            if (distance[i] == INF) {   // 초기화한 값이 그대로 남아있다면 경로를 못찾음것임!
                System.out.println("INF");
            } else {
                System.out.println(distance[i]);
            }
        }

    }
}
