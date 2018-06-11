package sortingalgorithm.RandomDataRange;

import sortingalgorithm.Util.SwapElements;

/**
 * Inherits fields from the superclass SortAlgorithm
 * <ul>
 * <li>stepsToSort - steps to sort any given array, the measurement of steps is defined in the sorting algorithm implementation.</li>
 * <li>inputArray - input array to be sorted</li>
 * </ul>
 */
public class BubbleSort extends RandomDataRangeSortAlgorithm {

    public BubbleSort(){
        this.setInputArray(RandomDataRangeSortAlgorithm.getUnSortedArray());
    }

    private int[] bubbleSort(int[] inputArray) {
        int stepsToSort = 0;
        int[] localArray = new int[inputArray.length];
        System.arraycopy(inputArray, 0, localArray, 0, localArray.length);

        System.out.println("===BUBBLE SORT===");
        for (int lastUnsortedIndex = localArray.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            for (int i = 0; i < lastUnsortedIndex; i++) {
                stepsToSort++;
                if (localArray[i] > localArray[i + 1]) {
                    stepsToSort = SwapElements.swap(localArray, i, i + 1, stepsToSort);
                }
            }
        }

        setStepsToSort(stepsToSort);
        setOutputArray(localArray);
        return localArray;
    }

    @Override
    public int[] sort(int[] inputArray) {
        int[] outputArray = bubbleSort(inputArray);
        return outputArray;
    }
}
