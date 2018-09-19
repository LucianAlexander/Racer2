/**
 * Interfaccia che rappresenta un arco del grafo.
 */
public interface Edge<V,E> {
    /**
     * restituisce il valore associato all'arco
     *
     * @return elemento
     */
    public E getElement();

    /**
     * imposta il valore associato all'arco
     *
     * @param element valore
     */
    public void setElement(E element);
    
    /**
     * restituisce il vertice sorgente dell'arco specificato
     *
     * @param edge arco di riferimento
     * @return nodo sorgente dell'arco
     */
    public Vertex<V> getSourceSide();

    /**
     * restituisce il vertice destinazione dell'arco specificato
     *
     * @param edge arco di riferimento
     * @return nodo destinazione dell'arco
     */
    public Vertex<V> getDestinationSide();      

}


