package com.company;

public class Main {

    public static void main(String[] args) {

        int[] arr = {9, 2, 3, 5, 8, 1, 5, 7, -15};

        // this loop traverses the array from the start to the end of it, starting from 1 not 0
        for (int firstUnsortedIndex = 1; firstUnsortedIndex < arr.length; firstUnsortedIndex++) {

            int element = arr[firstUnsortedIndex];  // to hold a value from the outer loop
            int i;

            // this loop will traverse the array from right to left and check if there is a bigger number than the one it is holding in element
            for (i = firstUnsortedIndex; i > 0 && arr[i - 1] > element; i--) {
                arr[i] = arr[i - 1];    // this means that the number will be placed at the previous position in the array, as it is smaller than element
            }
            arr[i] = element;       // other than that the element is larger and would be placed in the correct place in the array

        }

        printArray(arr);

    }


    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}
