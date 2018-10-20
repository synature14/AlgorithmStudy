package com.study;
// https://www.acmicpc.net/problem/1946

import java.util.Scanner;
import java.util.HashMap;
import java.util.Arrays;
import java.util.TreeMap;

public class NewJunior1946 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap();

        int nCase = scan.nextInt();
        int[] count = new int[nCase];
        Arrays.fill(count, 1);  // 무조건 서류 순위 1위인 지원자는 잘났으므로 합격
        int index = 0;

        while(nCase > 0) {
            int num = scan.nextInt();

            for(int i=0; i<num; i++) {
                int firstScore = scan.nextInt();        // 서류 순위
                int secondScore = scan.nextInt();       // 면접 순위

                map.put(firstScore, secondScore);
            }

            TreeMap<Integer, Integer> treeMap = new TreeMap<>(map);
            treeMap.keySet().iterator();    // 오름차순 정렬
//            System.out.println(treeMap.entrySet());

            for(int i=1; i<num; i++) {
                for(int j=i+1; j>=i; j--) {
                    int value1 = treeMap.get(i);
                    int value2 = treeMap.get(j);
//                    System.out.println("value "+ i + " : " + value1);
//                    System.out.println("value " + j+ ": " + value2);
                    if(value1 > value2) count[index] += 1;
                }
            }
            index++;
            nCase--;
        }

        for(int i=0; i<count.length; i++) {
            System.out.println(count[i]);
        }
    }
}
