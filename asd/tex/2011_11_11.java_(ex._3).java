// Esame dell'11 novembre 2011, esercizio 3
// Ricordarsi di specificare sempre, nei commenti al codice, l'utilità di ogni metodo.
// Per le implementazioni standard di un grafo riferirsi a GraphImplementations.java

class Graph has Vertex root;

public int pruneUnreachable()
	{
	HashSet<Vertex> visited = new HashSet<Vertex>();
	DFSRemoval(root, visited); // Questa implementazione prevede che esista una variabile d'istanza Vertex<V> root, che è il q0 dell'ASF
	int previousSize = vertices.size();
	for(Vertex v : vertices)
		{
		if(!visited.contains(v))
			vertices.remove(v); // Se v non appartiene a visited ma si trova in vertices, ossia è irraggiungibile, viene rimosso
		}
	return previousSize - visited.size(); // La differenza tra la size() di vertices e di visited da' il numero degli stati (vertici) rimossi
	}

public void DFSRemoval(Vertex v, HashSet<Vertex> visited)
	{
	visited.put(v);
	for(Edge e : incidentEdges(v))
		{
		Vertex w = opposite(e, v);
		if(!visited.contains(v))
			DFSRemoval(w, visited);
		}
	}