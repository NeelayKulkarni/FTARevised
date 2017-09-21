package com.assessment.partition;

import java.util.List;

public class ListPartition {

	boolean partitionSum(Integer bag[], int partitionsWtRemaining[], int index,
			int k, int n) {
		// return true if partition is found
		if (checkIfAllPartitionsAreZero(partitionsWtRemaining, k))
			return true;

		// base case: no items left
		if (index >= n)
			return false;

		boolean ans = false;

		// consider current item bag[last] and explore all possibilities
		// using backtracking
		for (int i = 0; i < k; i++) {
			if (ans != true && partitionsWtRemaining[i] - bag[index] >= 0) {

				// By subtracting we include the index th element in the ith
				// partition
				partitionsWtRemaining[i] -= bag[index];

				// try remaining items recursively
				ans = partitionSum(bag, partitionsWtRemaining, index + 1, k, n);

				// by adding the weight of the element again,we discard and
				// backtrack
				partitionsWtRemaining[i] += bag[index];
			}
		}
		return ans;
	}

	public boolean separate(List<Integer> list, int k) {
		// Your resolution
		// Time complexity:0((2^n)*k)
		// Space complexity:)(k)
		int n = list.size();
		if (n < k)
			return false;
		if (k == 1)
			return true;

		int sum = 0;
		for (Integer element : list) {
			sum += element;
		}
		if (sum % k != 0) {
			return false;
		} else {
			int[] partitionWtRemaining = new int[k];
			for (int i = 0; i < k; i++) {
				partitionWtRemaining[i] = sum / k;
			}
			Integer[] temp = new Integer[n];
			list.toArray(temp);
			return partitionSum(temp, partitionWtRemaining, 0, k, n);
		}
	}

	public boolean checkIfAllPartitionsAreZero(int partitionWtRemaining[], int k) {
		for (int i = 0; i < k; i++) {
			if (partitionWtRemaining[i] != 0)
				return false;
		}
		return true;
	}
}