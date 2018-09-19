// Esame del 6 maggio 2011, esercizio 2
// Ricordarsi di specificare sempre, nei commenti al codice, l'utilità di ogni metodo.

class BSTNode
	{
	int key;
	E elem;
	BSTNode left;
	BSTNode right;
	public BSTNode(int key, E elem);
	public int getKey();
	public E getElem();
	public BSTNode left();
	public BSTNode right();
	public boolean hasLeft();
	public boolean hasRight();
	}

class BST
	{
	private BSTNode root;
	public BST(int rootKey, E rootElem);
	public BSTNode insert(int key, E elem);
	public BSTNode remove(int key);
	public BSTNode removeMin(BSTNode start); // Rimuove il nodo minimo del sottoalbero a radice start
	public BSTNode find(int key);
	public Collection<BSTNode> findAll(int key);
	
	public List<Integer> chiaviOrdinate() // Costo computazionale Theta(n) per definizione; attraversamento inorder
		{
		List<Integer> out = new LinkedList<Integer>();
		trovaChiavi(root, out);
		return out;
		}
	public void trovaChiavi(BSTNode n, List<Integer> l)
		{
		if(n.hasLeft()) trovaChiavi(n.left, out);
		out.add(n.getKey());
		if(n.hasRight()) trovaChiavi(n.right, out);
		}
	
	public boolean verificaBilanciamento() // Costo computazionale non richiesto
		{
		int i = 0;
		isBilanciato(root, i);
		return Math.abs(i) <= 1;
		}
	public int isBilanciato(BSTNode n, int bal)
		{
		if(!n.hasLeft() && !n.hasRight()) return 0;
		if(n.hasLeft() && n.hasRight())
			{
			bailLeft = Math.abs(isBilanciato(n.left, i);
			bailRight = Math.abs(isBilanciato(n.right, i);
			if(Math.abs(bailLeft) <= 1 && Math.abs(bailRight) <= 1)
				return bailLeft - bailRight;
			}
		if(n.hasLeft() && !n.hasRight()) return isBilanciato(n.left, bal + 1);
		else return isBilanciato(n.right, bal - 1);
		}
	}