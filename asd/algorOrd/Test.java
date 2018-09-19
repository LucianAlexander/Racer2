
import java.io.*;

public class Test {

	private static int n		   = 10;

	public static void main(String[] args) {
	
	    if (args.length > 0)			
			n = Integer.parseInt(args[0]);	
		
		int min, sec, msec;
		long prima, dopo;
		Integer[] pluto = ArrayUtil.getRandomArray(n, n);
		Integer[] plutocopy;

		System.out.println();		
		System.out.println("sort di " + n + " interi... ");
		ArrayUtil.stampa(pluto);
		
		// quick sort
		System.out.println();
		prima = System.currentTimeMillis();
		plutocopy = pluto.clone();
		Ordinamento.rd_quickSort(plutocopy);
		dopo = System.currentTimeMillis();		
		min  = (int) Math.floor((dopo-prima)/(1000*60));
		sec  = (int) Math.floor((dopo-prima)/1000) % 60;		
		msec = (int) (dopo-prima)%1000;		
		System.out.println("sorted in " + min +  ":" + sec + ":" + msec);	
		ArrayUtil.stampa(plutocopy);
		
		// merge sort iterativo
		System.out.println();
		prima = System.currentTimeMillis();
		plutocopy = pluto.clone();
		Ordinamento.is_mergeSort(plutocopy);
		dopo = System.currentTimeMillis();		
		min  = (int) Math.floor((dopo-prima)/(1000*60));
		sec  = (int) Math.floor((dopo-prima)/1000) % 60;		
		msec = (int) (dopo-prima)%1000;			
		System.out.println("sorted in " + min +  ":" + sec + ":" + msec);	
		ArrayUtil.stampa(plutocopy);
				
	}
}