package taskThree2;

public interface IMyCollection {
	int size();

	boolean isEmpty();

	boolean contains(Object o);

	Object[] toArray();

	boolean remove(Object o);

	boolean containsAll(Object[] c);

	boolean add(Object o);

	boolean removeAll(Object[] c);

	void clear();

	boolean equals(Object o);

	int hashCode();

	String toString();

}
