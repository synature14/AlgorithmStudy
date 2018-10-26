package com.Edaily;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 외줄타기 {
    public static class Pair implements Comparable<Pair> {
        int source;
        int weight;

        Pair(int src, int w) {
            this.source = src;
            this.weight = w;
        }

        @Override
        public int compareTo(Pair o) {
            return this.weight < o.weight ? -1 : 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int vertex = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());

        ArrayList<Pair>[] graph = new ArrayList[vertex+1];
        int nVisited;
        int[] distance = new int[vertex+1];     // distance[i] : i까지 도착하는데 걸리는 최단경로 -> 그 경로가 모든 노드를 거치는지 체크할것임
        ArrayList<Integer> fullPaths = new ArrayList<>();

        for(int i=0; i<=vertex; i++) {
            distance[i] = 1000000;
            graph[i] = new ArrayList<>();
        }

        for(int i=1; i<=edge; i++) {
            String str = br.readLine();
            st = new StringTokenizer(str, " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[from].add(new Pair(to, weight));
        }
        br.close();

        int node = 1;   // 1에서 출발할 경우부터 탐색
        while(node <= vertex) {
            // 초기화
            nVisited = 1;       // 본인 자기자신 방문.
            for(int i=0; i<=vertex; i++) {
                if (i == node) {
                    distance[i] = 0;
                } else {
                    distance[i] = 1000000;
                }
            }

            PriorityQueue<Pair> pq = new PriorityQueue();
            pq.add(new Pair(node, 0));

            while(!pq.isEmpty()) {
                Pair current = pq.poll();
                int currentIndex = current.source;

                for(int i=0; i<graph[currentIndex].size(); i++) {
                    Pair next = graph[currentIndex].get(i);
                    int nextIndex = next.source;

                    if(distance[nextIndex] > next.weight + distance[currentIndex]) {
                        nVisited += 1;

                        distance[nextIndex] = next.weight + distance[currentIndex];
                        pq.add(new Pair(next.source, distance[nextIndex]));
                    }
                }

                if(nVisited == vertex) {
                    Arrays.sort(distance);
                    fullPaths.add(distance[vertex-1]);
                    System.out.println("node : " + node + " --> " + distance[vertex-1]);
                    break;
                }
            }

            node++;
        }

        int min = 5000000;
        for(int i=0; i<fullPaths.size(); i++) {
            if( min > fullPaths.get(i) ) {
                min = fullPaths.get(i);
            }
        }
        System.out.println(min);

    }
}
