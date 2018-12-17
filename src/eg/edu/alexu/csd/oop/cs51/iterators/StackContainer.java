package eg.edu.alexu.csd.oop.cs51.iterators;

import java.util.Collection;
import java.util.Stack;

public class StackContainer<T> implements Collections<T> {
	private Stack<T> stack;

	public StackContainer() {
		stack = new Stack<T>();
	}

	@Override
	public IteratorI createIterator() {
		return new StackIterator(stack);
	}

	@Override
	public void add(T a) {
		stack.add(a);
	}

	@Override
	public T peek() {
		if (!stack.isEmpty())
			return stack.peek();
		return null;
	}

	@Override
	public T pop() {
		if (!stack.isEmpty())
			return stack.pop();
		return null;

	}

	@Override
	public boolean remove(T obj) {
		if (!stack.isEmpty())
			return stack.remove(obj);
		return false;

	}

	@Override
	public T removeLast() {
		if (!stack.isEmpty())
			return stack.pop();
		return null;

	}

	@Override
	public T removeFirst() {
		if (!stack.isEmpty())
			stack.remove(0);
		return null;

	}

	@Override
	public int size() {
		return stack.size();
	}

	@Override
	public void clear() {
		stack.clear();
		
	}

	@Override
	public Collection<T> getCollection() {
		return stack;
	}

}
