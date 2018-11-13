package com.study181113;

import java.util.*;

public class 키로거5397 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int nTestCase = scan.nextInt();
        scan.nextLine();

        while (nTestCase-- > 0) {
            ArrayList<String> leftList = new ArrayList<>();
            Stack<String> right = new Stack<>();

            String str = scan.nextLine();
            String[] strArr = str.split("");
            for (String letter : strArr) {
                if (letter.equals("-")) {
                    if (!leftList.isEmpty()) {
                        leftList.remove(leftList.size() - 1);

                    }
                } else if (letter.equals("<")) {
                    if (!leftList.isEmpty()) {
                        int lastIndex = leftList.size()-1;
                        right.push(leftList.get(lastIndex));
                        leftList.remove(lastIndex);
                    }
                } else if (letter.equals(">")) {
                    if (!right.isEmpty()) {
                        leftList.add(right.peek());
                        right.pop();
                    }

                } else {    // 알파벳이라면
                    leftList.add(letter);
                }

            } //for()

            while(!right.isEmpty()) {
                leftList.add(right.pop());
            }

            for(int i=0; i<leftList.size(); i++) {
                System.out.print(leftList.get(i));
            }
            System.out.println();

        } //while()

    }
}
