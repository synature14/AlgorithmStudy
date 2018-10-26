package com.Edaily;

import java.util.Scanner;

public class 반찬투정 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int square = (int) Math.pow(2, n);

        for(int i=0; i<square; i++) {
            String binary = Integer.toBinaryString(i);
            if (binary.length() < n) {
                int extraZero = n - binary.length();
                for(int nZero = 0; nZero<extraZero; nZero++) {
                    System.out.print("0");
                }
            }
            System.out.println(binary);
        }


    }
}
