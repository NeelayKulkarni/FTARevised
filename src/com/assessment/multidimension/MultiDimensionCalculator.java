package com.assessment.multidimension;

import java.math.BigInteger;
import java.util.Arrays;

import com.assessment.multidimension.dto.MultiDimensionArray;

public class MultiDimensionCalculator {

	// lengthOfDeminsion: each dimension's length, assume it is valid:
	// lengthOfDeminsion[i]>0.
	public static Long sum(MultiDimensionArray mArray, int[] lengthOfDeminsion) {
		// Your resolution
		// Time complexity:0(number of elements of mArray*lengthOfDeminsion)
		// Space complexity:0(lengthOfDeminsion)
		long sum = 0L;
		BigInteger bigInteger = BigInteger.ONE;
		for (int i : lengthOfDeminsion) {
			BigInteger bg = BigInteger.valueOf(i);
			bigInteger = bigInteger.multiply(bg);
		}
		bigInteger = bigInteger.subtract(BigInteger.ONE);

		for (BigInteger bgi = bigInteger; bgi.compareTo(BigInteger.ZERO) >= 0;) {
			int[] dimension = convertToIndex(bgi, lengthOfDeminsion);
			System.out.println(Arrays.toString(dimension));
			sum += MultiDimensionArray.getValue(dimension);
			bgi = bgi.subtract(BigInteger.ONE);
		}
		return sum;
	}

	private static int[] convertToIndex(BigInteger bigInteger,
			int[] lengthOfDeminsion) {
		int n = lengthOfDeminsion.length;
		int[] arr = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			BigInteger remainder = bigInteger.mod(BigInteger
					.valueOf(lengthOfDeminsion[i]));
			bigInteger = bigInteger.divide(BigInteger
					.valueOf(lengthOfDeminsion[i]));
			arr[i] = remainder.intValue();
		}
		return arr;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 3, 4 };
		sum(new MultiDimensionArray(), arr);
	}
}
