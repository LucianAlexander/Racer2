// Esame del 7 febbraio 2011, esercizio 3
// Ricordarsi di specificare sempre, nei commenti al codice, l'utilità di ogni metodo.
// Per le implementazioni standard di un grafo riferirsi a GraphImplementations.java

public Graph chiusuraTransitiva()
	{
	Graph out = this.clone();
	HashMap<Object, Integer> visited = new HashMap<Object, Integer>(); // Memorizza sia i Vertex che gli Edge visitati, ergo Object
	int iter = 0;
	for(Vertex<V> v : vertices)
		{
		DFS(v, out, visited, iter);
		iter++;
		}
	return out;
	}

public void DFS(Vertex v, Graph out, HashMap<Object, Integer> visited, int iter)
	{
	visited.put(v, iter);
	for(Edge e : incidentEdges(v))
		{
		if(!visited.containsKey(e))
			{
			Vertex w = opposite(e, v);
			if(!visited.containsKey(w)) // Controlla che w non sia stato già visitato
				{
				visited.put(e, iter); // Se non lo è stato, viene visitato
				DFS(w, out, visited, iter);
				}
			else
				{
				for(Object o : visited.keySet()) // Se lo è stato, vengono esaminati tutti i nodi visitati in questa DFS e collegati al nodo corrente per realizzare la chiusura
					{
					if(o instanceof Vertex)
						{
						Vertex x = (Vertex)o;
						if(visited.get(x) == visited.get(w) && x != w && !areAdjacent(w, x))
							insertEdge(w, x);
						}
					}
				}
			}
		}
	}