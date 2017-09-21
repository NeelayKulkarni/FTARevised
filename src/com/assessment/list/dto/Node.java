package com.assessment.list.dto;

import java.util.Objects;

public class Node {

	public Node next;
	public int value;

	@Override
	public String toString() {
		return this.value + "";
	}

	/**
	 * @param data
	 */
	public Node(int data) {
		this.value = data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		Node otherNode = (Node) obj;
		return this.value == otherNode.value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}
}
