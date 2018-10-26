package com.company;

public class Main {

    public static void main(String[] args) {
        int[] arr = {9, 2, 3, 5, 8, 1, 5, 7};
        radixSort(arr, 10, 1);
        printArray(arr);
    }

    public static void radixSort(int[] arr, int radix, int width){
        // this loop sends the values of elements in the array by the width, so in the second iteration
        // if the value = 824, then 2 is sent to the radixSingleSort, with all the elements in the array at the same position
        for (int i = 0; i < width; i++)
            radixSingleSort(arr, i, radix);
    }

    public static void radixSingleSort(int[] arr, int position, int radix){
        int numItems = arr.length;
        int[] countArray = new int[radix];  // to count the occurrences of the same number  // counting sort array
        for (int value : arr){  // this loop is the counting sort, it counts how many times the numbers are present at a certain position
            countArray[getDigit(position, value, radix)]++;
        }
        // adjust the count array, to make it count the post occurrences of the elements
        for (int j = 1; j < radix; j++)
            countArray[j] += countArray[j - 1];

        int[] temp = new int[numItems];
        // this loop is to save the numbers that are ordered by the certain position in the temp array
        for (int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--){
            temp[--countArray[getDigit(position, arr[tempIndex], radix)]] = arr[tempIndex];
        }
        // this loop is to save all the sorted numbers back to the original array
        for (int tempIndex = 0; tempIndex < numItems; tempIndex++)
            arr[tempIndex] = temp[tempIndex];


    }

    public static int getDigit(int position, int value, int radix){ // this function is used to get the number from a certain multi-digit number based on a position
        return value / (int) Math.pow(radix, position) % radix;
        // if we need to get the 2 from 824, it will be getDigit(1, 2, 3), the output will be 1, which is in the position in the array is 2
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }


}
