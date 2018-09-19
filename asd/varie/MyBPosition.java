import java.util.*;

public class MyBPosition<E> implements BPosition<E> {
	
	private E element;
	private int  rank; 
	private BPosition<E>[] elements;

	public MyBPosition() { }
	
	@SuppressWarnings({"unchecked"})
	public MyBPosition(int maxnum) {
		elements    = (BPosition<E>[]) new BPosition[maxnum];
		rank        = 1;
		elements[0] = this;
	}

    public void setElement(E elem) {
		element = elem; 
	}
	
    public BPosition<E> setRightChild(E elem) {
		int child_rank = this.rank * 2 + 1;
		//System.out.println(elem+" ha rank "+child_rank);
		if (child_rank > this.elements.length)
			return null;
		MyBPosition<E> right = new MyBPosition<E>();
		right.setElement(elem);
		// -- setup --
		right.rank     = child_rank;
		right.elements = this.elements;
		right.elements[right.rank-1] = right;
		// -----------
		return right;
	}
	
    public BPosition<E> setLeftChild(E elem) {
		int child_rank = this.rank * 2;	
		//System.out.println(elem+" ha rank "+child_rank);		
		if (child_rank > this.elements.length)
			return null;	
		MyBPosition<E> left = new MyBPosition<E>();
		left.setElement(elem);
		// -- setup --
		left.rank      = child_rank;
		left.elements  = this.elements;		
		left.elements[left.rank-1] = left;
		// -----------		
		return left;
	}	

    public E getElement() {
		return element;
	}
	
    public BPosition<E> getParent() {
		if (this.rank == 0) 
			return null;
		int parent_rank = this.rank / 2;
		return elements[parent_rank-1];		
	}
	
    public BPosition<E> getRightChild() {
		int child_rank = this.rank * 2 + 1;
		if (child_rank > this.elements.length)
			return null;	
		return elements[child_rank-1];
	}
	
    public BPosition<E> getLeftChild() {
		int child_rank = this.rank * 2;
		if (child_rank > this.elements.length)
			return null;	
		return elements[child_rank-1];
	}

}
