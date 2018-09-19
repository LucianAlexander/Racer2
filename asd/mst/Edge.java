public class Edge {

	private Integer source, target, weight;

	public Edge() { }
	public Edge(Integer source, Integer target, Integer weight) {
		this.source = source;
		this.target = target;
		this.weight = weight;
	}


	// Restituisce il nodo destinazione dell'arco
	public Integer getSource() { return source; }

	// Restituisce il nodo destinazione dell'arco
	public Integer getTarget() { return target; }

	// Restituisce il peso dell'arco
	public Integer getWeight() { return weight; }

	public String toString() {
		return "(" + source.toString() + "," + target.toString() + ") [peso=" + weight + "]";
	}

}
----------------------
public class Edge {

	private Integer source, target, weight;

	public Edge() { }
	public Edge(Integer source, Integer target, Integer weight) {
		this.source = source;
		this.target = target;
		this.weight = weight;
	}


	// Restituisce il nodo destinazione dell'arco
	public Integer getSource() { return source; }

	// Restituisce il nodo destinazione dell'arco
	public Integer getTarget() { return target; }

	// Restituisce il peso dell'arco
	public Integer getWeight() { return weight; }

	public String toString() {
		return "(" + source.toString() + "," + target.toString() + ") [peso=" + weight + "]";
	}

}
