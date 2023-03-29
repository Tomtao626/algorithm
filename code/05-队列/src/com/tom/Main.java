package com.tom;

public class Main {
	public static void main(String[] args) {
//		Queue<Integer> queue = new Queue<>();
//		queue.enQueue(11);
//		queue.enQueue(22);
//		queue.enQueue(33);
//		queue.enQueue(44);
//		
//		System.out.println(queue.size());
//		while (!queue.isEmpty()) {
//			System.out.println(queue.deQueue());
//		}
		
		Deque<Integer> queue = new Deque<>();
		queue.enQueueFront(11);
		queue.enQueueFront(22);
		queue.enQueueRear(33);
		queue.enQueueRear(44);
		/* 44 33 11 22  */
		while (!queue.isEmpty()) {
			System.out.println(queue.deQueueRear());
			System.out.println("-----------------------");
		}
	}
}
