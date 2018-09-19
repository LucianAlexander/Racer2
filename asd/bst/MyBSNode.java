import java.util.*;

public class MyBSNode<E> implements BSPosition<E> {
	
	private E   value;
	private int key;	
	private BSPosition<E> parent;
	private BSPosition<E> left;
	private BSPosition<E> right;
	
	/**
	 * le sottoclassi dovrebbero prendere nel costruttore
	 * il nodo Parent ed impostarlo direttamente
	 */
	public MyBSNode(BSPosition<E> p) {
		parent = p;
	}	

   /**
     * imposta chiave e valore del nodo corrente
     *
     * @param k, e
     */
    public void setElement(int k, E e) {
		key = k;
		value = e;
	}
	
    /**
     * modifica il parent del nodo
     *
     * @param v
     */
    public void setParent(BSPosition<E> v) {
		parent = v;
	}

    /**
     * aggiunge il figlio destro al nodo corrente, ritornando il nuovo tree node creato
     *
     * @param k, e
     * @return
     */
    public BSPosition<E> setRightChild(int k, E e) {
		right = new MyBSNode<E>(this);
		right.setElement(k, e);
		return right;
	}		
	
    public void setRightChild(BSPosition<E> v) {
		right = v;
	}	
	
    /**
     * aggiunge il figlio sinistro al nodo corrente, ritornando il nuovo tree node creato
     *
     * @param k, e
     * @return
     */
    public BSPosition<E> setLeftChild(int k, E e) {
		left = new MyBSNode<E>(this);
		left.setElement(k, e);
		return left;
	}		

	public void setLeftChild(BSPosition<E> v) {
		left = v;
	}	
	
    /**
     * Ritorna il campo "informativo" del nodo
     */
    public E getElement() {
		return value;
	}
	
	/**
     * Ritorna il campo "chiave" del nodo
     */
    public int getKey() {
		return key;
	}	
	
    /**
     * ritorna il genitore del nodo
     *
     * @return
     */
    public BSPosition<E> getParent() {
		return parent;
	}

    /**
     * ritorna il figlio destro (null se non esiste)
     *
     * @return
     */
    public BSPosition<E> getRightChild() {
		return right;
	}
	
    /**
     * ritorna il figlio sinistro (null se non esiste)
     *
     * @return
     */
    public BSPosition<E> getLeftChild() {
		return left;
	}		

}
