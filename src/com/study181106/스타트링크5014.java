package com.study181106;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 스타트링크5014 {
    public static class Elevator {
        int count;
        int floor;

        Elevator(int count, int floor) {
            this.count = count;
            this.floor = floor;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int up = Integer.parseInt(st.nextToken());
        int down = Integer.parseInt(st.nextToken());

        int[] direction = {up, down};
        boolean[] visited = new boolean[F+1];

        Queue<Elevator> queue = new LinkedList<>();
        queue.add(new Elevator(1, S));

        while(!queue.isEmpty()) {
            Elevator current = queue.poll();
            if (current.floor == G) {
                System.out.println(current.count);
                break;
            }

            for(int i=0; i<2; i++) {
                int next = current.floor + direction[i];

                if (next <= F && next > 0) {
                    if(!visited[next]) {
                        visited[next] = true;
                        queue.add(new Elevator(current.count+1, next));
                    }
                }
            }
            if(queue.isEmpty()) {
                System.out.println("use the stairs");
            }
        }
    }
}
