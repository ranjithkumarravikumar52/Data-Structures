package heaps;

import java.util.Arrays;

public class Heaps {

    private int[] heapArray;
    private int size;

    public Heaps(int capacity) {
        this.heapArray = new int[capacity];
    }

    public void insert(int newElement) {
        //insert at the end of the array
        heapArray[size++] = newElement;

        //every insertion is followed by a heapfiy process
        int childIndex = size - 1;
        heapifyTree(childIndex);
    }

    private void heapifyTree(int childIndex) {
        //child = index; parent = (index - 1)/2
//        int parentIndex = (childIndex - 1) / 2;
        while (childIndex > 0) {
            int parentIndex = (childIndex - 1) / 2;
            if (heapArray[childIndex] > heapArray[parentIndex]) {
                swap(childIndex, parentIndex);
            }
            childIndex--;
        }
    }



    private void swap(int childIndex, int parentIndex) {
        //Debug variables
        int parentValue = heapArray[parentIndex];
        int childValue = heapArray[childIndex];

        int tempValue = parentValue;
        heapArray[parentIndex] = childValue;
        heapArray[childIndex] = tempValue;
    }

    @Override
    public String toString() {
        return Arrays.toString(heapArray);
    }

}
