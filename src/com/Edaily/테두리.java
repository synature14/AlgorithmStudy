package com.Edaily;

import java.util.Scanner;

public class 테두리 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        int result = 0;

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(i==1) {  // 맨 위
                    result += j;
                } else if (i==n) {      // 맨 아래
                    result += (n*(i-1)) + j;
                } else {
                    if(j==1) {
                        result += j + n*(i-1);
                    } else if(j==n) {
                        result += (n*i);
                    }
                }
            }
        }

        System.out.println(result);
    }
}
