package com.company;

public class Main {

    public static void main(String[] args) {
        int[] arr = {9, 2, 3, 5, 8, 1, 5, 7};   // this algorithm works on positive numbers only
        countingSort(arr, 1, 9);   // this algorithm needs to work in a range, which is minimum and maximum numbers present
        printArray(arr);
    }

    public static void countingSort(int[] arr, int min, int max){

        int[] countArray = new int[(max - min) + 1 ];
        // this loop counts the occurrences of the same number in the array
        for (int i = 0; i < arr.length; i++){
            countArray[arr[i] - min]++;
        }

        int j = 0;
        // this loop is to traverse all the array by values
        for (int i = min; i <= max; i++){
            // this loop is to write the numbers by their occurrences
            while (countArray[i - min] > 0){
                arr[j++] = i;
                countArray[i - min]--;      // this is to decrement the counts of the same number after writing the number in the original array
            }
        }
    }


    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

}
