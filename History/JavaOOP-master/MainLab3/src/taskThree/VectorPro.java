package taskThree;

public class VectorPro implements ICollection {
	private final int CAPACITY = 1000000;
	private int size;
	private int[] vector = new int[CAPACITY];

	public VectorPro() {
		size = 0;
	}

	public VectorPro(int[] a) {
		size = a.length;
		for (int i = 0; i < size; i++)
			vector[i] = a[i];
	}

	public int size() {
		return size;
	}

	public void push_back(int element) {
		vector[size++] = element;
	}

	public void pop_back() {
		vector[--size] = 0;
	}

	public int back() {
		if (!isEmpty())
			return vector[size - 1];
		return -1;
	}

	public int front() {
		if (!isEmpty())
			return vector[0];
		return -1;
	}

	public int at(int index) {
		if (index < 0 || index >= size)
			return -1;
		return vector[index];
	}

	public void insert(int index, int element) {
		if (index > size) {
			System.out.print("Segmentation fault");
			return;
		}
		for (int i = size; i > index; i--)
			vector[i] = vector[i - 1];
		vector[index] = element;
		size++;
	}

	public void clear() {
		for (int i = 0; i < size; i++)
			vector[i] = 0;
		size = 0;
	}

	public boolean contains(int element) {
		for (int i = 0; i < size; i++)
			if (element == vector[i])
				return true;
		return false;
	}

	public int find(int element) {
		for (int i = 0; i < size; i++)
			if (element == vector[i])
				return i;
		return -1;
	}

	public int rfind(int element) {
		for (int i = 0; i < size; i++)
			if (element == vector[size - 1 - i])
				return size - 1 - i;
		return -1;
	}

	public void set(int index, int element) {
		if (index >= size || index < 0) {
			System.out.print("Segmentation fault");
			return;
		}
		vector[index] = element;
	}

	public boolean isEmpty() {
		if (size != 0)
			return false;
		return true;
	}

	public void removeAtIndex(int index) {
		if (index >= size) {
			System.out.print("Segmentation fault");
			return;
		}
		for (int i = index; i < size - 1; i++)
			vector[i] = vector[i + 1];
		vector[--size] = 0;
	}

	public void removeElement(int element) {
		for (int i = 0; i < size; i++) {
			if (vector[i] == element) {
				removeAtIndex(i);
				return;
			}
		}
	}

	public void reverse() {
		for (int i = 0; i < size / 2; i++) {
			int t = vector[i];
			vector[i] = vector[size - i - 1];
			vector[size - i - 1] = t;
		}
	}

	public int[] toArray() {
		return vector;
	}

	public void sort(int l, int r) { // n^2 sort, sorry, but it works
		if (l < 0 || r > size) {
			System.out.println("Segmentation fault");
			return;
		}
		for (int i = l; i < r; i++) {
			for (int j = i; j < r; j++) {
				if (vector[i] > vector[j]) {
					int t = vector[i];
					vector[i] = vector[j];
					vector[j] = t;
				}
			}
		}
	}

	public String toString() {
		String s = "VectorPro: {";
		for (int i = 0; i < size; i++) {
			s += vector[i];
			if (i != size - 1)
				s += ", ";
		}
		return s + "}";
	}

}
