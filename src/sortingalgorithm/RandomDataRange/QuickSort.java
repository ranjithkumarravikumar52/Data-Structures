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
            //traverse from the end of the array
            //look for position element < pivot
            while (i < j && localArray[--j] >= pivot);
            if (i < j) {
                localArray[i] = localArray[j];
            }

            //traverse from the start of the array
            //look for position where element > pivot
            while (i < j && localArray[++i] <= pivot);
            if (i < j) {
                localArray[j] = localArray[i];
            }
        }

        //if code reaches here then i == j
        localArray[i] = pivot;
//        printArray(localArray);
        doQuickSort(localArray, start, i);
        doQuickSort(localArray, i + 1, end);

    }
}
