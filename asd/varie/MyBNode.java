import java.util.*;

public class MyBNode<E> implements BPosition<E> {
	
	private E element;
	private BPosition parent;
	private BPosition left;
	private BPosition right;

	/**
	 * le sottoclassi dovrebbero prendere nel costruttore
	 * il nodo Parent ed impostarlo direttamente
	 */
	public MyBNode(BPosition<E> p) {
		parent = p;
	}

    /**
     * imposta il campo informazione del nodo corrente
     *
     * @param o
     */
    public void setElement(E o) {
		element = o;
	}
	
    /**
     * modifica il parent del nodo
     *
     * @param v
     */
    public void setParent(BPosition<E> v) {
		parent = v;
	}

    /**
     * aggiunge il figlio destro al nodo corrente, ritornando il nuovo tree node creato
     *
     * @param elem
     * @return
     */
    public BPosition<E> setRightChild(E elem) {
		right = new MyBNode(this);
		right.setElement(elem);
		return right;
	}
	
    /**
     * aggiunge il figlio sinistro al nodo corrente, ritornando il nuovo tree node creato
     *
     * @param elem
     * @return
     */
    public BPosition<E> setLeftChild(E elem) {
		left = new MyBNode(this);
		left.setElement(elem);
		return left;
	}	

    /**
     * Ritorna il campo "informativo" del nodo
     */
    public E getElement() {
		return element;
	}
	
    /**
     * ritorna il genitore del nodo
     *
     * @return
     */
    public BPosition<E> getParent() {
		return parent;
	}

    /**
     * ritorna il figlio destro (null se non esiste)
     *
     * @return
     */
    public BPosition<E> getRightChild() {
		return right;
	}
	
    /**
     * ritorna il figlio sinistro (null se non esiste)
     *
     * @return
     */
    public BPosition<E> getLeftChild() {
		return left;
	}
}
