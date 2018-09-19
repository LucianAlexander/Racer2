import java.util.LinkedList;
import java.util.List;

public class Graph<V> {

    public enum GRAPH_TYPE {
        UNDIRECTED,
        DIRECTED
    }

    private GRAPH_TYPE type;
    private LinkedList<GraphNode<V>> nodes;

    public Graph (GRAPH_TYPE type) {
        this.type = type;
        this.nodes = new LinkedList<GraphNode<V>>();
    }

    public List<GraphNode<V>> getNodes() {
        return (List<GraphNode<V>>) this.nodes.clone();
    }

    public List<GraphNode<V>> getNeighbors(GraphNode<V> n){
        return (List<GraphNode<V>>) n.outEdges.clone();
    }

    public GraphNode addNode(V value) {

        GraphNode<V> n = new GraphNode<V>();
        n.value = value;
        n.outEdges = new LinkedList<GraphNode<V>>();
        this.nodes.add(n);

        return n;
    }

    public void addEdge(GraphNode<V> s, GraphNode<V> t) {

        s.outEdges.add(t);
        if (this.type == GRAPH_TYPE.UNDIRECTED)
            t.outEdges.add(s);

        return;
    }

    public V getNodeValue(GraphNode<V> n) {
        return n.value;
    }

    private boolean getPath(GraphNode<V> s, GraphNode<V> t, LinkedList<V> l) {

        if (s.state != GraphNode.Status.UNEXPLORED)
            return false;

        s.state = GraphNode.Status.EXPLORED;

        for (GraphNode<V> u : s.outEdges) {

            if (u.state == GraphNode.Status.EXPLORED) {
                continue;
            }

            l.add(u.value);

            if (u == t)
                return true;

            else if (u.state == GraphNode.Status.UNEXPLORED) {
                boolean res = getPath(u, t, l);
                if (res)
                    return true;
                else
                    l.removeLast();
            }

        }

        return false;
    }

    public List<V> getPath(GraphNode<V> s, GraphNode<V> t) {

        for (GraphNode<V> n : this.nodes)
            n.state = GraphNode.Status.UNEXPLORED;

        LinkedList<V> l = new LinkedList<V>();
        l.add(s.value);

        boolean found = getPath(s, t, l);
        if (found)
            return l;
        else {
            return null;
        }
    }

    private int sweepAux(GraphNode<V> source, int time) {

        if (source.state != GraphNode.Status.UNEXPLORED)
            return 0;

        int loctime = 1;
        source.state = GraphNode.Status.EXPLORING;
        source.rename = time;

        for (GraphNode<V> u : source.outEdges) {

            System.out.print("\t" + source.value + "(" + source.rename + ")->" + u.value + "(" + u.rename + ") ");
            if (u.state == GraphNode.Status.EXPLORED) {

                if (source.rename < u.rename)
                    System.out.print("FORWARD\n");
                else
                    System.out.print("CROSS\n");

            } else if (u.state == GraphNode.Status.EXPLORING) {
                System.out.print("BACK\n");

            } else {
                System.out.print("TREE\n");
                loctime += sweepAux(u, time + loctime);
            }
        }

        source.state = GraphNode.Status.EXPLORED;
        return loctime;
    }

    public void sweep() {

        for (GraphNode<V> n : this.nodes) {
            n.state = GraphNode.Status.UNEXPLORED;
            n.rename = 0;
        }

        int loctime = 0;
        for (GraphNode<V> node : this.nodes) {

            System.out.println("Root " + node.value);
            loctime += sweepAux(node, loctime);

        }
    }

    public static class GraphNode<V> {

        public enum Status {UNEXPLORED, EXPLORED, EXPLORING}

        protected V value;
        protected LinkedList<GraphNode<V>> outEdges;

        // keep track status
        protected Status state;
        protected int rename;
    }
}
--------------------------------------------
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Graph<V> {

    private LinkedList<GraphNode<V>> nodes;
    private int n_nodes;
    private int n_edges;

    public Graph () {
        this.nodes = new LinkedList<GraphNode<V>>();
    }

    @SuppressWarnings("unchecked")
	public List<GraphNode<V>> getNodes() {
    	List<GraphNode<V>> ret = new LinkedList<>();
    	for(GraphNode<V> n : this.nodes) {
    		try {
				ret.add((GraphNode<V>) n.clone());
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
    	}
        return (List<GraphNode<V>>) ret;
    }

    @SuppressWarnings("unchecked")
	public List<GraphNode<V>> getNeighbors(GraphNode<V> n){
    	List<GraphNode<V>> ret = new LinkedList<>();
    	for(GraphNode<V> edge : n.outEdges) {
    		try {
				ret.add((GraphNode<V>) edge.clone());
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
    	}
        return (List<GraphNode<V>>) ret;
    }

    public GraphNode<V> addNode(V value) {
        GraphNode<V> n = new GraphNode<V>();
        n.value = value;
        n.outEdges = new LinkedList<GraphNode<V>>();
        n.state = GraphNode.Status.UNEXPLORED;
        for(GraphNode<V> node : this.nodes) {
        	if(node.value.equals(value))
        		return node;
        }
        this.nodes.add(n);
        this.n_nodes++;
        return n;
    }

    public void addEdge(GraphNode<V> s, GraphNode<V> t) {
        s.outEdges.add(t);
        t.outEdges.add(s);
        this.n_edges++;
    }

    public V getNodeValue(GraphNode<V> n) {
        return n.value;
    }

    public void removeEdge(GraphNode<V> v1, GraphNode<V> v2){
    	removeEdgeAux(v1,v2);
    	removeEdgeAux(v2,v1);
		this.n_edges--;
    }

    private void removeEdgeAux(GraphNode<V> v1, GraphNode<V> v2) {
    	Iterator<GraphNode<V>> it = this.nodes.iterator();
    	while(it.hasNext()) {
    		GraphNode<V> n1 = it.next();
    		Iterator<GraphNode<V>> it2 = n1.outEdges.iterator();
    		if(n1.equals(v1)) {
	    		while(it2.hasNext()) {
	    			GraphNode<V> n2 = it2.next();
	    			if(n2.equals(v2)) {
	    				it2.remove();
	    			}
	    		}
    		}
    	}
    }

    public void removeNode(GraphNode<V> v){
    	if(this.nodes.contains(v)) {
	    	for(GraphNode<V> e : v.outEdges) {
	    		this.removeEdgeAux(e, v);
	    		this.n_edges--;
	    	}
    	}
    	this.nodes.remove(v);
    }

    public static <V> Graph<V> readFF(File input){
    	Graph<V> toRet = new Graph<>();
    	try {
			BufferedReader br = new BufferedReader(new FileReader(input));
			String firstLine = br.readLine();
			StringTokenizer tok = new StringTokenizer(firstLine);
			int v = Integer.parseInt(tok.nextToken());
			int e = Integer.parseInt(tok.nextToken());
			for(int i = 0; i< e; i++) {
				tok = new StringTokenizer(br.readLine());
				while(tok.hasMoreTokens()) {
					GraphNode<V> v1 = toRet.addNode((V) tok.nextToken());
					GraphNode<V> v2 = toRet.addNode((V) tok.nextToken());
					toRet.addEdge(v1, v2);
				}
			}
			br.close();
			if(toRet.n_nodes < v) {
				int rem = v - toRet.n_nodes;
				int name = e + 1;
				for(int i = 0; i<rem; name++, i++) {
					toRet.addNode((V) (name + ""));
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return toRet;
    }

    public String printAdj() {
    	StringBuffer toRet = new StringBuffer();
        for(GraphNode<V> v : this.nodes) {
      	  toRet.append(v.value + ": ");
      	  for(GraphNode<V> e: v.outEdges) {
      		  toRet.append(e.value + " ");
      	  }
      	  toRet.append("\n");
        }
        return toRet.toString();
    }

    @Override
    public String toString(){
    	StringBuffer toRet = new StringBuffer();
    	toRet.append(this.n_nodes + " " + this.n_edges + "\n");
    	for(GraphNode<V> node : this.nodes) {
    		if(node.state == GraphNode.Status.UNEXPLORED)
    			DFSprintEdges(node, toRet);
    	}
    	return toRet.toString();
    }

    private void DFSprintEdges(GraphNode<V> node, StringBuffer str) {
    	if(node.state != GraphNode.Status.UNEXPLORED)
    		return;
    	node.state = GraphNode.Status.EXPLORING;
    	for(GraphNode<V> e : node.outEdges) {
    		if(e.state == GraphNode.Status.UNEXPLORED)
    			str.append(node.value + " " + e.value + "\n");
    	}
    	for(GraphNode<V> e : node.outEdges) {
    		if(e.state == GraphNode.Status.UNEXPLORED)
    			DFSprintEdges(e, str);
    	}
    	node.state = GraphNode.Status.EXPLORED;
	}

	public int nConComp(){
		int ret = 0;
		for(GraphNode<V> node : this.nodes) {
			if(node.state == GraphNode.Status.UNEXPLORED) {
				ret++;
				DFS(node);
			}
		}
		return ret;
    }

    private void DFS(GraphNode<V> node) {
    	if(node.state != GraphNode.Status.UNEXPLORED)
    		return;
    	node.state = GraphNode.Status.EXPLORING;
    	for(GraphNode<V> e : node.outEdges) {
    		if(e.state == GraphNode.Status.UNEXPLORED)
    			DFS(e);
    	}
    	node.state = GraphNode.Status.EXPLORED;
	}

	public List<Graph<V>> getConComp(){
		LinkedList<Graph<V>> toRet = new LinkedList<>();
		for(GraphNode<V> node : this.nodes) {
			if(node.state == GraphNode.Status.UNEXPLORED) {
				Graph<V> g = new Graph<>();
				toRet.add(g);
				DFSfillCC(node, g.nodes);
			}
		}

		return toRet;
    }

    private void DFSfillCC(GraphNode<V> node, LinkedList<GraphNode<V>> list) {
    	if(node.state != GraphNode.Status.UNEXPLORED)
    		return;
    	node.state = GraphNode.Status.EXPLORING;
    	list.add(node);
    	for(GraphNode<V> n : node.outEdges) {
    		if(n.state == GraphNode.Status.UNEXPLORED)
    			DFSfillCC(n, list);
    	}
    	node.state = GraphNode.Status.EXPLORED;
	}

	public static class GraphNode<V> implements Cloneable{

        public enum Status {UNEXPLORED, EXPLORED, EXPLORING}

        protected V value;
        protected LinkedList<GraphNode<V>> outEdges;

        // keep track status
        protected Status state;

		@Override
		public String toString() {
			return "GraphNode [value=" + value + ", state=" + state + "]";
		}

		@Override
		protected Object clone() throws CloneNotSupportedException {
			return super.clone();
		}


    }
}
.----------------------------------------
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Graph<V> {

    private LinkedList<GraphNode<V>> nodes;
    private int n_nodes;
    private int n_edges;

    public Graph () {
        this.nodes = new LinkedList<GraphNode<V>>();
    }

    @SuppressWarnings("unchecked")
	public List<GraphNode<V>> getNodes() {
    	List<GraphNode<V>> ret = new LinkedList<>();
    	for(GraphNode<V> n : this.nodes) {
    		try {
				ret.add((GraphNode<V>) n.clone());
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
    	}
        return (List<GraphNode<V>>) ret;
    }

    @SuppressWarnings("unchecked")
	public List<GraphNode<V>> getNeighbors(GraphNode<V> n){
    	List<GraphNode<V>> ret = new LinkedList<>();
    	for(GraphNode<V> edge : n.outEdges) {
    		try {
				ret.add((GraphNode<V>) edge.clone());
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
    	}
        return (List<GraphNode<V>>) ret;
    }

    public GraphNode<V> addNode(V value) {
        GraphNode<V> n = new GraphNode<V>();
        n.value = value;
        n.outEdges = new LinkedList<GraphNode<V>>();
        n.state = GraphNode.Status.UNEXPLORED;
        n.timestamp = 0;
        for(GraphNode<V> node : this.nodes) {
        	if(node.value.equals(value))
        		return node;
        }
        this.nodes.add(n);
        this.n_nodes++;
        return n;
    }

    public void addEdge(GraphNode<V> s, GraphNode<V> t) {
        s.outEdges.add(t);
        this.n_edges++;
    }

    public V getNodeValue(GraphNode<V> n) {
        return n.value;
    }

    public void removeEdge(GraphNode<V> v1, GraphNode<V> v2){
    	removeEdgeAux(v1,v2);
		this.n_edges--;
    }

    private void removeEdgeAux(GraphNode<V> v1, GraphNode<V> v2) {
    	Iterator<GraphNode<V>> it = this.nodes.iterator();
    	while(it.hasNext()) {
    		GraphNode<V> n1 = it.next();
    		Iterator<GraphNode<V>> it2 = n1.outEdges.iterator();
    		if(n1.equals(v1)) {
	    		while(it2.hasNext()) {
	    			GraphNode<V> n2 = it2.next();
	    			if(n2.equals(v2)) {
	    				it2.remove();
	    				return;
	    			}
	    		}
    		}
    	}
    }

    public void removeNode(GraphNode<V> v){
    	if(this.nodes.contains(v)) {
	    	for(GraphNode<V> e : v.outEdges) {
	    		this.removeEdgeAux(v, e);
	    		this.n_edges--;
	    	}
    	}
    	this.nodes.remove(v);
    }

    @Override
    public String toString(){
    	HashMap<GraphNode<V>, Graph.GraphNode.Status> savedStatus = new HashMap<>();
    	for(GraphNode<V> node : this.nodes) {
    		savedStatus.put(node, node.state);
    		node.state = Graph.GraphNode.Status.UNEXPLORED;
    	}

    	StringBuffer toRet = new StringBuffer();
    	toRet.append(this.n_nodes + " " + this.n_edges + "\n");
    	for(GraphNode<V> node : this.nodes) {
    		if(node.state == Graph.GraphNode.Status.UNEXPLORED)
    			DFSprintEdges(node, toRet);
    	}

    	for(GraphNode<V> node : this.nodes) {
    		node.state = savedStatus.get(node);
    	}
    	return toRet.toString();
    }

    private void DFSprintEdges(GraphNode<V> node, StringBuffer str) {
    	if(node.state != GraphNode.Status.UNEXPLORED)
    		return;
    	node.state = GraphNode.Status.EXPLORING;
    	for(GraphNode<V> e : node.outEdges) {
    		str.append(node.value + " " + e.value + "\n");
    	}
    	for(GraphNode<V> e : node.outEdges) {
    		if(e.state == GraphNode.Status.UNEXPLORED)
    			DFSprintEdges(e, str);
    	}
    	node.state = GraphNode.Status.EXPLORED;
	}

	public static class GraphNode<V> implements Cloneable{
        public enum Status {UNEXPLORED, EXPLORED, EXPLORING}

        protected V value;
        protected LinkedList<GraphNode<V>> outEdges;

        // keep track status
        protected Status state;
        protected int timestamp;

		@Override
		public String toString() {
			return "GraphNode [value=" + value + ", state=" + state + "]";
		}

		@Override
		protected Object clone() throws CloneNotSupportedException {
			return (GraphNode<V>) this;
		}
    }
}
-------------------------------------------
import java.util.*;

public class Graph<V> {

	HashMap<Node<V>, List<Edge<V>>> graph;

    /**
     * Costruttore
     *
     */
	public Graph() {
		graph = new HashMap<Node<V>, List<Edge<V>>>();
	}

    /**
     * Restituisce una collezione contenente i nodi del grafo
     *
     */
	public Collection<Node<V>> getNodes() {
		return graph.keySet();
	}

	/**
     * Restituisce una collezione contenente gli archi uscenti dal nodo dato
     *
     */
	public Collection<Edge<V>> getOutEdges(Node<V> source) {
		return graph.get(source);
	}

    /**
     * Aggiunge un nuovo nodo al grafo
     *
     */
    public void insertNode(Node<V> v) {
		if (! graph.containsKey(v))
			graph.put(v, new LinkedList<Edge<V>>());
	}

	 /**
     * Aggiunge un nuovo arco (pesato) al grafo tra il nodo source e il nodo destination, di peso weight
     *
     */
    public void insertEdge(Node<V> source, Node<V> destination, Integer weight) throws RuntimeException {
		if (! (graph.containsKey(source) &&
			   graph.containsKey(destination)) )
			throw new RuntimeException("Nodo non presente nel grafo");

		graph.get(source).add(new Edge<V>(source, destination, weight));
	}

	 /**
     * Aggiunge un nuovo arco (non pesato, ovvero di peso 1) al grafo tra il nodo source e il nodo destination
     *
     */
    public void insertEdge(Node<V> source, Node<V> destination) throws RuntimeException {
		if (! (graph.containsKey(source) &&
			   graph.containsKey(destination)) )
			throw new RuntimeException("Nodo non presente nel grafo");

		graph.get(source).add(new Edge<V>(source, destination, 1));
	}

    /**
     * Stampa il grafo su stdout
     */
    @Override
    public String toString() {
    	StringBuffer sb = new StringBuffer();
		for (Node<V> v : this.getNodes()) {
			sb.append(v + " : ");

			for (Edge<V> u : this.getOutEdges(v)) {
				sb.append(u+" ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

    /**
     * Restituisce l'insieme di tutti gli archi del grafo.
     *
     */
	public Set<Edge<V>> getEdges() {
		HashSet<Edge<V>> set = new HashSet<>();
		for(Node<V> n : this.graph.keySet()) {
			set.addAll(graph.get(n));
		}
		return set;
	}
}

-----------------
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
* Grafo semplice non diretto rappresentato mediante lista delle incidenze.
*/
public class Graph {

	/**
	* Etichette potenzialmente utili, associabili agli archi di un grafo.
	*/
	public static final int UNEXPLORED = 0;
	public static final int DISCOVERY = 1;
	public static final int BACK = 2;
	public static final int EXCLUDED = 3;

	private LinkedList<GraphNode> nodes;
	int nNodes;
	int nEdges;

	/**
	* Crea un nuovo grafo.
	*/
	public Graph() {
		nodes = new LinkedList<GraphNode>();
	}

	/**
	* Ritorna la lista dei nodi del grafo.
	*/
	public List<GraphNode> getNodes(){
		return nodes;
	}

	/**
	* Ritorna la lista degli archi incidenti ad n.
	*/
	public List<GraphEdge> getIncidentEdges(GraphNode n){
		return n.incidentEdges;
	}

	/**
	* Aggiunge un nodo al grafo con la label specificata.
	*/
	public GraphNode addNode(String label) {
		GraphNode toPut = new GraphNode();
		toPut.incidentEdges = new LinkedList<GraphEdge>();
		toPut.key = this.nNodes;
		toPut.label = label;
		this.nodes.add(toPut);
		this.nNodes++;
		return toPut;
	}

	/**
	* Aggiunge al grafo un arco che collega i nodi n1 ed n2.
	*/
	public void addEdge(GraphNode n1, GraphNode n2) {
		GraphEdge toPut = new GraphEdge();
		toPut.key = this.nEdges;
		toPut.n1 = n1;
		toPut.n2 = n2;
		for(GraphNode nd : this.nodes) {
			if(nd == n1 || nd == n2) {
				for(GraphEdge edg : nd.incidentEdges) {
					if(edg.n1 == n1 && edg.n2 == n2 || edg.n2 == n1 && edg.n1 == n2)
						return; // arco gia' presente nel grafo
				}
				nd.incidentEdges.add(toPut);
			}
		}
		this.nEdges++;
	}

	/**
	*Rimuove dal grafo l'arco che collega i nodi v1 e v2.
	*/
	public void removeEdge(GraphNode v1, GraphNode v2) {
		for(GraphNode nd : this.nodes) {
			if(nd == v1) {
				Iterator<GraphEdge> it = nd.incidentEdges.iterator();
				while(it.hasNext()) {
					GraphEdge edg = it.next();
					if(edg.n1 == v1 && edg.n2 == v2 || edg.n2 == v1 && edg.n1 == v2) {
						it.remove();
						this.nEdges--;
					}
				}
			}
			if(nd == v2) {
				Iterator<GraphEdge> it = nd.incidentEdges.iterator();
				while(it.hasNext()) {
					GraphEdge edg = it.next();
					if(edg.n1 == v1 && edg.n2 == v2 || edg.n2 == v1 && edg.n1 == v2)
						it.remove();
				}
			}
		}
	}

	/**
	* Rimuove il nodo v dal grafo.
	*/
	public void removeNode(GraphNode n) {
		Iterator<GraphNode> it = this.nodes.iterator();
		while(it.hasNext()) {
			GraphNode nd = it.next();
			if(nd == n) {
				Iterator<GraphEdge> it2 = nd.incidentEdges.iterator();
				while(it2.hasNext()) {
					it2.next();
					it2.remove();
					this.nEdges--;
				}
				it.remove();
				this.nNodes--;
			}
			Iterator<GraphEdge> it2 = nd.incidentEdges.iterator();
			while(it2.hasNext()) {
				GraphEdge edg = it2.next();
				if(edg.n1 == n || edg.n2 == n)
					it2.remove();
			}
		}
	}

	/**
	* Stampa a video una rappresentazione del grafo.
	*/
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for(GraphNode nd : this.nodes) {
			sb.append(nd.key + ":" + nd.label + ": ");
			for(GraphEdge edg : nd.incidentEdges) {
				sb.append(edg.getEdgeOpposite(nd).key + ":" + edg.getEdgeOpposite(nd).label + " ");
			}
			sb.append("\n");
		}
		sb.append("nNodes:" + this.nNodes + ", nEdges:" + this.nEdges);
		return sb.toString();
	}
}

class GraphEdge{
	int key;
	GraphNode n1;
	GraphNode n2;

	/**
	* Ritorna il nodo in posizione opposta a cur, rispetto all'arco this.
	*/
	public GraphNode getEdgeOpposite(GraphNode cur) {
		if (this.n1 == cur)
			return this.n2;
		if (this.n2 == cur)
			return this.n1;
		throw new RuntimeException("ERROR - Wrong invocation in getEdgeOpposite");
	}

	/**
	* Ritorna la chiave dell'arco this.
	*/
	public int getEdgeKey() {
		return this.key;
	}
}

class GraphNode{
	int key;
	String label;
	List<GraphEdge> incidentEdges;

	/**
	* Ritorna la chiave del nodo this.
	*/
	public int getNodeKey() {
		return this.key;
	}

	/**
	* Ritorna la label del nodo this.
	*/
	public String getNodeLabel() {
		return this.label;
	}
}
