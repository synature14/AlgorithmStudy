package com.study181030;

// 뉴스전하기 문제와 비슷
// 1차 시도 : 실패, root가 무조건 0번째 노드라고 생각하고 풀었음
// 2차 시도 : 입력값이 -1일때 root인덱스로 설정, searchLeafNode(root) 호출하기 위함
//          --> 실패, 채점 80%정도 되었을때 실패했다고 뜸. 어느 테스트케이스를 충족 못 시키는지 모르겠음
// 3차 시도 : 결국 HashMap<부모, [자식들]>로 풀지 않고 배열 사용

import java.io.*;
import java.util.StringTokenizer;

public class Tree1068 {
    static int n;
    static int[] tree;
    static int numLeafNode = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        tree = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int root = 0;

        for (int i = 0; i < n; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            if (tree[i] == -1) {
                root = i;
            }
        }

        // 삭제
        int removeNodeAt = Integer.parseInt(br.readLine());
        removeRecursively(removeNodeAt);

        for(int i=0; i<n; i++) {
            if (tree[i] != -1){
                searchLeafNode(i);
            }
        }
        System.out.println(numLeafNode);
}

    public static void removeRecursively(int parent) {
        tree[parent] = -1;
        for(int i=0; i<n; i++) {
            if(tree[i] == parent) {
                tree[i] = -1;
                removeRecursively(i);
            }
        }
    }

    public static void searchLeafNode(int parent) {
        for(int i=0; i<n; i++) {
            if( tree[i] == parent) {
                return;
            }
        }
        numLeafNode++;
    }
}
