package com.github.obeseclown.tictactoe.utils;

import java.util.Iterator;

public class List<T> implements Iterable<T> {
	
	private Object[] elements = new Object[0];
	
	public void add(T obj)
	{
		Object[] temp = new Object[elements.length + 1];
		
		for (int i = 0; i < this.elements.length; i++)
		{	
			temp[i] = this.elements[i];
		}
		
		temp[temp.length - 1] = obj;
		
		this.elements = temp;
	}
	
	public boolean isEmpty() 
	{
		return this.elements.length == 0 ? true : false;
	}
	
	@SuppressWarnings("unchecked")
	public T get(int index)
	{
		return (T) this.elements[index];
	}
	
	public int size()
	{
		return this.elements.length;
	}

	@Override
	public Iterator<T> iterator() 
	{
		return new ListIterator<T>(this);
	}
	
	private static class ListIterator<T> implements Iterator<T>
	{
		List<T> list;
		int currentIndex = 0;
		
		public ListIterator(List<T> list)
		{
			this.list = list;
		}

		@Override
		public boolean hasNext() 
		{
			if (this.currentIndex >= this.list.size()) return false;
			
			else return true;
		}

		@Override
		@SuppressWarnings("unchecked")
		public T next() 
		{
			Object obj = this.list.get(currentIndex);
			
			this.currentIndex++;
			
			return (T) obj;
		}
	}
}
