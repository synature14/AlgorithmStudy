package com.study181113;

// 시뮬레이션

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 가르침1062 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if (k>5) k -= 5;

        ArrayList<String>[] word = new ArrayList[51];
        ArrayList<String>[] uniqueLetter = new ArrayList[51];

        for(int i=0; i<n; i++) {
            word[i] = new ArrayList<>();
            uniqueLetter[i] = new ArrayList<>();
            String[] str = br.readLine().split("");

            for(int j=0; j<str.length; j++) {
                word[i].add(str[j]);

                if(j>3 && j<str.length-4    // "anta" 와 "tica"의 사이 글자라면
                        && !str[j].equals("a") && !str[j].equals("n") && !str[j].equals("t") && !str[j].equals("i") && !str[j].equals("c")
                        && !uniqueLetter[i].contains(str[j])) {
                    uniqueLetter[i].add(str[j]);
                }
            }
        }

        int[] answer = new int[15];
        Arrays.fill(answer, 100000);

        for(int i=0; i<n; i++) {
            int count = 0;

            for(int j=0; j<uniqueLetter[i].size(); j++) {
                String letter = uniqueLetter[i].get(j);
                if(word[i].contains(letter)) {
                    count += 1;
                }
            }
            answer[i] = count;
        }

        // 아래 코드가 논리적으로 어긋나는 케이스 있을듯
        Arrays.sort(answer);
        int readable = 0;

        for(int orderOfWord=0; orderOfWord<n; orderOfWord++) {
            if(answer[orderOfWord] == k) {
                readable += 1;
            }
        }

        System.out.println(readable);
    }
}
