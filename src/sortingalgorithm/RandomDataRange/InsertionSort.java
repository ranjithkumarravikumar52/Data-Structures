package sortingalgorithm.RandomDataRange;

public class InsertionSort extends RandomDataRangeSortAlgorithm{
    


    public void insertionSort() {
        int stepsToSort = 0;
        int[] localArray = new int[getUnSortedArray().length];
        System.arraycopy(getUnSortedArray(), 0, localArray, 0, localArray.length);
        System.out.println("===INSERTION SORT===");

        for (int firstUnsortedIndex = 1; firstUnsortedIndex < localArray.length; firstUnsortedIndex++) {
            int newElement = localArray[firstUnsortedIndex];
            int i;
            stepsToSort++;
            for (i = firstUnsortedIndex; i > 0 && localArray[i - 1] > newElement; i--) {
                stepsToSort++;
                //shifting to right
                localArray[i] = localArray[i - 1];
            }
            localArray[i] = newElement;

        }
        setStepsToSort(stepsToSort);
        setInputArray(localArray);

    }
}
