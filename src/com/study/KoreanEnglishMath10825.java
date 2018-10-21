package com.study;
// 10825 국영수

import java.util.ArrayList;
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


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = scan.nextInt();
        scan.nextLine();    // nextInt() 에서 Enter 를 칠 때 발생하는 '개행문자'를 처리하지 않고 버퍼에 남기기 때문이다

        ArrayList<Score> totalArrayList = new ArrayList<>();

        for(int i=0; i<num; i++){
            String infoString = scan.nextLine();
            String[] info = infoString.split(" ");

            String name = "";
            int koreanScore = 0;
            int englishScore = 0;
            int mathScore = 0;

            for(int index = 0; index<4; index++) {
                switch (index) {
                    case 0:
                        name = info[index];
                        break;
                    case 1:
                        koreanScore = Integer.parseInt(info[index]);
                        break;
                    case 2:
                        englishScore = Integer.parseInt(info[index]);
                        break;
                    case 3:
                        mathScore = Integer.parseInt(info[index]);
                        break;
                }
            }
            Score eachScore = new Score(name, koreanScore, englishScore, mathScore);
            totalArrayList.add(eachScore);
        }

        for(int i=0; i<totalArrayList.size()-1; i++) {
            for(int j=i+1; j<totalArrayList.size(); j++) {
                Score score1 = totalArrayList.get(i);
                Score score2 = totalArrayList.get(j);

                if (score1.koreanScore < score2.koreanScore) {        // 1. 국어 점수 비교 (내림차순)
                    Score temp = score1;
                    totalArrayList.set(i, score2);
                    totalArrayList.set(j, temp);
                }
            }
        } // for()

        for(int i=0; i<totalArrayList.size()-1; i++) {
            for(int j=i+1; j<totalArrayList.size(); j++) {
                Score score1 = totalArrayList.get(i);
                Score score2 = totalArrayList.get(j);

                // 2. 영어 점수 비교 (오름차)
                if (score1.koreanScore == score2.koreanScore
                        && score1.englishScore > score2.englishScore) {
                    Score temp = score2;
                    totalArrayList.set(j, score1);
                    totalArrayList.set(i, temp);
                }
            }
        }

        for(int i=0; i<totalArrayList.size()-1; i++) {
            for(int j=i+1; j<totalArrayList.size(); j++) {
                Score score1 = totalArrayList.get(i);
                Score score2 = totalArrayList.get(j);

                if (score1.koreanScore == score2.koreanScore && score1.englishScore == score2.englishScore
                        && score1.mathScore != score2.mathScore) {
                    if (score1.mathScore < score2.mathScore) {     // 3. 수학 점수 비교 (내림차)
                        Score temp = score1;
                        totalArrayList.set(i, score2);
                        totalArrayList.set(j, temp);
                    }
                }
            }
        }

        for(int i=0; i<totalArrayList.size()-1; i++) {
            for (int j=i+1; j<totalArrayList.size(); j++) {
                Score score1 = totalArrayList.get(i);
                Score score2 = totalArrayList.get(j);

                // 4. 모든 점수가 같으면, 이름이 사전순으로 오름차순
                if (score1.koreanScore == score2.koreanScore && score1.englishScore == score2.englishScore
                        && score1.mathScore == score2.mathScore) {
                    if (score1.name.compareTo(score2.name) > 0) { // score1.name > score2.name --> score2.name이 사전순으로 앞이다
                        Score temp = score2;
                        totalArrayList.set(j, score1);
                        totalArrayList.set(i, temp);
                    }
                }
            }
        }

        for(int i=0; i<num; i++) {
            System.out.println(totalArrayList.get(i).name);
        }
    }

}
