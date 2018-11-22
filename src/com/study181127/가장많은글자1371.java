package com.study181127;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 가장많은글자1371 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Character, Integer> alphabetMap = new HashMap<>();

        do {
            String str = br.readLine();

            int length = str.length();
            if(length <= 0) {
                break;
            }

            for(int i=0; i<length; i++) {
                Character alphabet = str.charAt(i);

                if (alphabet.equals(' ')) {
                    // 공백
                } else {
                    if(alphabetMap.containsKey(alphabet)) { // 중복된 알파벳일 경우
                        int countValue = alphabetMap.get(alphabet);
                        alphabetMap.replace(alphabet, countValue + 1);
                    } else {    // 새로 저장해야할 알파벳일 경우 (alphabetMap에 key로서 가지고 있지 않은 경우)
                        alphabetMap.put(alphabet, 1);
                    }
                }
            }
        } while(br.readLine().length() > 0);

        br.close();
        Iterator iterator = sortByValue(alphabetMap).iterator();   // values 내림차순 정렬을 위해

        Object keyOfMaxValue = iterator.next();
        System.out.print(keyOfMaxValue);

        int maxValue = alphabetMap.get(keyOfMaxValue);        // 첫번째 위치한 키값의 value가 최대값임
        for(int i=0; i<alphabetMap.size() && iterator.hasNext(); i++) {
            Object nextKeyOfMaxValue = iterator.next();
            if(maxValue == alphabetMap.get(nextKeyOfMaxValue)) {  // maxValue와 동일한 값을 가진 키가 있다면
                System.out.print(nextKeyOfMaxValue);
            }
        }

    }

    public static List sortByValue(Map map) {       // 내부적으로 Collections.sort()함수 쓰기 위해서 List타입으로 반환
        List<String> list = new ArrayList<>();
        list.addAll(map.keySet());

        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Object value1 = map.get(o1);
                Object value2 = map.get(o2);

                return ((Comparable) value2).compareTo(value1);     // 뒤에 위치한게 앞에 위치한것(value1)보다 작으면 위치바
            }
        });
        return list;
    }
}
