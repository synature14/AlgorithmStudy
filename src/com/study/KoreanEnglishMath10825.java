package com.study;
// 10825 국영수

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class KoreanEnglishMath10825 {
    public static class Score {
        String name;
        int koreanScore;
        int englishScore;
        int mathScore;

        Score(String name, int koreanScore, int englishScore, int mathScore) {
            this.name = name;
            this.koreanScore = koreanScore;
            this.englishScore = englishScore;
            this.mathScore = mathScore;
        }
    }

    static class ScoreComparator implements Comparator<Score> {
        @Override
        public int compare(Score score1, Score score2) {
            int ret = 0;
            if (score1.koreanScore > score2.koreanScore) {        // 1. 국어 점수 비교 (내림차순)
                ret = 1;
            }

            if (score1.koreanScore == score2.koreanScore) {
                if (score1.englishScore < score2.englishScore) {   // 2. 영어 점수 비교 (오름차)
                    ret = 1;
                }

                if (score1.englishScore == score2.englishScore) {
                    if (score1.mathScore > score2.mathScore) {     // 3. 수학 점수 비교 (내림차)
                        ret = 1;
                    }
                }
            }
            return ret;

        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = scan.nextInt();
        scan.nextLine();    // nextInt() 에서 Enter 를 칠 때 발생하는 '개행문자'를 처리하지 않고 버퍼에 남기기 때문이다

        ArrayList<Score> totalArrayList = new ArrayList<>();

        for(int i=0; i<num; i++){
            String infoString = scan.nextLine();
            String[] info = infoString.split(" ");

            /* --- error ---
            for(int index = 0; index<4; index++) {
                if (index == 0) {
                    String name = info[0];
                    System.out.println("name : " + name);
                } else {
                      int score = Integer.parseInt(info[i]);
                      System.out.println("info : " + score);
                }
            }
            */
            String name = info[0];
            int koreanScore = Integer.parseInt(info[1]);
            int englishScore = Integer.parseInt(info[2]);
            int mathScore = Integer.parseInt(info[3]);
            System.out.println("info : " + koreanScore + ", " + englishScore + ", " + mathScore);

            Score eachScore = new Score(name, koreanScore, englishScore, mathScore);
            totalArrayList.add(eachScore);
        }

        Collections.sort(totalArrayList, ScoreComparator);

    }

}
