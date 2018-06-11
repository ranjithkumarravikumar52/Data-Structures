package sortingalgorithm.FixedDataRange;

import sortingalgorithm.Util.ArrayGenerator;
import sortingalgorithm.Util.SortAlgorithm;

/**
 * This class extends SortAlgorithm.
 * This class is implemented for SortAlgorithm classes where the data to be sorted <b>MUST</b> be of a specified order.
 * <p>The classes that extends this classes are as follows: </p>
 * <ul>
 * <li>Counting Sort</li>
 * <li>Radix Sort</li>
 * </ul>
 */
public abstract class FixedDataRangeSortAlgorithm extends SortAlgorithm {

    private static int[] unSortedArray = ArrayGenerator.getFixedDataRangeArray(1, 10);

    public static int[] getUnSortedArray() {
        return unSortedArray;
    }

}
