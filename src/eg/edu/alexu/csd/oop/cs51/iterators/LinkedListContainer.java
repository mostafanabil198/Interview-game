package eg.edu.alexu.csd.oop.cs51.iterators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class LinkedListContainer<T> implements Collections<T> {

	private List<T> list = new ArrayList<T>();

	@Override
	public IteratorI createIterator() {
		return new LinkedListIterator(list);
	}

	@Override
	public void add(T a) {
		list.add(a);

	}

	@Override
	public T peek() {
		if (!list.isEmpty())
			return list.get(list.size() - 1);
		return null;
	}

	@Override
	public T pop() {
		if(!list.isEmpty())
		return list.remove(list.size()-1);
		return null;
	}

	@Override
	public boolean remove(T obj) {
		if(!list.isEmpty())
		return list.remove(obj);
		return false;
	}

	@Override
	public T removeLast() {
		if(!list.isEmpty())
		return pop();
		return null;
	}

	@Override
	public T removeFirst() {
		if(!list.isEmpty())
		return list.remove(0);
		return null;
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public void clear() {
		list.clear();
		
	}

	@Override
	public Collection<T> getCollection() {
		return list;
	}

}
