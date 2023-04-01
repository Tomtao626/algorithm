package com.tom.circle;

public class CircleQueue<E>{
	private int size;
	private int front;
	private E[] elements;
	private static final int DEFAULT_CAPACITY = 10;
	
	public CircleQueue() {
		elements = (E[]) new Object[DEFAULT_CAPACITY];
	}
	
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void enQueue(E element) {
		ensureCapacity(size + 1);
		elements[(front + size) % elements.length] = element;
		size++;
	}
	
	
	public E deQueue() {
		E frontElement = elements[front];
		elements[front] = null;
		front = (front + 1) % elements.length;
		size--;
		return frontElement; 
	}
	
	public E front() {
		return elements[front];
	}
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("capcacity=").append(elements.length)
		.append(" size=").append(size)
		.append(" front=").append(front)
		.append(", [");
		for (int i = 0; i < elements.length; i++) {
			if (i != 0) {
				string.append(", ");
			}
			
			string.append(elements[i]);
		}
		string.append("]");
		return string.toString();
	}
	
	
	public void ensureCapacity(int capacity) {
		int oldCapacity = elements.length;
		if (oldCapacity >= capacity) return;
		
		// 新容量为旧容量的1.5倍
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		E[] newElements = (E[]) new Object[newCapacity];
		for (int i = 0; i < size; i++) {
			newElements[i] = elements[(i + front) % elements.length];
		}
		elements = newElements;
		System.out.println(oldCapacity + "正在扩容为" + newCapacity);
		
		// 重置fornt
		front = 0;
	}
	
}
