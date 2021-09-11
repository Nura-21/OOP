package taskFive;

public class Sort {
	public Sort() {
	}

	public static <E> void swap(E[] array, int i, int j) {
		E e = array[i];
		array[i] = array[j];
		array[j] = e;
	}

	public static <E extends Comparable<E>> void sort(E[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = i; j < array.length; j++) {
				if (array[i].compareTo(array[j]) == 1)
					swap(array, i, j);
			}
		}
	}

	public static <E extends Comparable<E>> void fastSort(E[] array, int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;
			fastSort(array, l, m);
			fastSort(array, m + 1, r);
			merge(array, l, m, r);
		}
	}

	public static <E extends Comparable<E>> void merge(E[] array, int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;

		Object L[] = new Object[n1];
		Object R[] = new Object[n2];

		for (int i = 0; i < n1; ++i)
			L[i] = array[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = array[m + 1 + j];
		int i = 0, j = 0;
		int k = l;
		while (i < n1 && j < n2) {
			if (((Comparable<E>) L[i]).compareTo((E) R[j]) == -1) {
				array[k] = (E) L[i];
				i++;
			} else {
				array[k] = (E) R[j];
				j++;
			}
			k++;
		}
		while (i < n1) {
			array[k] = (E) L[i];
			i++;
			k++;
		}
		while (j < n2) {
			array[k] = (E) R[j];
			j++;
			k++;
		}
	}
}