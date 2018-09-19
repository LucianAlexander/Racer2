import java.util.*; 

public class Partition {
	// Manteniamo una ArrayList *non necessariamente distinta* per ogni chiave
	HashMap<Integer, ArrayList<Integer>> A; 

	// Crea una partizione in cui ogni elemento di V forma un insieme a se stante
	// Costo: O(n)
	public Partition(Collection<Integer> S) {
		A = new HashMap<Integer, ArrayList<Integer>>(); 

		for(int i : S) {
			A.put(i, new ArrayList<Integer>()); 
			A.get(i).add(i); 
		}
	}
	
	// Recupera la lista contenente una data chiave
	// Costo: O(1)
	public List<Integer> find(int key) {
		return A.get(key); 
	}
	
	// Fonde le liste contenenti due date chiavi, aggiornando i riferimenti in A
	// Costo: O(min(n_u, n_v))
	public void union(int u, int v) {
		if(A.get(u) == A.get(v)) return; 
		int n_u = A.get(u).size(), n_v = A.get(v).size(); 
		ArrayList<Integer> A_u = A.get(u), A_v = A.get(v); 
		if(n_u < n_v) {
			for(int x : A_u) {
				A.put(x, A_v); 
				A_v.add(x); 
			}
		}
		else {
			for(int x : A_v) {
				A.put(x, A_u); 
				A_u.add(x); 
			}
		}
	}
}

