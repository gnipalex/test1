package com.epam.hnyp.task1.subtask2;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class GoodsContainer<E> implements List<E> {

	public static final int DEFAULT_EXTRA_LENGTH = 10;
	public static final int DEFAULT_LENGTH = 10;

	private Object[] elements;
	private int size;
	private int initCapacity;
	private int extraLength;

	public GoodsContainer() {
		extraLength = DEFAULT_EXTRA_LENGTH;
		elements = new Object[DEFAULT_LENGTH];
		initCapacity = DEFAULT_LENGTH;
	}

	public GoodsContainer(int capacity) {
		extraLength = DEFAULT_EXTRA_LENGTH;
		elements = new Object[capacity];
		this.initCapacity = capacity;
	}

	public GoodsContainer(int capacity, int extraLen) {
		extraLength = extraLen;
		elements = new Object[capacity];
		this.initCapacity = capacity;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean contains(Object o) {
		for (int i = 0; i < size; i++) {
			if (elements[i].equals(o)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		return;
	}

	@Override
	public Object[] toArray() {
		return Arrays.copyOf(elements, size);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T[] toArray(T[] a) {
		if (a.length < size) {
			return (T[]) Arrays.copyOf(elements, size, a.getClass());
		}
		System.arraycopy(elements, 0, a, 0, size);
		// if (a.length > size)
		// a[size] = null;
		return a;

	}

	private void extendStorage() {
		Object[] storage = new Object[this.elements.length + extraLength];
		System.arraycopy(elements, 0, storage, 0, size);
		this.elements = storage;
	}
	
	private void extendStorage(int extraLen) {
		Object[] storage = new Object[this.elements.length + extraLen];
		System.arraycopy(elements, 0, storage, 0, size);
		this.elements = storage;
	}

	private void narrowStorage() {
		Object[] storage = Arrays.copyOfRange(elements, 0, elements.length
				- extraLength);
		this.elements = storage;
	}

	@Override
	public boolean add(E e) {
		if (size == elements.length) {
			extendStorage();
		}
		elements[size++] = e;
		return true;
	}

	@Override
	public boolean remove(Object o) {
		return remove(indexOf(o), true);
	}
	
	@Override
	public E remove(int index) {
		return remove(index, true);
	}
	
	@SuppressWarnings("unchecked")
	private E remove(int index, boolean narrow) {
		if (index < 0 || index > size - 1) {
			return null;
		}
		E removedItem = (E)elements[index];
		if (index < size - 1) {
			for (int i=index; i < size - 1; i++) {
				elements[i] = elements[i + 1];
			}
		} 
		elements[--size] = null;
		if (narrow && elements.length > size 
				&& elements.length >= initCapacity + extraLength 
				&& elements.length - size >= extraLength) {
			narrowStorage();
		}
		return removedItem;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		for (Object o : c) {
			if (indexOf(o) < 0) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		int addLen = c.size();
		if (elements.length - size < addLen) {
			int extLen = addLen / extraLength * extraLength;
			extLen += addLen % extraLength > 0 ? extLen : 0;
			extendStorage(extLen);
		}
		for (E i : c) {
			elements[size++] = i;
		}
		return true;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		if (index > size) {
			return false;
		}
		int addLen = c.size();
		if (elements.length - size < addLen) {
			int extLen = addLen / extraLength * extraLength;
			extLen += addLen % extraLength > 0 ? extLen : 0;
			extendStorage(extLen);
		}
		Object[] ost = new Object[size - index];
		System.arraycopy(elements, index, ost, 0, size - index);
		int tmp_index = index;
		for (E i : c) {
			elements[tmp_index++] = i;
		}
		System.arraycopy(ost, 0, elements, tmp_index, ost.length);
		size += addLen;
		
		return true;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		int deleted = 0;
		for (Object o : c) {
			if (re)
		}
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		size = 0;
		elements = new Object[initCapacity];
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub

	}

	@Override
	public int indexOf(Object o) {
		for (int i = 0; i < size; i++) {
			if (elements[i].equals(o)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public int lastIndexOf(Object o) {
		for (int i = size - 1; i >= 0; i--) {
			if (elements[i].equals(o)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}