import java.util.*;

public class GraphUtil {

	public static void stampa(Graph<String, Integer> g) {
		Collection<Vertex<String>> vs = g.vertices();
		Iterator<Vertex<String>>   i  = vs.iterator();
		while (i.hasNext()) {
			Vertex<String> v = i.next();
			System.out.print(v.getElement()+" : ");
			
			Collection<Edge<String,Integer>> c  = g.outEdges(v);
			if (c != null)  {
				Iterator<Edge<String,Integer>>   i2 = c.iterator();
				while (i2.hasNext()) {
					Edge<String,Integer> e = i2.next();
					System.out.print("["+e.getElement()+" - "+e.getSourceSide().getElement()+"-"+e.getDestinationSide().getElement()+"] ");
				}
			}				
			
			System.out.println();
		}
	}


	public static void dfsRic(Graph<String, Integer> g, Vertex<String> source) {
		System.out.println("DFS: "); 
		dfsRic(g, source, new HashSet<Vertex<String>>()); 
		System.out.println(); 
	} 
	
	private static void dfsRic(Graph<String, Integer> g, Vertex<String> source, HashSet<Vertex<String>> visited) {
		if(visited.contains(source)) return; 
		visited.add(source); 
		System.out.print(source.getElement() + " "); 
		for(Vertex<String> v : g.outVertices(source)) {
			dfsRic(g, v, visited); 
		}
	}
	
	public static void dfs(Graph<String,Integer> g, Vertex<String> source) {
		System.out.println("DFS: "); 
		
		Stack<Vertex<String>> stack = new Stack<Vertex<String>>(); 
		HashSet<Vertex<String>> marked = new HashSet<Vertex<String>>(); 

		stack.push(source); 
		marked.add(source); 
		while(!stack.empty()) {
			Vertex<String> u = stack.pop(); 
			System.out.print(u.getElement() + " "); 
			for(Vertex<String> v : g.outVertices(u)) {
				if(!marked.contains(v)) {
					stack.push(v); 
					marked.add(v); 
				}
			}
		} 
		System.out.println(); 
	}

	public static void bfs(Graph<String,Integer> g, Vertex<String> source) {
		System.out.println("BFS: "); 

		Queue<Vertex<String>> queue = new ArrayDeque<Vertex<String>>(); 
		HashSet<Vertex<String>> marked = new HashSet<Vertex<String>>(); 

		queue.add(source); 
		marked.add(source); 
		while(!queue.isEmpty()) {
			Vertex<String> u = queue.remove(); 
			System.out.print(u.getElement() + " "); 
			for(Vertex<String> v : g.outVertices(u)) {
				if(!marked.contains(v)) {
					queue.add(v); 
					marked.add(v); 
				}
			}
		} 
		System.out.println(); 
	}
	
	static class Distanza implements Comparable {
		
		private Vertex<String> n;
		private Integer		   d;
	
		Distanza(Vertex<String> n, Integer d) {
			this.n = n;
			this.d = d;
		}
		
		Distanza(Vertex<String> n) {
			this.n = n;
			this.d = null; // oo
		}	

		Distanza(Vertex<String> n, Integer d, Distanza offset) {
			this.n = n;
			if (offset.isInfty()) 
				this.d = null;
			else
				this.d = offset.getDistanza() + d;
		}		
		
		public Integer getDistanza() {
			return d;
		}
		
		public Vertex<String> getVertex() {
			return n;
		}	

		private boolean isInfty() {
			return d == null;
		}					

		public int compareTo(Object c) {
			Distanza d   = (Distanza) c;
			if (this.isInfty()) return 1;
			if (d.isInfty())    return -1;
			int confronto = this.getDistanza() - d.getDistanza();
			return confronto;
		}	
		
		public String toString() {
			if (this.isInfty()) return n.getElement() +" oo";
			return n.getElement() +" "+ d;
		}
	}	

	public static void sssp(Graph<String,Integer> g, Vertex<String> source) {
		System.out.println("SSSP: "); 

		PriorityQueue<Distanza> Q = new PriorityQueue<Distanza>();
		HashMap<Vertex<String>,
		              Distanza> D = new HashMap<Vertex<String>, Distanza>(); 
		// init
		Collection<Vertex<String>> vs = g.vertices();
		Iterator<Vertex<String>>   i  = vs.iterator();
		while (i.hasNext()) {
			Vertex<String> v = i.next();
			Distanza       d;
			if (v == source) d = new Distanza(v,0);
			else			 d = new Distanza(v); // oo
			D.put(v,d);
			Q.offer(d);
		}
		// dijkstra
		while (Q.size() > 0) {
		    Distanza      du = Q.poll();
			Vertex<String> u = du.getVertex();
			System.out.println(du); 
			for(Edge<String, Integer> e : g.outEdges(u)) {
				Vertex<String> v   = e.getDestinationSide() != u ? e.getDestinationSide() : e.getSourceSide();
				Distanza       dv  = D.get(v);
				Distanza       dv2 = new Distanza(v, e.getElement(), du);
				if (dv2.compareTo(dv) < 0) {
					//D.remove(v);
					Q.remove(dv);
					D.put(v, dv2);
					Q.offer(dv2);
				}
			}			
		}
		// stampa
		/*
		Collection<Distanza> ds = D.values();		
		Iterator<Distanza>   di = ds.iterator();
		while (di.hasNext()) {	
			Distanza       d = di.next();
			System.out.println(d); 		
		}
		*/		
	}
	
	public static void main(String[] args) {
		Graph<String, Integer> gra = new GraphImpl<String, Integer>();

		Vertex<String> a = new VertexImpl<String>("a");
		Vertex<String> b = new VertexImpl<String>("b");		
		Vertex<String> c = new VertexImpl<String>("c");		
		Vertex<String> d = new VertexImpl<String>("d");
		Vertex<String> e = new VertexImpl<String>("e");
		Vertex<String> f = new VertexImpl<String>("f");
		
		gra.insertVertex(a); 		
		gra.insertVertex(b); 		
		gra.insertVertex(c); 		
		gra.insertVertex(d); 		
		gra.insertVertex(e); 		
		gra.insertVertex(f); 		

		// usiamo il campo dati "element" per il peso dell'arco per semplicità 
		gra.insertEdge(new EdgeImpl<String,Integer>(new Integer(2), a, b));
		gra.insertEdge(new EdgeImpl<String,Integer>(new Integer(1), a, c));
		gra.insertEdge(new EdgeImpl<String,Integer>(new Integer(5), a, d));
		gra.insertEdge(new EdgeImpl<String,Integer>(new Integer(2), b, c));
		gra.insertEdge(new EdgeImpl<String,Integer>(new Integer(3), b, d));
		gra.insertEdge(new EdgeImpl<String,Integer>(new Integer(3), c, d));
		gra.insertEdge(new EdgeImpl<String,Integer>(new Integer(1), c, e));		
		gra.insertEdge(new EdgeImpl<String,Integer>(new Integer(1), d, e));
		gra.insertEdge(new EdgeImpl<String,Integer>(new Integer(5), d, f));		
		gra.insertEdge(new EdgeImpl<String,Integer>(new Integer(2), e, f));		
		
		stampa(gra);
		System.out.println();
		
		// Test per DFS, BFS e sssp
		dfs(gra, a); 
		dfs(gra, b); 
		bfs(gra, a); 
		sssp(gra, a);
		/*
		*/

	}
	
}




