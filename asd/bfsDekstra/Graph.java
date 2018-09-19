import java.util.*;

public class Graph<V> {

	HashMap<Node<V>, List<Edge<V>>> graph;

    /**
     * Costruttore
     *
     */
	public Graph() {
		graph = new HashMap<Node<V>, List<Edge<V>>>();
	}

    /**
     * Restituisce una collezione contenente i nodi del grafo
     *
     */
	public Collection<Node<V>> getNodes() {
		return graph.keySet();
	}

	/**
     * Restituisce una collezione contenente gli archi uscenti dal nodo dato
     *
     */
	public Collection<Edge<V>> getOutEdges(Node<V> source) {
		return graph.get(source);
	}

    /**
     * Aggiunge un nuovo nodo al grafo
     *
     */
    public void insertNode(Node<V> v) {
		if (! graph.containsKey(v))
			graph.put(v, new LinkedList<Edge<V>>());
	}

	 /**
     * Aggiunge un nuovo arco (pesato) al grafo tra il nodo source e il nodo destination, di peso weight
     *
     */
    public void insertEdge(Node<V> source, Node<V> destination, Integer weight) throws RuntimeException {
		if (! (graph.containsKey(source) &&
			   graph.containsKey(destination)) )
			throw new RuntimeException("Nodo non presente nel grafo");

		graph.get(source).add(new Edge<V>(destination, weight));
	}

	 /**
     * Aggiunge un nuovo arco (non pesato, ovvero di peso 1) al grafo tra il nodo source e il nodo destination
     *
     */
    public void insertEdge(Node<V> source, Node<V> destination) throws RuntimeException {
		if (! (graph.containsKey(source) &&
			   graph.containsKey(destination)) )
			throw new RuntimeException("Nodo non presente nel grafo");

		graph.get(source).add(new Edge<V>(destination, 1));
	}

}
--------------------------
import java.util.*;

public class Graph<V> {

	HashMap<Node<V>, List<Edge<V>>> graph;

    /**
     * Costruttore
     *
     */
	public Graph() {
		graph = new HashMap<Node<V>, List<Edge<V>>>();
	}

    /**
     * Restituisce una collezione contenente i nodi del grafo
     *
     */
	public Collection<Node<V>> getNodes() {
		return graph.keySet();
	}

	/**
     * Restituisce una collezione contenente gli archi uscenti dal nodo dato
     *
     */
	public Collection<Edge<V>> getOutEdges(Node<V> source) {
		return graph.get(source);
	}

    /**
     * Aggiunge un nuovo nodo al grafo
     *
     */
    public void insertNode(Node<V> v) {
		if (! graph.containsKey(v))
			graph.put(v, new LinkedList<Edge<V>>());
	}

	 /**
     * Aggiunge un nuovo arco (pesato) al grafo tra il nodo source e il nodo destination, di peso weight
     *
     */
    public void insertEdge(Node<V> source, Node<V> destination, Integer weight) throws RuntimeException {
		if (! (graph.containsKey(source) &&
			   graph.containsKey(destination)) )
			throw new RuntimeException("Nodo non presente nel grafo");

		graph.get(source).add(new Edge<V>(destination, weight));
	}

	 /**
     * Aggiunge un nuovo arco (non pesato, ovvero di peso 1) al grafo tra il nodo source e il nodo destination
     *
     */
    public void insertEdge(Node<V> source, Node<V> destination) throws RuntimeException {
		if (! (graph.containsKey(source) &&
			   graph.containsKey(destination)) )
			throw new RuntimeException("Nodo non presente nel grafo");

		graph.get(source).add(new Edge<V>(destination, 1));
	}

}
                                  
