package com.tom;

import java.io.File;
import java.util.Comparator;

import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;

import com.tom.file.Files;
import com.tom.printer.BinaryTreeInfo;
import com.tom.printer.BinaryTrees;

public class Main {
	
	public static class PersonComparator implements Comparator<Person> {
		public int compare(Person e1, Person e2) {
			return e2.getAge() - e1.getAge();
		}
	}
	 
	public static class PersonComparator2 implements Comparator<Person> {
		public int compare(Person e1, Person e2) {
			return e2.getAge() - e1.getAge();
		}
	}
	
	static void test1() {
		Integer data[] = new Integer[] {
				7,4,9,2,5,8,11,3,12,1
			};
			
			BinarySearchTree<Integer> bst = new BinarySearchTree<>();
			for (int i=0; i < data.length; i++) {
				bst.add(data[i]);
			}
			BinaryTrees.println(bst);
	}
	
	static void test2() {
		Integer data[] = new Integer[] {
				7,4,9,2,5,8,11,3,12,1
			};
		BinarySearchTree<Person> bst1 = new BinarySearchTree<>();
			for (int i=0; i < data.length; i++) {
				bst1.add(new Person(data[i]));
			}
			BinaryTrees.println(bst1);
			
		BinarySearchTree<Person> bst2 =  new BinarySearchTree<>(new Comparator<Person>() {
			public int compare(Person o1, Person o2) {
				return o2.getAge() - o1.getAge();
			}
		});
		for (int i=0; i < data.length; i++) {
			bst2.add(new Person(data[i]));
		}
		BinaryTrees.println(bst2);
	}
	
	static void test3() {
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		for (int i = 0; i < 30; i++) {
			bst.add((int)(Math.random() * 100));
		}
		String str = BinaryTrees.printString(bst);
		str += "\n";
		Files.writeToFile("/Users/tao626/Documents/workspaces/github/algorithm/code/06-二叉搜索树/src/com/tom/out.txt", str, true);
//		BinaryTrees.println(bst);
	}
	
	static void test4() {
BinaryTrees.println(new BinaryTreeInfo() {
			
			@Override
			public Object string(Object node) {
				// TODO Auto-generated method stub
				return node.toString() + "_";
			}
			
			@Override
			public Object root() {
				// TODO Auto-generated method stub
				return "A";
			}
			
			@Override
			public Object right(Object node) {
				// TODO Auto-generated method stub
				if (node.equals("A")) return "C";
				if (node.equals("C")) return "E";
				return null;
			}
			
			@Override
			public Object left(Object node) {
				// TODO Auto-generated method stub
				if (node.equals("A")) return "B";
				if (node.equals("C")) return "D";
				return null;
			}
		});
	}
	
	public static void main(String[] args) {
		test3();
		/**
		 * Java中的匿名类 类似于IOS中的Block Js中的闭包
		 */

//		
//		BinarySearchTree<Person> bst2 =  new BinarySearchTree<>(new PersonComparator2());
//		bst2.add(new Person(12));
//		bst2.add(new Person(15));
//		
//		BinarySearchTree<Person> bst3 =  new BinarySearchTree<>();
//		bst2.add(new Person(12));
//		bst2.add(new Person(15));
	}
}
