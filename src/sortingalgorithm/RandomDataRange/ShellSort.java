/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingalgorithm.RandomDataRange;

/**
 *
 * @author Ranjith
 */
public class ShellSort extends RandomDataRangeSortAlgorithm {


    public void shellSort() {
        int[] localArray = new int[getUnSortedArray().length];
        System.arraycopy(getUnSortedArray(), 0, localArray, 0, localArray.length);
        System.out.println("===SHELL SORT===");
        int stepsToSort = 0;
        for (int gap = localArray.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < localArray.length; i++) {
                int newElement = localArray[i];
                //j used for traversing
                int j = i;
                while (j >= gap && localArray[j - gap] > newElement) {
                    stepsToSort++;
                    localArray[j] = localArray[j - gap];
//                  20 35 -15 7 55 1 -22
//                  20 35 -15 20 55 1 -22
//                  subtract gap from j
                    j = j - gap;
                }
                localArray[j] = newElement;
                //7 35 -15 20 55 1 -22
            }
        }
        setStepsToSort(stepsToSort);
        setSortedArray(localArray);
    }
}
