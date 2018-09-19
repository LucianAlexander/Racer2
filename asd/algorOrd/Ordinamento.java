
public class Ordinamento {

    // profiling util
	private static int confronti = 0;
    private static int myCompareTo(Comparable a, Comparable b) {
		confronti++;
		return a.compareTo(b);
	}
	
    private static void printConfronti(String info) {
		System.out.println("["+info+"]"+" confronti: "+ confronti);
	}	
	
    private static void resetConfronti() {
		confronti = 0;
	}		
	
	// * merge sort * //
	public static void mergeSort(Comparable A[]) {
	    resetConfronti();
		mergeSortRec(A, 0, A.length);
		printConfronti("merge sort");
	}

	protected static void mergeSortRec(Comparable A[], int i, int f) {
		if (i >= f-1) return;
		int l = (f-i) / 2;
		mergeSortRec(A, i, i+l);
		mergeSortRec(A, i+l, f);
		merge(A, i, l, f);
	}
	
	protected static void merge(Comparable[] in, int i, int l, int f) {
		int n = f-i;
		Comparable[] out = new Comparable[n];
		int it = 0;         
		
		int i1 = i; 
		int f1 = i1 + l   < f ? i1 + l : f;
		int i2 = i1 + l;
		int f2 = f;
		while (i1 < f1 && i2 < f2) {
			if (myCompareTo(in[i1], in[i2]) <= 0) out[it++] = in[i1++];
			else out[it++] = in[i2++];
		}
		while (i1 < f1) out[it++] = in[i1++];
		while (i2 < f2) out[it++] = in[i2++];

	    for (it = 0; it < n; it++) in[i+it] = out[it];	
	}	
    // ************** //	

	// * merge sort iterativo + allocazione statica * //	
	public static void is_mergeSort(Comparable A[]) {
		resetConfronti();
		
        int n = A.length;
	    Comparable in[]  = A;
	    Comparable out[] = new Comparable[n];
	    Comparable tmp[] ;
        for (int i=1; i < n;  i*=2) {
			for (int j=0; j < n; j+=2*i)
                is_merge(in, out, j, i);
			tmp = in; in = out; out = tmp;
		}
		for (int it = 0; it < n; it++) A[it] = in[it];	
		printConfronti("merge sort iterativo");
    }
	
    protected static void is_merge(Comparable[] in, Comparable[] out, int i, int l) {	
	    int n = in.length;
		int it = i;           									
		
		int i1 = i; 
		int f1 = i1 + l   < n ? i1 + l : n;
		int i2 = i1 + l;
		int f2 = i1 + 2*l < n ? i1 + 2*l : n;
		while (i1 < f1 && i2 < f2) {
			if (myCompareTo(in[i1], in[i2]) <= 0) out[it++] = in[i1++];
			else out[it++] = in[i2++];
		}
		while (i1 < f1) out[it++] = in[i1++];
		while (i2 < f2) out[it++] = in[i2++];
	}			
    // ************** //	
		
	// * quick sort * //
	public static void quickSort(Comparable A[]) {
		resetConfronti();
		quickSortRec(A, 0, A.length - 1);
		printConfronti("quick sort");
	}
	
	private static void quickSortRec(Comparable A[], int l, int r ) {
		if (r <= l) return;
		int i = l-1;
		int j = r;
		Comparable v = A[r];										// pivot
		while (true) {
			  while (myCompareTo(A[++i], v) < 0) ;
			  while (myCompareTo(v, A[--j]) < 0) if (j == l) break;
			  if (i >= j) break;
			  exch(A, i, j);
		} 
		exch(A, i, r);
		j = i-1; 
		i = i+1;		
		quickSortRec(A, l, j);
		quickSortRec(A, i, r);
	}
    // ************** //	
		
	// * quick sort randomizzato + duplicati * //
	public static void rd_quickSort(Comparable A[]) {
		resetConfronti();
		rd_quickSortRec(A, 0, A.length - 1);
		printConfronti("quick sort");
	}	
	
	public static void rd_quickSortRec(Comparable[] A, int l, int r) {
		// Bentley-McIlroy 3-way partitioning: 
		// vedi slides allegate al materiale dell'esercitazione
		if (r <= l) return;
		int i = l-1;
		int j = r; 
		// 3-way
		int p = l-1;
		int q = r;
		// ----
		int pivot    = l + (int) Math.floor((r-l) * Math.random());	// random pivot
		exch(A, pivot, r);											// random pivot
		Comparable v = A[r];										// random pivot
		while (true) { 
			  while (myCompareTo(A[++i], v) < 0) ;
			  while (myCompareTo(v, A[--j]) < 0) if (j == l) break;
			  if (i >= j) break;
			  exch(A, i, j);
			  // 3-way
			  if (myCompareTo(A[i], v) == 0) { p++; exch(A, p, i); }
			  if (myCompareTo(v, A[j]) == 0) { q--;	exch(A, j, q); }
			  // ----
		} 
		exch(A, i, r);
		j = i-1; 
		i = i+1;
		// 3-way		
		for (int k = l; k < p; k++, j--) exch(A, k, j);
		for (int k = r-1; k > q; k--, i++) exch(A, i, k);
		// ----
		rd_quickSortRec(A, l, j);
		rd_quickSortRec(A, i, r);
	}
	
	private static void exch(Comparable A[], int a, int b) {
		Comparable tmp = A[a];
		A[a] = A[b];
		A[b] = tmp;
	}
	// ************** //	

	// * selection sort * //	
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
    // ****************** //	

    // * insertion sort * //	
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
    // ****************** //	
	
	// * heap sort * //	
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
    // ************* //	
	
}