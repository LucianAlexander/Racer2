import java.util.*;

public class Graph { // Classe Grafo non orientato con nodi a chiavi intere

	HashMap<Integer, List<Edge>> incidence;
	ArrayList<Edge> edges;

	public Graph() {
		incidence = new HashMap<Integer, List<Edge>>();
		edges = new ArrayList<Edge>();
	}

    /**
     * restituisce i nodi del grafo
     *
     */
	public Collection<Integer> getNodes() {
		return incidence.keySet();
	}

	/**
	 * restituisce gli archi del grafo
	 *
	 */
	public Collection<Edge> getEdges() {
		return edges;
	}

	/**
     * restituisce la lista di adiacenza di un nodo
     *
     */
	public Collection<Edge> getIncidentEdges(Integer source) {
		return incidence.get(source);
	}

    /**
     * Aggiunge un nuovo nodo al grafo
     *
     */
    public void insertNode(Integer v) {
		if (! incidence.containsKey(v))
			incidence.put(v, new LinkedList<Edge>());
	}

	 /**
     * Aggiunge un nuovo arco (pesato) al grafo tra il nodo source e il nodo destination, di peso weight
     *
     */
    public void insertEdge(Integer source, Integer destination, Integer weight) throws RuntimeException {
		if (! (incidence.containsKey(source) &&
			   incidence.containsKey(destination)) )
			throw new RuntimeException("Arco non valido");

		incidence.get(source).add(new Edge(source, destination, weight));
		incidence.get(destination).add(new Edge(destination, source, weight));

		edges.add(new Edge(source, destination, weight));
	}


}

..........................
import java.util.*;

public class Graph { // Classe Grafo non orientato con nodi a chiavi intere

	HashMap<Integer, List<Edge>> incidence;
	ArrayList<Edge> edges;

	public Graph() {
		incidence = new HashMap<Integer, List<Edge>>();
		edges = new ArrayList<Edge>();
	}

    /**
     * restituisce i nodi del grafo
     *
     */
	public Collection<Integer> getNodes() {
		return incidence.keySet();
	}

	/**
	 * restituisce gli archi del grafo
	 *
	 */
	public Collection<Edge> getEdges() {
		return edges;
	}

	/**
     * restituisce la lista di adiacenza di un nodo
     *
     */
	public Collection<Edge> getIncidentEdges(Integer source) {
		return incidence.get(source);
	}

    /**
     * Aggiunge un nuovo nodo al grafo
     *
     */
    public void insertNode(Integer v) {
		if (! incidence.containsKey(v))
			incidence.put(v, new LinkedList<Edge>());
	}

	 /**
     * Aggiunge un nuovo arco (pesato) al grafo tra il nodo source e il nodo destination, di peso weight
     *
     */
    public void insertEdge(Integer source, Integer destination, Integer weight) throws RuntimeException {
		if (! (incidence.containsKey(source) &&
			   incidence.containsKey(destination)) )
			throw new RuntimeException("Arco non valido");

		incidence.get(source).add(new Edge(source, destination, weight));
		incidence.get(destination).add(new Edge(destination, source, weight));

		edges.add(new Edge(source, destination, weight));
	}


}
                                  
