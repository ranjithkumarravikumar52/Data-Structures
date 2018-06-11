package sortingalgorithm.RandomDataRange;

public class QuickSort extends RandomDataRangeSortAlgorithm {


    public void quickSort() {
        int[] localArray = new int[getUnSortedArray().length];
        System.arraycopy(getUnSortedArray(), 0, localArray, 0, localArray.length);
//        int[] localArray = {20, 35, -15, 7, 55, 1, -22};
        System.out.println("===QUICK SORT===");
        doQuickSort(localArray, 0, localArray.length);
        setInputArray(localArray);
    }


    private void doQuickSort(int[] localArray, int start, int end) {

        if (end - start < 2) {
            return;
        }

        int pivot = localArray[start];
        int i = start;
        int j = end;

        while (i < j) {
            j = traverseFromEnd(localArray, pivot, i, j);
            i = traverseFromStart(localArray, pivot, i, j);
        }

        //if code reaches here then i == j
        localArray[i] = pivot;
        doQuickSort(localArray, start, i);
        doQuickSort(localArray, i + 1, end);

    }

    /**
     * traverse from the start of the array
     * look for position where element > pivot
     * @param localArray
     * @param pivot
     * @param i
     * @param j
     * @return
     */
    private int traverseFromStart(int[] localArray, int pivot, int i, int j) {
        while (i < j && localArray[++i] <= pivot);
        if (i < j) {
            localArray[j] = localArray[i];
        }
        return i;
    }

    /**
     * traverse from the end of the array
     * look for position element < pivot
     * @param localArray
     * @param pivot
     * @param i
     * @param j
     * @return
     */
    private int traverseFromEnd(int[] localArray, int pivot, int i, int j) {
        while (i < j && localArray[--j] >= pivot);
        if (i < j) {
            localArray[i] = localArray[j];
        }
        return j;
    }

    @Override
    public int[] sort(int[] inputArray) {
        return new int[0];
    }
}
