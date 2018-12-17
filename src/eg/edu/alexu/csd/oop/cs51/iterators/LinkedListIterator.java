package eg.edu.alexu.csd.oop.cs51.iterators;

import java.util.List;

public class LinkedListIterator implements IteratorI{

	private List list;
	private int index;
	public LinkedListIterator(List list) {
		this.list = list;
		index = 0;
	}

	@Override
	public boolean hasNext() {
		if(index < list.size())
			return true;
		return false;
	}

	@Override
	public Object next() {
		if(hasNext())
			return list.get(index++);
		return null;
	}


}
