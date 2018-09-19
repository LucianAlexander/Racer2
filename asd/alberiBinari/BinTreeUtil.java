
import java.util.*;

/**
 * Classe di utility
 */
public class BinTreeUtil {

	/*
	 * Stampa "graficamente" l'albero
	 */
    public static <E> void print(BinTree<E> tree) {
        print(tree, 0);
    }

	/*
	 * Metodo ausiliario ricorsivo di print
	 */
    private static <E> void print(BinTree<E> t, int level) {
        for (int i = 0; i < level - 1; i++) {
            System.out.print("   ");
        }
        if (level > 0)
            System.out.print(" |--");
        System.out.println(t.getRoot());
		if (t.getLeftSubtree() != null)   print(t.getLeftSubtree(), level+1);
		if (t.getRightSubtree() != null)  print(t.getRightSubtree(), level+1);
    }

	/*
	 * Stampa secondo la visita simmetrica
	 */
	public static <E> void printInorder(BinTree<E> t) {
        if (t.getLeftSubtree() != null)  printInorder(t.getLeftSubtree());
        System.out.print(t.getRoot() + " ");
		if (t.getRightSubtree() != null) printInorder(t.getRightSubtree());	
	}
	
	/* 
	 * Stampa per livelli
	 */
	public static <E> void printLivelli(BinTree<E> t) {
		LinkedList<BinTree<E>> l = new LinkedList<BinTree<E>>();
		l.add(t);

		while (!l.isEmpty()) {
			BinTree<E> v = l.remove();
			System.out.print(v.getRoot()+" ");
			if (v.getLeftSubtree()  != null) l.add(v.getLeftSubtree());
			if (v.getRightSubtree() != null) l.add(v.getRightSubtree());	
		}
		System.out.println(); 
	}	
	
	/* 
	 * Stampa speculare
	 */	
	 public static <E> void printMirror(BinTree<E> tree) {
        printMirror(tree, 0);
    }

	/*
	 * Metodo ausiliario ricorsivo di printMirror
	 */
    private static <E> void printMirror(BinTree<E> t, int level) {
        for (int i = 0; i < level - 1; i++) {
            System.out.print("   ");
        }
        if (level > 0)
            System.out.print(" |--");
        System.out.println(t.getRoot());
		if (t.getRightSubtree() != null)  printMirror(t.getRightSubtree(), level+1);
		if (t.getLeftSubtree() != null)   printMirror(t.getLeftSubtree(), level+1);
	} 
	
	
	/*
	 * Costruzione albero speculare
	 */
	public static <E> BinTree<E> mirror(BinTree<E> t) {
		BinTree<E> out = new BinTree<E>(t.getRoot()); 
		mirror(t, out); 
		return out; 
	}
	
	/*
	 * Metodo ausiliario ricorsivo di mirror
	 */ 
	private static <E> BinTree<E> mirror(BinTree<E> in, BinTree<E> out) {
		BinTree<E> left = in.getLeftSubtree(); 
		BinTree<E> right = in.getRightSubtree(); 
		if(right != null) {
			BinTree<E> leftMirror = out.addLeftChild(right.getRoot()); 
			mirror(right, leftMirror); 
		}
		if(left != null) {
			BinTree<E> rightMirror = out.addRightChild(left.getRoot()); 
			mirror(left, rightMirror); 
		}
		return out; 
	}


}


