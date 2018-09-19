import java.io.*; 
import java.util.*;

public class TreeParser {
	
	public static <E> BSTree<E> readTree() throws IOException {
		BSTree<E> t = new MyBSTree<E>(); 
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in)); 
		String s = r.readLine(); 
		StringTokenizer st = new StringTokenizer(s); 
		BSPosition<E> noParent = null; 
		t.setRoot(readSubtree(noParent, st)); 
		return t;
	}
	
	private static <E> BSPosition<E> readSubtree(BSPosition<E> parent, StringTokenizer st) throws IOException {
		String tok = st.nextToken(); // tok == "()" o "("   
		if(tok.equals("()")) return null; 
		String val = st.nextToken(); // tok == chiave
		int x = Integer.parseInt(val); 
		BSPosition<E> v = new MyBSNode<E>(parent); // !!! 
		v.setElement(x, null); 
		v.setLeftChild(readSubtree(v, st)); 
		v.setRightChild(readSubtree(v, st)); 
		st.nextToken(); // leggo la ")" di chiusura
		return v; 
	}
	
	public static <E> boolean isBSTree(BSTree<E> t) {
		List<Integer> q = new LinkedList<Integer>(); 
		inorder(t.getRoot(), q); 
		System.out.println("Visita in ordine: " + q); 

		int oldKey = Integer.MIN_VALUE; 
		for(Integer key : q) {
			if(key < oldKey) return false; 
			oldKey = key; 
		}
		return true; 
	}
	
	private static <E> void inorder(BSPosition<E> v, List<Integer> q) {
		if(v==null) return; 
		inorder(v.getLeftChild(), q); 
		q.add(v.getKey()); 
		inorder(v.getRightChild(), q); 
	}
				
	
	public static void main(String[] args) throws Exception {
		BSTree<String> t = readTree(); 
		BSTreeUtil.stampa(t); 
		System.out.println(isBSTree(t) ? "Albero binario di ricerca" : "Albero binario NON di ricerca"); 
	}
		
}


