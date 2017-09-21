package com.assessment.partition.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.assessment.partition.ListPartition;

public class TestListPartition {

	@Test
	public void testSeperateForEmptyList() {

		int k = 2;
		List<Integer> list = new ArrayList<Integer>();
		assertFalse(new ListPartition().separate(list, k));
	}

	@Test
	public void testSeperateForKgtN() {

		int k = 5, n = 4;
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < n; i++)
			list.add(i);
		assertFalse(new ListPartition().separate(list, k));
	}

	@Test
	public void testSeperateWhereSumModKisNonZero() {
		int k = 2, n = 6;
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i < n; i++)
			list.add(i);
		assertFalse(new ListPartition().separate(list, k));
	}

	@Test
	public void testSeperateForPossiblePartitions() {
		int k = 6;
		Integer[] arr = { 1, 2, 3, 4, 5, 6, 7, 7, 8, 0, 7, 7, 3, 2, 1, 4, 6, 7,
				9, 6, 4, 3, 2, 4 };
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(arr));
		assertTrue(new ListPartition().separate(list, k));
	}

	@Test
	public void testSeperateForPartitionsNotPossible() {
		int k = 6;
		Integer[] arr = { 1, 2, 3, 4, 5, 6, 7, 7, 8, 0, 7, 7, 3, 2, 1, 4, 6, 7,
				9, 6, 4, 3, 2 };
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(arr));
		assertFalse(new ListPartition().separate(list, k));
	}

	@Test
	public void testCheckSumNonZero() {
		int k = 6;
		int[] arr = { 1, 2, 3, 4, 5, 6 };
		assertFalse(new ListPartition().checkIfAllPartitionsAreZero(arr, k));
	}

	@Test
	public void testCheckSumZero() {
		int k = 3;
		int[] arr = new int[k];
		assertTrue(new ListPartition().checkIfAllPartitionsAreZero(arr, k));
	}

}
