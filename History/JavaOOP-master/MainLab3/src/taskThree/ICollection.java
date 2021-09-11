package taskThree;

public interface ICollection {
	int size();

	void push_back(int element);

	void pop_back();

	int at(int index);

	int back();

	int front();

	void insert(int index, int element);

	void clear();

	boolean contains(int element);

	int find(int element);

	int rfind(int element);

	void set(int index, int element);

	boolean isEmpty();

	void removeAtIndex(int index);

	void removeElement(int element);

	void reverse();

	int[] toArray();

	void sort(int l, int r);

	String toString();

}
