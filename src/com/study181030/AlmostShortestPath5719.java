package com.study181030;

// 1차시도 : 그래프를 2차원 배열로 표현!, visited표시, DFS로 탐색
// 2차시도 : 최단경로 구한 후, 최단경로만 지워나간다

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AlmostShortestPath5719 {
    static boolean[][] visited;
    static int n;
    static int[] distance;
    static int destination;
    static ArrayList<Path>[] savingEdge;
    static int start;
    static ArrayList<Path>[] graph;
    static int INF = 100000000;

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

        while(true){
            nm = br.readLine();
            if(nm.equals("0 0")) {
                break;
            }

            StringTokenizer st = new StringTokenizer(nm, " ");
            n = Integer.parseInt(st.nextToken());
            int nEdge = Integer.parseInt(st.nextToken());

            String sd = br.readLine();
            st = new StringTokenizer(sd, " ");
            start = Integer.parseInt(st.nextToken());
            destination = Integer.parseInt(st.nextToken());
            distance = new int[n+1];
            graph = new ArrayList[nEdge+1];
            savingEdge = new ArrayList[nEdge+1];
            visited = new boolean[n+1][n+1];

            for(int i=0; i<=nEdge; i++) {
                graph[i] = new ArrayList<>();
                savingEdge[i] = new ArrayList<>();
            }


            for(int i=0; i<nEdge; i++) {
                String road = br.readLine();
                st = new StringTokenizer(road, " ");
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                graph[from].add(new Path(to, weight));
                savingEdge[to].add(new Path(from, weight));
            }

            dijkstra();
            removeEdge();
            dijkstra();

            if (distance[destination] != INF) {
                answerQueue.add(distance[destination]);
            } else {
                answerQueue.add(-1);
            }

        }

        while(answerQueue.peek() != null) {
            System.out.println(answerQueue.poll());
        }

    }

    public static void dijkstra() {        // k번째 최단경로
        Arrays.fill(distance, INF);
        distance[start] = 0;

        PriorityQueue<Path> pq = new PriorityQueue<>();
        pq.add(new Path(start, 0));

        while(!pq.isEmpty()) {
            Path current = pq.poll();
            int currentIndex = current.source;
            int currentWeight = current.weight;

            for(int i=0; i<graph[currentIndex].size(); i++) {
                int nextIndex = graph[currentIndex].get(i).source;
                int nextWeight = graph[currentIndex].get(i).weight;

                if (distance[nextIndex] > nextWeight + currentWeight
                        && visited[nextIndex][currentIndex] == false) {     // 도착지 -> 출발지로 오는 최단경로에 visited했으므로 행,열을 거꾸로 체크해야함
                    distance[nextIndex] = nextWeight + currentWeight;
                    pq.add(new Path(nextIndex, currentWeight + nextWeight));
                }
            }
        }
    }

    public static void removeEdge() {
        PriorityQueue<Path> pq = new PriorityQueue<>();
        pq.add(new Path(destination, distance[destination]));       // 도착지에서부터 거꾸로 weight 줄여나가며 최단경로인 부분 visited 체크

        while(!pq.isEmpty()) {
            Path current = pq.poll();
            int currentIndex = current.source;

            for(Path each : savingEdge[currentIndex]) {
                int nextIndex = each.source;

                if(distance[nextIndex] == distance[currentIndex] - each.weight) {
                    visited[currentIndex][nextIndex] = true;
                    pq.add(new Path(nextIndex, distance[nextIndex]));
                }
            }
        }
    }


}
