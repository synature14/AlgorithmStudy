package com.study181204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 입국심사3079 {
    static int n;
    static int nBlueRay;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        nBlueRay = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        int[] lesson = new int[n];

        int maxLesson = 0;
        int right = 0;
        for(int i=0; i<n; i++) {
            lesson[i] = Integer.parseInt(st.nextToken());
            right += lesson[i];
            if (maxLesson < lesson[i]) {
                maxLesson = lesson[i];
            }
        }

        int left = maxLesson;
        while(left <= right) {
            int mid = (left + right)/2;
            int sum = 0;
            int count = 1;

            for(int i=0; i<n; i++) {
                if(sum + lesson[i] > mid) {
                    sum = 0;
                    count++;
                }
                sum += lesson[i];
            }

            if (count <= nBlueRay) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }

        System.out.println(right+1);

     }

}
