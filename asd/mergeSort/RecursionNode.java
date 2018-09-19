import java.util.Arrays;

public class RecursionNode{
	private int i,f;
	private int[] pre;
	private int[] post;
	private RecursionNode left,right;
	
	public RecursionNode(int[] pre, int i,int f){
		this.i = i;
		this.f = f;
		this.pre = pre;
		this.post = null;
	}
	
	public RecursionNode getLeft(){return left;}
	public RecursionNode getRight(){return right;}
	public void setLeft(RecursionNode n){left = n;}
	public void setRight(RecursionNode n){right = n;}	
	public void setPost(int[] post){ this.post = post;}
	public String toString(){ return Arrays.toString(pre); }
	public String toStringPre(){
		return (Arrays.toString(pre)+"  { "+i+","+f+" }");
	}
	public String toStringPost(){
		String result = Arrays.toString(post)+"  { "+i+","+f+" }";
		return result;
	}
}
