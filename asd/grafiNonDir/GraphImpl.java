import java.util.*;

/**
 * Interfaccia grafo (V tipo dei vertici, E tipo degli archi)
 */
public class GraphImpl<V,E> implements Graph<V, E> {

	HashMap<Vertex<V>, List<Edge<V,E>>> graph;
	

	public GraphImpl() {
		graph = new HashMap<Vertex<V>, List<Edge<V,E>>>();
	}
	
    /**
     * restituisce true se i due vertici sono collegati da un arco da v verso w
     *
     * @param source      nodo sorgente
     * @param destination nodo destinazione
     * @return true se i due vertici sono adiacenti
     */
    public boolean areAdjacent(Vertex<V> source, Vertex<V> destination) {
		List<Edge<V,E>> edges = graph.get(source);
		if (edges != null) {
			Iterator<Edge<V,E>> li = edges.iterator();
			while (li.hasNext()) {
				Edge<V,E> e = li.next();
				if (e.getDestinationSide() == destination)
					return true;
			}
		}
		return false;
	}

    /**
     * Restituisce una collezione degli archi del grafo
     *
     * @return archi del grafo
     */
    public Collection<Edge<V,E>> edges() {
	    Collection<Edge<V,E>> ris = new LinkedList<Edge<V,E>>();
		Collection<List<Edge<V,E>>> lists = graph.values();
		Iterator<List<Edge<V,E>>> it = lists.iterator();
		while (it.hasNext()) {
			ris.addAll(it.next());
		}
		return ris;
	}

    /**
     * restituisce l'arco tra sorgente e destinazione se esiste oppure null se non c'e' nessun arco.
     *
     * @param source      nodo sorgente
     * @param destination nodo destinazione
     * @return arco tra i due nodi
     */
    public Edge<V,E> getEdge(Vertex<V> source, Vertex<V> destination) {
		List<Edge<V,E>> edges = graph.get(source);
		if (edges != null) {
			Iterator<Edge<V,E>> li = edges.iterator();
			while (li.hasNext()) {
				Edge<V,E> e = li.next();
				if (e.getDestinationSide() == destination)
					return e;
			}
		}
		return null;		
	}

    public void insertEdge(Edge<V,E> e) {
		Vertex<V> s         = e.getSourceSide();
		Vertex<V> d         = e.getDestinationSide();		
		List<Edge<V,E>> sEdges = graph.get(s);
		if (sEdges == null) {
			sEdges = new LinkedList<Edge<V,E>>();
			graph.put(s, sEdges);
		}
		sEdges.add((Edge<V,E>) e); 

		List<Edge<V,E>> dEdges = graph.get(d);
		if (dEdges == null) {
			dEdges = new LinkedList<Edge<V,E>>();
			graph.put(d, dEdges);
		}	
		// grafo non diretto
		dEdges.add((Edge<V,E>) e); 	
		// -----------------
	}

    /**
     * aggiunge un nuovo vertice al grafo
     *
     * @param v vertice da aggiungere
     */
    public void insertVertex(Vertex<V> v) {
		List<Edge<V,E>> edges = graph.get(v);
		if (edges == null) {
			edges = new LinkedList<Edge<V,E>>();
			graph.put(v, edges);
		}
	}	

    /**
     * restituisce la collezione di tutti gli archi uscenti dal nodo sorgente
     *
     * @param source nodo sorgente
     * @return archi uscenti dal nodo
     */
    public Collection<Edge<V,E>> outEdges(Vertex<V> source) {
		return graph.get(source);
	}

    /**
     * Restituisce l'insieme di tutti i vertici raggiungibili dal vertice corrente mediante un arco uscente
     *
     * @param source nodo sorgente.
     *               Se non ci sono vertici ritornare una collezione vuota.
     * @return vertici raggiungibili dal vertice corrente.
     */
    public Collection<Vertex<V>> outVertices(Vertex<V> source) {
	    Collection<Vertex<V>> out = new LinkedList<Vertex<V>>();
		List<Edge<V,E>> edges = graph.get(source);
		if (edges != null) {
			Iterator<Edge<V,E>> li = edges.iterator();
			while (li.hasNext()) {
				Edge<V,E> e = li.next();
				// grafo non diretto
				out.add(e.getDestinationSide() != source ? e.getDestinationSide() : e.getSourceSide());
				// -----------------
			}
		}
		return out;
	}		

    /**
     * Rimuove l'arco dal grafo
     *
     * @param edge arco
     */
    public void removeEdge(Edge<V,E> edge) {
		Vertex<V> s         = edge.getSourceSide();
		List<Edge<V,E>> edges = graph.get(s);
		if (edges != null)
			edges.remove(edge);	
	}

    /**
     * Il metodo restituisce la collezione di tutti vertici del grafo
     *
     * @return vertici del grafo
     */
    public Collection<Vertex<V>> vertices() {
	    Collection<Vertex<V>> out = new HashSet<Vertex<V>>();
		Set<Vertex<V>> vert		  = graph.keySet();
		if (vert != null) {
			Iterator<Vertex<V>> li = vert.iterator();
			while (li.hasNext()) {
				Vertex<V> v = li.next();
				out.add(v);
				out.addAll(outVertices(v));
			}
		}
		return out;	
	}
	
}
                                  