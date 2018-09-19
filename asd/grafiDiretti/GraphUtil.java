import java.util.*;

public class GraphUtil {

	public static void stampa(Graph<Integer, Integer> g) {
		Collection<Vertex<Integer>> vs = g.vertices();
		Iterator<Vertex<Integer>>   i  = vs.iterator();
		while (i.hasNext()) {
			Vertex<Integer> v = i.next();
			System.out.print(v.getElement()+" : ");
			
			Collection<Edge<Integer,Integer>> c  = g.outEdges(v);
			if (c != null)  {
				Iterator<Edge<Integer,Integer>>   i2 = c.iterator();
				while (i2.hasNext()) {
					Edge<Integer,Integer> e = i2.next();
					System.out.print("["+e.getElement()+" - "+e.getSourceSide().getElement()+"->"+e.getDestinationSide().getElement()+"] ");
				}
			}				
			
			System.out.println();
		}
	}


	public static void dfsRic(Graph<Integer, Integer> g, Vertex<Integer> source) {
		System.out.println("DFS: "); 
		dfsRic(g, source, new HashSet<Vertex<Integer>>()); 
		System.out.println(); 
	} 
	
	private static void dfsRic(Graph<Integer, Integer> g, Vertex<Integer> source, HashSet<Vertex<Integer>> visited) {
		if(visited.contains(source)) return; 
		visited.add(source); 
		System.out.print(source.getElement() + " "); 
		for(Vertex<Integer> v : g.outVertices(source)) {
			dfsRic(g, v, visited); 
		}
	}
	
	public static void dfs(Graph<Integer,Integer> g, Vertex<Integer> source) {
		System.out.println("DFS: "); 
		
		Stack<Vertex<Integer>> stack = new Stack<Vertex<Integer>>(); 
		HashSet<Vertex<Integer>> marked = new HashSet<Vertex<Integer>>(); 

		stack.push(source); 
		marked.add(source); 
		while(!stack.empty()) {
			Vertex<Integer> u = stack.pop(); 
			System.out.print(u.getElement() + " "); 
			for(Vertex<Integer> v : g.outVertices(u)) {
				if(!marked.contains(v)) {
					stack.push(v); 
					marked.add(v); 
				}
			}
		} 
		System.out.println(); 
	}

	public static void bfs(Graph<Integer,Integer> g, Vertex<Integer> source) {
		System.out.println("BFS: "); 

		Queue<Vertex<Integer>> queue = new ArrayDeque<Vertex<Integer>>(); 
		HashSet<Vertex<Integer>> marked = new HashSet<Vertex<Integer>>(); 

		queue.add(source); 
		marked.add(source); 
		while(!queue.isEmpty()) {
			Vertex<Integer> u = queue.remove(); 
			System.out.print(u.getElement() + " "); 
			for(Vertex<Integer> v : g.outVertices(u)) {
				if(!marked.contains(v)) {
					queue.add(v); 
					marked.add(v); 
				}
			}
		} 
		System.out.println(); 
	}
	
	
	public static void main(String[] args) {
		Graph<Integer, Integer> gra = new GraphImpl<Integer, Integer>();

		Vertex<Integer> a = new VertexImpl<Integer>(new Integer(1));
		Vertex<Integer> b = new VertexImpl<Integer>(new Integer(2));		
		Vertex<Integer> c = new VertexImpl<Integer>(new Integer(3));		
		Vertex<Integer> d = new VertexImpl<Integer>(new Integer(4));
		Vertex<Integer> e = new VertexImpl<Integer>(new Integer(5));
		Vertex<Integer> f = new VertexImpl<Integer>(new Integer(6));
		Vertex<Integer> g = new VertexImpl<Integer>(new Integer(7));		
		Vertex<Integer> h = new VertexImpl<Integer>(new Integer(8));		
		
		gra.insertVertex(a); 		
		gra.insertVertex(b); 		
		gra.insertVertex(c); 		
		gra.insertVertex(d); 		
		gra.insertVertex(e); 		
		gra.insertVertex(f); 		
		gra.insertVertex(g); 
		gra.insertVertex(h); 

		gra.insertEdge(new EdgeImpl<Integer,Integer>(new Integer(11), a, b));
		gra.insertEdge(new EdgeImpl<Integer,Integer>(new Integer(15), a, f));
		gra.insertEdge(new EdgeImpl<Integer,Integer>(new Integer(12), b, c));
		gra.insertEdge(new EdgeImpl<Integer,Integer>(new Integer(13), c, d));
		gra.insertEdge(new EdgeImpl<Integer,Integer>(new Integer(13), d, b));		
		gra.insertEdge(new EdgeImpl<Integer,Integer>(new Integer(14), e, f));

		stampa(gra);
		System.out.println();
		
		// Test per DFS e BFS
		dfs(gra, a); 
		dfs(gra, b); 
		bfs(gra, a); 
		/*
		*/

	}
	
}




