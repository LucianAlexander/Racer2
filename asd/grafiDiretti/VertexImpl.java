/**
 * Interfaccia che rappresenta un vertice del grafo.
 * Il valore del vertice andrebbe impostato nel costruttore e non piu' modificabile.
 */
public class VertexImpl<V> implements Vertex<V> {

	private V element;
	
	public VertexImpl(V e) {
		element = e;
	}

    public V getElement() {
		return element;
	}
	
}


