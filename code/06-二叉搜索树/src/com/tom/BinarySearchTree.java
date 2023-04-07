package com.tom;

import java.util.Comparator;

public class BinarySearchTree<E>{
	private int size;
	private Node<E> rootNode;
	private Comparator<E> comparator;
	
	public BinarySearchTree() {
		this(null);
	}
	
	public BinarySearchTree(Comparator<E> comparator) {
		this.comparator = comparator;
	}
	
	public int size() {
		return 0;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void clear() {
	}
	
	public void add(E element) {
		elementNotNullCheck(element);
		// 添加第一个节点
		if (rootNode == null) {
			rootNode = new Node<>(element, null);
			size++;
			return;
		}
		// 添加的不是第一个节点
		// 找到父节点
		Node<E> parentNode = rootNode;
		Node<E> node = rootNode;
		int cmp = 0;
		while (node != null) {
			cmp = compare(element, node.element);
			if (cmp > 0) {
				node = node.rightNode;
			} else if (cmp < 0) {
				node = node.leftNode;
			} else { // 相等
				return;
			}
		}
		// 看看插入到父节点哪个位置
		Node<E> newNode = new Node<>(element, parentNode);
		if (cmp > 0) {
			parentNode.rightNode = newNode;
		} else {
			parentNode.leftNode = newNode;
		}
		size++;
	}	
	
	public void remove(E element) {
		
	}
	
	public boolean contains(E element) {
		return false;
	}
	
	/**
	 * @return 返回值等于0,代表e1和e2相等
	 * @return 返回值大于0,代表e1大于e2
	 * @return 返回值小于0,代表e1小于e2
	 */
	@SuppressWarnings("unchecked")
	private int compare(E e1, E e2) {
		if (comparator != null) {
			return comparator.compare(e1, e2);
		}
		return ((Comparable<E>)e1).compareTo(e2);
	}
	
	private void elementNotNullCheck(E element) {
		if (element == null) {
			throw new IllegalArgumentException("element must not be null");
		}
	}
	
	private static class Node<E> {
		E element;
		Node<E> leftNode;
		Node<E> rightNode;
		@SuppressWarnings("unused")
		Node<E> parentNode;
		public Node(E element, Node<E> parentNode) {
			this.element = element;
			this.parentNode = parentNode;
		}
	}
	
}
