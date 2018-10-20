package com.study;

import java.io.*;
import java.util.HashMap;

public class NumberCard10816 {
    static HashMap<Integer, Integer> cardMap = new HashMap();      // key, value
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int numOfCards = Integer.parseInt(br.readLine());
        String card = br.readLine();
        int[] cardArray = stringToIntArray(card, numOfCards);

        for(int i=0; i<numOfCards; i++) {
            if (cardMap.containsKey(cardArray[i])) {
                cardMap.replace(cardArray[i], cardMap.get(cardArray[i]) + 1);
            } else {
                cardMap.put(cardArray[i], 1);
            }
        }

        int queryNum = Integer.parseInt(br.readLine());
        String queryCard = br.readLine();
        int[] queryArray = stringToIntArray(queryCard, queryNum);

        for(int i=0; i<queryArray.length; i++) {
            bw.write(search(queryArray[i]) + " ");
        }
        bw.flush();
    }

    public static int search(int find) {
        if (cardMap.containsKey(find)) {
            return cardMap.get(find);
        } else {
            return 0;
        }
    }


        /*  오류 있음 (1, 4, 5, 5, 5, 8) <- 여기서 arr[3]이 mid값일때의 left/right 자리를 정하지 못함
        int left = 0;
        int right = cardArray.length-1;
        int count = 0;

        while(left <= right) {
            int mid = (left + right) / 2;

            if(find <= cardArray[mid]) {
                right = mid - 1;
                if (find == cardArray[mid]) {
                    left = mid;
                    right = cardArray.length - 1;

                    // 어차피 오름차순으로 정렬되어있으니


                    for(int i=left; i<=right; i++) {
                        if(cardArray[i] == find) {
                            count++;
                        } else {
                            break;
                        }
                    }
                    break;
                }
            } else if (find > cardArray[mid]) {
                left = mid + 1;
            }
        }
        */

    public static int[] stringToIntArray (String str, int size) {
        int[] cards = new int[size];
        String[] cardStrArray = str.split(" ");

        for(int i=0; i<size; i++) {
            cards[i] = Integer.parseInt(cardStrArray[i]);
        }

        return cards;
    }
}
