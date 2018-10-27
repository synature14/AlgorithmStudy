package com.WinterCoding;

// dp로 풀어야될듯..
public class Cookie {
    public static void main(String[] args) {
        int[] cookie = {1,1,2,3};
        boolean answer;

        for(int i=1; i<cookie.length; i++) {
           answer = partion(cookie, i);
           if (answer) {
               System.out.println("나눠줄수있음!");
               break;
           }
        }

    }

    public static boolean partion(int[] cookies, int start) {
        int nFirst = 0;
        int nSecond = 0;

        for(int i=0; i<start; i++) {
            nFirst += cookies[i];
        }

        for(int i=start; i<cookies.length; i++) {
            nSecond += cookies[i];
        }

        if (nFirst == nSecond) {
            return true;
        } else {
            return false;
        }
    }
}
