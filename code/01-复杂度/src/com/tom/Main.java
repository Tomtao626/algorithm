package com.tom;

import com.tom.TimeTools.Task;

public class Main {
	
	/*  0 1 2 3 4 5 6  7  8  9 
	 *  0 1 1 2 3 5 8 13 21 34 55 89
	 * 
	 */
	
	public static int fib1(int n) {
		// O(2^n)
		// fib1(5) == > 2^0 + 2^1 + 2^2 + 2^3 = 2^4 - 1 = 2^(n-1) - 1 = 0.5*(2^n) - 1
		if (n <= 1 ) return n;
		return fib1(n-1) + fib1(n-2);
	}
	
	public static int fib2(int n) {
		// O(n) 时间复杂度
		if (n <= 1) return n;
		int first = 0;
		int second = 1;
		for (int i = 0; i < n - 1; i++) {
			int sum = first + second;
			first = second;
			second = sum;
		}
		return second;
	}
	
	public static int fib4(int n) {
		if (n<=1) return n;
		int first = 0;
		int second = 1;
		while(n-- > 1) {
			second += first;
			first = second - first;
		}
		return second;
	}
	
    //	斐波那契的线性代数解法 – 特征方程
	public static int fib3(int n) {
		// 时间复杂度 O(1)
		double c = Math.sqrt(5);
		return (int)((Math.pow((1 + c) / 2, n) - Math.pow((1 - c) / 2, n)) / c);
	}
	/*
	 *  ◼ 用尽量少的存储空间
		◼ 用尽量少的执行步骤（执行时间）
		◼ 根据情况，可以
			空间换时间
			时间换空间
	 */
	
	public static void main(String[] args) {
		int n = 40;
		TimeTools.test("fib1", new Task() {
			public void execute() {
				System.out.println(fib1(n));
			}
		});
		TimeTools.test("fib2", new Task() {
			public void execute() {
				System.out.println(fib2(n));
			}
		});
		TimeTools.test("fib3", new Task() {
			public void execute() {
				System.out.println(fib3(n));
			}
		});
		TimeTools.test("fib4", new Task() {
			public void execute() {
				System.out.println(fib4(n));
			}
		});
	}
	
	// 大O表示法
	/*
	 * 9 >> O(1)
	 * 2n + 3 >> O(n)
	 * n^2 + 2n + 1 >> O(n^2)
	 * n^3 + 3n^2 + 22n + 100 >> O(n^3)
	 */
	
	public static void test1(int n) {
		// 1
		if (n > 10) {
			System.out.println("n>10");
		} else if (n > 5) {
			System.out.println("n>5");
		} else {
			System.out.println("n<=5");
		}
		
		// 1 + 4 + 4 + 4
		// 13
		// 14
		for (int i = 0; i < 4; i++) {
			System.out.println("test1");
		}
		// O(1) 大O表示法 时间复杂度
		// 存在了 定义的常数项i 空间复杂度所以是O(1)
	}
	
	public static void test2(int n) {
		// 1 + n + n + n
		// 3n + 1
		for (int i = 0; i < n; i++) {
			System.out.println("test2");
		}
		// // O(n) 大O表示法 时间复杂度
		// 存在了 定义的常数项i 空间复杂度所以是O(1)
	}
	
	public static void test3(int n) {
		// 1 + n + n
		for (int i = 0; i < n; i++) {
			// 1 + n + n + n
			// 3n + 1
			for (int j = 0; j < n; j++) {
				System.out.println("test3");
			}
		}
		// 1 + 2n + n * (3n + 1)
		// 3n^2 + 3n + 1
		// O(n^2) 大O表示法 时间复杂度
	}
	
	public static void test4(int n) {
		// 1 + n + n
		// 1 + 2n
		for (int i = 0; i < n; i++) {
			// 1 + 15 + 15 + 15
			for (int j = 0; j < 15; j++) {
				System.out.println("test4");
			}
		}
		// 1 + 2n + n * 46
		// 48n + 1
		// O(n) 大O表示法 时间复杂度
	}
	
	public static void test5(int n) {
		// n = 8
		// 4
		// 2
		// 1
		// 0 不符合条件 退出循环 执行3次
		// n = 8 = 2^3
		// log2(8) = 3
		
		// n = 16
		// 8
		// 4
		// 2
		// 1
		// 0 不符合条件 退出循环 执行3次
		// n = 16 = 2^4
		// log2(16) = 4
		
		// 执行次数 = log2(n)
		while ((n = n / 2) > 0) {
			System.out.println("test5");
		}
		// O(log(n)) 大O表示法
		/*
		 * 对数阶一般省略底数
		 * log2(n) = log2(9) * log9(n)
		 * 所以log2(n) log9(n) 统称为log(n)
		 */
		// O(log(n)) 大O表示法 时间复杂度
	}
	
	public static void test6(int n) {
		// // 执行次数 = log5(n)
		while ((n = n / 5) > 0) {
			System.out.println("test6");
		}
		// O(log(n)) 大O表示法
	}
	
	public static void test7(int n) {
		// i += i === i = i * 2
		// 1 + 2*log2(n)
		for (int i = 1; i < n; i+=i) {
			// 1 + n + n + n
			// 1 + 3n
			for (int j = 0; j < n; j++) {
				System.out.println("test7");
			}
		}
		// 1 + 2*log2(n) + log2(n) * (1 + 3n)
		// 1 + 3*log2(n) + 3n*log2(n)
		// 1 + 3log2(n) * (n + 1)
		// O(log(n) + nlog(n)) 大O表示法
		// O(nlog(n)) 大O表示法 时间复杂度
	}
	
	/*
	 * 
	 * 执行次数	                复杂度	      非正式术语
		12		                 O(1)          常数阶
		4log2(n) + 25		     O(log(n))     对数阶
		2n + 3		             O(n)          线性阶
		3n + 2nlog3(n) + 15		 O(nlog(n))    nlog(n)阶
		4n^2 + 2n + 6		     O(n^2)        平方阶
		4n^3 + 3n^2 + 22n + 100	 O(n^3)	       立方阶
		2^n		                 O(2^n)        指数阶
		
	 O(1) < O(long(n)) < O(n) < O(nlog(n)) < O(n^2) < O(n^3) < O(2^n) < O(n!) < O(n^n)
	 注意： 大 O 表示法仅仅是一种粗略的分析模型，是一种估算，能帮助我们短时间内了解一个算法的执行效率。
	 */
	public static void test8(int n) {
		// 空间复杂度
		// a b c 都是常数项 所以是O(1)
		int a = 10;
		int b = 20;
		int c = 30;
		// 申请了一个空间为n的数组 再算上上面的常数项 所以是 O(n)
		int[] array = new int[n];
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i] + c);
		}
	}
	
}
