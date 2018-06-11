package sortingalgorithm.FixedDataRange;

import java.util.Arrays;

public class CountingSort extends FixedDataRangeSortAlgorithm {

    public CountingSort() {
        this.setInputArray(FixedDataRangeSortAlgorithm.getUnSortedArray());
    }

    private int[] countingSort(int[] inputArray) {
        //accessing array variable from FixedDataRangeSortAlgorithm
        int[] localArray = new int[inputArray.length];
        System.arraycopy(inputArray, 0, localArray, 0, localArray.length);

        int[] countingArray = new int[10];
        System.out.println("===COUNTING SORT===");
        setStepsToSort(0);

        //Setting up counting array
        for (int i = 0; i < localArray.length; i++) {
            countingArray[localArray[i] - 1]++; //how to calculate for different mins and max values? 
        }

        //how this could work for different min and max values instead of min=1
        //sorting elements based on the counting array
        int j = 0;
        for (int i = 0; i < countingArray.length; i++) {
            if (countingArray[i] != 0) {
//                int count = countingArray[i];
                while ((countingArray[i]-- > 0)) {
                    localArray[j++] = i + 1;
                }
            }
        }

        setOutputArray(localArray);
        return localArray;

    }

    @Override
    public int[] sort(int[] inputArray) {
        System.out.println("Input array for the counting sort:\n"+ Arrays.toString(this.getInputArray()));
        return countingSort(inputArray);
    }
}
