package com.company;

public class Main {

    // this algorithm does some preliminary work first, by sorting the array by a gap, here the gap = array length / 2
    // then it runs the insertion sort normally

    public static void main(String[] args) {
        int[] arr = {9, 2, 3, 5, 8, 1, 5, 7, -15};

        // this loop is used to traverse the array at a gap
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {

            // this loop runs from the gap position to the end of the array
            for (int i = gap; i < arr.length; i++) {
                int element = arr[i];
                int j = i;

                // this loop compares an element to the rest of the array while traversing it starting from the gap to the start of the array
                // and checks if the element is larger than the value pointed at by j - gap
                while (j >= gap && arr[j - gap] > element) {
                    arr[j] = arr[j - gap];      // if the element is smaller it will swap every element pointed at by j to j - gap
                    j -= gap;                   // this is to decrement the j by the gap, to make it end the loop and change the gap
                }
                arr[j] = element;       // then the element is placed at the correct position of j
            }
        }
        printArray(arr);

    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}
