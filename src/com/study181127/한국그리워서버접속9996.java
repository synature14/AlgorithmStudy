package com.study181127;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 한국그리워서버접속9996 {
    static ArrayList<Character> charPattern;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        String pattern = br.readLine();
        charPattern = new ArrayList<>();

        for(int i=0; i<pattern.length(); i++) {
            charPattern.add(pattern.charAt(i));
        }

        String[] fileNames = new String[num];

        for(int i=0; i<num; i++) {
            fileNames[i] = br.readLine();
        }
        br.close();


        int starMarkIndex = 0;

        // '*'을 기준으로 앞, 뒤에 몇개의 알파벳이 있는지
        for(int i=0; i<pattern.length(); i++) {
           Character letter = charPattern.get(i);

           if(letter.equals('*')) {
               starMarkIndex = i;
               break;
           }
        }

        // fileNames 패턴일치하는지 확인
        for(int i=0; i<fileNames.length; i++) {
            // '*'을 기준으로 앞에 있는 알파벳들 패턴 일치하는지?
            if(isHeadPatternCorrect(fileNames[i], starMarkIndex)) {
                if(isTailPatternCorrect(fileNames[i], starMarkIndex)) {
                    System.out.println("DA");
                } else {
                    System.out.println("NE");
                }
            } else {
                System.out.println("NE");
            }

        }

    }

    public static boolean isHeadPatternCorrect(String fileName, int starMarkIndex) {
        for(int j=0; j<starMarkIndex; j++) {
            if(fileName.charAt(j) != charPattern.get(j)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isTailPatternCorrect(String fileName, int starMarkIndex) {
        int patternEndIndex = charPattern.size() - 1;
        for(int j=fileName.length()-1; j>starMarkIndex; j--) {
            if(patternEndIndex <= starMarkIndex) return true;
            if(fileName.charAt(j) != charPattern.get(patternEndIndex)) {
                return false;
            }
            patternEndIndex -= 1;
        }
        return true;
    }
}
