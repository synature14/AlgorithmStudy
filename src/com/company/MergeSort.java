package com.company;// 머지소트 - 실행시에 별도의 정렬해야할 배열의 크기만큼 임시 저장할 공간을 필요로 함
// 최악의 경우에도 O(n * logN)

public class MergeSort {
    public static void main(String[] agrs) {
        int[] arr = {5, 10, 2, 6, 8, 1, 21, 13, 4, 9};
        int[] temp = new int[arr.length];
        partition(arr, temp, 0, arr.length-1);
        for(int i=0; i<arr.length; i++) {
            System.out.print("arr : " + arr[i] + "\n");
        }
    }

    private static void partition(int[] arr, int[] temp, int start, int end) {
        // 분할이 아직 다 완료되지 않았을 경우 if문 실행
        if (start < end) {
            int mid = (start + end) / 2;
            partition(arr, temp, start, mid);       // 왼쪽 블록 분할
            partition(arr, temp, mid+1, end);   // 오른쪽 블록 분할
            // 이제 병합!
            merge(arr, temp, start, mid, end);
        }
    }

    private static void merge(int[] arr, int[] temp, int start, int mid, int end) {
        // 배열값 복사
        for(int i = start; i<=end; i++) {
            temp[i] = arr[i];
        }

        int part1 = start;      // 첫번째 배열방의 첫번째 인덱스
        int part2 = mid + 1;    // 두번째 배열방의 첫번쨰 인덱스
        int index = start;

        while (part1 <= mid && part2 <= end) {
            if (temp[part1] <= temp[part2]) {
                arr[index] = temp[part1];
                part1++;
            } else {
                arr[index] = temp[part2];
                part2++;
            }
            index++;
        }

        // 뒤쪽 배열은 비었고, 앞쪽 배열만 데이터 남아있을 경우
        for (int i = 0; i <= mid-part1; i++) {
            arr[index + i] = temp[part1 + i];
        }
    }

}
