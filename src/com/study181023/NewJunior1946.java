package com.study181023;
// https://www.acmicpc.net/problem/1946

import java.util.Scanner;
import java.util.HashMap;
import java.util.Arrays;
import java.util.TreeMap;
import static java.lang.Math.min;

public class NewJunior1946 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<>();

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

            int value1 = treeMap.get(1);      // 서류 1위의 면접 결과를 기준점으로 시작
            for(int i=1; i<num; i++) {
                value1 = min(value1 , treeMap.get(i));     // 숫자가 작을수록 순위 높으므로, min값을 value1에 넣음

                int value2 = treeMap.get(i+1);
//              System.out.println("value "+ i + " : " + value1);
//              System.out.println("value " + j+ ": " + value2);

                if(value1 > value2) {   // j보다 서류에서 순위가 높은 지원자 중에, j보다 면접 순위가 낮은 사람이 있다면,
//                  System.out.println("합격 : " + j);
                    count[index] += 1;

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
