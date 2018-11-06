package com.study181106;

// 플로이드와샬
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 역사1613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] history = new int[n+1][n+1];

        for(int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            history[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = -1;
        }

        // 플로이드 와샬
        for(int p=1; p<=n; p++) {        // 거쳐가는 꼭짓점
            for(int i=1; i<=n; i++) {      // 출발하는 꼭짓점
                for(int j=1; j<=n; j++) {    // 도착하는 꼭짓점
                    if(history[i][p] == -1 && history[p][j] == -1) {  // i->p로의 경로가 있고 p->j로의 경로가 있다면
                        history[i][j] = -1;     // i->j까지의 경로도 존재
                    }
                }
            }
        }


        int s = Integer.parseInt(br.readLine());
        Queue<Integer> answerQueue = new LinkedList<>();

        for(int i=0; i<s; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int old = Integer.parseInt(st.nextToken());
            int recent = Integer.parseInt(st.nextToken());

            if(history[old][recent] == -1) {        // old가 먼저 일어난 사건이라면
                answerQueue.add(-1);
            } else if(history[recent][old] == -1) { // recent가 먼저 일어난 사건이라면
                answerQueue.add(1);
            } else {
                answerQueue.add(0);     // 그 둘다 해당되지 않으면
            }
        }


        for (int i=0; i<s; i++) {
            System.out.println(answerQueue.poll());
        }

    }
}
