import java.util.LinkedList;
import java.util.List;

public class GraphServices<V>{

  public static <V> void sweep(Graph<V> g) {
	  List<Graph.GraphNode<V>> nodes = g.getNodes();
	  for(Graph.GraphNode<V> node : nodes){
		  node.state = Graph.GraphNode.Status.UNEXPLORED;
		  node.timestamp = 0;
	  }

	  int loctime = 0;
	  for(Graph.GraphNode<V> node : nodes) {
		  System.out.println("Root " + g.getNodeValue(node));
		  loctime += sweep_aux(node, loctime);
	  }
  }

  private static <V> int sweep_aux(Graph.GraphNode<V> node, int time) {
	if(node.state != Graph.GraphNode.Status.UNEXPLORED)
		return 0;
	int loctime = 1;
	node.state = Graph.GraphNode.Status.EXPLORING;
	node.timestamp = time;

	for(Graph.GraphNode<V> cur : node.outEdges) {
		System.out.print("\t" + node.value + "(" + node.timestamp + ")->" + cur.value + "(" + cur.timestamp + ")");
		if (cur.state == Graph.GraphNode.Status.EXPLORED) {
			if (node.timestamp < cur.timestamp)
				System.out.println("FORWARD");
			else
				System.out.println("CROSS");
		}
		else if (cur.state == Graph.GraphNode.Status.EXPLORING) {
			System.out.println("BACK");
		}
		else {
			System.out.println("TREE");
			loctime += sweep_aux(cur, time + 1);
		}
	}
	node.state = Graph.GraphNode.Status.EXPLORED;
	return loctime;
  }

	public static <V> void topologicalSort(Graph<V> g) {
		List<Graph.GraphNode<V>> nodes = g.getNodes();
		for(Graph.GraphNode<V> node : nodes){
			node.state = Graph.GraphNode.Status.UNEXPLORED;
			node.timestamp = 0;
		}
		LinkedList<Graph.GraphNode<V>> ts = new LinkedList<Graph.GraphNode<V>>();

		for(Graph.GraphNode<V> nd : g.getNodes()) {
			if(nd.state == Graph.GraphNode.Status.UNEXPLORED) {
				if(DDFS(nd, ts) > 0) {
					System.out.println("Impossibile ottenere ordine topologico, il grafo non � un DAG");
					return;
				}
			}
		}
		for(Graph.GraphNode<V> nd : ts) {
			System.out.print(nd.value + " ");
		}
		System.out.println("");
	}

  private static<V> int DDFS(Graph.GraphNode<V> nd, LinkedList<Graph.GraphNode<V>> ts) {
	  if(nd.state == Graph.GraphNode.Status.EXPLORING)
		  return 1;
	  if(nd.state == Graph.GraphNode.Status.EXPLORED)
		  return 0;
	  nd.state = Graph.GraphNode.Status.EXPLORING;
	  int ret = 0;
	  for(Graph.GraphNode<V> cur : nd.outEdges) {
		  ret += DDFS(cur, ts);
	  }
	  nd.state = Graph.GraphNode.Status.EXPLORED;
	  ts.addFirst(nd);
	  return ret;
  }

	public static <V> void strongConnectedComponents(Graph<V> g) {
		// Reset node's status
		List<Graph.GraphNode<V>> nodes = g.getNodes();
		for(Graph.GraphNode<V> node : nodes){
			node.state = Graph.GraphNode.Status.UNEXPLORED;
			node.timestamp = 0;
		}
		// First DFS
		LinkedList<Graph.GraphNode<V>> stack = new LinkedList<>();
		for(Graph.GraphNode<V> n : g.getNodes()) {
			if(n.state == Graph.GraphNode.Status.UNEXPLORED)
				DDFS(n, stack);
		}
		// Reset node's status
		for(Graph.GraphNode<V> node : nodes){
			node.state = Graph.GraphNode.Status.UNEXPLORED;
			node.timestamp = 0;
		}
		// Second DFS on the transposed graph
		for(Graph.GraphNode<V> n : stack) {
			if(n.state == Graph.GraphNode.Status.UNEXPLORED) {
				LinkedList<Graph.GraphNode<V>> ret = new LinkedList<>();
				transposedDFS(g, n, ret);
				System.out.println("Strong connected component:");
				for(Graph.GraphNode<V> cur : ret) {
					System.out.print(cur.value + " ");
				}
				System.out.println("");
			}
		}
	  }

	private static<V> void transposedDFS(Graph<V> g, Graph.GraphNode<V> n, LinkedList<Graph.GraphNode<V>> ret) {
		if(n.state != Graph.GraphNode.Status.UNEXPLORED)
			return;
		n.state = Graph.GraphNode.Status.EXPLORING;
		for(Graph.GraphNode<V> to : g.getNodes()) {
			for(Graph.GraphNode<V> frm : to.outEdges) {
				if(frm == n)
					transposedDFS(g, to, ret);
			}
		}
		ret.addLast(n);
		n.state = Graph.GraphNode.Status.EXPLORED;
	}
}
--------------------------------------------------
import java.util.*;

public class GraphServices {

	public static <V> void bfs(Graph<V> g) {
		for(Node<V> n : g.getNodes()) {
			if(n.stato == Node.Stato.UNEXPLORED)
				bfsFromNode(g, n);
		}
	}

	private static <V> void bfsFromNode(Graph<V> g, Node<V> source) {
		if(!(source.stato == Node.Stato.UNEXPLORED))
			return;

		Queue<Node<V>> queue = new ArrayDeque<Node<V>>();
		source.stato = Node.Stato.EXPLORING;
		System.out.println(source.getElement());

		queue.add(source);
		while(!queue.isEmpty()) {
			Node<V> u = queue.remove();
			for(Edge<V> e : g.getOutEdges(u)) {
				Node<V> v = e.getTarget();
				if(v.stato == Node.Stato.UNEXPLORED) {
					queue.add(v);
					bfsFromNode(g, v);
				}
			}
		}
		source.stato = Node.Stato.EXPLORED;
	}

	public static <V> void sssp(Graph<V> g, Node<V> source) {
		MinHeap<Node<V>> pqueue = new MinHeap<Node<V>>();
		HashMap<Node<V>, HeapEntry<Node<V>>> dist = new HashMap<Node<V>, HeapEntry<Node<V>>>();

		final int INFINITY = 100000; // = "Infinito"
		// (NB.: deve essere maggiore della somma di tutti i pesi del grafo, altrimenti e' scorretto)

		// Inizializzazione
		for(Node<V> u : g.getNodes()) {
			HeapEntry<Node<V>> hu = pqueue.insert(u == source ? 0 : INFINITY, u);
			dist.put(u, hu);
		}

		// Ciclo principale
		while (!pqueue.isEmpty()) {
			HeapEntry<Node<V>> hu = pqueue.removeMin();
			Node<V> u = hu.getValue();

			for(Edge<V> e : g.getOutEdges(u)) {
				Node<V> v = e.getTarget();
				if (dist.get(u).getKey() + e.getWeight() < dist.get(v).getKey()) {
					pqueue.replaceKey(dist.get(v), dist.get(u).getKey() + e.getWeight());
				}
			}
		}

		for(Node<V> u : g.getNodes()) {
			System.out.println(u + " " + dist.get(u).getKey());
		}
	}

	public static <V> void mst(Graph<V> G) {
		Partition<V> P;
		MinHeap<Edge<V>> Q;

		int i = 0;
		for(Node<V> n : G.getNodes()) {
			n.map = i++;
		}

		P = new Partition<V>(G.getNodes());
		Q = new MinHeap<Edge<V>>();
		for(Edge<V> e : G.getEdges())
			Q.insert(e.getWeight(), e);

		while(!Q.isEmpty())	{
			Edge<V> e = Q.removeMin().getValue();
			Node<V> u = e.getSource(), v = e.getTarget();
			if(P.find(u.map) != P.find(v.map)) {
				System.out.println(u.getElement() + " " + v.getElement());
				P.union(u.map,v.map);
			}
		}
	}
}
-
-------------------
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("unused")
public class GraphServices {

	/**
	* Ritorna la lista degli archi di g.
	*/
	public static List<GraphEdge> getEdges(Graph g){
		/*DA IMPLEMENTARE*/
		return null;
	}


	/**
	* Ritorna 1 se il grafo g e' connesso, 0 altrimenti.
	*/
	public static int isConnected(Graph g) {
		/*DA IMPLEMENTARE*/
		return 0;
	}


	/**
	* Ritorna 1 se il grafo g e' 1-connesso, 0 altrimenti.
	*/
	public static int is1Connected(Graph g) {
		/*DA IMPLEMENTARE*/
		return 0;
	}
}
