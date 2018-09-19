/**
 * Interfaccia che rappresenta un vertice del grafo.
 * Il valore del vertice andrebbe impostato nel costruttore e non piu' modificabile.
 */
public interface Vertex<V> {
    /**
     * restituisce il valore associato al vertice
     *
     * @return elemento
     */
    public V getElement();
}
