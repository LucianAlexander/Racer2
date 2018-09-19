// Esame del 24 luglio 2012, esercizio 2
// Ricordarsi di specificare sempre, nei commenti al codice, l'utilità di ogni metodo.

class Node
	{
	E elem;
	Node left;
	Node right;
	public Node();
	public Node(E elem);
	public E getElem();
	public boolean hasLeft();
	public boolean hasRight();
	public Node left();
	public Node right();
	}

class BinTree
	{
	Node root;
	public BinTree(E rootElem);
	public Node insert(E elem);
	public Node remove(E elem);
	public int size();
	
	public boolean isCompleto() // O(n) perché esamina l'intero albero
		{
		return isCompleto(root);
		}
	public boolean isCompleto(Node n)
		{
		if(n == null) return true;
		if((n.hasLeft() && !n.hasRight()) || (n.hasRight() && !n.hasLeft())) return false;
		return isCompleto(n.left) && isCompleto(n.right);
		}
	
	public Node maxCompleto() // O(n^2) perché esamina l'intero albero un massimo di n volte
		{
		if(isCompleto()) return root;
		Node out = new Node();
		maxCompleto(root, out);
		return out;
		}
	public void maxCompleto(Node n, Node out)
		{
		if(n == null) return;
		if(isCompleto(n.left))
			{
			out = n.left;
			return;
			}
		if(isCompleto(n.right))
			{
			out = n.right;
			return;
			}
		maxCompleto(n.left, out);
		maxCompleto(n.right, out);
		}
	}