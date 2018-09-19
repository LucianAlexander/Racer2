import java.util.*;

public class Test {

	public static void main(String[] args) throws Exception {
		
		Graph<String> gra = new Graph<String>();

		Node<String> a = new Node<String>("a");
		Node<String> b = new Node<String>("b");	
		Node<String> c = new Node<String>("c");
		Node<String> d = new Node<String>("d");	
		Node<String> e = new Node<String>("e");
		Node<String> f = new Node<String>("f");	
		Node<String> g = new Node<String>("g");
		Node<String> h = new Node<String>("h");		
		
		gra.insertNode(a); 
		gra.insertNode(b); 
		gra.insertNode(c);
		gra.insertNode(d);
		gra.insertNode(e);
        gra.insertNode(f);
        gra.insertNode(g);
        gra.insertNode(h); 		
		
		gra.insertEdge(a,b);
		gra.insertEdge(a,f);
		gra.insertEdge(b,c);
		gra.insertEdge(b,f);
		gra.insertEdge(c,d);
		gra.insertEdge(d,b);		
		gra.insertEdge(e,f);
		gra.insertEdge(f,c);
		
		System.out.println("Grafo");
		GraphUtil.stampa(gra);
		System.out.println();
		
		System.out.println("Visita in profondita");
		gra.dfs(); 
	}
	
}