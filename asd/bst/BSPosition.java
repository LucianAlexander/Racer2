import java.util.*;

/**
 * Interfaccia che definisce il nodo di un albero binario di ricerca
 *
 */
public interface BSPosition<E> {
	/**
	 * le sottoclassi dovrebbero prendere nel costruttore
	 * il nodo Parent ed impostarlo direttamente
	 */

    /**
     * imposta chiave e valore del nodo corrente
     *
     * @param k, e
     */
    void setElement(int k, E e);
	
    /**
     * modifica il parent del nodo
     *
     * @param v
     */
    void setParent(BSPosition<E> v);	

    /**
     * aggiunge il figlio destro al nodo corrente, ritornando il nuovo tree node creato
     *
     * @param k, e
     * @return
     */
    public BSPosition<E> setRightChild(int k, E e);
	
	public void setRightChild(BSPosition<E> v);
	
    /**
     * aggiunge il figlio sinistro al nodo corrente, ritornando il nuovo tree node creato
     *
     * @param k, e
     * @return
     */
    public BSPosition<E> setLeftChild(int k, E e);	
	
	public void setLeftChild(BSPosition<E> v);	

    /**
     * Ritorna il campo "informativo" del nodo
     */
    public E getElement();
	
	/**
     * Ritorna il campo "chiave" del nodo
     */
    public int getKey();
	
    /**
     * ritorna il genitore del nodo
     *
     * @return
     */
    public BSPosition<E> getParent();	

    /**
     * ritorna il figlio destro (null se non esiste)
     *
     * @return
     */
    public BSPosition<E> getRightChild();
	
    /**
     * ritorna il figlio sinistro (null se non esiste)
     *
     * @return
     */
    public BSPosition<E> getLeftChild();	
}
