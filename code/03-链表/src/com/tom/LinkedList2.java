package com.tom;

/**
 * 增加一个虚拟头结点
 * @author tao626
 *
 * @param <E>
 */
public class LinkedList2<E> extends AbstractList<E> {
	private Node<E> first;
	
	public LinkedList2() {
		first = new Node<E>(null,null);
	}
	
	private static class Node<E> {
		E element;
		Node<E> next;
		public Node(E element, Node<E> next) {
			super();
			this.element = element;
			this.next = next;
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
		// 先找到前置节点 再通过前置节点找到下一个节点
		Node<E> prev = index == 0 ? first : node(index - 1);
		prev.next = new Node<>(element, prev.next);
		size++;
		// 在编写链表过程中,要注意边界测试,比如index为0,size-1,size时的情况
	}

	@Override
	public E remove(int index) {
		rangeCheck(index);
		Node<E> prev = index == 0 ? first : node(index - 1);
		Node<E> node = prev.next;
		prev.next = node.next;
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
		Node<E> node = first.next;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		return node;
	}
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("size=").append(size).append(", [");
		Node<E> node = first.next;
		for (int i = 0; i < size; i++) {
			if (i!=0) {
				string.append(", ");
			}
			string.append(node.element);
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
