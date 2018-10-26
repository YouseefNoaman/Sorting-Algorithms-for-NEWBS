package com.company;

public class Main {

    public static void main(String[] args) {
        int[] arr = {9, 2, 3, 5, 8, 1, 5, 7, 15};


        // this implementation of the Bubble sort is about comparing every number with the number after it, if it is larger than
        // next number it will swap them, if not it won't, it will do this for the rest of the array

        // in-place algorithm: it does not need another array or space to save data into, so it doesn't need more memory

        // this algorithm has a complexity of O(n^2), as the algorithm traverses the array every time a number is being pointed
        // at and compares it with the following element of the array

        for (int lastIndex = arr.length - 1; lastIndex > 0; lastIndex--) {
            for (int i = 0; i < lastIndex; i++) {
                if (arr[i] > arr[i + 1])
                    swap(arr, i, i + 1);
            }
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
