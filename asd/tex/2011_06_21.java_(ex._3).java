// Esame del 21 giugno 2011, esercizio 3
// Ricordarsi di specificare sempre, nei commenti al codice, l'utilità di ogni metodo.
// Per le implementazioni standard di un grafo riferirsi a GraphImplementations.java

class Vertex has int pos;
class Edge has double length, String name (and is oriented);

public void streetCleaner()
	{
	HashSet<Object> visited = new HashSet<Object>();
	for(Vertex v : vertices)
		{
		if(!visited.contains(v))
			DFSRemoval(v, visited);
		}
	}

public void DFSRemoval(Vertex v, HashSet<Object> visited)
	{
	visited.put(v);
	for(Edge e : incidentEdges(v))
		{
		if(!visited.contains(e))
			{
			visited.put(e);
			Vertex w = opposite(e, v);
			if(e.getName() == null) removeEdge(e);
			if(!visited.contains(w))
				DFSRemoval(w, visited);
			}
		}
	}

public List<Vertex> isocrone(Vertex src, int min, int max)
	{
	TreeMap<Integer, Vertex> pq = new TreeMap<Integer, Vertex>();
	HashMap<Vertex, Integer> dist = new HashMap<Vertex, Integer>();
	for(Vertex v : vertices)
		{
		if(v == src)
			{
			pq.put(0, v);
			dist.put(v, 0);
			}
		else
			{
			pq.put(Integer.MAX_VALUE, v);
			dist.put(v, Integer.MAX_VALUE);
			}
		}
	while(!pq.isEmpty())
		{
		Vertex v = pq.pollFirstEntry().getValue();
		for(Edge e : incidentEdges(v))
			{
			Vertex w = opposite(e, v);
			int newDist = dist.get(v) + e.getWeight();
			if(newDist < dist.get(w))
				{
				pq.put(newDist, w);
				dist.put(w, newDist);
				}
			}
		}
	List<Vertex> out = new LinkedList<Vertex>();
	for(Vertex v : vertices)
		{
		if(dist.get(v) <= min && dist.get(v) >= max)
			out.put(v);
		}
	return out;
	}