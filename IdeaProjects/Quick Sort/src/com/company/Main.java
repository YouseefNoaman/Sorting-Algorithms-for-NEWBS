package com.company;

public class Main {

    public static void main(String[] args) {
        int[] arr = {9, 2, 3, 5, 8, 1, 5, 7, -15};
        quickSort(arr, 0, arr.length);
        printArray(arr);

    }

    public static void quickSort(int[] arr, int start, int end) {
        if ((end - start) < 2)  // this condition checks if the sent array = 1 element or else, then returns it
            return;
        int pivotIndex = partition(arr, start, end);    // this is used to select the pivot element
        quickSort(arr, start, pivotIndex);              // this recursion is used to make the left array start from the start to the pivot index
        quickSort(arr, pivotIndex + 1, end);      // // this recursion is used to make the left array start from the pivot index to the end
    }

    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[start];     // this is to initialize the array by the choosing the first element, and compare all the numbers to it
        int i = start;              // this is the pointer at the start of the array
        int j = end;                // this is the pointer at the end of the array
        while (i < j) {     // if the start pointer < end pointer
            // EMPTY LOOP
            while (i < j && arr[--j] >= pivot)
                ;    // while the start pointer < end pointer *and* the previous to the end element >= pivot, DO NOTHING
            if (i < j) {        // after breaking the while loop, if the end pointer is smaller than the start pointer
                arr[i] = arr[j];    // swap the 2 numbers
            }
            // EMPTY LOOP
            while (i < j && arr[++i] <= pivot)
                ;    // while the start pointer < end pointer *and* the next to the start element <= pivot, DO NOTHING
            if (i < j) {        // after breaking the while loop, if the start pointer is smaller than the end pointer
                arr[j] = arr[i];    // swap the 2 numbers
            }
        }
        arr[j] = pivot;     // this means that after comparing the pivot to all the elements and placing the smaller elements to the left and the larger elements to the right
        return j;           // the pivot is at the right place
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}
