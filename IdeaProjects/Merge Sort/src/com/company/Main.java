package com.company;

/*
*
* this is an implementation of the merge sort, using the recursion.
*
* it is a stable algorithm, as the duplicate numbers are ordered in the same order they were in the original array
*
* it is a not in-place algorithm, as it requires temporary arrays to hold values in the merge phase
*
* O(n log to the base 2 n) = O(n log n), n for traversing the array for comparisons, and log n (to the base 2) because it divides the array to 2 arrays
*
*   this algorithm works on negative numbers
*/

public class Main {

    public static void main(String[] args) {

        int[] arr = {9, 2, 3, 5, 8, 1, 5, 7, -15};
        mergeSort(arr, 0, arr.length);
        printArray(arr);

    }

    public static void mergeSort(int [] arr, int start, int end){   // this function is used to split the array into 2 halves till 1 item is remaining in an array
        if (end - start < 2)    // if the array's size = 1, end the splitting function
            return;
        int middle = (start + end) / 2;     // get the middle point of an array, then split it into 2 halves using recursion
        mergeSort(arr, start, middle);      // first half
        mergeSort(arr, middle, end);        // second half
        merge(arr, start, middle, end);     // call the merge function to merge the 2 halves of the array
    }

    public static void merge(int [] arr, int start, int middle, int end){   // this function is used to compare the 2 array halves and sort them
        if (arr[middle - 1] <= arr[middle])     // if the last item in the left half array <= the first item in the right half array, then they are sorted
            return;                             // end the function if it is sorted
        int i = start;
        int j = middle;
        int tempIndex = 0;

        int[] temp = new int[end - start];
        while (i < middle && j < end){          // if the start pointer < middle of the array *and* the middle pointer < end
            // if the first pointer's value < second pointer's value, then save the first value in the temp array, else save the second pointer's value
            // then increment the selected pointer from the selected array, to get the next value, and increment the temp array
            temp[tempIndex++] = arr[i] < arr[j] ? arr[i++]: arr[j++];
        }
        // System.arraycopy() is a function used to copy an array's contents to another array, given the 2 array, and the starting point of the copy and paste
        System.arraycopy(arr, i, arr, start + tempIndex, middle - i);
        System.arraycopy(temp, 0, arr, start, tempIndex);
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}
