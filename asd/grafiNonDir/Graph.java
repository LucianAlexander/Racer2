import java.util.Collection;

/**
 * Interfaccia grafo (V tipo dei vertici, E tipo degli archi)
 */
public interface Graph<V, E> {
    /**
     * restituisce true se i due vertici sono collegati da un arco da source verso destination
     *
     * @param source      nodo sorgente
     * @param destination nodo destinazione
     * @return true se i due vertici sono adiacenti
     */
    public boolean areAdjacent(Vertex<V> source, Vertex<V> destination);

    /**
     * aggiunge un nuovo vertice al grafo
     *
     * @param v vertice da aggiungere
     */
    public void insertVertex(Vertex<V> v);

    /**
     * aggiunge un nuovo arco al grafo
     *
     * @param e arco da inserire
     */
    public void insertEdge(Edge<V,E> e);

    /**
     * restituisce la collezione di tutti gli archi uscenti dal nodo sorgente
     *
     * @param source nodo sorgente
     * @return archi uscenti dal nodo
     */
    public Collection<Edge<V,E>> outEdges(Vertex<V> source);

    /**
     * Restituisce l'insieme di tutti i vertici raggiungibili dal vertice corrente mediante un arco uscente
     *
     * @param source nodo sorgente.
     *               Se non ci sono vertici ritornare una collezione vuota.
     * @return vertici raggiungibili dal vertice corrente.
     */
    public Collection<Vertex<V>> outVertices(Vertex<V> source);

    /**
     * restituisce l'arco tra sorgente e destinazione se esiste oppure null se non c'e' nessun arco.
     *
     * @param source      nodo sorgente
     * @param destination nodo destinazione
     * @return arco tra i due nodi
     */
    public Edge<V,E> getEdge(Vertex<V> source, Vertex<V> destination);

    /**
     * Rimuove l'arco dal grafo
     *
     * @param edge arco
     */
    public void removeEdge(Edge<V,E> edge);

    /**
     * Il metodo restituisce la collezione di tutti vertici del grafo
     *
     * @return vertici del grafo
     */
    public Collection<Vertex<V>> vertices();

    /**
     * Restituisce una collezione degli archi del grafo
     *
     * @return archi del grafo
     */
    public Collection<Edge<V,E>> edges();

}



