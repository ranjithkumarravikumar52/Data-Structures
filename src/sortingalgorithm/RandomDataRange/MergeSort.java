package sortingalgorithm.RandomDataRange;

public class MergeSort extends RandomDataRangeSortAlgorithm{


    /**
     *
     * No new arrays is created during splitting phase - logical splitting
     * Not an inplace algorithm
     * O(n*logn)
     * Stable Algorithm
     *
     */
    public void mergeSort() {
        int[] localArray = new int[getUnSortedArray().length];
        System.arraycopy(getUnSortedArray(), 0, localArray, 0, localArray.length);
        System.out.println("===MERGE SORT===");
        int start = 0;
        int end = localArray.length;

        splitForMergeSort(localArray, start, end);
        setInputArray(localArray);

    }


    /**
     * end index is always one greater than the last element's index
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
//            if (array[i] > array[j]) {
//                //put array[j] into the new array
//                tempArray[tempIndex++] = array[j++];
//            } else {
//                tempArray[tempIndex++] = array[i++];
//            }
            //tempArray[tempIndex++] = array[i] <= array[j] ? array[i++] : array[j++];
            tempArray[tempIndex++] = array[i] >= array[j] ? array[i++] : array[j++];
            int stepsToSort = getStepsToSort();
            stepsToSort++;
            setStepsToSort(stepsToSort);
        }

        //addressing strangler elements (left over elements in either of sub arrays)
//        while (i < mid) {
//            tempArray[tempIndex++] = array[i++];
//        }
//        while (j < end) {
//            tempArray[tempIndex++] = array[j++];
//        }
        while (j < end) {
            tempArray[tempIndex++] = array[j++];
        }
        while (i < mid) {
            tempArray[tempIndex++] = array[i++];
        }

//        copying back into the given array
//        tempIndex = 0;
//        for( i = start; i < end; i++){
//            array[i] = tempArray[tempIndex++];
//        }
        System.arraycopy(tempArray, 0, array, 0 + start, end - start);

    }
}
