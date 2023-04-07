package com.tom;

public class Person implements Comparable<Person>{
	private int age;
	
	public Person(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int compareTo(Person e) {
		// TODO Auto-generated method stub
//		if (age > e.age) return 1;
//		if (age < e.age) return -1;
//		return 0;
		return age - e.age;
	}
	
	public String toString() {
		return age + "=";
	}
}
