import java.util.*;

public class Mirror {
	
	public static <E> BPosition<E> mirror(BPosition<E> r, BPosition<E> rMirror) {
		BPosition<E> left = r.getLeftChild(); 
		BPosition<E> right = r.getRightChild(); 
		if(right != null) {
			BPosition<E> leftMirror = rMirror.setLeftChild(right.getElement()); 
			mirror(right, leftMirror); 
		}
		if(left != null) {
			BPosition<E> rightMirror = rMirror.setRightChild(left.getElement()); 
			mirror(left, rightMirror); 
		}
		return rMirror; 
	}
	
	public static <E> BTree<E> mirror(BTree<E> t) {
		BTree<E> tMirror = new MyBTree<E>(); 
		if(t.isEmpty()) return tMirror; 
		tMirror.setRoot(t.getRoot().getElement()); 
		mirror(t.getRoot(), tMirror.getRoot()); 
		return tMirror; 
	}
	

	public static void main(String[] args) {
	
		// semplice albero binario
	
		MyBTree<Integer> t             = new MyBTree<Integer>();
		BPosition<Integer> root        = t.setRoot(100);
		BPosition<Integer> cL          = root.setLeftChild(20);
		BPosition<Integer> cR          = root.setRightChild(230);

		cL.setLeftChild(1);
		cL.setRightChild(2);
		cR.setLeftChild(3);

		System.out.println("Stampa Albero");
		BTreeUtil.stampa(t);
		
		System.out.println("Stampa Albero Speculare");
		BTree<Integer> mirr = mirror(t); 
		BTreeUtil.stampa(mirr); 
	}

}