package com.tom;

public class Main {

	public static void main(String[] args) {
        java.util.ArrayList listArrayList; // 源码
		// Object[] objects = new Object[7];
		// objects[0] = new Person(10, "Jack"); // 对象数组里面存放的是对象的地址
		// 为什么存放地址 而不存放对象的实际数据
		// 因为对象的数据大小是不可控的,存放对象的内存地址可以节省内存空间,通过内存地址获取对应的对象数据即可
		ArrayList<Object> persons = new ArrayList<>();
		persons.add(new Person(10, "Jack"));
		persons.add(new Person(18, "Alice"));
		persons.add(new Person(6, "Rose"));
		persons.clear();
		
		// 提醒JVM进行垃圾回收 将没有地址指向的对象清除
		System.gc();
	}
	
	static void test() {
		int array[] = new int[] {11,22,33};
		// new是向堆空间申请内存
		// int -> Integer
		ArrayList<Person> persons = new ArrayList<>();
		persons.add(new Person(10, "Jack"));
		persons.add(new Person(18, "Alice"));
		persons.add(new Person(6, "Rose"));
		System.out.println(persons);
		
		ArrayList<Integer> ints = new ArrayList<>();
		ints.add(100);
		ints.add(101);
		ints.add(111);
		System.out.println(ints);
		
//		list.add(99);
//		list.add(88);
//		list.add(77);
//		list.add(66);
//		list.add(55);
//		for (int i = 0; i < 30; i++) {
//			list.add(i);
//		}
//		System.out.println(list.toString());
//		Asserts.test(list.get(3) == 80);
//		Asserts.test(list.size() == 6);
	}
}
