package com.study;

//  2805 나무자르기
import java.util.Arrays;
import java.util.Scanner;

public class Tree2805 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        String[] inputArray = input.split(" ");
        int numOfTrees = Integer.parseInt(inputArray[0]);
        int targetLength = Integer.parseInt(inputArray[1]);

        String heightOfTrees = scan.nextLine();
        String[] heightArray = heightOfTrees.split(" ");
        int[] height = new int[numOfTrees];

        for(int i=0; i<numOfTrees; i++) {
            height[i] = Integer.parseInt(heightArray[i]);
        }

        Arrays.sort(height);
        findMaxHeight(height, numOfTrees, targetLength);
    }


    public static void findMaxHeight(int[] heightArray, int numOfTrees ,int targetLength) {
        int left = 0;
        int right = heightArray[numOfTrees-1];
        long max = 0;

        while(left <= right) {
            int mid = (left + right) / 2;
            long total = 0;

            for(int i=0; i<numOfTrees; i++) {
                if (mid <= heightArray[i]) {       // 필요한 나무길이보다 나무의 높이가 크거나 같으면
                    total += (heightArray[i] - mid);
                }
            }

            if (total >= targetLength) {    // 잘라낸 나무길이 총합 >= 필요한 길이이라면, 더 높은위치에서 잘라내서 잘라낸 길이가 줄어들어야함.
                left = mid + 1;
                max = mid;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(max);
    }
}
