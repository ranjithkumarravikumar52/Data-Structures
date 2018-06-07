package sortingalgorithm.Util;

public interface swappable {
    /**
     * Every time there is a swap operation between two variables the stepsToSort count increases
     * @param array input array
     * @param i element to be swapped with
     * @param j element to be swapped with
     */
    public void swap(int[] array, int i, int j);
}
