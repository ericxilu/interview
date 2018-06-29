package com.lucrortek.datastructure;

import java.util.ArrayList;
import java.util.List;

public class MergeSortApp {
    private int[] sortingList;


    private void merge(int[] arry, int lowerBoundIndex, int midIndex, int upperBoundIndex){

        //calculate the size of the left array and right array
        //for example, if the full array size is 5, midIndex is 2,
        //left array size is 2-0+1 = 3
        //right array size is 4-2 = 2
        int leftArraySize = midIndex -lowerBoundIndex+1;
        int rightArraySize = upperBoundIndex-midIndex;


        //create two temp array to store the left array and right array
        //use the array from input parameter to store the sorted array
        int[] leftArray = new int[leftArraySize];
        int[] rightArray = new int[rightArraySize];

        for (int l =lowerBoundIndex; l<=midIndex; l++)
            leftArray[l] = arry[l];

        for(int r = 0; r<rightArraySize; r++)
            rightArray = arry[midIndex+1];

        //current position trackers that tracks the movement of the left array and right array during comparision
        int leftArrayCurrentPostionTracker =  lowerBoundIndex;
        int rightArrayCurrentPositionTracker = midIndex+1;

        while (leftArrayCurrentPostionTracker<= midIndex && rightArrayCurrentPositionTracker<= upperBoundIndex){

        }

    }

    private void sort(int arry[], int lowerBoundIndex, int upperBoundIndex ){
        if (lowerBoundIndex < upperBoundIndex){
            int midIndex = (upperBoundIndex - lowerBoundIndex)/2;
            sort(arry, lowerBoundIndex, midIndex);
            sort(arry, midIndex+1, upperBoundIndex);
            merge(arry, lowerBoundIndex, midIndex, upperBoundIndex);
        }


    }

    public static void main(String[] args){

    }

}