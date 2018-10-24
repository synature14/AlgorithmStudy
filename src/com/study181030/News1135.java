package com.study181030;
// Hashmap으로 1차 시도

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class News1135 {
    static HashMap<Integer, ArrayList<Integer>> map; // <부모 인덱스, 자식들>

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        map = new HashMap<>();
        String parentStr = br.readLine();
        StringTokenizer st = new StringTokenizer(parentStr, " ");
        st.nextToken();

        /* key : 부모인덱스, value: 자식노드들 */
        for(int child=1; child<n; child++) {        // 무조건 0번 인덱스는 루트임
            int parent = Integer.parseInt(st.nextToken());
            if (parent != -1) {
                if (map.get(parent) == null) {      // 자식노드가 없는 부모노드라면, 새로운 childArray리스트 추가
                    ArrayList<Integer> childArrayList = new ArrayList<>();
                    childArrayList.add(child);
                    map.put(parent, childArrayList);
                } else {        // 자식노드가 이미 있는 parent라면, 추가된 자식을 기존 childArrayList에 업데이트
                    ArrayList<Integer> updateChildList = map.get(parent);
                    updateChildList.add(child);
                    map.replace(parent, updateChildList);
                }
            }

        }

        /* 루트인 인덱스 0부터 자식 노드 탐색 */
        int min = callToChildFrom(0);
        System.out.println(min);
    }

    public static int callToChildFrom(int parent) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int subChild : map.get(parent)) {
           int count = callToChildFrom(subChild);
            pq.add(count);
        }

        int ret = 0;
        for(int depth=0; depth<pq.size(); depth++) {
            ret = Math.max(ret, pq.poll()+depth);
            System.out.println("return = " + ret);
        }

        return ret;
    }
}
