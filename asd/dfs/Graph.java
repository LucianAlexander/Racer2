import java.util.*;

public class Graph<V> {

	enum Status { UNEXPLORED, EXPLORED, EXPLORING }

	HashMap<Node<V>, List<Node<V>>> graph;

	public Graph() {
		graph = new HashMap<Node<V>, List<Node<V>>>();
	}

    /**
     * restituisce i nodi del grafo
     *
     */
	public Collection<Node<V>> getNodes() {
		return graph.keySet();
	}

	/**
     * restituisce la lista di adiacenza di un nodo
     *
     */
	public Collection<Node<V>> getOutEdges(Node<V> source) {
		return graph.get(source);
	}

	 /**
     * aggiunge un nuovo arco al grafo
     *
     */
    public void insertEdge(Node<V> source, Node<V> destination) throws Exception {
		if (! (graph.containsKey(source) &&
			   graph.containsKey(destination)) )
			throw new Exception("Nodo non presente nel grafo");

		graph.get(source).add(destination);
	}

    /**
     * aggiunge un nuovo nodo al grafo
     *
     */
    public void insertNode(Node<V> v) {
		if (! graph.containsKey(v))
			graph.put(v, new LinkedList<Node<V>>());
	}

	/**
     * esegue una dfs
     *
     */
	public void dfs() {
	    HashMap<Node<V>, Status> status = new HashMap<Node<V>, Status>();
		HashMap<Node<V>, Integer> timest = new HashMap<Node<V>, Integer>();
		for (Node<V> u : getNodes()) {
			status.put(u, Status.UNEXPLORED);
			timest.put(u, 0);
		}
		int loctime = 0;
		for (Node<V> v : getNodes()) {
			System.out.println("Root "+v);
			loctime += sweep(v, status, timest, loctime);
		}
	}

	private int sweep(Node<V> source, HashMap<Node<V>, Status> status, HashMap<Node<V>, Integer> timest, int time) {
		if (status.get(source) != Status.UNEXPLORED) return 0;

		int loctime = 1;
		status.put(source, Status.EXPLORING);
		timest.put(source, time);
		for (Node<V> u : getOutEdges(source)) {
			System.out.print(source+"("+timest.get(source)+")->"+u+"("+timest.get(u)+") ");

			if(status.get(u) == Status.EXPLORED) {
				if (timest.get(source) < timest.get(u))
					 System.out.println("FORW");
				else System.out.println("CROS");
				continue;
			}
			if(status.get(u) == Status.EXPLORING) {
				System.out.println("BACK");
				continue;
			}

			System.out.println("TREE");
			loctime += sweep(u, status, timest, time+loctime);
		}
		status.put(source, Status.EXPLORED);
		return loctime;
	}

}
......................----------------------
import java.util.*;

public class Graph<V> {

	enum Status { UNEXPLORED, EXPLORED, EXPLORING }

	HashMap<Node<V>, List<Node<V>>> graph;

	public Graph() {
		graph = new HashMap<Node<V>, List<Node<V>>>();
	}

    /**
     * restituisce i nodi del grafo
     *
     */
	public Collection<Node<V>> getNodes() {
		return graph.keySet();
	}

	/**
     * restituisce la lista di adiacenza di un nodo
     *
     */
	public Collection<Node<V>> getOutEdges(Node<V> source) {
		return graph.get(source);
	}

	 /**
     * aggiunge un nuovo arco al grafo
     *
     */
    public void insertEdge(Node<V> source, Node<V> destination) throws Exception {
		if (! (graph.containsKey(source) &&
			   graph.containsKey(destination)) )
			throw new Exception("Nodo non presente nel grafo");

		graph.get(source).add(destination);
	}

    /**
     * aggiunge un nuovo nodo al grafo
     *
     */
    public void insertNode(Node<V> v) {
		if (! graph.containsKey(v))
			graph.put(v, new LinkedList<Node<V>>());
	}

	/**
     * esegue una dfs
     *
     */
	public void dfs() {
	    HashMap<Node<V>, Status> status = new HashMap<Node<V>, Status>();
		HashMap<Node<V>, Integer> timest = new HashMap<Node<V>, Integer>();
		for (Node<V> u : getNodes()) {
			status.put(u, Status.UNEXPLORED);
			timest.put(u, 0);
		}
		int loctime = 0;
		for (Node<V> v : getNodes()) {
			System.out.println("Root "+v);
			loctime += sweep(v, status, timest, loctime);
		}
	}

	private int sweep(Node<V> source, HashMap<Node<V>, Status> status, HashMap<Node<V>, Integer> timest, int time) {
		if (status.get(source) != Status.UNEXPLORED) return 0;

		int loctime = 1;
		status.put(source, Status.EXPLORING);
		timest.put(source, time);
		for (Node<V> u : getOutEdges(source)) {
			System.out.print(source+"("+timest.get(source)+")->"+u+"("+timest.get(u)+") ");

			if(status.get(u) == Status.EXPLORED) {
				if (timest.get(source) < timest.get(u))
					 System.out.println("FORW");
				else System.out.println("CROS");
				continue;
			}
			if(status.get(u) == Status.EXPLORING) {
				System.out.println("BACK");
				continue;
			}

			System.out.println("TREE");
			loctime += sweep(u, status, timest, time+loctime);
		}
		status.put(source, Status.EXPLORED);
		return loctime;
	}

}
                                  
