package com.tom;

public abstract class AbstractList<E> implements List<E> {
	
	/*
	 * 元素的数量
	 */
	protected int size;
	/*
	 * 元素的数量
	 * @return
	 */
	public int size() {
		return size;
	}
	
	/*
	 * 是否为空
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
		/*
		 * if (size == 0) {
			return true;
		}
		*/
	}
	
	/*
	 * 是否包含某个元素
	 * @param element
	 * @return
	 */
	public boolean contains(E element) {
		return indexOf(element) != ELEMENT_NOT_FOUND;
	}
	
	/*
	 * 添加元素到尾部
	 * @param element
	 */
	public void add(E element) {
	//		elements[size] = element;
	//		size++;
		add(size, element); 
		// 最好情况:向数组末尾添加 O(1)
		// 最坏情况: 扩容 O(N) 0-size
		// 平均: O(1)
		// 均摊: O(1) 经过连续的多次复杂度比较低的情况后, 出现个别复杂度过高的情况
	}
	
	protected void outOfBounds(int index) {
		throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
	}
	
	protected void rangeCheck(int index) {
		if (index < 0 || index >= size) {
			outOfBounds(index);
		}
	}
	
	protected void rangeCheckForAdd(int index) {
		if (index < 0 || index > size) {
			outOfBounds(index);
		}
	}

}
