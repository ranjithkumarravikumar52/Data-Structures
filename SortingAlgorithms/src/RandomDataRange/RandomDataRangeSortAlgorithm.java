package RandomDataRange;

import Init.ArrayGenerator;
import Init.SortAlgorithm;
import java.util.Arrays;

public abstract class RandomDataRangeSortAlgorithm extends SortAlgorithm {

    private static int[] unSortedArray = ArrayGenerator.getRandomDataRangeArray();

    public int[] getUnSortedArray() {
        return unSortedArray;
    }

}
