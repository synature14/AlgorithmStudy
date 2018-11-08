package com.최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 숨바꼭질6118 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] path = new ArrayList[n*2 +1];
        for(int i=1; i<=n*2; i++) {
            path[i] = new ArrayList<>();
        }

        for(int i=1; i<=m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            path[from].add(to);
            path[to].add(from);
        }

        int[] distance = new int[n+1];
        for(int i=2; i<=n; i++) {
            distance[i] = 100000000;
        }
        distance[1] = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(1);
        while(!pq.isEmpty()) {
            int current = pq.poll();

            for(int i=0; i<path[current].size(); i++) {
                int next = path[current].get(i);
                if (next == 1) continue;

                if(distance[next] > distance[current] + 1) {
                    distance[next] = distance[current] + 1;
                    pq.add(next);
                }
            }
        }

        int maxPath = 0;
        int leastVertexNumber = 0;
        int nVertexMaxPath = 0;

        for(int i=0; i<=n; i++) {
            if(maxPath < distance[i]) {
                maxPath = distance[i];
                leastVertexNumber = i;
            }
        }
        for(int i=0; i<=n; i++) {
            if(distance[i] == maxPath) {
                nVertexMaxPath++;
            }
        }

        System.out.println(leastVertexNumber + " " + maxPath + " " + nVertexMaxPath);
    }
}
