package com.tom;

public class Main {

	public static void main(String[] args) {
		int array[] = new int[] {11,22,33};
		
		ArrayList list = new ArrayList();
		list.add(99);
		list.add(88);
		list.add(77);
		list.add(66);
		list.add(55);
		list.set(3, 80);
		list.add(0, 100);
		// 往最后一个位置插入元素
		list.add(list.size(), 101);
		Assert.test(list.get(3) == 80);
		Assert.test(list.size() == 6);
		System.out.println(list.toString());
	}

}
