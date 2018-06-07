package sortingalgorithm.FixedDataRange;

import sortingalgorithm.Init.ArrayGenerator;
import sortingalgorithm.Init.SortAlgorithm;

public abstract class FixedDataRangeSortAlgorithm extends SortAlgorithm {
    private static int[] unSortedArray = ArrayGenerator.getFixedDataRangeArray(1, 10);

    public static int[] getUnSortedArray() {
        return unSortedArray;
    }
    
    
}
