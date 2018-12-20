package eg.edu.alexu.csd.oop.cs51.iterators;

import java.util.Collection;

public interface Collections<T> {
	public IteratorI createIterator();
	public void add(T a);
	public void addFirst(T a);
	public T peek();
	public T pop();
	public boolean remove(T obj);
	public T removeLast();
	public T removeFirst();
	public int size();
	public void clear();
	public Collection<T> getCollection();
	
}
