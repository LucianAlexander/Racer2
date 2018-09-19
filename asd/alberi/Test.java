
import java.util.*;

public class Test {

	public static void main(String[] args) {

		Tree<String> t = new Tree<String>("R");
		Tree<String> a = t.addChild("A");
		Tree<String> b = t.addChild("B");

		a.addChild("u");
		a.addChild("v");

		b.addChild("x");
		b.addChild("y");
		b.addChild("z");

		System.out.println("Stampa Albero");
		TreeUtil.print(t);
		System.out.println("\n");

		System.out.println("Visita in Preordine");
		TreeUtil.printPreorder(t);
		System.out.println("\n");

		System.out.println("Visita in Postordine");
		TreeUtil.printPostorder(t);
		System.out.println("\n");

		System.out.println("Visita in Preordine con Iteratore");
		Iterator<Tree<String>> itPre = new PreOrderIterator<String>(t);
		while(itPre.hasNext()) System.out.print(itPre.next().getRoot() + " ");
		System.out.println("\n");

		System.out.println("Visita in Postordine con Iteratore");
		Iterator<Tree<String>> itPost = new PostOrderIterator<String>(t);
		while(itPost.hasNext()) System.out.print(itPost.next().getRoot() + " ");
		System.out.println();

	}

}
----------------------------------------------


import java.util.*;

public class Test {

	public static void main(String[] args) throws Exception {

		System.out.println("Inserire Albero");

		Tree<Integer> t = TreeParser.readTree();
		System.out.println("Parsing Albero");
		TreeUtil.print(t);

		MinHeap<String> h = new MinHeap<String>();

		h.insert(1, "Roma");
		h.insert(12, "Milano");
		h.insert(7, "Bologna");
		h.insert(5, "Firenze");

		System.out.println("Stampa Heap");
		while(!h.isEmpty())
		   System.out.println(h.removeMin());

		int[] v = { 3, 7, 1, 2, 8, 5, 0, -1, 4, 6 };
		System.out.println(Arrays.toString(v));
		MinHeap.heapsort(v);
		System.out.println(Arrays.toString(v));

		// PER CASA ---------------------------------

		HeapEntry<String> r = h.insert(1, "Roma");
		HeapEntry<String> m = h.insert(12, "Milano");
		HeapEntry<String> b = h.insert(7, "Bologna");
		HeapEntry<String> f = h.insert(5, "Firenze");

		h.remove(b);
		h.replaceKey(m, 3);
		h.replaceValue(f, "Orte");
		System.out.println("Stampa Heap Modificato");
		while(!h.isEmpty())
		   System.out.println(h.removeMin());

	}

}
