// Esame del 18 giugno 2012, esercizio 3
// Ricordarsi di specificare sempre, nei commenti al codice, l'utilità di ogni metodo.
// Per le implementazioni standard di un grafo riferirsi a GraphImplementations.java

class Vertex has String nick; double x; double y; Object profile; and get methods
class Edge has double distance;

public Collection<Vertex> introduction(String nick)
	{
	HashSet<Vertex> people = new HashSet<Vertex>();
	for(Vertex v : vertices)
		{
		if(v.getNick().equals(nick))
			DFS(v, people, new HashSet<Vertex>());
		}
	return people;
	}

public void DFS(Vertex v, HashSet<Vertex> people, HashSet<Vertex> visited)
	{
	visited.put(v);
	for(Edge e : incidentEdges(v))
		{
		Vertex w = opposite(e, v);
		if(!visited.contains(w))
			{
			people.put(w);
			DFS(w, people, visited);
			}
		}
	}

public Collection<Vertex> compatible(String nick, double dist)
	{
	HashSet<Vertex> compatible = new HashSet<Vertex>();
	for(Vertex v : vertices)
		{
		if(v.getNick().equals(nick))
			DFS_C(v, nick, dist, compatible, new HashSet<Vertex>());
		}
	return compatible;
	}

public void DFS_C(Vertex v, String nick, double dist, HashSet<Vertex> compatible, HashSet<Vertex> visited)
	{
	visited.put(v);
	for(Edge e : incidentEdges(v))
		{
		Vertex w = opposite(v);
		if(!visited.contains(w))
			{
			if(compatibili(nick, w.getNick()) && distanzaIstantanea(nick, w.getNick()) <= dist)
				compatible.put(w);
			DFS_C(w, nick, dist, compatible, visited);
			}
		}
	}