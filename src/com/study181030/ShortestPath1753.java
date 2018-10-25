package com.study181030;

// 다익스트라 알고리즘 with PriorityQueue

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.Vector;

public class ShortestPath1753 {
    static int nVertex;
    static int nEdge;
    static int start;

    public static class Pair {
        int source;
        int weight;

        Pair(int src, int w) {
            this.source = src;
            this.weight = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        nVertex = Integer.parseInt(st.nextToken());
        nEdge = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());

        Vector<Pair> graph = new Vector<>();  // row: 시작점, column: 인점한 정점 저장

        for(int i=1; i<=nVertex; i++) {
           st = new StringTokenizer(br.readLine(), " ");
           int from = Integer.parseInt(st.nextToken());
           int to = Integer.parseInt(st.nextToken());
           int cost = Integer.parseInt(st.nextToken());

           graph[from].add(new Pair(to, cost));   // ex) graph[5].add(Pair(1, 1)) : 5->1로가는 간선의 가중치는 1
        }

        int[] distance = new int[nVertex+1];
        distance[start] = 0;     // 시작점 ~ 자기 자신까지의 경로는 0개

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(start, 0));

        while(!pq.isEmpty()) {
            int sourceIndex = pq.peek().source;
            int weight = pq.peek().weight;
            pq.poll();

            if(distance[sourceIndex] < weight ) continue;       // start~source까지의 가중치 < 방금 찾은 가중치 : 무시하면 되는 케이스

            for(int i=1; i<=nVertex; i++) {
                if(!graph[sourceIndex].isEmpty()) {      // sourceIndex -> i로 가는 경로가 있다면
                    int destIndex = graph[sourceIndex].get(i).source;   // 사실상 'i' equals to 'destIndex' 임!
                    int nextDistance = weight + graph[sourceIndex].get(i).weight;    // 정점 i까지 도착하는 비용구하고,

                    // 기존에 저장해 놓은 것 보다 더 짧은 경로 발견하면
                    if(distance[destIndex] > nextDistance) {
                        distance[destIndex] = nextDistance;
                        pq.add(new Pair(destIndex, nextDistance));      // destination
                    }
                }
            }
        }

        for(int i=1; i<=distance.length; i++) {
            System.out.println(distance[i]);
        }



        // 최단경로 출력



    }
}
