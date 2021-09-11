package taskThree2;

public class MyCollection implements IMyCollection {
	private final int CAPACITY = 100000;
	private int size;
	public Object[] collection = new Object[CAPACITY];

	
	
	public MyCollection() {
		size = 0;
	}

	public MyCollection(Object[] a) {
		size = a.length;
		for (int i = 0; i < size; i++)
			collection[i] = a[i];
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		if (size() == 0)
			return true;
		return false;
	}

	@Override
	public boolean contains(Object o) {
		for (Object object : collection)
			if (object.equals(o))
				return true;
		return false;
	}

	@Override
	public Object[] toArray() {
		return collection;
	}

	@Override
	public boolean remove(Object o) {
		for (int i = 0; i < size(); i++) {
			if (collection[i].equals(o)) {
				collection[i] = collection[size() - 1 - i];
				size--;
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean containsAll(Object[] c) {
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < size(); j++) {
				if (collection[i].equals(c[i]))
					break;
				if (j == size() - 1) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public boolean add(Object o) {
		for (Object obj : collection)
			if (obj.equals(o))
				return false;
		collection[size++] = o;
		return true;
	}

	@Override
	public boolean removeAll(Object[] c) {
		int curSize = size();
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < size(); j++) {
				if (collection[i].equals(c[i])) {
					collection[i] = collection[size() - 1];
					size--;
					break;
				}
			}
		}
		if (curSize == size)
			return false;
		return true;
	}

	@Override
	public void clear() {
		for (int i = 0; i < size(); i++)
			collection[i] = null;
		size = 0;
	}

	@Override
	public String toString() {
		String s = "{";
		for (int i = 0; i < size; i++) {
			s += collection[i];
			if (i != size - 1)
				s += ", ";
		}
		return s + "}";
	}

}
