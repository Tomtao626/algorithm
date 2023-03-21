package com.tom;


@SuppressWarnings("unchecked")

/**
 * 动态缩容操作
 * @author tao626
 *
 * @param <E>
 */
public class ArrayList2<E> extends AbstractList<E> {

	/*
	 * 所有的元素
	 */
	private E[] elements;
	private static final int DEFAULT_CAPATICY = 10;
	
	/*
	 * 构造函数
	 */
	public ArrayList2(int capaticy) {
		capaticy = (capaticy < DEFAULT_CAPATICY) ? DEFAULT_CAPATICY : capaticy;
		elements = (E[]) new Object[capaticy];
	}
	
	public ArrayList2() {
		this(DEFAULT_CAPATICY);
	}

		
	/*
	 * 清除所有元素
	 */
	public void clear() {
		// 不清空存有内存地址的数组 只需要置person对象为null
		for (int i = 0; i < size; i++) {
			elements[i] = null;
		}
		size = 0;
		if (elements != null && elements.length > DEFAULT_CAPATICY) {
			elements = (E[]) new Object[DEFAULT_CAPATICY]; // 回到最初的状态
		}
	}
	
	/*
	 * 获取index位置的元素
	 * @param index
	 * @return
	 */
	public E get(int index) {
		rangeCheck(index);
		return elements[index]; // O(1)
	}
	
	/*
	 * 设置index位置的元素
	 * @param index
	 * @param element
	 * @return 原来的元素
	 */
	public E set(int index, E element) {
		rangeCheck(index);
		E old = elements[index];
		elements[index] = element;
		return old; // O(1)
	}
	
	/*
	 * 在index位置插入一个元素
	 * @param index
	 * @param element
	 */
	public void add(int index, E element) {
		rangeCheckForAdd(index);
		ensureCapacity(size + 1);
		for (int i = size; i > index; i--) {
			elements[i] = elements[i-1];
		}
		elements[index] = element;
		size++; // size是数据规模
		// 最好情况复杂度 O(1) 向末尾添加
		// 最坏情况复杂度 O(N) 向开头添加
		// 平均复杂度    O((1+2+...+n)/n) = O(n/2) = O(N)
	}
	
	/*
	 * 删除index位置的元素
	 * @param index
	 * @return
	 */
	public E remove(int index) {
		// 动态缩容
		rangeCheck(index);
		E old = elements[index];
		for (int i = index + 1; i < size; i++) {
			elements[i - 1] = elements[i];
		}
		size--;
		
		trim();
		return old;
		// 最好情况复杂度 O(1) 从末尾删除
		// 最坏情况复杂度 O(N) 从开头删除
		// 平均复杂度    O((1+2+...+n)/n) = O(n/2) = O(N)
	}
	
	/*
	 * 根据元素删除
	 */
	public void remove(E element) {
		remove(indexOf(element));
	}
	
	/*
	 * 查看元素的索引
	 * @param element
	 * @return
	 */
	public int indexOf(E element) {
		if (element == null) {
			for (int i = 0; i < size; i++) {
				if (elements[i] == null) return i; //  因为不能对null调用equals 所以需要判断元素是否为空
			}
		} else {
			for (int i = 0; i < size; i++) {
				// 因为不能对null调用equals
			if (elements[i].equals(element)) return i;
		    }
		}
		return ELEMENT_NOT_FOUND;
	}
	
	/*
	 * 保证要有capacity的容量
	 * @param capacity
	 */
	public void ensureCapacity(int capacity) {
		int oldCapacity = elements.length;
		if (oldCapacity >= capacity) return;
		
		// 新容量为旧容量的1.5倍
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		E[] newElements = (E[]) new Object[newCapacity];
		for (int i = 0; i < size; i++) {
			newElements[i] = elements[i];
		}
		elements = newElements;
		System.out.println(oldCapacity + "正在扩容为" + newCapacity);
	}
	
	/**
	 * 缩容
	 */
	private void trim() {
		int oldCapacity = elements.length;
		int newCapacity = oldCapacity >> 1;
		if (size >= (oldCapacity >> 1) || oldCapacity <= DEFAULT_CAPATICY) return;
		E[] newElements = (E[]) new Object[newCapacity];
		for (int i=0;i<size;i++) {
			newElements[i] = elements[i];
		}
		elements = newElements;
		System.out.println(oldCapacity + "正在缩容为" + newCapacity);
	}
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("size=").append(size).append(", [");
		for (int i = 0; i < size; i++) {
			if (i!=0) {
				string.append(", ");
			}
			string.append(elements[i]);
//			if (i != size-1) {
//				string.append(", ");
//			}
		}
		string.append("]");
		return string.toString();
		
	}

}
