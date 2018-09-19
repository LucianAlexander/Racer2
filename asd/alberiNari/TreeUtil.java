
/**
 * Classe di utility
 */
public class TreeUtil {

	/*
	 * Stampa "graficamente" l'albero
	 */
    public static <E> void print(Tree<E> tree) {
        print(tree, 0);
    }

	/*
	 * Metodo ausiliario ricorsivo di print
	 */
    private static <E> void print(Tree<E> tree, int level) {
        for (int i = 0; i < level - 1; i++) {
            System.out.print("   ");
        }
        if (level > 0)
            System.out.print(" |--");
        System.out.println(tree.getRoot());
        for (Tree<E> subtree : tree.getSubtrees()) {
            print(subtree, level + 1);
        }
    }

	/*
	 * Stampa in preordine
	 */
	public static <E> void printPreorder(Tree<E> t) {
		System.out.print(t.getRoot() + " ");
		for (Tree<E> s : t.getSubtrees()) {
            printPreorder(s);
        }
	}

	/*
	 * Stampa in postordine
	 */
	public static <E> void printPostorder(Tree<E> t) {
		for (Tree<E> s : t.getSubtrees()) {
            printPostorder(s);
        }
	    System.out.print(t.getRoot() + " ");
	}

}
--------------------------------------------------------------

/**
 * Classe di utility
 */
public class TreeUtil {

	/*
	 * Stampa "graficamente" l'albero
	 */
    public static <E> void print(Tree<E> tree) {
        print(tree, 0);
    }

	/*
	 * Metodo ausiliario ricorsivo di print
	 */
    private static <E> void print(Tree<E> tree, int level) {
        for (int i = 0; i < level - 1; i++) {
            System.out.print("   ");
        }
        if (level > 0)
            System.out.print(" |--");
        System.out.println(tree.getRoot());
        for (Tree<E> subtree : tree.getSubtrees()) {
            print(subtree, level + 1);
        }
    }

	/*
	 * Stampa in preordine
	 */
	public static <E> void printPreorder(Tree<E> t) {
		System.out.print(t.getRoot() + " ");
		for (Tree<E> s : t.getSubtrees()) {
            printPreorder(s);
        }
	}

	/*
	 * Stampa in postordine
	 */
	public static <E> void printPostorder(Tree<E> t) {
		for (Tree<E> s : t.getSubtrees()) {
            printPostorder(s);
        }
	    System.out.print(t.getRoot() + " ");
	}

}
----------------------------

/**
 * Classe di utility
 */
public class TreeUtil {

	/*
	 * Stampa "graficamente" l'albero
	 */
    public static <E> void print(Tree<E> tree) {
        print(tree, 0);
    }

	/*
	 * Metodo ausiliario ricorsivo di print
	 */
    private static <E> void print(Tree<E> tree, int level) {
        for (int i = 0; i < level - 1; i++) {
            System.out.print("   ");
        }
        if (level > 0)
            System.out.print(" |--");
        System.out.println(tree.getRoot());
        for (Tree<E> subtree : tree.getSubtrees()) {
            print(subtree, level + 1);
        }
    }

	/*
	 * Stampa in preordine
	 */
	public static <E> void printPreorder(Tree<E> t) {
		System.out.print(t.getRoot() + " ");
		for (Tree<E> s : t.getSubtrees()) {
            printPreorder(s);
        }
	}

	/*
	 * Stampa in postordine
	 */
	public static <E> void printPostorder(Tree<E> t) {
		for (Tree<E> s : t.getSubtrees()) {
            printPostorder(s);
        }
	    System.out.print(t.getRoot() + " ");
	}

}
