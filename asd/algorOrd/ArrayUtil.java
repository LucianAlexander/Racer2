
import java.util.Random;

public class ArrayUtil {

	public static Integer[] getRandomArray(int size, int max) {
		Random generatore = new Random();

		int n = size;
		Integer[] pluto = new Integer[n];
		for(int i = 0; i < n; i++)
			pluto[i] = generatore.nextInt(max);			
			
		return pluto;
	}
	
	public static void stampa(Integer[] A) {
		System.out.print("[");
		for (int i = 0; i < A.length; i++)
			System.out.print(" "+A[i]+" ");
		System.out.println("]");			
	}

}