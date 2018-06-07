package sortingalgorithm.RandomDataRange;

import sortingalgorithm.Util.swappable;

/**
 * Inherits fields from the superclass SortAlgorithm
 * <ul>
 * <li>stepsToSort - steps to sort any given array, the measurement of steps is defined in the sorting algorithm implementation.</li>
 * <li>inputArray - input array to be sorted</li>
 * </ul>
 */
public class BubbleSort extends RandomDataRangeSortAlgorithm implements swappable {

    public BubbleSort() {
        super();
        //TODO: make sure that this class instance variables have values instantiated appropriately
    }

    /**
     * Worst sorting algorithm
     * Time complexity: O(n^2)
     * In-place sorting algorithm
     */
    public void bubbleSort() {
        //TODO this method should return an int array
        int stepsToSort = 0;
        int[] localArray = new int[getUnSortedArray().length];
        System.arraycopy(getUnSortedArray(), 0, localArray, 0, localArray.length);

        System.out.println("===BUBBLE SORT===");
        for (int lastUnsortedIndex = localArray.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            for (int i = 0; i < lastUnsortedIndex; i++) {
                stepsToSort++;
                if (localArray[i] > localArray[i + 1]) {
                    swap(localArray, i, i + 1);
                }
            }
        }

        setStepsToSort(stepsToSort);
        setInputArray(localArray);
    }

    @Override
    public void swap(int[] array, int i, int j) {
        if (i == j) {
            return;
        }
        int stepsToSort = getStepsToSort();
        stepsToSort++;
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        setStepsToSort(stepsToSort);
    }


}
