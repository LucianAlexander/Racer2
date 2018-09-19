
import java.util.*;

public class Tree<E> {

	private E root;
	private Tree<E> nextSibling;
	private Tree<E> firstChild;

	/**
	 * Costruisce un albero con un singolo nodo di valore val
	 */
	public Tree(E val) {
		root = val;
		nextSibling = null;
		firstChild = null;
	}

    /**
     * Ritorna il valore dell'elemento alla radice dell'albero
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
     * Ritorna un riferimento al primo sottoalbero
     */
    public Tree<E> getFirstSubtree() {
		return firstChild;
	}

	/*
	 * Ritorna un riferimento al successivo sottoalbero
	 */
	public Tree<E> getNextSiblingSubtree() {
		return nextSibling;
	}

 	/**
 	 * Aggiunge un nuovo figlio di valore val alla radice
 	 * e restituisce il corrispondente sottoalbero
 	 */
	public Tree<E> addChild(E val) {
		Tree<E> c = new Tree<E>(val);
		if (firstChild == null) {
			firstChild = c;
		} else {
			for (Tree<E> firstChild = this.firstChild; firstChild != null; firstChild = firstChild.nextSibling) {
				if (firstChild.nextSibling == null) {
					firstChild.nextSibling = c;
					break;
				}
			}
		}
		return c;
	}

	/*
	 * Rimuove dall'albero tutti i sottoalberi corrispondenti ai figli della radice
	 */
	 public void removeChildren() {
	 	firstChild = null;
	 }
}

----------------------

import java.util.*;

public class Tree<E> {

	private E root;
	private LinkedList<Tree<E>> subtrees;

	/**
	 * Costruisce un albero con un singolo nodo di valore val
	 */
	public Tree(E val) {
		root = val;
		subtrees = new LinkedList<Tree<E>>();
	}

    /**
     * Ritorna il valore dell'elemento alla radice dell'albero
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
     * Ritorna una collection di tipo List (ad es. LinkedList o ArrayList)
     * contenente i sottoalberi corrispondenti ai figli della radice
     */
    public List<Tree<E>> getSubtrees() {
		return subtrees;
	}

 	/**
 	 * Aggiunge un nuovo figlio di valore val alla radice
 	 * e restituisce il corrispondente sottoalbero
 	 */
	public Tree<E> addChild(E val) {
		Tree<E> c = new Tree<E>(val);
		subtrees.add(c);
		return c;
	}

	/*
	 * Rimuove dall'albero tutti i sottoalberi corrispondenti ai figli della radice
	 */
	 public void removeChildren() {
	 	subtrees = new LinkedList<Tree<E>>();
	 }

	 /*
	  * "Attacca" un sottoalbero alla radice
	  */
	 public void addSubtree(Tree<E> s) {
	 	subtrees.add(s);
	 }
}
