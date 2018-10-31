package com.study181106;

// 이분그래프
/*
* BFS, DFS로 탐색하면서 정점을 방문할 때마다 두 가지 색 중 하나를 칠한다.
다음 정점을 방문하면서 자신과 인접한 정점은 자신과 다른 색으로 칠한다.
탐색을 진행할 때 자신과 인접한 정점의 색이 자신과 동일하면 이분 그래프가 아니다.
BFS의 경우 정점을 방문하다가 만약 같은 레벨에서 정점을 다른 색으로 칠해야 한다면 무조건 이분 그래프가 아니다.
모든 정점을 다 방문했는데 위와 같은 경우가 없다면 이분 그래프이다.
이때 주의할 점은 연결 그래프와 비연결 그래프를 둘 다 고려 해야한다는 것이다.
그래프가 비연결 그래프인 경우 모든 정점에 대해서 확인하는 작업이 필요하다.
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 이분그래프1707 {
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> arrayList;
    static boolean isBipartite;
    static int BLUE = 10;
    static int RED = -10;
    static int[] colorChecked;

    public static class Coloring {
        int vertex;
        int color;

        Coloring(int v, int color) {
            this.vertex = v;
            this.color = color;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int nTest = Integer.parseInt(st.nextToken());
        ArrayList<String> answers = new ArrayList<>();

        while(nTest-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int vertex = Integer.parseInt(st.nextToken());
            int edge = Integer.parseInt(st.nextToken());

            arrayList = new ArrayList<>();
            visited = new boolean[vertex+1];
            colorChecked = new int[vertex+1];

            for(int i=0; i<=vertex; i++) {
                arrayList.add(new ArrayList<>());
            }

            while(edge-- > 0) {
                st = new StringTokenizer(br.readLine(), " ");
                int vertex1 = Integer.parseInt(st.nextToken());
                int vertex2 = Integer.parseInt(st.nextToken());

                arrayList.get(vertex1).add(vertex2);
                arrayList.get(vertex2).add(vertex1);
            }

            isBipartite = true;
            for(int i=1; i<=vertex; i++) {

                if(visited[i] == false) {
                    bfs(i, RED);
                }

            }

            if(isBipartite) {
                answers.add("YES");
            } else {
                answers.add("NO");
            }
        }

        for(int i=0; i<answers.size(); i++) {
            System.out.println(answers.get(i));
        }
    }

    public static void bfs(int vertex, int color) {
        Queue<Coloring> queue = new LinkedList<>();
        Coloring coloredNode = new Coloring(vertex, color);
        queue.add(coloredNode);

        while(!queue.isEmpty() && isBipartite) {
            Coloring current = queue.poll();
            int currentColor = current.color;

            // 인접 노드 방문
            for(int adjacent : arrayList.get(current.vertex)) {
                if(visited[adjacent] == false) {
                    visited[adjacent] = true;
                    colorChecked[adjacent] = currentColor * -1;
                    Coloring adjacentNode = new Coloring(adjacent, colorChecked[adjacent]);
                    queue.add(adjacentNode);

                } else if (currentColor == colorChecked[adjacent]) {    // 인접한 노드가 같은 색깔이라면
                    isBipartite = false;
                    return;
                }
            }
        }

    }
}
