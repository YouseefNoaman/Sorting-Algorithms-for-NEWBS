package com.company;

/*
*   this is a beginner's guide to selection sort
*
*/

public class Main {

    public static void main(String[] args) {

        int[] arr = {9, 2, 3, 5, 8, 1, 5, 7, -15};

        // this loop traverses the array from the end to the start of it
        for (int lastSortedIndex = arr.length - 1; lastSortedIndex > 0; lastSortedIndex--){

            int largestNum = 0;       // to hold the largest number's index in the array


            // this loop traverses from the start of the array to the index that the outer loop
            // is at, and checks if the number that it is at currently is larger than the number
            // that largestNum is holding
            for (int i = 1; i <= lastSortedIndex; i++){
                if (arr[i] > arr[largestNum])
                    largestNum = i;
            }

            swap(arr, largestNum, lastSortedIndex);
        }

        printArray(arr);


    }

    public static void swap(int[] arr, int i, int j) {  // this function is used to swap 2 numbers in an array
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

}
