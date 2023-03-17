package com.tom;


public class ArrayList {
	
	/*
	 * 元素的数量
	 */
	private int size;
	/*
	 * 所有的元素
	 */
	private int[] elements;
	
	private static final int DEFAULT_CAPATICY = 10;
	private static final int ELEMENT_NOT_FOUND = -1;
	
	/*
	 * 构造函数
	 */
	public ArrayList(int capaticy) {
		capaticy = (capaticy < DEFAULT_CAPATICY) ? DEFAULT_CAPATICY : capaticy;
		elements = new int[capaticy];
	}
	
	public ArrayList() {
		this(DEFAULT_CAPATICY);
	}

		
	/*
	 * 清除所有元素
	 */
	public void clear() {
		size = 0;
	}
	
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
	public boolean contains(int element) {
		return indexOf(element) != ELEMENT_NOT_FOUND;
	}
	
	/*
	 * 添加元素到尾部
	 * @param element
	 */
	public void add(int element) {
	//		elements[size] = element;
	//		size++;
		add(size, element);
	}
	
	/*
	 * 获取index位置的元素
	 * @param index
	 * @return
	 */
	public int get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
		}
		return elements[index];
	}
	
	/*
	 * 设置index位置的元素
	 * @param index
	 * @param element
	 * @return 原来的元素
	 */
	public int set(int index, int element) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
		}
		int old = elements[index];
		elements[index] = element;
		return old;
	}
	
	/*
	 * 在index位置插入一个元素
	 * @param index
	 * @param element
	 */
	public void add(int index, int element) {
		rangeCheckForAdd(index);
		for (int i = size - 1; i >= index; i--) {
			elements[i+1] = elements[i];
		}
		elements[index] = element;
		size++;
	}
	
	/*
	 * 删除index位置的元素
	 * @param index
	 * @return
	 */
	public int remove(int index) {
		rangeCheck(index);
		int old = elements[index];
		for (int i = index + 1; i < size - 1; i++) {
			elements[i - 1] = elements[i];
		}
		size--;
		return old;
	}
	
	/*
	 * 查看元素的索引
	 * @param element
	 * @return
	 */
	public int indexOf(int element) {
		for (int i = 0; i < size; i++) {
			if (elements[i] == element) 
				return i;
		}
		return ELEMENT_NOT_FOUND;
	}
	
	private void outOfBounds(int index) {
		throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
	}
	
	private void rangeCheck(int index) {
		if (index < 0 || index >= size) {
			outOfBounds(index);
		}
	}
	
	private void rangeCheckForAdd(int index) {
		if (index < 0 || index > size) {
			outOfBounds(index);
		}
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
