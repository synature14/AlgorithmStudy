package com.study;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.lang.*;

public class NotKnown1764 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numNonHeard = scan.nextInt();
        int numNonSeen = scan.nextInt();
        scan.nextLine();
        HashMap<Character, ArrayList<String>> dictionary = new HashMap<>();

        ArrayList<String> nonHeardNames = new ArrayList<>();
        ArrayList<String> nonSeenNames = new ArrayList<>();
        ArrayList<String> answer = new ArrayList<>();
        int index = 0;

        for(int i=0; i<numNonHeard; i++) {
            nonHeardNames.add(scan.nextLine());
            char key = nonHeardNames.get(i).charAt(0);

            if (dictionary.containsKey(key)) {     // 예) T로 시작하는 value를 이미 가지고있다면,
                ArrayList<String> list = dictionary.get(key);
                list.add(nonHeardNames.get(i));

                System.out.println("On " + key + " , value added --> " + list.get(list.size()-1));
                dictionary.replace(key, list);
            } else {
                ArrayList<String> newList = new ArrayList<>();
                newList.add(nonSeenNames.get(i));
                System.out.println("New Key -- Value added : " + newList.get(0));
                dictionary.put(nonSeenNames.get(i).charAt(0), newList);
            }
        }

        for(int i=0; i<numNonSeen; i++) {
            nonSeenNames.add(scan.nextLine());
            char key = nonSeenNames.get(i).charAt(0);

            if (dictionary.containsKey(key)) {
                for (String strValue : dictionary.get(key)) {
                    if( strValue.equals(nonSeenNames.get(i)) ) {
                        answer.add(strValue);
                        index++;
                    }
                }
            }
        }

        System.out.println(index + 1);
        for(int i=0; i<index+1; i++) {
            System.out.println(answer.get(i));
        }

    }

}
