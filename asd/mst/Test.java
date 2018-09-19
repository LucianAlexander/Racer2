import java.io.*; 
import java.util.*; 


public class Test {
	public static void main(String[] args) throws Exception {
		System.out.println("*** Test per Partition ***"); 
		ArrayList<Integer> V = new ArrayList<Integer>(); 
		V.add(1); V.add(2); V.add(3); V.add(4); 
		Partition P = new Partition(V); 
		
		System.out.println(P.find(1)); // [1]
		System.out.println(P.find(2)); // [2]
		System.out.println(P.find(3)); // [3]
		System.out.println(P.find(4)); // [4]

		P.union(2,4); 		
		System.out.println(P.find(2)); // [2, 4]
		P.union(1,3); 
		System.out.println(P.find(3)); // [1, 3]
		
		P.union(1,2); 
		System.out.println(P.find(3)); // [1, 3, 2, 4]
		
		System.out.println("*** Test per Kruskal ***"); 
		Graph G = new Graph(); 
		G.insertNode(1); G.insertNode(2); 
		G.insertNode(3); G.insertNode(4); 
		G.insertNode(5); G.insertNode(6); 
		G.insertNode(7); 
		G.insertEdge(1,2, 4);
		G.insertEdge(2,3, 1); 
		G.insertEdge(3,4, 10); 
		G.insertEdge(4,5, 7); 
		G.insertEdge(5,6, 2); 
		G.insertEdge(6,7, 5); 
		G.insertEdge(7,1, 8); 
		G.insertEdge(7,2, 9); 
		G.insertEdge(7,3, 6); 
		G.insertEdge(7,5, 3); 
		 
		Graph T = Kruskal.computeKruskal(G); 
		for(Edge e: T.getEdges()) {
			System.out.println(e); 
		}
	}
}

	