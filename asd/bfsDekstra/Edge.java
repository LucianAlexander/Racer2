
public	class Edge<V> {

	private Node<V> target;
	private Integer weight;

	public Edge(Node<V> target, Integer weight) {
		this.target = target;
		this.weight = weight;
	}

	// Restituisce il nodo puntato dall'arco
	public Node<V> getTarget() { return target; }

	// Restituisce il peso dell'arco
	public Integer getWeight() {
		return weight;
	}

	public String toString() {
		return target.toString() + "[peso=" + weight + "]";
	}

}

-----------------------

public	class Edge<V> {

	private Node<V> target;
	private Integer weight;

	public Edge(Node<V> target, Integer weight) {
		this.target = target;
		this.weight = weight;
	}

	// Restituisce il nodo puntato dall'arco
	public Node<V> getTarget() { return target; }

	// Restituisce il peso dell'arco
	public Integer getWeight() {
		return weight;
	}

	public String toString() {
		return target.toString() + "[peso=" + weight + "]";
	}

}
