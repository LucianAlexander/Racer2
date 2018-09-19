import java.util.*;

/**
 * Interfaccia grafo (V tipo dei vertici, E tipo degli archi)
 */
public class GraphImpl<V,E> implements Graph<V, E> {

	HashMap<Vertex<V>, List<Edge<E>>> graph;
	

	public GraphImpl() {
		graph = new HashMap<Vertex<V>, List<Edge<E>>>();
	}
	
    /**
     * restituisce true se i due vertici sono collegati da un arco da v verso w
     *
     * @param source      nodo sorgente
     * @param destination nodo destinazione
     * @return true se i due vertici sono adiacenti
     */
    public boolean areAdjacent(Vertex<V> source, Vertex<V> destination) {
		List<Edge<E>> edges = graph.get(source);
		if (edges != null) {
			Iterator<Edge<E>> li = edges.iterator();
			while (li.hasNext()) {
				EdgeImpl<E> e = (EdgeImpl) li.next();
				if ((e.destination).equals(destination))
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
    public Collection<Edge<E>> edges() {
	    Collection<Edge<E>> ris = new LinkedList<Edge<E>>();
		Collection<List<Edge<E>>> lists = graph.values();
		Iterator<List<Edge<E>>> it = lists.iterator();
		while (it.hasNext()) {
			ris.addAll(it.next());
		}
		return ris;
	}

    /**
     * restituisce il vertice destinazione dell'arco specificato
     *
     * @param edge arco di riferimento
     * @return nodo destinazione dell'arco
     */
    public Vertex<V> getDestinationSide(Edge<E> edge) {
		return ((EdgeImpl) edge).destination;
	}

    /**
     * restituisce l'arco tra sorgente e destinazione se esiste oppure null se non c'e' nessun arco.
     *
     * @param source      nodo sorgente
     * @param destination nodo destinazione
     * @return arco tra i due nodi
     */
    public Edge<E> getEdge(Vertex<V> source, Vertex<V> destination) {
		List<Edge<E>> edges = graph.get(source);
		if (edges != null) {
			Iterator<Edge<E>> li = edges.iterator();
			while (li.hasNext()) {
				EdgeImpl<E> e = (EdgeImpl) li.next();
				if ((e.destination).equals(destination))
					return e;
			}
		}
		return null;		
	}

    /**
     * restituisce il vertice sorgente dell'arco specificato
     *
     * @param edge arco di riferimento
     * @return nodo sorgente dell'arco
     */
    public Vertex<V> getSourceSide(Edge<E> edge) {
		return ((EdgeImpl) edge).source;
	}

    /**
     * rimuove il vertice e tutti gli archi nei quali compare
     *
     * @param e arco da rimuovere
     */
    public void insertEdge(Edge<E> e) {
		Vertex<V> s         = ((EdgeImpl) e).source;
		Vertex<V> d         = ((EdgeImpl) e).destination;		
		List<Edge<E>> sEdges = graph.get(s);
		if (sEdges == null) {
			sEdges = new LinkedList<Edge<E>>();
			graph.put(s, sEdges);
		}
		sEdges.add(e);		
		List<Edge<E>> dEdges = graph.get(d);
		if (dEdges == null) {
			dEdges = new LinkedList<Edge<E>>();
			graph.put(d, dEdges);
		}	
	}

    /**
     * aggiunge un nuovo arco al grafo tra i nodi sorgente e destinazione specificati
     *
     * @param source      nodo sorgente
     * @param destination nodo destinazione
     * @param edge        arco
     */
    public void insertEdge(Vertex<V> source, Vertex<V> destination, Edge<E> edge) {
		List<Edge<E>> sEdges = graph.get(source);
		if (sEdges == null) {
			sEdges = new LinkedList<Edge<E>>();
			graph.put(source, sEdges);
		}
		sEdges.add(edge);		
		List<Edge<E>> dEdges = graph.get(destination);
		if (dEdges == null) {
			dEdges = new LinkedList<Edge<E>>();
			graph.put(destination, dEdges);
		}		
	}

    /**
     * aggiunge un nuovo vertice al grafo
     *
     * @param v vertice da aggiungere
     */
    public void insertVertex(Vertex<V> v) {
		List<Edge<E>> edges = graph.get(v);
		if (edges == null) {
			edges = new LinkedList<Edge<E>>();
			graph.put(v, edges);
		}
	}	

    /**
     * restituisce la collezione di tutti gli archi uscenti dal nodo sorgente
     *
     * @param source nodo sorgente
     * @return archi uscenti dal nodo
     */
    public Collection<Edge<E>> outEdges(Vertex<V> source) {
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
		List<Edge<E>> edges = graph.get(source);
		if (edges != null) {
			Iterator<Edge<E>> li = edges.iterator();
			while (li.hasNext()) {
				EdgeImpl<E> e = (EdgeImpl) li.next();
				out.add(e.destination);
			}
		}
		return out;
	}		

    /**
     * Rimuove l'arco dal grafo
     *
     * @param edge arco
     */
    public void removeEdge(Edge<E> edge) {
		Vertex<V> s         = ((EdgeImpl) edge).source;
		List<Edge<E>> edges = graph.get(s);
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
                                  