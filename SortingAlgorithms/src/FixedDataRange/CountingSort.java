package FixedDataRange;

public class CountingSort extends FixedDataRangeSortAlgorithm {
    
    public void countingSort() {
        //accessing array variable from FixedDataRangeSortAlgorithm
        int[] localArray = new int[getUnSortedArray().length];
        System.arraycopy(getUnSortedArray(), 0, localArray, 0, localArray.length);
        
        int[] countingArray = new int[10];
        System.out.println("===COUNTING SORT===");
        setStepsToSort(0);

        //Setting up counting array
        for (int i = 0; i < localArray.length; i++) {
            countingArray[localArray[i] - 1]++; //how to calculate for different mins and max values? 
        }
        
        //how this could work for different min and max values instead of min=1
        //sorting elements based on the counting array
        int j=0;
        for (int i = 0; i < countingArray.length; i++) {
            if (countingArray[i] != 0) {
//                int count = countingArray[i];
                while ((countingArray[i]-- > 0)) {
                    localArray[j++] = i + 1;
                }
            }
        }
        
        setSortedArray(localArray);

    }

}
