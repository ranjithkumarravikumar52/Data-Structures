package FixedDataRange;

import java.util.Arrays;
import java.util.Random;

public class RadixSort extends FixedDataRangeSortAlgorithm {
	// Elements in the data has the same radix and width
	// Radix: Number of unique digits/characters in numbering system/alphabets
	// Radix for decimal system: 10
	// Radix for binary system: 2
	// Radix for english alphabets: 26

	// Width: Number of digits/characters
	// Width: 12345 is 5
	// Width: abc is 3
	// ASSUMPTION: This sorting assumes that data has same radix and width
	// SORTING DIRECTION: right->left
	// MUST use stable sort algorithm. WHY? Think about it. HINT: Sorting is done
	// based on each digit/character
	public void radixSortIntegers() {
		// Need an array with a fixed width
		// Array should be of the type integer (no-decimals)
		int width = 5;
		int numElements = 10;
		int radix = 10; // decimal system
		System.out.println("===RADIX SORT===");
		int[] unSortedArray = getIntegerArrayRadixSort(numElements, width, radix);
		System.out.println("Given integers array\n" + Arrays.toString(unSortedArray));

		radixSortDigits(unSortedArray, width, radix);
		System.out.println("Result:");

	}

	private void radixSortDigits(int[] unSortedArray, int width, int radix) {
		int numElements = unSortedArray.length;
		for (int count = 0; count < width; count++) {
			int[] tempArray = new int[numElements];
			int[] countingArray = new int[radix];
			int divisor = (int) Math.pow(radix, count);

			// creating counting array
			for (int i = 0; i < numElements; i++) {
				int evaluateIndex = (unSortedArray[i] / divisor) % radix;
				countingArray[evaluateIndex]++;
			}
			// System.out.println("counting Array for width: "+count);
			// System.out.println(Arrays.toString(countingArray));

			// creating adjusted counting array: number of values which are less than equal
			// to countingArray[i]
			for (int i = 1; i < radix; i++) {
				countingArray[i] += countingArray[i - 1];
			}
			// System.out.println("Adjusted counting Array for width: "+count);
			// System.out.println(Arrays.toString(countingArray));

			// creating a new array to store the sorted values at a specific position based
			// on the "adjusted" counting array
			for (int i = numElements - 1; i >= 0; i--) {
				int evaluateIndex = (unSortedArray[i] / divisor) % radix;
				tempArray[--countingArray[evaluateIndex]] = unSortedArray[i];
			}
			// System.out.println("Temp array at the end of width: "+count);
			// System.out.println(Arrays.toString(tempArray));
			// System.out.println();
			unSortedArray = tempArray;
			setSortedArray(tempArray);

		}

	}

	private int[] getIntegerArrayRadixSort(int numELements, int width, int radix) {

		// calculating max and min values based on the width value
		// Width: 1, min=0, max=9
		// Width: 2, min = 10, max = 99
		// Width: 3, min = 100, max = 999
		// ...
		// Width: n, min = 1000....(n-1 zeros) --> 10^width-1, max = 999....(n 9's) -->
		// (10^width)-1
		int min = (int) Math.pow(radix, width - 1);
		int max = (int) Math.pow(radix, width) - 1;
		System.out.println("max = " + max);
		System.out.println("min = " + min);
		// Based on the datasize, create an array with values in the range of [min,max]
		int[] unSortedArray = new int[numELements];
		// Random selection of data
		Random random = new Random();
		for (int i = 0; i < unSortedArray.length; i++) {
			unSortedArray[i] = random.nextInt(max - min) + min;
		}

		return unSortedArray;
	}

}
