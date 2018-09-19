// Esame del 6 maggio 2011, esercizio 3
// Ricordarsi di specificare sempre, nei commenti al codice, l'utilità di ogni metodo.
// Per le implementazioni standard di un grafo riferirsi a GraphImplementations.java

class Vertex has int pos;
class Edge has double length, int time, boolean sidewalk (and is oriented);

public boolean percorsoPedonale(int source, int dest)
	{
	HashSet<Object> visited = new HashSet<Object>();
	boolean flag = false;
	for(Vertex v: vertices)
		{
		if(v.getInfo() == source)
			checkDFS(v, dest, visited, flag);
		}
	return flag;
	}

public void checkDFS(Vertex v, int dest, HashSet<Object> visited, boolean flag)
	{
	visited.put(v);
	for(Edge e : incidentEdges(v))
		{
		if(!visited.contains(e))
			{
			visited.put(e);
			if(e.hasSidewalk())
				{
				Vertex w = opposite(e, v);
				if(!visited.contains(w))
					{
					if(w.getInfo() == dest)
						{
						flag = true;
						return;
						}
					else checkDFS(w, dest, visited, flag);
					}
				}
			}
		}
	}

public int tempoMinimo(Vertex src, Vertex dest)
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
	Integer minTime = dist.get(src);
	if(minTime != null && minTime != Integer.MAX_VALUE) return minTime;
	else return -1;
	}