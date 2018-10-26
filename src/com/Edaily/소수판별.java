package com.Edaily;

import java.util.Scanner;

public class 소수판별 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        boolean isPrime = true;

        if (n <= 1) {
            isPrime = false;
        } else {
            for(int i=2; i<n; i++) {
                if( n%i == 0 ) {
                    isPrime = false;
                    break;
                }
            }
        }

        if (isPrime) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }
}
