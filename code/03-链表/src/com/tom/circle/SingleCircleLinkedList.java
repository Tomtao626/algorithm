package com.tom.circle;

import com.tom.AbstractList;

public class SingleCircleLinkedList<E> extends AbstractList<E> {
	private Node<E> first;
	
	private static class Node<E> {
		E element;
		Node<E> next;
		public Node(E element, Node<E> next) {
			super();
			this.element = element;
			this.next = next;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			StringBuilder sBuilder = new StringBuilder();
			sBuilder.append(element).append("_").append(next.element);
			return sBuilder.toString();
		}
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		size = 0;
		first = null;
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
		// 最好情况复杂度 O(1) 开头
		// 最坏情况复杂度 O(N) 末尾
		// 平均复杂度    O(N)
	}

	@Override
	public void add(int index, E element) {
		rangeCheckForAdd(index);
		// 如果是第0个节点  需要将first指向第一个节点 然后将第一个节点的next指向原本的第零号节点
		if (index == 0) {
			Node<E> newFirst = new Node<>(element, first);
			// 拿到最后一个结点 // 单向循环链表
			Node<E> last = (size == 0) ? newFirst : node(size - 1);
			last.next = newFirst;
			first = newFirst;
		} else {
			// 先找到前置节点 再通过前置节点找到下一个节点
			Node<E> prev = node(index - 1);
			prev.next = new Node<>(element, prev.next);
		}
		size++;
		// 在编写链表过程中,要注意边界测试,比如index为0,size-1,size时的情况
		// 最好情况复杂度 O(1) 开头
		// 最坏情况复杂度 O(N) 末尾
		// 平均复杂度    O(N)
	}

	@Override
	public E remove(int index) {
		rangeCheck(index);
		Node<E> node = first;
		if (index == 0) {
			if (size == 1) {
				first = null;
			} else {
				Node<E> last = node(size - 1);
				first = first.next;
				last.next = first;
			}
			
		} else {
			Node<E> prev = node(index - 1);
			node = prev.next;
			prev.next = node.next;
		}
		size--;
		return node.element;
		// 最好情况复杂度 O(1) 开头
		// 最坏情况复杂度 O(N) 末尾
		// 平均复杂度    O(N)
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
		Node<E> node = first;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		return node;
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
