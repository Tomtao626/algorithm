package com.tom;

import com.tom.list.List;

import com.tom.list.LinkedList;

public class Queue<E> {
	private List<E> list = new LinkedList<>();
	
	public int size() {
		return list.size();
	}
	
	public boolean isEmpty() {
		return false;
	}
	
	public void enQueue(E element) {
		list.add(element);
	}
	
	public E deQueue() {
		return list.remove(0);
	}
	
	public E front() {
		return list.get(0);
	}
}
