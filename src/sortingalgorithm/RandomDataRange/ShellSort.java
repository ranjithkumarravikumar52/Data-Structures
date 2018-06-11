/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingalgorithm.RandomDataRange;

/**
 * @author Ranjith
 */
public class ShellSort extends RandomDataRangeSortAlgorithm {

    public ShellSort() {
        this.setInputArray(RandomDataRangeSortAlgorithm.getUnSortedArray());
    }

    private int[] shellSort(int[] inputArray) {
        int[] localArray = new int[inputArray.length];
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
                    j = j - gap;
                }
                localArray[j] = newElement;
            }
        }
        setStepsToSort(stepsToSort);
        setOutputArray(localArray);
        return localArray;
    }

    @Override
    public int[] sort(int[] inputArray) {
        return shellSort(inputArray);
    }
}
