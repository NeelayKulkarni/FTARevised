package com.assessment.list.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.assessment.list.LinkedList;
import com.assessment.list.dto.Node;

public class TestLinkedList {

	@Test
	public void testMultipleNodesReverse() {
		LinkedList linkedList = new LinkedList();
		List<Integer> integerList = new ArrayList<Integer>();
		integerList.add(1);
		integerList.add(2);
		integerList.add(3);
		integerList.add(4);
		integerList.add(5); // insert and return head.
		Node list = linkedList.insertAll(integerList);
		Node headNode = linkedList.reverse(list);
		LinkedList reveList = new LinkedList();
		reveList.setHead(headNode);
		ArrayList<Integer> integerListReversed = new ArrayList<Integer>();
		integerListReversed.add(5);
		integerListReversed.add(4);
		integerListReversed.add(3);
		integerListReversed.add(2);
		integerListReversed.add(1); // insert and return head.
		Node expectedHeadNode = linkedList.insertAll(integerListReversed);

		assertNotNull(expectedHeadNode);
		LinkedList expectedHeadList = new LinkedList();
		expectedHeadList.setHead(expectedHeadNode);
		assertEquals(expectedHeadList, reveList);

	}

	@Test
	public void testEmptyReverse() {
		LinkedList linkedList = new LinkedList();
		List<Node> allNodes = new ArrayList<Node>();
		allNodes.add(null); // insert and return head.
		linkedList.setHead(linkedList.getHead());
		Node headNode = linkedList.reverse(null);
		assertNull(headNode);
	}

	@Test
	public void testSingleNodeReverse() {
		LinkedList linkedList = new LinkedList();
		List<Integer> allNodes = new ArrayList<Integer>();
		allNodes.add(10); // insert and return head.
		Node singleHead = linkedList.insertAll(allNodes);
		Node headNode = linkedList.reverse(singleHead);
		LinkedList reveList = new LinkedList();
		reveList.setHead(headNode);
		ArrayList<Integer> expectedList = new ArrayList<Integer>();
		expectedList.add(10); // insert and return head.
		Node expectedHeadNode = linkedList.insertAll(expectedList);
		assertNotNull(expectedHeadNode);
		LinkedList expectedHeadList = new LinkedList();
		expectedHeadList.setHead(expectedHeadNode);
		assertEquals(expectedHeadList, reveList);
	}

	@Test
	public void testUnequalNodesReverse() {
		LinkedList linkedList = new LinkedList();
		List<Integer> allNodes = new ArrayList<Integer>();
		allNodes.add(14);
		allNodes.add(12);
		allNodes.add(13); // insert and return head.
		Node listHead = linkedList.insertAll(allNodes);
		Node reversedHeadNode = linkedList.reverse(listHead);
		ArrayList<Integer> expectedList = new ArrayList<Integer>();
		expectedList.add(12);
		expectedList.add(13);
		expectedList.add(14); // insert and return head.
		Node expectedHeadNode = linkedList.insertAll(expectedList);
		assertNotNull(expectedHeadNode);
		assertFalse(expectedHeadNode.equals(reversedHeadNode));
	}

	@Test
	public void testMissingEntryReverse() {
		LinkedList linkedList = new LinkedList();
		List<Integer> allNodes = new ArrayList<Integer>();
		allNodes.add(16);
		allNodes.add(14);
		allNodes.add(13);
		// insert and return head.
		Node listHead = linkedList.insertAll(allNodes);
		Node reversedHeadNode = linkedList.reverse(listHead);
		LinkedList llr = new LinkedList();
		llr.setHead(reversedHeadNode);
		ArrayList<Integer> expectedList = new ArrayList<Integer>();
		expectedList.add(12);
		expectedList.add(13);
		expectedList.add(14);
		expectedList.add(16);

		// insert and return head.
		Node expectedHeadNode = linkedList.insertAll(expectedList);
		assertNotNull(expectedHeadNode);
		LinkedList ll = new LinkedList();
		ll.setHead(expectedHeadNode);
		assertFalse(ll.equals(llr));
	}
}
