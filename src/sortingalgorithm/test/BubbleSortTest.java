package sortingalgorithm.test;

import sortingalgorithm.RandomDataRange.BubbleSort;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;

public class BubbleSortTest {

    /**
     * input:
     */
    @org.junit.Test
    public void bubbleSort_values_1() {
        //create bubble sort object
        BubbleSort bs = new BubbleSort();
        int[] unSortedArray = {3, 2, 1};
        bs.setInputArray(unSortedArray);
        bs.bubbleSort();
        int[] actual = bs.getInputArray();
        assertArrayEquals(new int[]{1,2,3}, actual);

    }

    @org.junit.Test
    public void swap() {
        fail("Yet to be implemented");
    }
}