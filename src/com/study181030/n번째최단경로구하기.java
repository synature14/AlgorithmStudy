package com.study181030;
// k번째 최단경로!!

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class n번째최단경로구하기 {
    static boolean[][] visited;
    static int n;
    static PriorityQueue<Integer>[] distance;
    static int destination;
    static ArrayList<Path>[] savingEdge;
    static int start;
    static ArrayList<Path>[] graph;
    static int INF = 10000000;

    public static class Path implements Comparable<Path> {
        int source;
        int weight;

        Path(int src, int w) {
            this.source = src;
            this.weight = w;
        }

        @Override
        public int compareTo(Path o) {
            return this.weight < o.weight ? -1 : 1;
        }
    }

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
            distance = new PriorityQueue[n+1];
            graph = new ArrayList[m+1];
            visited = new boolean[n][n];

            for(int i=0; i<=n; i++) {
                distance[i] = new PriorityQueue<>();
            }

            for(int i=0; i<=m; i++) {
                graph[i] = new ArrayList<>();
            }


            for(int i=0; i<m; i++) {
                String road = br.readLine();
                st = new StringTokenizer(road, " ");
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                graph[from].add(new Path(to, weight));
            }

            dijkstra(2);


            if (distance[destination].size() == 2) {      // 2번째 최단경로의 크기가 2라면
                // 첫번째로 짧은 경로는 버리고
                distance[destination].poll();
                answerQueue.add(distance[destination].poll());  // 두번째 최단경로만 넣는다
            } else {
                answerQueue.add(-1);
            }

        } while(!nm.equals("0 0"));


        while(answerQueue.peek() != null) {
            System.out.println(answerQueue.poll());
        }

    }

    public static void dijkstra(int k) {        // k번째 최단경로
        distance[start].add(0);

        PriorityQueue<Path> pq = new PriorityQueue<>();
        pq.add(new Path(start, 0));

        while(!pq.isEmpty()) {
            Path current = pq.poll();
            int currentIndex = current.source;
            int currentWeight = current.weight;

            for(int i=0; i<graph[currentIndex].size(); i++) {
                int nextIndex = graph[currentIndex].get(i).source;
                int nextWeight = graph[currentIndex].get(i).weight;

                if(distance[nextIndex].size() < k) {        // nextIndex의 우선순위 큐 크기가 찾으려는 k개까지만 존재하면 됨
                    distance[nextIndex].add(currentWeight + nextWeight);
                    pq.add(new Path(nextIndex, currentWeight + nextWeight));

                } else if (distance[nextIndex].peek() > nextWeight + currentWeight) {     // 저장한 경로 개수가 k개 이상일경우, 더 짧은 거리 찾았다면, 갱신
                    distance[nextIndex].poll();
                    distance[nextIndex].add(nextWeight + currentWeight);
                    pq.add(new Path(nextIndex, currentWeight + nextWeight));
                }
            }
        }
    }


}