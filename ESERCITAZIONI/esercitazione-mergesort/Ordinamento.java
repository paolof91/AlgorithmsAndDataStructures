

public class Ordinamento {

	// * merge sort * //
	public static void mergeSort(Comparable A[]) {
		mergeSortRec(A, 0, A.length - 1);
	}

	protected static void merge(Comparable A[], int i1, int f1, int f2) {
		Comparable[] X = new Comparable[f2 - i1 + 1];
		int i = 0, 
		i2 = f1 + 1, 
		k = i1;
		while (i1 <= f1 && i2 <= f2) {
			if (A[i1].compareTo(A[i2]) < 0) X[i++] = A[i1++];
			else X[i++] = A[i2++];
		}
		if (i1 <= f1)
			for (int j = i1; j <= f1; j++, i++) X[i] = A[j];
		else for (int j = i2; j <= f2; j++, i++) X[i] = A[j];
		for (int t = 0; k <= f2; k++, t++) A[k] = X[t];
	}

	protected static void mergeSortRec(Comparable A[], int i, int f) {
		if (i >= f) return;
		int m = (i + f) / 2;
		mergeSortRec(A, i, m);
		mergeSortRec(A, m + 1, f);
		merge(A, i, m, f);
	}
    // ************** //	

	public static void selectionSort(Comparable A[]) {
		for (int k = 0; k < A.length - 1; k++) {
			int m = k;
			for (int j = k + 1; j < A.length; j++)
				if (A[j].compareTo(A[m]) < 0) m = j;
			if (m != k) {
				Comparable temp = A[m];
				A[m] = A[k];
				A[k] = temp;
			}
		}
	}

	public static void insertionSort(Comparable A[]) {
		for (int k = 1; k <= A.length - 1; k++) {
			int j;
			Comparable x = A[k];
			for (j = 0; j < k; j++)
				if (A[j].compareTo(x) > 0) break;
			if (j < k) {
				for (int t = k; t > j; t--) A[t] = A[t - 1];
				A[j] = x;
			}
		}
	}

	public static void quickSort(Comparable A[]) {
		quickSortRec(A, 0, A.length - 1);
	}

	public static void quickSortRec(Comparable[] A, int i, int f) {
		if (i >= f) return;

		int m = partition(A, i, f);
		quickSortRec(A, i, m - 1);
		quickSortRec(A, m+1, f);
	}
	
	protected static int partition(Comparable A[], int i, int f) {
		int inf = i, sup = f + 1, pos = i
				+ (int) Math.floor((f-i+1) * Math.random());
		Comparable temp, x = A[pos];
		A[pos] = A[i];
		A[i] = x;
		while (true) {
			do {inf++;}
			while (inf <= f && A[inf].compareTo(x) <= 0);

			do {sup--;}
			while (A[sup].compareTo(x) > 0);
			if (inf < sup) {
				temp = A[inf];
				A[inf] = A[sup];
				A[sup] = temp;
			} else
				break;
		}
		temp = A[i];
		A[i] = A[sup];
		A[sup] = temp;
		return sup;
	}

	public static void heapSort(Comparable S[]) {
		heapify(S, S.length - 1, 1);
		for (int c = (S.length - 1); c > 0; c--) {
			Comparable k = findMax(S);
			deleteMax(S, c);
			S[c] = k;
		}
	}

	private static Comparable findMax(Comparable S[]) {
		return S[1];
	}

	private static void heapify(Comparable S[], int n, int i) {
		if (i > n) return;
		heapify(S, n, 2 * i);
		heapify(S, n, 2 * i + 1);
		fixHeap(S, n, i);
	}
	
	private static void deleteMax(Comparable S[], int c) {
		if (c <= 0) return;
		S[1] = S[c];
		c--;
		fixHeap(S, c, 1);
	}	

	private static void fixHeap(Comparable S[], int c, int i) {
		int max = 2 * i;
		if (2 * i > c) return;
		if (2 * i + 1 <= c && S[2 * i].compareTo(S[2 * i + 1]) < 0)
			max = 2 * i + 1;
		if (S[i].compareTo(S[max]) < 0) {
			Comparable temp = S[max];
			S[max] = S[i];
			S[i] = temp;
			fixHeap(S, c, max);
		}
	}	
	
}