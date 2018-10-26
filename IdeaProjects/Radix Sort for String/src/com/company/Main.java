package com.company;

public class Main {

    public static void main(String[] args) {
        String[] arr = {"abc", "abb", "acd", "bda", "aaa", "aab"};  // words need to have the same width, here it's 3, also this code only works on small letters
        radixSort(arr, 10, 3);  // the radix = 10 because the characters are converted to ASCII code
        printArray(arr);
    }

    public static void radixSort(String[] arr, int radix, int width){
        // this loop sends the values of elements in the array by the width, so in the second iteration
        // if the value = 824, then 2 is sent to the radixSingleSort, with all the elements in the array at the same position
        for (int i = width - 1; i >= 0; i--)
            radixSingleSort(arr, i, radix);
    }

    public static void radixSingleSort(String[] arr, int position, int radix){
        int numItems = arr.length;
        int[] countArray = new int[radix];      // to count the occurrences of the same number  // counting sort array
        for (String value : arr){  // this loop is the counting sort, it counts how many times the numbers are present at a certain position
            countArray[getIndex(position, value)]++;
        }
        // adjust the count array, to make it count the post occurrences of the elements
        for (int j = 1; j < radix; j++)
            countArray[j] += countArray[j - 1];

        String[] temp = new String[numItems];
        // this loop is to save the numbers that are ordered by the certain position in the temp array
        for (int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--){
            temp[--countArray[getIndex(position, arr[tempIndex])]] = arr[tempIndex];
        }
        // this loop is to save all the sorted numbers back to the original array
        for (int tempIndex = 0; tempIndex < numItems; tempIndex++)
            arr[tempIndex] = temp[tempIndex];


    }

    public static int getIndex(int position, String value){
        return value.charAt(position) - 'a';    // the value is - 'a' because it needs to get the value of the character from 0 to 25
    }

    public static void printArray(String[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}
