import java.util.LinkedList;


public class RecursionTree{
	private RecursionNode root;
	
	public RecursionTree(RecursionNode r){
		root =r;
	}
	
	public static RecursionTree mergeSort(int[] a){
		return new RecursionTree(mergeSort(a,0,a.length-1));
	}
	
	private static RecursionNode mergeSort(int[] a, int i, int f){
		
		
		//costruisco array pre-union	
		int[] pre = new int[((f-i)+1)];
		
		for(int j = 0; j < pre.length; j++)
			pre[j] = a[i+j];
			
		RecursionNode result = new RecursionNode(pre,i,f);
		
		if(i!=f){
			int mid = ((i+f)/2);
			result.setLeft( mergeSort(a, i, mid));
			result.setRight( mergeSort(a,mid+1,f));
			
			union(a,i,f);
		}
		//costruisce array post-union
		int[] post = new int[((f-i)+1)];
		
		for(int j = 0; j < post.length; j++)
			post[j] = a[i+j];
		
		result.setPost(post);
		
		return result;
		
	}
	private static void union(int[] a, int i, int f){
			
		int[] temp = new int[((f-i)+1)];
		int i1 = i;
		int mid = ((f+i)/2); 
		int i2 = mid+1;	
		
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
	
	public void stampaMergeTree(){
		System.out.print("\n\n\n");
		LinkedList<RecursionNode> list = new LinkedList<RecursionNode>();
		list.add(root);
		stampaMergeTree(list);
	}
	private void stampaMergeTree(LinkedList<RecursionNode> list){
		
		LinkedList<RecursionNode> nuova = new LinkedList<RecursionNode>();
	
		for(RecursionNode n: list){
			if(n == null){
				printSpace(2);
			}else{
				System.out.print(n+" ");
				nuova.add(n.getLeft());
				nuova.add(n.getRight());
			}
		}
		System.out.println("");
		if(nuova.size() != 0)
			stampaMergeTree(nuova);
	}
	
	private void printSpace(int i){
		for(int j = 0; j<i; j++){
			System.out.print(" ");
		}
	}
	
	public void stampaChiamate(){
		stampaChiamate(root);
	}
	private void stampaChiamate(RecursionNode n){
		if(n == null ) return;
		stampaChiamate(n.getLeft());
		stampaChiamate(n.getRight());
		System.out.println((n.toStringPost()));
		
	}
}
