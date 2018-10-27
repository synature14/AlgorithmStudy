package com.study181030;

// 웜홀, 도로 경로 이렇게 두개의 ArrayList만들어서 풀다가 포기.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Wormhole1865 {
    public static int INF = 1000000000;

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
        StringTokenizer st;

        String str = br.readLine();
        st = new StringTokenizer(str, " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int nWormHole = Integer.parseInt(st.nextToken());

        ArrayList<Pair>[] graph = new ArrayList[m*2+nWormHole];

        for(int i=0; i<m*2+nWormHole; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++) {
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[from].add(new Pair(to, weight));
            graph[to].add(new Pair(from, weight));      // 도로는 방향이 없으므로
        }

        for(int i=0; i<nWormHole; i++) {
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int shortCut = Integer.parseInt(st.nextToken());
            graph[from].add(new Pair(to, -shortCut));
        }

        int[] distance = new int[n+1];
        Arrays.fill(distance, INF);
        distance[1] = 0;

        for(int iterator=1; iterator<n; iterator++) {
            for(int current=1; current<=n; current++) {   // 각 정점마다
                for(int next=0; next<graph[current].size(); next++) {      // 연결된 edge or 웜홀 탐색
                    Pair nextNode = graph[current].get(next);

                    if(distance[next] > distance[current] + nextNode.weight) {
                        distance[next] = distance[current] + nextNode.weight;
                    }
                }
            }
        }


        boolean isFound = false;
        for(int current=1; current<=n; current++) {
            for(int next=0; next<graph[current].size(); next++) {
                Pair nextNode = graph[current].get(next);

                if(distance[next] > distance[current] + nextNode.weight) {
                    isFound = true;
                    distance[next] = distance[current] + nextNode.weight;
                    break;
                }
            }
            if(isFound) break;
        }


        System.out.println(isFound ? "YES" : "NO");
    }
}
