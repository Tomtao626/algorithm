package com.tom;

import org.w3c.dom.ls.LSInput;

import com.tom.circle.CircleLinkedList;

public class Main {

	public static void main(String[] args) {
//		List<Integer> list = new LinkedList2<>();
//		list.add(20);
//		list.add(0, 10);
//		list.add(30);
//		list.add(list.size(), 40);
//		list.remove(1);
		
		/*List<Integer> list = new ArrayList2<>();
		for (int i = 0; i < 50; i++) {
			list.add(i);
		}2222
		for (int i=0;i<50;i++) {
			list.remove(0);
		}
		System.err.println(list); // [10, 30, 40]
		*/
		
//		testList(new ArrayList<>());
//		testList(new LinkedList<>());
//		testList(new CircleLinkedList<>());
		josephus();
	}
	
	static void testList(List<Integer> list) {
		list.add(11);
		list.add(22);
		list.add(33);
		list.add(44);
		
		list.add(0, 55);
		list.add(2, 66);
		list.add(list.size(), 77);
		
		list.remove(0);
		list.remove(2);
		list.remove(list.size() - 1);
		
		Asserts.test(list.indexOf(44) == 3);
		Asserts.test(list.indexOf(22) == list.ELEMENT_NOT_FOUND);
		Asserts.test(list.contains(33));
		Asserts.test(list.get(0) == 11);
		Asserts.test(list.get(1) == 66);
		Asserts.test(list.get(list.size() - 1) == 44);
		
		System.out.println(list);
	}
	
	static void josephus() {
		CircleLinkedList<Integer> list = new CircleLinkedList<>();
		for (int i = 1; i <= 8; i++) {
			list.add(i);
		}
		// 指向头节点
		list.reset();
		
		// 直到链表为空
		while (!list.isEmpty()) {
			list.next();
			list.next();
			System.out.println(list.remove());
		}
	}

}
