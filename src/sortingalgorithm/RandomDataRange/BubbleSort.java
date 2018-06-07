package sortingalgorithm.RandomDataRange;

import sortingalgorithm.Init.swappable;

public class BubbleSort extends RandomDataRangeSortAlgorithm implements swappable {

    
    public void bubbleSort() {
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
        setSortedArray(localArray);
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
