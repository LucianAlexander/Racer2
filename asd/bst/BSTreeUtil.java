/**
 * Classe di utility
 */
public class BSTreeUtil {
    /**
     * Stampa un albero
     *
     * @param tree
     */
    public static void stampa(BSTree<String> tree) {
        stampa(tree.getRoot(), 0);
    }

    private static void stampa(BSPosition<String> root, int level) {
        if  (root == null) return;
        for (int i = 0; i < level - 1; i++) {
            System.out.print("   ");
        }
        if (level > 0)
            System.out.print(" |--");
        
		System.out.println("<"+root.getKey()+" "+root.getElement()+">");
        stampa(root.getLeftChild() , level + 1);
        stampa(root.getRightChild(), level + 1);		
    }

    public static void stampaInOrdine(BSTree<String> tree) {
        stampaInOrdine(tree.getRoot());
    }
	
	private static void stampaInOrdine(BSPosition<String> v) {	
	    if  (v == null)   
			return;

        stampaInOrdine(v.getLeftChild());
		System.out.print(v.getKey() + " ");		
        stampaInOrdine(v.getRightChild());		
	}	
}
