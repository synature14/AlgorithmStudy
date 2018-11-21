package com.study181127;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 방번1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        str = str.replace('9', '6');
        String[] strArr = str.split("");

        int[] numArr = new int[str.length()+1];

        for(int i=0; i<str.length(); i++) {
            numArr[i] = Integer.parseInt(strArr[i]);
        }

        int[] setNum = new int[10];

        for(int i=0; i<numArr.length; i++) {
            setNum[numArr[i]] += 1;
        }

        setNum[6] = setNum[6]/2 + setNum[6]%2;      // 주의

        int nSet = 0;
        for(int i=0; i<9; i++) {
            if(nSet < setNum[i]) {
                nSet = setNum[i];
            }
        }

        System.out.println(nSet);
    }
}
