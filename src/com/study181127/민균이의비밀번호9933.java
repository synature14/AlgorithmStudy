package com.study181127;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 민균이의비밀번호9933 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] password = new String[n+1];
        ArrayList<String> reversedArr = new ArrayList<>();

        for(int i=0; i<n; i++) {
            StringBuilder reversed = new StringBuilder();
            password[i] = br.readLine();

            for(int c=password[i].length()-1; c>=0; c--) {
                reversed.append(password[i].charAt(c));
            }
            reversedArr.add(reversed.toString());
        }

        for(int i=0; i<n; i++) {
            if(reversedArr.contains(password[i])) {
                int length = password[i].length();
                System.out.println(length + " " + password[i].charAt(length/2));
                break;
            }
        }

    }
}
