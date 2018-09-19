// Esame del 12 settembre 2012, esercizio 2
// Ricordarsi di specificare sempre, nei commenti al codice, l'utilità di ogni metodo.

class RecursionNode has int[] config, RecursionNode left, RecursionNode right and methods addLeft and addRight;
class RecursionTree has constructor public RecursionTree(int[] config); and method getRoot;

public static RecursionTree mergeSort(int[] a)
	{
	RecursionTree t = new RecursionTree(a);
	mergeSort(a, t.getRoot());
	return t;
	}

public static int[] mergeSort(int[] a, RecursionNode n)
	{
	if(a.length <= 1) return a;
	int[] b = new int[a.length / 2];
	int[] c = new int[a.length / 2];
	n.addLeftChild(b);
	n.addRightChild(c);
	b = mergeSort(b, n.left);
	c = mergeSort(c, n.right);
	return merge(b, c);
	}

public static int[] merge(int[] b, int[] c)
	{
	int[] a = new int[b.length + c.length];
	int leftIndex = 0;
	int rightIndex = 0;
	for(int i = 0; i < a.length; i++)
		{
		if(rightIndex >= c.length || b[leftIndex] <= c[rightIndex])
			{
			a[i] = b[leftIndex];
			leftIndex++;
			}
		else
			{
			a[i] = c[rightIndex];
			rightIndex++;
			}
		}
	return a;
	}

public void inorder()
	{
	inorder(root);
	}

public void inorder(RecursionNode n)
	{
	if(n.hasLeft()) inorder(n.left());
	System.out.println(n);
	if(n.hasRight()) inorder(n.right());
	}