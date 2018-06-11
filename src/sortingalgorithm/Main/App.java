package sortingalgorithm.Main;

import sortingalgorithm.RandomDataRange.BubbleSort;
import sortingalgorithm.RandomDataRange.InsertionSort;
import sortingalgorithm.Util.SortAlgorithm;

import java.util.Arrays;
import java.util.List;

//TODO once all the sort algorithms is cleaned, provide a way to implement in JAVA EE
public class App {

    public static void main(String[] args) {

        SortAlgorithm sortAlgorithm = new InsertionSort();
        SortAlgorithm[] listArray = {new BubbleSort(), new InsertionSort()};
        for(int i = 0; i<listArray.length; i++){
            randomSortClientModule(listArray[i]);
        }

    }

    private static void randomSortClientModule(SortAlgorithm sortAlgorithm) {
        System.out.println("Inside client:\n"+Arrays.toString(sortAlgorithm.getInputArray()));
        sortAlgorithm.sort(sortAlgorithm.getInputArray());
        System.out.println(Arrays.toString(sortAlgorithm.getOutputArray()));
        System.out.println("Steps to sort: " + sortAlgorithm.getStepsToSort());
        System.out.println();
    }
}