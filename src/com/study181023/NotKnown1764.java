package com.study181023;

// https://www.acmicpc.net/problem/1764
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

public class NotKnown1764 {
    static ArrayList<String> nonHeardNames = new ArrayList<>();
    static ArrayList<String> nonSeenNames = new ArrayList<>();

    public static boolean binarySearch(int left, int right, String name) {
        if (left > right) {
            return false;
        }

        int mid = (left + right) / 2;
        if ( name.equals(nonHeardNames.get(mid)) ) {       // 찾았다면?
            return true;
        } else if ( name.compareTo(nonHeardNames.get(mid)) < 0 ) {   // 찾으려는 name이 비교값보다 더 앞에 우선하여 있을경우
            return binarySearch(left, mid-1, name);
        } else { // 찾으려는 name이 비교값보다 더 뒤에 있을경우
            return binarySearch(mid+1, right, name);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int numNonHeard = Integer.parseInt(st.nextToken());
        int numNonSeen = Integer.parseInt(st.nextToken());

        nonHeardNames = new ArrayList<>();
        nonSeenNames = new ArrayList<>();
        Stack<String> answerStack = new Stack<>();

        for(int i=0; i<numNonHeard; i++) {
            nonHeardNames.add(br.readLine());
        }
        Collections.sort(nonHeardNames);

        for(int i=0; i<numNonSeen; i++) {
            String name = br.readLine();
            nonSeenNames.add(name);

            // 듣도 보지도 못했다면
            if(binarySearch(0, numNonSeen-1, name) == true ) {
                answerStack.push(name);
            }
        }

        int size = answerStack.size();

        Collections.sort(answerStack);
        Collections.reverse(answerStack);
        System.out.println(size);
        for(int index=0; index<size; index++) {
            System.out.println(answerStack.pop());
        }


//        long end = System.currentTimeMillis();
//        System.out.println((end-start)/1000 +" 초 걸림");
    }
}
