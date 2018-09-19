// Esame del 24 luglio 2012, esercizio 3
// Ricordarsi di specificare sempre, nei commenti al codice, l'utilità di ogni metodo.
// Per le implementazioni standard di un grafo riferirsi a GraphImplementations.java

class Graph has public enum Label = { DISCOVERY, BACK, CROSS, FORWARD };

public void DFS()
	{
	HashMap<Edge, Label> mark = new HashMap<Edge, Label>();
	HashMap<Vertex, Integer> visited = new HashMap<Vertex, Integer>();
	for(Vertex v : vertices)
		{
		if(!visited.containsKey(v))
			DFSMark(v, mark, visited, 0);
		}
	}

public void DFSMark(Vertex v, HashMap<Edge, Label> mark, HashMap<Vertex, Integer> visited, int layer)
	{
	visited.put(v, layer);
	for(Edge e : incidentEdges(v))
		{
		Vertex w = opposite(e, v);
		if(!visited.containsKey(w))
			{
			mark.put(e, Label.DISCOVERY);
			DFSMark(w, mark, visited, layer + 1);
			}
		else
			{
			if(layer - visited.get(w) < 0)
				mark.put(e, Label.FORWARD);
			else if(layer - visited.get(w) > 1)
				mark.put(e, Label.BACK);
			else
				mark.put(e, Label.CROSS);
			}
		}
	}