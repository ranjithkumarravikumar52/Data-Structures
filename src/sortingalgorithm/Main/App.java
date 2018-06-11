package sortingalgorithm.Main;

import sortingalgorithm.RandomDataRange.BubbleSort;
import sortingalgorithm.RandomDataRange.InsertionSort;
import sortingalgorithm.RandomDataRange.MergeSort;
import sortingalgorithm.RandomDataRange.QuickSort;
import sortingalgorithm.Util.SortAlgorithm;

import java.util.Arrays;
import java.util.List;

//TODO once all the sort algorithms is cleaned, provide a way to implement in JAVA EE
//TODO change parameter stepsToSort to TimeTaken
public class App {

    public static void main(String[] args) {

        SortAlgorithm[] listArray = {new BubbleSort(), new InsertionSort(), new MergeSort(), new QuickSort()};
        for(int i = 0; i<listArray.length; i++){
            randomSortClientModule(listArray[i]);
        }

    }

    private static void randomSortClientModule(SortAlgorithm sortAlgorithm) {
        sortAlgorithm.sort(sortAlgorithm.getInputArray());
        System.out.println(Arrays.toString(sortAlgorithm.getOutputArray()));
    }
}