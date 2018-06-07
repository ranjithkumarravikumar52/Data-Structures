package sortingalgorithm.Init;

import java.util.Arrays;

public abstract class SortAlgorithm {
    private int stepsToSort;
    private int[] sortedArray;

    public int getStepsToSort() {
        return stepsToSort;
    }

    public void setStepsToSort(int stepsToSort) {
        this.stepsToSort = stepsToSort;
    }

    public int[] getSortedArray() {
        return sortedArray;
    }

    public void setSortedArray(int[] sortedArray) {
        this.sortedArray = sortedArray;
    }
    
    @Override
    public String toString() {
        return Arrays.toString(getSortedArray()) + "\n"
                + "Total Steps to sort: " + getStepsToSort();
    }
}
