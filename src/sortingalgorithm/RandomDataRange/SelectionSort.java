/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingalgorithm.RandomDataRange;

import sortingalgorithm.Init.swappable;

/**
 *
 * @author Ranjith
 */
public class SelectionSort extends RandomDataRangeSortAlgorithm implements swappable {


    public void selectionSort() {
        int[] localArray = new int[getUnSortedArray().length];
        System.arraycopy(getUnSortedArray(), 0, localArray, 0, localArray.length);
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
            swap(localArray, lastUnsortedIndex, maxIndex);
        }
        setStepsToSort(stepsToSort);
        setSortedArray(localArray);
    }

    public void swap(int[] array, int i, int j) {
        if (i == j) {
            return;
        }
        int stepsToSort = getStepsToSort();
        stepsToSort++;
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        setStepsToSort(stepsToSort);
    }
}
