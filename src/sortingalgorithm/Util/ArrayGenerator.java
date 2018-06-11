package sortingalgorithm.Util;

import java.util.Arrays;
import java.util.Random;

public class ArrayGenerator {

    private static int[] randomArray;
    private static int[] fixedArray;

    public static int[] getRandomDataRangeArray() {
        int size = 10;
        Random rand = new Random();
        randomArray = new int[size];
        for (int i = 0; i < size; i++) {
            randomArray[i] = rand.nextInt(10);
        }
        System.out.println("Given random - unsorted Array:\n" + Arrays.toString(randomArray) + "\n");
        return randomArray;
    }

    public static int[] getFixedDataRangeArray(int min, int max) {
        int size = max - min + 1;
        Random rand = new Random();
        fixedArray = new int[size];
        for (int i = 0; i < fixedArray.length; i++) {
            fixedArray[i] = rand.nextInt(max - min) + min;
        }
        System.out.println("Given fixed - unsorted Array:\n" + Arrays.toString(fixedArray) + "\n");
        return fixedArray;

    }

}
