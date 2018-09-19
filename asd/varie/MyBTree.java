
import java.util.*;

public class MyBTree<E> implements BTree<E> {

    private BPosition<E> root;
	static private int   maxnum = 100;
	
	// ---------------
	// visite
	private void printInorder(BPosition<E> v) {	
		if (v.getLeftChild() != null)  printInorder(v.getLeftChild());
        System.out.println(v.getElement());
		if (v.getRightChild() != null) printInorder(v.getRightChild());		
	}
	
	public void printInorder() {
		printInorder(root);
	}
	
	private void printLivelli(Queue<BPosition<E>> l) {
		BPosition<E> v = null;
		while (!l.isEmpty()) {
			v = l.poll();
			System.out.print(v.getElement()+" ");
			if (v.getLeftChild() != null)  l.offer(v.getLeftChild());
			if (v.getRightChild() != null) l.offer(v.getRightChild());	
		}
		System.out.println(); 			
	}
	
	public void printLivelli() {
		Queue<BPosition<E>> l = new LinkedList<BPosition<E>>();
		l.offer(root);
		printLivelli(l);
	}
	
	private class BPair<E> {
		public BPosition<E> pos; 
		public int level; 
		BPair(BPosition<E> pos, int level) {
			this.pos = pos; 
			this.level = level; 
		}
	}
	
	private void printLivelliBis(Queue<BPair<E>> l) {
		BPair<E> p = null; 
		int currentLevel = 0; 
		while(!l.isEmpty()) {
			p = l.poll(); 
			if(p.level > currentLevel) System.out.println(); 
			currentLevel = p.level;  
			System.out.print(p.pos.getElement()+" "); 
			if (p.pos.getLeftChild() != null) l.offer(new BPair<E>(p.pos.getLeftChild(), p.level+1)); 
			if (p.pos.getRightChild() != null) l.offer(new BPair<E>(p.pos.getRightChild(), p.level+1)); 
		}
		System.out.println(); 
	}
	
	public void printLivelliBis() {
		Queue<BPair<E>> l = new LinkedList<BPair<E>>(); 
		l.offer(new BPair<E>(root, 0)); 
		printLivelliBis(l); 
	}
	
	// ---------------	

    public boolean isEmpty() {
		return root == null;
	}

    public boolean isRoot(BPosition<E> v) {
		return v == root;
	}

    public BPosition<E> setRoot(E n) {
		root = new MyBPosition<E>(maxnum);
		root.setElement(n);
		return root;
	}
	
    public BPosition<E> getRoot() {
		return root;
	}
	
    public E replace(BPosition<E> v, E e) {
		E old = v.getElement();
		v.setElement(e);
		return old;
	}
}
