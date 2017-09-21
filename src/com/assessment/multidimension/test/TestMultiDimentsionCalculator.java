package com.assessment.multidimension.test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.assessment.multidimension.dto.MultiDimensionArray;
import com.assessment.multidimension.MultiDimensionCalculator;

@RunWith(PowerMockRunner.class)
@PrepareForTest(MultiDimensionArray.class)
public class TestMultiDimentsionCalculator {

	@Before
	public void setUp() {

		int n = 3;
		int arr[] = new int[n];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		PowerMockito.mockStatic(MultiDimensionArray.class);
		/*
		 * I have mocked it for one index but its possible to iterate over all
		 * indices and return a value.I have used powermock since methods are
		 * static.
		 */
		PowerMockito.when(MultiDimensionArray.getValue(arr)).thenReturn(0L);
		int arr2[] = new int[n + 1];
		arr2[0] = 1;
		arr2[1] = 2;
		arr2[2] = 6;
		arr2[3] = 3;
		PowerMockito.when(MultiDimensionArray.getValue(arr2)).thenReturn(1L);
	}

	@Test
	public void checkSumIsZero() {
		int n = 3;
		int arr[] = new int[n];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		MultiDimensionArray mArray = new MultiDimensionArray();
		assertEquals(Long.valueOf(MultiDimensionCalculator.sum(mArray, arr)),
				Long.valueOf(0L));
	}

	@Test
	public void checkSumIsNotZero() {
		int n = 4;
		int arr[] = new int[n];
		arr[0] = 6;
		arr[1] = 5;
		arr[2] = 7;
		arr[3] = 4;
		MultiDimensionArray mArray = new MultiDimensionArray();
		assertFalse(Long.valueOf(MultiDimensionCalculator.sum(mArray, arr)) == Long
				.valueOf(0L));
	}
}
