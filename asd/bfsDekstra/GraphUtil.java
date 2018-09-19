

import java.util.*;

public class GraphUtil {

	/*
		Stampa del grafo
	*/
	public static <V> void print(Graph<V> g) {
		for (Node<V> v : g.getNodes()) {
			System.out.print(v + " : ");

			for (Edge<V> u : g.getOutEdges(v)) {
				System.out.print(u+" ");
			}
			System.out.println();
		}
	}

	/*
		Depth-First Search
		(Visita in Profondità)
	*/
	public static <V> void dfs(Graph<V> g, Node<V> source) {
		System.out.println("DFS: ");

		Stack<Node<V>> stack = new Stack<Node<V>>();
		HashSet<Node<V>> marked = new HashSet<Node<V>>();

		stack.push(source);
		marked.add(source);
		while(!stack.empty()) {
			Node<V> u = stack.pop();
			System.out.print(u.getElement() + " ");
			for(Edge<V> e : g.getOutEdges(u)) {
				Node<V> v = e.getTarget();
				if(!marked.contains(v)) {
					stack.push(v);
					marked.add(v);
				}
			}
		}
		System.out.println();
	}


	/*
		Breadth-First Search
		(Visita in Ampiezza)
	*/
	public static <V> void bfs(Graph<V> g, Node<V> source) {
		System.out.println("BFS: ");

		Queue<Node<V>> queue = new ArrayDeque<Node<V>>();
		HashSet<Node<V>> marked = new HashSet<Node<V>>();

		queue.add(source);
		marked.add(source);
		while(!queue.isEmpty()) {
			Node<V> u = queue.remove();
			System.out.print(u.getElement() + " ");
			for(Edge<V> e : g.getOutEdges(u)) {
				Node<V> v = e.getTarget();
				if(!marked.contains(v)) {
					queue.add(v);
					marked.add(v);
				}
			}
		}
		System.out.println();
	}



	/*
		Algoritmo di Dijkstra per Single Source Shortest Path

		Variante che non utilizza il metodo replaceKey del MinHeap
		(inserisce più HeapEntry corrispondenti allo stesso nodo)
	*/
	public static <V> void sssp(Graph<V> g, Node<V> source) {
		System.out.println("SSSP: ");

		MinHeap<Node<V>> pqueue = new MinHeap<Node<V>>();
		HashMap<Node<V>, Integer> dist = new HashMap<Node<V>, Integer>();

		final int INFINITY = 100000; // = "Infinito"
		// (NB.: deve essere maggiore della somma di tutti i pesi del grafo, altrimenti è scorretto)

		// Inizializzazione
		for(Node<V> u : g.getNodes()) {
			if(u == source) {
				pqueue.insert(0, u);
				dist.put(u, 0);
			}
			else {
				pqueue.insert(INFINITY, u);
				dist.put(u, INFINITY);
			}
		}

		// Ciclo principale
		while (!pqueue.isEmpty()) {
			HeapEntry<Node<V>> hu = pqueue.removeMin();
			Node<V> u = hu.getValue();

			for(Edge<V> e : g.getOutEdges(u)) {
				Node<V> v = e.getTarget();
				if (dist.get(u) + e.getWeight() < dist.get(v)) {
					pqueue.insert(dist.get(u) + e.getWeight(), v);
					dist.put(v, dist.get(u) + e.getWeight());
				}
			}
		}

		for(Node<V> u : g.getNodes()) {
			System.out.println(u + " " + dist.get(u));
		}
	}


	/*
		Algoritmo di Dijkstra per Single Source Shortest Path

		Variante che utilizza il metodo replaceKey del MinHeap
		(sfrutta il fatto che le HeapEntry aggiornano da sole la loro posizione nel MinHeap)
	*/
	public static <V> void sssp_fast(Graph<V> g, Node<V> source) {
		System.out.println("SSSP-fast: ");

		MinHeap<Node<V>> pqueue = new MinHeap<Node<V>>();
		HashMap<Node<V>, HeapEntry<Node<V>>> dist = new HashMap<Node<V>, HeapEntry<Node<V>>>();

		final int INFINITY = 100000; // = "Infinito"
		// (NB.: deve essere maggiore della somma di tutti i pesi del grafo, altrimenti è scorretto)

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


	/*
		Test
	*/
	public static void main(String[] args) {
		Graph<String> gra = new Graph<String>();

		Node<String> a = new Node<String>(new String("a"));
		Node<String> b = new Node<String>(new String("b"));
		Node<String> c = new Node<String>(new String("c"));
		Node<String> d = new Node<String>(new String("d"));
		Node<String> e = new Node<String>(new String("e"));
		Node<String> f = new Node<String>(new String("f"));

		gra.insertNode(a);
		gra.insertNode(b);
		gra.insertNode(c);
		gra.insertNode(d);
		gra.insertNode(e);
		gra.insertNode(f);

		gra.insertEdge(a, b, 2);
		gra.insertEdge(a, c, 1);
		gra.insertEdge(a, d, 5);
		gra.insertEdge(b, c, 2);
		gra.insertEdge(b, d, 3);
		gra.insertEdge(c, d, 3);
		gra.insertEdge(c, e, 1);
		gra.insertEdge(e, d, 1);
		gra.insertEdge(d, f, 5);
		gra.insertEdge(e, f, 2);

		print(gra);
		System.out.println();

		// Test per DFS
		dfs(gra, a);
		// Test per BFS
		bfs(gra, a);
		// Test per SSSP (Dijkstra)
		//sssp(gra, a);
		sssp_fast(gra, a);

	}

}
------------------------------------------


import java.util.*;

public class GraphUtil {

	/*
		Stampa del grafo
	*/
	public static <V> void print(Graph<V> g) {
		for (Node<V> v : g.getNodes()) {
			System.out.print(v + " : ");

			for (Edge<V> u : g.getOutEdges(v)) {
				System.out.print(u+" ");
			}
			System.out.println();
		}
	}

	/*
		Depth-First Search
		(Visita in Profondità)
	*/
	public static <V> void dfs(Graph<V> g, Node<V> source) {
		System.out.println("DFS: ");

		Stack<Node<V>> stack = new Stack<Node<V>>();
		HashSet<Node<V>> marked = new HashSet<Node<V>>();

		stack.push(source);
		marked.add(source);
		while(!stack.empty()) {
			Node<V> u = stack.pop();
			System.out.print(u.getElement() + " ");
			for(Edge<V> e : g.getOutEdges(u)) {
				Node<V> v = e.getTarget();
				if(!marked.contains(v)) {
					stack.push(v);
					marked.add(v);
				}
			}
		}
		System.out.println();
	}


	/*
		Breadth-First Search
		(Visita in Ampiezza)
	*/
	public static <V> void bfs(Graph<V> g, Node<V> source) {
		System.out.println("BFS: ");

		Queue<Node<V>> queue = new ArrayDeque<Node<V>>();
		HashSet<Node<V>> marked = new HashSet<Node<V>>();

		queue.add(source);
		marked.add(source);
		while(!queue.isEmpty()) {
			Node<V> u = queue.remove();
			System.out.print(u.getElement() + " ");
			for(Edge<V> e : g.getOutEdges(u)) {
				Node<V> v = e.getTarget();
				if(!marked.contains(v)) {
					queue.add(v);
					marked.add(v);
				}
			}
		}
		System.out.println();
	}



	/*
		Algoritmo di Dijkstra per Single Source Shortest Path

		Variante che non utilizza il metodo replaceKey del MinHeap
		(inserisce più HeapEntry corrispondenti allo stesso nodo)
	*/
	public static <V> void sssp(Graph<V> g, Node<V> source) {
		System.out.println("SSSP: ");

		MinHeap<Node<V>> pqueue = new MinHeap<Node<V>>();
		HashMap<Node<V>, Integer> dist = new HashMap<Node<V>, Integer>();

		final int INFINITY = 100000; // = "Infinito"
		// (NB.: deve essere maggiore della somma di tutti i pesi del grafo, altrimenti è scorretto)

		// Inizializzazione
		for(Node<V> u : g.getNodes()) {
			if(u == source) {
				pqueue.insert(0, u);
				dist.put(u, 0);
			}
			else {
				pqueue.insert(INFINITY, u);
				dist.put(u, INFINITY);
			}
		}

		// Ciclo principale
		while (!pqueue.isEmpty()) {
			HeapEntry<Node<V>> hu = pqueue.removeMin();
			Node<V> u = hu.getValue();

			for(Edge<V> e : g.getOutEdges(u)) {
				Node<V> v = e.getTarget();
				if (dist.get(u) + e.getWeight() < dist.get(v)) {
					pqueue.insert(dist.get(u) + e.getWeight(), v);
					dist.put(v, dist.get(u) + e.getWeight());
				}
			}
		}

		for(Node<V> u : g.getNodes()) {
			System.out.println(u + " " + dist.get(u));
		}
	}


	/*
		Algoritmo di Dijkstra per Single Source Shortest Path

		Variante che utilizza il metodo replaceKey del MinHeap
		(sfrutta il fatto che le HeapEntry aggiornano da sole la loro posizione nel MinHeap)
	*/
	public static <V> void sssp_fast(Graph<V> g, Node<V> source) {
		System.out.println("SSSP-fast: ");

		MinHeap<Node<V>> pqueue = new MinHeap<Node<V>>();
		HashMap<Node<V>, HeapEntry<Node<V>>> dist = new HashMap<Node<V>, HeapEntry<Node<V>>>();

		final int INFINITY = 100000; // = "Infinito"
		// (NB.: deve essere maggiore della somma di tutti i pesi del grafo, altrimenti è scorretto)

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


	/*
		Test
	*/
	public static void main(String[] args) {
		Graph<String> gra = new Graph<String>();

		Node<String> a = new Node<String>(new String("a"));
		Node<String> b = new Node<String>(new String("b"));
		Node<String> c = new Node<String>(new String("c"));
		Node<String> d = new Node<String>(new String("d"));
		Node<String> e = new Node<String>(new String("e"));
		Node<String> f = new Node<String>(new String("f"));

		gra.insertNode(a);
		gra.insertNode(b);
		gra.insertNode(c);
		gra.insertNode(d);
		gra.insertNode(e);
		gra.insertNode(f);

		gra.insertEdge(a, b, 2);
		gra.insertEdge(a, c, 1);
		gra.insertEdge(a, d, 5);
		gra.insertEdge(b, c, 2);
		gra.insertEdge(b, d, 3);
		gra.insertEdge(c, d, 3);
		gra.insertEdge(c, e, 1);
		gra.insertEdge(e, d, 1);
		gra.insertEdge(d, f, 5);
		gra.insertEdge(e, f, 2);

		print(gra);
		System.out.println();

		// Test per DFS
		dfs(gra, a);
		// Test per BFS
		bfs(gra, a);
		// Test per SSSP (Dijkstra)
		//sssp(gra, a);
		sssp_fast(gra, a);

	}

}
