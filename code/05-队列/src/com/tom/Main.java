package com.tom;

import com.tom.circle.CircleQueue;

public class Main {
	
	static void test2() {
		CircleQueue<Integer> queue = new CircleQueue<Integer>();
		// 0 1 2 3 4 5 6 7 8 9
		for (int i = 0; i < 10; i++) {
			queue.enQueue(i);
		}
		// null null null null null 5 6 7 8 9
		for (int i = 0; i < 5; i++) {
			queue.deQueue();
		}
		// 15 16 17 18 19 5 6 7 8 9
		for (int i = 15; i < 23; i++) {
			queue.enQueue(i);
		}
		while (!queue.isEmpty()) {
			System.out.println(queue.deQueue());
		}
		System.out.println(queue);
	}
	
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
		
//		Deque<Integer> queue = new Deque<>();
//		queue.enQueueFront(11);
//		queue.enQueueFront(22);
//		queue.enQueueRear(33);
//		queue.enQueueRear(44);
//		/* 44 33 11 22  */
//		while (!queue.isEmpty()) {
//			System.out.println(queue.deQueueRear());
//			System.out.println("-----------------------");
//		}
		
		test2();
	}
}
