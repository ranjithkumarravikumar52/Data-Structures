package heaps;

import java.util.Arrays;

public class Heaps {

    private int[] heapArray;
    private int size;

    public Heaps(int capacity) {
        this.heapArray = new int[capacity];
    }

    public void insert(int newElement) {
        heapArray[size++] = newElement;
        int childIndex = size - 1;
        heapifyTree(childIndex);
    }

    private void heapifyTree(int childIndex) {
        while (childIndex > 0) {
            int parentIndex = (childIndex - 1) / 2;
            if (heapArray[childIndex] > heapArray[parentIndex]) {
                swap(childIndex, parentIndex);
            }
            childIndex--;
        }
    }

    private void swap(int childIndex, int parentIndex) {
        int parentValue = heapArray[parentIndex];
        int childValue = heapArray[childIndex];

        int tempValue = parentValue;
        heapArray[parentIndex] = childValue;
        heapArray[childIndex] = tempValue;
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(heapArray[i] + " ");
        }
        System.out.println();
    }
    
    public void delete(int deleteIndex){
        if(deleteIndex >=0 && deleteIndex < size){
            heapArray[deleteIndex] = heapArray[size - 1];
            size--;
            heapifyTree(size -1);
        }
    }
}
