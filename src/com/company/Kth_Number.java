package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Kth_Number {
    public static void main(String[] args) {
        int[] array = new int[] {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = new int[][] {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        System.out.print(solution(array, commands));
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[10];
        int i = 0;

        System.out.println("commands.length : " + commands.length);
        while(i < commands.length) {
            int startIndex = commands[i][0] - 1;
            int endIndex = commands[i][1] - 1;
            List<Integer> cutList = new ArrayList<>();

            System.out.println("start: " + startIndex + "  end: " + endIndex);
            for(int j = startIndex; j <= endIndex; j++) {
                cutList.add(array[j]);
            }

            Collections.sort(cutList);
            System.out.println("index : " + commands[i][2] + " --- cutList : " + cutList);
            int num = commands[i][2] - 1;
            System.out.println("num = " + num );

            answer[i] = cutList.get(num);
            System.out.println("answer[" + i + "] = " + answer[i]);
            i++;
        }
        return answer;
    }
}
