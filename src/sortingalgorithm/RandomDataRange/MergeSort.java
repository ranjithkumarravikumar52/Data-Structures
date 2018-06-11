package sortingalgorithm.RandomDataRange;

public class MergeSort extends RandomDataRangeSortAlgorithm {


    public MergeSort() {
        this.setInputArray(RandomDataRangeSortAlgorithm.getUnSortedArray());
    }

    /**
     * No new arrays is created during splitting phase - logical splitting
     * Not an inplace algorithm
     * O(n*logn)
     * Stable Algorithm
     */
    //TODO change the sort to increasing order
    public int[] mergeSort(int[] inputArray) {
        int[] localArray = new int[inputArray.length];
        System.arraycopy(getUnSortedArray(), 0, localArray, 0, localArray.length);
        System.out.println("===MERGE SORT===");
        int start = 0;
        int end = localArray.length;

        splitForMergeSort(localArray, start, end);
        this.setOutputArray(localArray);
        return localArray;

    }


    /**
     * end index is always one greater than the last element's index
     *
     * @param array
     * @param start
     * @param end
     */
    private void splitForMergeSort(int[] array, int start, int end) {
        int mid = (start + end) / 2;

        if (end - start > 1) {
            splitForMergeSort(array, start, mid);
            splitForMergeSort(array, mid, end);
            mergeForMergeSort(array, start, mid, end);

        } else {
            return;
        }

    }

    private void mergeForMergeSort(int[] array, int start, int mid, int end) {
        int i = start;
        int j = mid;
        int tempIndex = 0;
        int[] tempArray = new int[end - start];
        while (i < mid && j < end) {
            tempArray[tempIndex++] = array[i] >= array[j] ? array[i++] : array[j++];
            int stepsToSort = getStepsToSort();
            stepsToSort++;
            setStepsToSort(stepsToSort);
        }

        while (j < end) {
            tempArray[tempIndex++] = array[j++];
        }
        while (i < mid) {
            tempArray[tempIndex++] = array[i++];
        }


        System.arraycopy(tempArray, 0, array, 0 + start, end - start);

    }

    @Override
    public int[] sort(int[] inputArray) {
        return mergeSort(inputArray);
    }
}
