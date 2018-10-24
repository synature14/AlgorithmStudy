package com.study181030;

// 뉴스전하기 문제와 비슷
// 1차 실패 : root가 무조건 0번째 노드라고 생각하고 풀었음
// 2차 시도 : 입력값이 -1일때 root인덱스로 설정, searchLeafNode(root) 호출하기 위함

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Tree1068 {
    static HashMap<Integer, ArrayList<Integer>> hashMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        hashMap = new HashMap<>();

        int root = 0;
        for(int node=0; node<n; node++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) {
                root = node;
            }
            if (hashMap.get(parent) == null) {      // 자식노드가 없는 부모노드라면, 새로운 childArray리스트 추가
                ArrayList<Integer> childArrayList = new ArrayList<>();
                childArrayList.add(node);
                hashMap.put(parent, childArrayList);
            } else {        // 자식노드가 이미 있는 parent라면, 추가된 자식을 기존 childArrayList에 업데이트
                ArrayList<Integer> updateChildList = hashMap.get(parent);
                updateChildList.add(node);
                hashMap.replace(parent, updateChildList);
            }
        }

        int removeNodeAt = Integer.parseInt(br.readLine());
        hashMap.remove(removeNodeAt);       // 삭제할 노드를 키값으로 가지는 values, 즉 자식노드들 없애기

        int count = 0;
        count += searchLeafNode(root);  // 루트에서 시작!

        // 삭제할 노드가 리프노드로서 남아있기 때문에
        System.out.println(count - 1);

    }

    public static int searchLeafNode(int parent) {
        int ret = 0;

        // 아니라면 또 호출
        ArrayList<Integer> childList = new ArrayList<>();
        childList = hashMap.get(parent);

        // 자식노드가 있다면
        if( childList != null ) {
            for(int each : childList) {
                ret += searchLeafNode(each);
            }
            return ret;
        } else {
            // 마지막 leaf node라면
            return ret+1;
        }
    }
}
