package sortingalgorithm.FixedDataRange;

import java.util.Arrays;
import java.util.Random;

public class RadixSort extends FixedDataRangeSortAlgorithm {
    private int width;
    private int numElements;
    private int radix;

    /**
     * // Elements in the data has the same radix and width
     * // Radix: Number of unique digits/characters in numbering system/alphabets
     * // Radix for decimal system: 10
     * // Radix for binary system: 2
     * // Radix for english alphabets: 26
     * <p>
     * // Width: Number of digits/characters
     * // Width: 12345 is 5
     * // Width: abc is 3
     * // ASSUMPTION: This sorting assumes that data has same radix and width
     * // SORTING DIRECTION: right->left
     * // MUST use stable sort algorithm. WHY? Think about it. HINT: Sorting is done
     * // based on each digit/character
     */
    public RadixSort() {
        width = 5;
        numElements = 10;
        radix = 10; // decimal system
        int[] inputArray = getIntegerArrayRadixSort(numElements, width, radix);
        this.setInputArray(inputArray);

    }

    /**
     * // Need an array with a fixed width
     * // Array should be of the type integer (no-decimals)
     */
    public int[] radixSortIntegers(int[] inputArray) {
        System.out.println("===RADIX SORT===");
        return radixSortDigits(inputArray, width, radix);
    }

    private int[] radixSortDigits(int[] inputArray, int width, int radix) {
        int numElements = inputArray.length;
        for (int count = 0; count < width; count++) {
            int[] tempArray = new int[numElements];
            int[] countingArray = new int[radix];
            int divisor = (int) Math.pow(radix, count);

            // creating counting array
            for (int i = 0; i < numElements; i++) {
                int evaluateIndex = (inputArray[i] / divisor) % radix;
                countingArray[evaluateIndex]++;
            }

            // creating adjusted counting array: number of values which are less than equal to countingArray[i]
            for (int i = 1; i < radix; i++) {
                countingArray[i] += countingArray[i - 1];
            }

            // creating a new array to store the sorted values at a specific position based on the "adjusted" counting array
            for (int i = numElements - 1; i >= 0; i--) {
                int evaluateIndex = (inputArray[i] / divisor) % radix;
                tempArray[--countingArray[evaluateIndex]] = inputArray[i];
            }

            inputArray = tempArray;
        }
        return inputArray;

    }

    /**
     * // calculating max and min values based on the width value
     * // Width: 1, min=0, max=9
     * // Width: 2, min = 10, max = 99
     * // Width: 3, min = 100, max = 999
     * // ...
     * // Width: n, min = 1000....(n-1 zeros) --> 10^width-1, max = 999....(n 9's) -->
     * // (10^width)-1
     *
     * @param numELements
     * @param width
     * @param radix
     * @return // Based on the datasize, create an array with values in the range of [min,max]
     */
    private int[] getIntegerArrayRadixSort(int numELements, int width, int radix) {

        int min = (int) Math.pow(radix, width - 1);
        int max = (int) Math.pow(radix, width) - 1;

        int[] unSortedArray = new int[numELements];

        // Random selection of data
        Random random = new Random();
        for (int i = 0; i < unSortedArray.length; i++) {
            unSortedArray[i] = random.nextInt(max - min) + min;
        }

        return unSortedArray;
    }

    @Override
    public int[] sort(int[] inputArray) {
        System.out.println("Input array for the radix sort:\n"+ Arrays.toString(inputArray));
        int[] ints = radixSortIntegers(inputArray);
        this.setOutputArray(ints);
        return ints;
    }
}