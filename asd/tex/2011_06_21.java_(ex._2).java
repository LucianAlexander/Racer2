// Esame del 21 giugno 2011, esercizio 2
// Ricordarsi di specificare sempre, nei commenti al codice, l'utilità di ogni metodo.

class Node<E>
	{
	E elem;
	LinkedList<Node<E>> children;
	public Node(E elem);
	public E getElem();
	public LinkedList<Node<E>> children();
	}

class Tree<String>
	{
	Node<String> root;
	public Tree(String s);
	public Node<String> root();
	public Node<String> remove(Node<String> n);
	public boolean isExternal();
	public String replace(Node<String> n, String s);
	public boolean isEmpty();
	
	public boolean startWith(Node root, String prefix) // Costo computazionale Theta(n) per definizione
		{
		boolean ret = false;
		startWith(root, prefix, "", 0, ret);
		return ret;
		}
	public boolean startWith(Node n, String prefix, String s, int pos, boolean ret)
		{
		if(s.equals(prefix))
			{
			ret = true;
			return;
			}
		if(n.isExternal() || n.children().size() >= pos) return;
		if(!n.isExternal() && n.children().size() < pos)
			{
			s = s.concat(n.children().get(pos));
			startWith(n.children().get(pos), prefix, s, 0, ret);
			}
		startWith(n, prefix, s, pos + 1, ret);
		}
	
	public void remove(String s) // Stimato O(n*h) perché può effettuare fino a n/k rimozioni ciascuna di costo h
		{
		remove(s, root);
		}
	public void remove(String s, Node<String> n)
		{
		if(n == null) return;
		for(int i = 0; i < s.length(); i++)
			{
			if(n.getElem().equals(s.charAt(i)))
				{
				remove(n);
				return;
				}
			}
		for(Node<String> c : n.children())
			remove(s, c);
		}
	}