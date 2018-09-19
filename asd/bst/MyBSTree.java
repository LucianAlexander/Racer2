
import java.util.*;

public class MyBSTree<E> implements BSTree<E> {

    private BSPosition<E> root;
	
    /**
     * Ritorna true se l'albero e' vuoto (non ha nessun nodo)
	 *
     * @return	 
     */
    public boolean isEmpty() {
		return root == null;
	}

    /**
     * indica se il nodo è una foglia dell'albero
	 *
	 * @param v
     * @return	 
     */
    public boolean isLeaf(BSPosition<E> v) {
		return v.getLeftChild() == null && v.getRightChild() == null;
	}	
	
    private boolean isExternal(BSPosition<E> v) {
		return v.getLeftChild() == null || v.getRightChild() == null;
	}	
	
    /**
     * ritorna la radice dell'albero
	 *
     * @return	 
     */
    public BSPosition<E> getRoot() {
		return root;
	}	
	
    /**
     * imposta la radice dell'albero
	 *
     * @return	 
     */
    public void setRoot(BSPosition<E> r) {
		root = r;
	}	
	
    /**
     * inserisce un nuovo valore ritornando il nodo creato
     *
     * @param k, e
     * @return	 
     */
    public BSPosition<E> insert(int k, E e) {
		return insert(k, e, root);
	}

	public BSPosition<E> insert(int k, E e, BSPosition<E> v) {	
		 if  (v == null) {
			root = new MyBSNode<E>(null);
			root.setElement(k, e);
			return root;  
		}			

		if (k < v.getKey()) {
			if(v.getLeftChild() == null)
				return v.setLeftChild(k, e);
			return insert(k, e, v.getLeftChild());
		}
		if (k > v.getKey()) {
			if(v.getRightChild() == null)
				return v.setRightChild(k, e);
			return insert(k, e, v.getRightChild());
		}
		v.setElement(k, e);
		return v;
	}
	
    /**
     * rimuove un nodo (se esiste) ritornando il nodo rimosso
     *
     * @param k, e
	 * @return
     */
    public BSPosition<E> remove(int k, E e) {
		return remove(k, e, root);
	}

	public BSPosition<E> remove(int k, E e, BSPosition<E> v) {	
		 if  (v == null)
			return null;  

		if (k < v.getKey())
			return remove(k, e, v.getLeftChild());
		if (k > v.getKey())
			return remove(k, e, v.getRightChild());
		
		if (!v.getElement().equals(e))
			return null;
		BSPosition<E> ext = v;		
		if (!isExternal(v)) {
			ext = findSuccessor(v);
			v.setElement(ext.getKey(), ext.getElement());
		}
		removeExternal(ext);
		return v;
	}
	
	private void removeExternal(BSPosition<E> v) {	
		BSPosition<E> parent   = v.getParent();
		BSPosition<E> newchild = null;
		if (v.getLeftChild()  != null)
			newchild = v.getLeftChild();
		else
			newchild = v.getRightChild();
		
		if (newchild != null)
			newchild.setParent(parent);
		if (parent.getLeftChild() != null && parent.getLeftChild().equals(v))
			parent.setLeftChild(newchild);
		if (parent.getRightChild() != null && parent.getRightChild().equals(v))
			parent.setRightChild(newchild);
	}
	
	private BSPosition<E> findSuccessor(BSPosition<E> v) {
		return findMin(v.getRightChild());
	}
	
	private BSPosition<E> findMin(BSPosition<E> v) {
		if (v == null)
			return null;
		if (v.getLeftChild() == null)
			return v;
		
		return findMin(v.getLeftChild());
	}
	
	/**
     * cerca il nodo con chiave k e ritorna il valore associato
     *
     * @param k, e
     * @return	 
     */
    public E find(int k) {
		return find(k, root);
	}

	public E find(int k, BSPosition<E> v) {	
		 if  (v == null) 
			return null;        

		if (k < v.getKey())
			return find(k, v.getLeftChild());
		if (k > v.getKey())
			return find(k, v.getRightChild());
		return v.getElement();
	}
}
