package com.tom.list;

public class LinkedList<E> extends AbstractList<E> {
	private Node<E> first;
	private Node<E> last;
	
	private static class Node<E> {
		E element;
		Node<E> prev;
		Node<E> next;
		public Node(Node<E> prev, E element, Node<E> next) {
			this.prev = prev;
			this.element = element;
			this.next = next;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			StringBuilder sBuilder = new StringBuilder();
			if (prev != null) {
				sBuilder.append(prev.element);
			} else {
				sBuilder.append("null");
			}
			sBuilder.append("_").append(element).append("_");
			if (next != null) {
				sBuilder.append(next.element);
			} else {
				sBuilder.append("null");
			}
			return sBuilder.toString();
		}
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		size = 0;
		first = null;
		last = null;
	}

	@Override
	public E get(int index) {
		return node(index).element;
		// 最好情况复杂度 O(1) 开头
		// 最坏情况复杂度 O(N) 末尾
		// 平均复杂度    O(N)
	}

	@Override
	public E set(int index, E element) {
		Node<E> node = node(index);
		E old = node.element;
		node.element = element;
		return old;
	}

	@Override
	public void add(int index, E element) {
		rangeCheckForAdd(index);
		// 链表没有元素的情况
		// index = size = 0
		if (index == size) {
			Node<E> oldLast = last;
			last = new Node<>(oldLast, element, null); // 指向之前最后一个元素的last
			
			if (oldLast == null) {
				// 链表添加的第一个元素
				first = last;
			} else {
				oldLast.next = last;
			}
		} else {
			Node<E> next = node(index);
			Node<E> prev = next.prev;
			Node<E> node = new Node<>(prev, element, next);
			next.prev = node;
			
			
			if (prev == null) { // index = 0 开头
				first = node;
			} else {
				prev.next = node;
			}
		}
		size++;
	}

	@Override
	public E remove(int index) {
		rangeCheck(index);
		Node<E> node = node(index);
		Node<E> prev = node.prev;
		Node<E> next = node.next;
		if (prev == null) { // index = 0 从开头删除 删除第一个
			first = next; // 第零个结点的下一个 == node.next
		} else {
			prev.next = next;
		}
		if (next == null) { // index = size - 1 从末尾删除 删除最后一个
			last = prev; // 最后一个结点的上一个 == node.prev
		} else {
			next.prev = prev;
		}
		size--;
		return node.element;
	}

	@Override
	public int indexOf(E element) {
		if (element == null) {
			Node<E> node = first;
			for (int i = 0; i < size; i++) {
				if (node.element == null) return i; //  因为不能对null调用equals 所以需要判断元素是否为空
				node = node.next;
			}
		} else {
			Node<E> node = first;
			for (int i = 0; i < size; i++) {
				// 因为不能对null调用equals
			if (element.equals(node.element)) return i;
				node = node.next;
		    }
		}
		return ELEMENT_NOT_FOUND;
	}
	
	/**
	 * 获取index位置对应的node
	 * @param index
	 * @return
	 */
	private Node<E> node(int index) {
		rangeCheck(index);
		if (index < (size >> 1)) {
			Node<E> node = first;
			for (int i = 0; i < index; i++) {
				node = node.next;
			}
			return node;
		} else {
			Node<E> node = last;
			for (int i = size - 1; i > index; i--) {
				node = node.prev;
			}
			return node;
		}
		
	}
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("size=").append(size).append(", [");
		Node<E> node = first;
		for (int i = 0; i < size; i++) {
			if (i!=0) {
				string.append(", ");
			}
			string.append(node);
			node = node.next;
		}
		string.append("]");
		
//		Node<E> node1 = first;
//		while (node1 != null) {
		// 最后一个元素的next是null
//			node1 = node1.next;
//		}
		return string.toString();
		
	}
	
}
