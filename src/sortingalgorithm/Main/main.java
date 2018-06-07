package sortingalgorithm.Main;

import sortingalgorithm.FixedDataRange.CountingSort;
import sortingalgorithm.FixedDataRange.RadixSort;
import sortingalgorithm.RandomDataRange.*;

public class main {

    public static void main(String[] args) {
        
//        doAllFixedSizeSorts();
        doAllRandomSizeSorts();
        
        

    }
    
    public static void doAllFixedSizeSorts(){
        CountingSort countingSort = new CountingSort();
        countingSort.countingSort();
        System.out.println(countingSort);

        System.out.println();
        
        RadixSort radixSort = new RadixSort();
        radixSort.radixSortIntegers();
        System.out.println(radixSort);
        
        System.out.println();
    }
    
    public static void doAllRandomSizeSorts(){
        BubbleSort bubble = new BubbleSort();
        bubble.bubbleSort();
        System.out.println(bubble);
        
        System.out.println();
        
        InsertionSort insertion = new InsertionSort();
        insertion.insertionSort();
        System.out.println(insertion);
        
        System.out.println();
        
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort();
        System.out.println(mergeSort);
        
        System.out.println();
        
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort();
        System.out.println(quickSort);
        
        System.out.println();
        
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.selectionSort();
        System.out.println(selectionSort);
        
        System.out.println();
        
        ShellSort shellSort = new ShellSort(); 
        shellSort.shellSort();
        System.out.println(shellSort);
        
        System.out.println();
    }
}
