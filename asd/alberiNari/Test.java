
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



