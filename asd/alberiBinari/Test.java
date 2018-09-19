
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
--------------------------------

import java.util.*;

public class Test {

	public static void main(String[] args) {

		BSTree<String> b = new BSTree<String>(6, "Pisa");

		b.insert(1, "Roma");
		b.insert(12, "Milano");
		b.insert(7, "Bologna");
		b.insert(5, "Firenze");

		System.out.println("Stampa BST");
		b.print();

		System.out.println();

		System.out.print("Valore associato a 7: ");
		System.out.println(b.find(7));

		System.out.println("remove(7)");
		b.remove(7);

		System.out.print("Valore associato a 7: ");
		System.out.println(b.find(7));

		System.out.println();

		System.out.print("Nodo associato a floor(8): ");
		System.out.println("[chiave: " + b.floor(8) + ", valore: " + b.find(b.floor(8)) + "]");

		System.out.println();

		System.out.println("remove(1)");
		b.remove(1);
		System.out.println("remove(6)");
		b.remove(6);

		System.out.println();

		System.out.println("Stampa BST");
		b.print();

		System.out.println();

		System.out.println("remove(5)");
		b.remove(5);

		System.out.println();

		System.out.println("Stampa BST");
		b.print();

	}

}