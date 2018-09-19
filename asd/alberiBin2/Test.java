
import java.util.*;

public class Test {

	public static void main(String[] args) {

		BinTree<String> t = new BinTree<String>("A");
		BinTree<String> e = t.addRightChild("E");
		BinTree<String> b = t.addLeftChild("B");

		e.addRightChild("F");
		b.addRightChild("D");
		b.addLeftChild("C");

		System.out.println("Stampa albero");
		BinTreeUtil.print(t);
		System.out.print("\n");

		System.out.println("Padre di "+e.getRoot()+": "+e.getParent().getRoot());
		System.out.print("\n");

		System.out.println("Visita simmetrica");
		BinTreeUtil.printInorder(t);
		System.out.println("\n");

		System.out.println("Stampa per livelli");
		BinTreeUtil.printLivelli(t);
		System.out.print("\n");

		System.out.println("Stampa albero speculare");
		BinTreeUtil.print(BinTreeUtil.mirror(t));

	}

}

---------------------------------

import java.util.*;

public class Test {

	public static void main(String[] args) {

		BinTree<String> t = new BinTree<String>("A");
		BinTree<String> e = t.addRightChild("E");
		BinTree<String> b = t.addLeftChild("B");

		e.addRightChild("F");
		b.addRightChild("D");
		b.addLeftChild("C");

		System.out.println("Stampa albero");
		BinTreeUtil.print(t);
		System.out.print("\n");

		System.out.println("Padre di "+e.getRoot()+": "+e.getParent().getRoot());
		System.out.print("\n");

		System.out.println("Visita simmetrica");
		BinTreeUtil.printInorder(t);
		System.out.println("\n");

		System.out.println("Stampa per livelli");
		BinTreeUtil.printLivelli(t);
		System.out.print("\n");

		System.out.println("Stampa albero speculare");
		BinTreeUtil.print(BinTreeUtil.mirror(t));

	}

}
