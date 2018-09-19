import java.util.*; 

public class BSTree<V> {
	
	private class Node<V> {
		private int key; 
		private V value; 
		private Node<V> left, right; 
		
		public Node(int key, V value) {
			this.key = key; 
			this.value = value; 
			this.left = this.right = null; 
		}
		
		public String toString() {
			return "[chiave: "+key+", valore: "+value+"]"; 
		}
	}

	private Node<V> root; 
	
	/*
	 * Stampa dell'albero
	 */
	public void print() {
		print(root, 0); 
	}
	
	/*
	 * Metodo ausiliario ricorsivo di print
	 */
	private void print(Node<V> x, int level) {
		for (int i = 0; i < level - 1; i++) {
			System.out.print("   ");
		}
		
		if (level > 0)
	    	System.out.print(" |--");
	
		System.out.println(x.value); 
	   
		if (x.left != null) 
			print(x.left, level + 1);
		if (x.right != null) 
			print(x.right, level + 1);
	}

	/*
		Costruisce un BST avente un unico nodo, costituito 
		dalla chiave k e dal valore value. 
	*/	
	public BSTree(int k, V value) {
		root = new Node<V>(k, value); 
	}
	
	/*
		Costruisce un BST avente un unico nodo, costituito da x. 
	*/
	private BSTree(Node<V> x) {
		root = x; 
	}

	/*
		Restituisce l'unico valore associato associato a k, 
		se esiste, o null altrimenti
	*/	
	public V find(int k) {
		return find(root, k); 
	}

	/*
		Metodo ausiliario ricorsivo di find. 
		Restituisce il valore associato a k nel sottoalbero con radice x
		(o null se non esiste)
	*/	
	private V find(Node<V> x, int k) {
		if (x == null) return null; 
		
		if (k < x.key) return find(x.left, k); 
		if (k > x.key) return find(x.right, k); 
		
		return x.value;	
	}
	
	/*
		Inserisce nel punto appropriato del BST la coppia (k, value); 
		se esiste già un valore associato alla chiave k, il metodo 
		sovrascrive il vecchio valore 
	*/
	public void insert(int k, V value) {
		root = insert(root, k, value); 
	}
	
	/*
		Metodo ausiliario ricorsivo di insert.
		Inserisce (k, value) nel sottoalbero la cui radice è x. 
		Restituisce il riferimento al "nuovo" x
	*/
    private Node<V> insert(Node<V> x, int k, V value) {
    	if (x == null) return new Node<V>(k, value); 
    	
		if (k < x.key) x.left = insert(x.left, k, value);
		else if (k > x.key) x.right = insert(x.right, k, value);
		else x.value = value;

		return x;
	}
	
	/*
		Metodo privato ricorsivo (propedeutico a remove)
		Restituisce il nodo a chiave minima nel sottoalbero la cui radice è x
	*/	
	private Node<V> findMin(Node<V> x) {
		if (x.left == null) return x; 
		return findMin(x.left); 
	}

	/*
		Metodo privato ricorsivo (propedeutico a remove)
		Elimina il nodo a chiave minima dal sottoalbero la cui radice è x
		Restituisce il nodo radice del sottoalbero modificato
		(o null, se x non ha figli). 
	*/	
	private Node<V> removeMin(Node<V> x) {
		if (x.left == null) return x.right; 
		x.left = removeMin(x.left); 
		return x; 
	}
	
	/*
		Elimina dal BST il nodo con chiave k (se esiste)
	*/
	public void remove(int k) {
		root = remove(root, k); 
	}
	
	/*
		Elimina il nodo con chiave k (se esiste)
		dal sottoalbero la cui radice è x
		Il valore di ritorno è usato per mantenere la radice del sottoalbero che deve rimpiazzare il nodo eliminato
	*/
	private Node<V> remove(Node<V> x, int k) {
		if (x == null) return null; 
		if (k < x.key) x.left = remove(x.left, k); 
		else if (k > x.key) x.right = remove(x.right, k); 
		else {
			if (x.right == null) return x.left; 
			if (x.left == null) return x.right; 
			Node<V> t = x; 
			x = findMin(t.right); 
			x.right = removeMin(t.right); 
			x.left = t.left; 
		}
		return x; 
	}
	
	/*
		Restituisce la chiave del nodo precedence(k)
		(o null se il BST non contiene nessun nodo con chiave < k).
	*/
	public Integer precedence(int k) {
		Node<V> x = precedence(root, k); 
		if(x == null) return null; 
		return x.key; 
	}
	
	/*
		Metodo ausiliario ricorsivo di floor.
		Restituisce il nodo precedence(k) calcolato nel sottoalbero la cui radice è x 
		(o null se tale sottoalbero non contiene nessun nodo con chiave < k). 
	*/
	private Node<V> precedence(Node<V> x, int k) {
		if (x == null) return null; 
		if (k <= x.key) return precedence(x.left, k); 
		Node<V> t = precedence(x.right, k); 
		if(t != null) return t; 
		return x;  
	}
	

}


