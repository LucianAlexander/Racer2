// Esame del 4 marzo 2011, esercizio 3
// Ricordarsi di specificare sempre, nei commenti al codice, l'utilità di ogni metodo.
// Per le implementazioni standard di un grafo riferirsi a GraphImplementations.java

class Vertex is Integer;
class Edge has double weight;
class Graph has Edge[][] adjMatrix;

public List<Integer> searchPath(int src, int dest, double maxWeight)
	{
	LinkedList<LinkedList<Integer>> config = new LinkedList<LinkedList<Integer>>(); // Memorizza le configurazioni che portano all'ultimo nodo della lista-nella-lista
	HashSet<Integer> visited = new HashSet<Integer>();
	visited.put(src);
	List<Integer> path = new LinkedList<Integer>();
	path.add(src);
	config.add(path);
	while(!config.isEmpty() && visited.size() < vertices.size())
		{
		List<Integer> pathfinder = config.poll();
		Integer v = pathfinder.peekLast();
		if(v == dest) return pathfinder; // Se l'ultimo nodo è il nodo destinazione, restituisce la lista
		for(int i = 0; i < adjMatrix.length; i++)
			{
			if(adjMatrix[v][i] != null)
				{
				Integer w = opposite(adjMatrix[v][i], v);
				if(!visited.contains(w))
					{
					visited.put(w);
					List<Integer> p2 = pathfinder.clone(); // Aggiunge una nuova configurazione all'insieme per ogni arco incidente
					p2.add(w);
					config.add(p2);
					}
				}
			}
		}
	return null;
	}