// Esame del 14 settembre 2011, esercizio 2
// Ricordarsi di specificare sempre, nei commenti al codice, l'utilità di ogni metodo.

class ExpressionTreeNode
	{
	String op;
	ExpressionTreeNode left;
	ExpressionTreeNode right;
	public ExpressionTreeNode(String op);
	public String getOp();
	public ExpressionTreeNode left();
	public ExpressionTreeNode right();
	public boolean hasLeft();
	public boolean hasRight();
	}

class ExpressionTree
	{
	ExpressionTreeNode root;
	public ExpressionTree(String op);
	public ExpressionTreeNode add(String op);
	public ExpressionTreeNode remove(String op);
	
	public double eval() // Costo computazionale lineare al numero di operandi per definizione
		{
		return eval(root);
		}
	public double eval(ExpressionTreeNode n)
		{
		if(!n.hasLeft() && !n.hasRight()) return (double)n.getOp();
		if(n.hasLeft() && !n.left().hasLeft())
			{
			if(n.getOp().equals("+")) return (double)n.left().getOp() + eval(n.right());
			if(n.getOp().equals("-")) return (double)n.left().getOp() - eval(n.right());
			if(n.getOp().equals("*")) return (double)n.left().getOp() * eval(n.right());
			if(n.getOp().equals("/")) return (double)n.left().getOp() / eval(n.right());
			}
		if(n.getOp().equals("+")) return eval(n.left()) + eval(n.right());
		if(n.getOp().equals("-")) return eval(n.left()) - eval(n.right());
		if(n.getOp().equals("*")) return eval(n.left()) * eval(n.right());
		if(n.getOp().equals("/")) return eval(n.left()) / eval(n.right());
		}
	}