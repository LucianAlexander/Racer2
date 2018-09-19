import java.util.Arrays;
import java.util.Random;


public class MergeSort {

	private static void iterativeMergeSort(int[] a, int[] tmp) {
        int n = a.length;
        if(n < 2) return;

        int lunghOrd = 1; // all'inizio assumiamo che ci siano porzioni ordinate lunghe 1

        while(lunghOrd < n) {
            int i = 0;
            int j = lunghOrd;
            while(j < n) {
                merge(a, i, j, tmp);
                i += lunghOrd*2;
                j = i + lunghOrd;
            }
            lunghOrd *= 2;
        }
    }


    private static void merge(int[] a, int sx, int dx, int[] temp) {
        int stop; int n = a.length;
        int l = dx - sx;
        if(dx + l <= n) stop = sx + 2*l;
        else stop = n;

        int i = sx, j = dx, k = sx;
        while((i < dx) && (j < stop))
            if(a[i] <= a[j])
                temp[k++] = a[i++];
            else
                temp[k++] = a[j++];
        int h = stop - 1;
        int ii = dx - 1; // ultimo parte sx
        while(ii >= i) {
        	a[h--] = a[ii--];
        }
        while(k > sx) { k--; a[k] = temp[k]; }
    }

}

