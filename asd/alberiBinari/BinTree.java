
import java.util.*;

public class BinTree<E> {

	private static final int MAXNODES = 100; // capienza massima dell'albero

	private E   root; // valore dell'elemento
	private int rank; // indice dell'elemento nell'array
	private BinTree<E> subtrees[]; // array condiviso, contenente i riferimenti ai sottoalberi
	
	/**
	 * Costruisce un albero con un singolo nodo di valore val
	 * (in un nuovo array)
	 */
	@SuppressWarnings({"unchecked"}) // evita il warning riguardante la creazione di array di generics
	public BinTree(E val) {
		root = val; 
		rank = 1;
		subtrees    = (BinTree<E>[]) new BinTree [MAXNODES+1]; // cast necessario per creare un array di generics
		subtrees[1] = this;
	}
	
	/**
	 * Costruisce un nuovo sottoalbero all'indice r nell'array condiviso subtrees
	 */
	private BinTree(BinTree<E> subtrees[], int r, E val) {
		root = val; 
		rank = r; 
		this.subtrees = subtrees; 
		subtrees[rank] = this; 
	}
	
    /**
     * Restituisce il valore dell'elemento alla radice dell'albero
     */
    public E getRoot() {
		return root; 
	}

    /**
     * Modifica il valore dell'elemento alla radice dell'albero
     */
    public void setRoot(E val) {
    	root = val; 
	}
	
 	/**
 	 * Crea un figlio sinistro di valore val alla radice
 	 * e restituisce il corrispondente sottoalbero
 	 */   
	public BinTree<E> addLeftChild(E val) {
		int rank = this.rank * 2;
		if (rank > MAXNODES)
			throw new IllegalArgumentException("Capacita' esaurita");
		if (subtrees[rank] != null)
			throw new IllegalArgumentException("Nodo gia' esistente"); 

		return new BinTree<E>(subtrees, rank, val); // usa il costruttore privato
	}	

 	/**
 	 * Crea un figlio destro di valore val alla radice
 	 * e restituisce il corrispondente sottoalbero
 	 */   
	public BinTree<E> addRightChild(E val) {
		int rank = this.rank * 2 + 1;
		if (rank > MAXNODES)
			throw new IllegalArgumentException("Capacita' esaurita");
		if (subtrees[rank] != null)
			throw new IllegalArgumentException("Nodo gia' esistente"); 

		return new BinTree<E>(subtrees, rank, val); // usa il costruttore privato
	}
	
 	/**
 	 * Trova il figlio sinistro della radice
     * e restituisce il corrispondente sottoalbero
 	 */   	
    public BinTree<E> getLeftSubtree() {
		int rank = this.rank * 2;
		if (rank > MAXNODES)
			return null; 
			
		return subtrees[rank];
	}

 	/**
 	 * Trova il figlio destro della radice
     * e restituisce il corrispondente sottoalbero
 	 */
    public BinTree<E> getRightSubtree() {
		int rank = this.rank * 2 + 1;
		if (rank > MAXNODES)
			return null;	
			
		return subtrees[rank];
	}
	
 	/**
 	 * Trova il padre della radice del sottoalbero
     * su cui è invocato, e restituisce il corrispondente sottoalbero
 	 */ 	
	public BinTree<E> getParent() {
		int rank = this.rank / 2;
		if (rank == 0)
			return null; // se la radice non ha padre, restituiamo null
			
		return subtrees[rank];
	}
}




