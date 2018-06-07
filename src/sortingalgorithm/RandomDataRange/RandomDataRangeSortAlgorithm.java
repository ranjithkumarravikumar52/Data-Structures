package sortingalgorithm.RandomDataRange;

import sortingalgorithm.Init.ArrayGenerator;
import sortingalgorithm.Init.SortAlgorithm;

public abstract class RandomDataRangeSortAlgorithm extends SortAlgorithm {

    private static int[] unSortedArray = ArrayGenerator.getRandomDataRangeArray();

    public int[] getUnSortedArray() {
        return unSortedArray;
    }

}
