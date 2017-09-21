package com.assessment.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.assessment.list.dto.Node;

public class LinkedList {

	private Node head;

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	// Your resolution
	// Time complexity:O(n)
	// Space complexity:O(1)
	public Node reverse(Node head) {
		if (head == null)
			return head;
		else {
			Node prev = null;
			Node curr = null;
			Node next = null;
			curr = head;
			while (curr != null) {
				next = curr.next;
				curr.next = prev;
				prev = curr;
				curr = next;
			}
			return prev;
		}
	}

	/**
	 * Converts a list of integers into a link list.All nodes get chained
	 * together.
	 * 
	 * @param allNodes
	 * @return
	 */
	public Node insertAll(List<Integer> integerList) {
		Node curr = null, head = null;
		for (Integer i : integerList) {
			if (head == null)
				head = curr = new Node(i);
			else {
				curr.next = new Node(i);
				curr = curr.next;
			}
		}
		return head;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		Node ptr = this.head;
		if (ptr == null)
			return "empty";
		else {
			StringBuilder sb = new StringBuilder();
			while (ptr != null) {
				sb.append(ptr.toString() + " ");
				ptr = ptr.next;
			}
			return sb.toString();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		LinkedList otherListUtil = (LinkedList) obj;
		if (this.head == null)
			return obj == null;
		else if (otherListUtil != null && otherListUtil.getHead() == null)
			return false;
		else {
			Node ptr1 = this.head;
			Node ptr2 = otherListUtil.getHead();
			while (ptr1 != null && ptr2 != null) {
				if (!ptr1.equals(ptr2)) {
					return false;
				} else {
					ptr1 = ptr1.next;
					ptr2 = ptr2.next;
				}
			}
			if (ptr2 != null && ptr1 == null)
				return false;
			if (ptr2 == null && ptr1 != null)
				return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		Node ptr = head;
		List<Node> nodeList = new ArrayList<Node>();
		while (ptr != null) {
			nodeList.add(ptr);
			ptr = ptr.next;
		}
		return Objects.hash(nodeList);
	}
}