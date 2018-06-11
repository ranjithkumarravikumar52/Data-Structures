/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingalgorithm.RandomDataRange;

import sortingalgorithm.Util.SwapElements;

/**
 *
 * @author Ranjith
 */
public class SelectionSort extends RandomDataRangeSortAlgorithm  {


    public int[] selectionSort() {
        int[] inputArray = getUnSortedArray();
        int[] localArray = new int[inputArray.length];
        System.arraycopy(inputArray, 0, localArray, 0, localArray.length);
        System.out.println("===SELECTION SORT===");
        
        int stepsToSort = 0;
        for (int lastUnsortedIndex = localArray.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            int maxIndex = 0;
            for (int arrayIndex = 1; arrayIndex <= lastUnsortedIndex; arrayIndex++) {
                stepsToSort++;
                if (localArray[arrayIndex] > localArray[maxIndex]) {
                    maxIndex = arrayIndex;
                }
            }
            stepsToSort = SwapElements.swap(localArray, lastUnsortedIndex, maxIndex, stepsToSort);
        }
        setStepsToSort(stepsToSort);
        setOutputArray(localArray);
        return localArray;
    }

    @Override
    public int[] sort(int[] inputArray) {
        int[] outputArray = selectionSort();
        return outputArray;
    }
}
