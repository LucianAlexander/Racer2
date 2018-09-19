import java.util.*;

public class Kruskal {

	public static Graph computeKruskal(Graph G) {
		Partition P;
		MinHeap<Edge> Q;
		Graph T;

		P = new Partition(G.getNodes());

		Q = new MinHeap<Edge>();
		for(Edge e : G.getEdges())
			Q.insert(e.getWeight(), e);

		T = new Graph();
		for(Integer v : G.getNodes())
			T.insertNode(v);

		while(!Q.isEmpty())	{
			Edge e = Q.removeMin().getValue();
			Integer u = e.getSource(), v = e.getTarget();
			if(P.find(u) != P.find(v)) {
				T.insertEdge(u, v, e.getWeight());
				P.union(u,v);
			}
		}

		return T;
	}

}
-----------------------
import java.util.*;

public class Kruskal {

	public static Graph computeKruskal(Graph G) {
		Partition P;
		MinHeap<Edge> Q;
		Graph T;

		P = new Partition(G.getNodes());

		Q = new MinHeap<Edge>();
		for(Edge e : G.getEdges())
			Q.insert(e.getWeight(), e);

		T = new Graph();
		for(Integer v : G.getNodes())
			T.insertNode(v);

		while(!Q.isEmpty())	{
			Edge e = Q.removeMin().getValue();
			Integer u = e.getSource(), v = e.getTarget();
			if(P.find(u) != P.find(v)) {
				T.insertEdge(u, v, e.getWeight());
				P.union(u,v);
			}
		}

		return T;
	}

}
