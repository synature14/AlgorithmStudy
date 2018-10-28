package com.study181030;

// 웜홀, 도로 경로 이렇게 두개의 ArrayList만들어서 풀다가 포기.
// 벨만 포드 알고리즘 - 음의 가중치가 있는 경

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

        int T = Integer.parseInt(br.readLine());
        Queue<String> answerQ = new LinkedList<>();

        while(T > 0) {

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
                graph[from].add(new Pair(to, -1 * shortCut));
            }

            int[] distance = new int[n+1];
            Arrays.fill(distance, INF);
            distance[1] = 0;

            boolean isCycle = false;
            for(int current=1; current<=n; current++) {
                for(int next=1; next<=n; next++) {

                    for(Pair each : graph[next]) {
                        if(distance[each.source] > distance[next] + each.weight && distance[next] != INF) {
                            distance[each.source] = distance[next] + each.weight;

                            if(current == n) {      // 마지막 노드에서 값을 갱신하면, 음수 경로라는것.
                                isCycle = true;
                            }
                        }
                    }
                }
            }

            if (isCycle || distance[1] < 0) {
                answerQ.add("YES");
            } else {
                answerQ.add("NO");
            }

            T--;
        }

        while(!answerQ.isEmpty()) {
            System.out.println(answerQ.poll());
        }

        br.close();
    }
}
