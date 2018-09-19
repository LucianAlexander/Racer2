import java.util.*;

public class GraphUtil {

	public static void stampa(Graph<Integer, Integer> g) {
		Collection<Vertex<Integer>> vs = g.vertices();
		Iterator<Vertex<Integer>>   i  = vs.iterator();
		while (i.hasNext()) {
			Vertex<Integer> v = i.next();
			System.out.print(v.getElement()+" : ");
			
			Collection<Edge<Integer>> c  = g.outEdges(v);
			if (c != null)  {
				Iterator<Edge<Integer>>   i2 = c.iterator();
				while (i2.hasNext()) {
					Edge<Integer> e = i2.next();
					System.out.print("["+e.getElement()+" - "+g.getSourceSide(e).getElement()+"->"+g.getDestinationSide(e).getElement()+"] ");
				}
			}				
			
			System.out.println();
		}
	}

	public static List<EdgeLabel<Integer>> dfsLabel(Graph<Integer, Integer> g, Integer source) {
		List<EdgeLabel<Integer>> dfs = new LinkedList<EdgeLabel<Integer>>();
		HashSet<Vertex<Integer>> v_exp = new HashSet<Vertex<Integer>>();
		HashSet<Edge<Integer>> e_exp   = new HashSet<Edge<Integer>>();		
		
		Collection<Vertex<Integer>> vertices = g.vertices();
		Iterator<Vertex<Integer>>    i = vertices.iterator();
		while (i.hasNext()) {
			Vertex<Integer> v = i.next();
			if (v.getElement().equals(source)) {
				dfs = dfsLabel(g, v, dfs, v_exp, e_exp);
				break;
			}
		}
		
		return dfs;
	}		
	
	public static List<EdgeLabel<Integer>> dfsLabel(Graph<Integer, Integer> g, Vertex<Integer> source, List<EdgeLabel<Integer>> dfs, HashSet<Vertex<Integer>> v_exp, HashSet<Edge<Integer>> e_exp) {
		v_exp.add(source);
		Collection<Edge<Integer>> c  = g.outEdges(source);
		if (c != null)  {
			Iterator<Edge<Integer>> i = c.iterator();
			while (i.hasNext()) {			
				Edge<Integer> e = i.next();
				if (!e_exp.contains(e)) {
					e_exp.add(e);
					EdgeLabel el = new EdgeLabel(e);
					Vertex<Integer> v = g.getDestinationSide(e);
					if (!v_exp.contains(v)) {
						el.setDiscovery();
						dfs.add(el);
						dfsLabel(g, v, dfs, v_exp, e_exp);
					}
					else {
						el.setBack();
						dfs.add(el);
					}
				}				
			}
		}				
		return dfs;
	}	
	
	public static void main(String[] args) {
		Graph<Integer, Integer> gra = new GraphImpl<Integer, Integer>();
		Vertex<Integer> a = new VertexImpl(new Integer(1));
		Vertex<Integer> b = new VertexImpl(new Integer(2));		
		Vertex<Integer> c = new VertexImpl(new Integer(3));		
		Vertex<Integer> d = new VertexImpl(new Integer(4));
		Vertex<Integer> e = new VertexImpl(new Integer(5));
		Vertex<Integer> f = new VertexImpl(new Integer(6));
		Vertex<Integer> g = new VertexImpl(new Integer(7));		
		Vertex<Integer> h = new VertexImpl(new Integer(8));		
		
		gra.insertEdge(new EdgeImpl(new Integer(11), a, b));
		gra.insertEdge(new EdgeImpl(new Integer(12), b, c));
		gra.insertEdge(new EdgeImpl(new Integer(13), c, d));
		gra.insertEdge(new EdgeImpl(new Integer(13), d, b));		
		gra.insertEdge(new EdgeImpl(new Integer(14), e, f));

		stampa(gra);
		System.out.println();

		Collection<Edge<Integer>> edges = gra.edges();
		print(edges, gra);
		System.out.println();		
		
		Edge<Integer> edge = gra.getEdge(a,b);
		System.out.println(gra.getSourceSide(edge).getElement()+" -> "+gra.getDestinationSide(edge).getElement());		
		System.out.println();		

		Collection<Edge<Integer>> oute = gra.outEdges(b);
		print(oute, gra);
		System.out.println();		

		Collection<Vertex<Integer>> outv = gra.outVertices(b);		
		print(outv);
		System.out.println();
		
		gra.removeEdge(gra.getEdge(e,f));
		stampa(gra);
		System.out.println();		
		
		Collection<Vertex<Integer>> vertices = gra.vertices();		
		print(vertices);
		System.out.println();		
		
		System.out.println(gra.areAdjacent(a, b));		
		System.out.println(gra.areAdjacent(a, d));		
		System.out.println();
		
		List<EdgeLabel<Integer>> dfslist = dfsLabel(gra, 1);
		print(dfslist, gra);
		
	}

	private static void print(Collection<Edge<Integer>> c, Graph<Integer, Integer> g) {
		Iterator<Edge<Integer>>   i = c.iterator();
		while (i.hasNext()) {
			Edge<Integer> e = i.next();
			System.out.println(g.getSourceSide(e).getElement()+" -> "+g.getDestinationSide(e).getElement());
		}
	}	
	
	private static void print(Collection<Vertex<Integer>> c) {
		Iterator<Vertex<Integer>>   i = c.iterator();
		while (i.hasNext()) {
			Vertex<Integer> e = i.next();
			System.out.println(e.getElement());
		}
	}	
	
	private static void print(List<EdgeLabel<Integer>> c, Graph<Integer, Integer> g) {
		Iterator<EdgeLabel<Integer>>   i = c.iterator();
		while (i.hasNext()) {
			EdgeLabel<Integer> e = i.next();
			System.out.println("["+g.getSourceSide(e.getEdge()).getElement()+"->"+g.getDestinationSide((e.getEdge())).getElement()+" back:"+e.isBack()+" discovery:"+e.isDiscovery()+" ] ");
		}
	}		
}