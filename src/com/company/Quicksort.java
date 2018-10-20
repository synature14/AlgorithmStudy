package com.company;

import java.util.Scanner;

public class Quicksort {
    public static void main(String[] args) {
        int[] array = {4, 6, 1, 8, 10, 2, 7, 5, 9};
        quickSort(array, 0, array.length-1);
        for(int i=0; i<array.length; i++) {
            System.out.println(array[i]);
        }
    }

    private static void quickSort(int[] arr, int start, int end) {
        int pivotNewIndex = partition(arr, start, end);
        // pivot의 왼쪽 정렬
        if (start < pivotNewIndex - 1) {
            quickSort(arr, start, pivotNewIndex - 1);
        }

        // pivot의 오른쪽 정렬
        if (pivotNewIndex < end) {
            quickSort(arr, pivotNewIndex, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int piviot = arr[(start + end) / 2];
        while (start <= end) {
            while (arr[start] < piviot) start++;
            while (arr[end] > piviot) end--;

            if (start <= end) {
                swap(arr, start, end);
                start++;
                end--;
            }
        }
        return start;
    }

    private static void swap(int[] arr, int from, int to) {
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }
}
