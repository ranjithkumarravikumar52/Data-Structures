package sortingalgorithm.Util;

public class SwapElements {
    /**
     * Every time there is a swap operation between two variables the stepsToSort count increases
     * @param array input array
     * @param i element to be swapped with
     * @param j element to be swapped with
     * @return number of steps to swap
     */
    public static int swap(int[] array, int i, int j, int stepsToSort) {
        if (i == j) {
            return 0;
        }
        stepsToSort++;
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        return stepsToSort;
    }
}
