package eg.edu.alexu.csd.oop.cs51.iterators;

import java.util.Stack;

public class StackIterator implements IteratorI {

	private Stack stack;
	private int index;

	public StackIterator(Stack stack) {
		this.stack = stack;
		index = stack.size()-1;
	}

	@Override
	public boolean hasNext() {
		if (index >= 0)
			return true;
		return false;
	}

	@Override
	public Object next() {
		if (hasNext()) {
			return stack.get(index--);
		}
		return null;
	}
}
