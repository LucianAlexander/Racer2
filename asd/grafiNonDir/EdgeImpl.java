/**
 * Interfaccia che rappresenta un arco del grafo.
 */
public class EdgeImpl<V,E> implements Edge<V,E> {

	private E element;
	private Vertex<V> source;
	private Vertex<V> destination;	
	
	public EdgeImpl(E e, Vertex<V> s, Vertex<V> d) {
		element      = e;
		source       = s;
		destination  = d;
	}

    public E getElement() {
		return element;
	}		
	
    public void setElement(E element) {
		this.element = element;
	}

    public Vertex<V> getSourceSide() { return source; }

    public Vertex<V> getDestinationSide() { return destination; }

}


