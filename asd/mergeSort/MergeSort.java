import java.util.Arrays;
public class MergeSort{

	public static void main(String[] a){
		int[] prova = {7,5,4,6,9,1,3,8,2,0};
		mergeSort(prova);
		System.out.println(Arrays.toString(prova));	
		
		int[] prova1 = {7,5,4,6,9,1,3,8,2,0};
		RecursionTree prova1Tree = RecursionTree.mergeSort(prova1);
		
		System.out.println(Arrays.toString(prova1));
		prova1Tree.stampaMergeTree();
		
		System.out.println("\n\n\n");
		prova1Tree.stampaChiamate();
		
	}
	
	
	public static void mergeSort(int[] a){
		mergeSort(a,0,a.length-1);
	}
	

	private static void mergeSort(int[] a, int i, int f){
			
			if(i == f) return;
			int mid = ((i+f)/2);
			mergeSort(a, i, mid);
			mergeSort(a,mid+1,f);
			union(a,i,f);
	}
	
	private static void union(int[] a, int i, int f){
			
		int[] temp = new int[((f-i)+1)];
		int i1 = i;
		int mid = ((f+i)/2); 
		int i2 = mid+1;
		System.out.println("i="+i+"    mid="+mid+"     f="+f+"  array="+((f-i)+1));	
		
		for(int j = 0; j< temp.length; j++){
			if(i1 > mid){
				temp[j] = a[i2];
				i2++;
			}else if(i2 > f){
				temp[j] = a[i1];
				i1++;
			}else	if( a[i1] < a[i2]){
				temp[j] = a[i1];
				i1++;
			}else{
				temp[j] = a[i2];
				i2++;
			}
		}
		for(int j = 0; j< temp.length; j++){
			a[i+j] = temp[j];  
		}
	}
}
