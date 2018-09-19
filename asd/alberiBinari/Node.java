public class Node {

    private String nome;
    private Node parent;
    private Node firstChild;
    private Node nextSibling;
    private int size;
    private boolean isDir;

    public Node(String n, int s, boolean isD) {
        if (n.length() <= 16)
            nome = n;
            else
            nome = n.substring(0, 16);
        size = s;
        isDir = isD;
        parent = null;
        firstChild = null;
        nextSibling = null;
    }

    public String getNome() {
        return this.nome;
    }

    public int getSize(){
        return size;
    }

    public void setSize(int s){
        size = s;
    }


    public boolean getIsDir(){
        return isDir;
    }

    public void setFirstChild (Node firstChild){
        this.firstChild = firstChild;
    }

    public Node getFirstChild() {
        return this.firstChild;
    }

    public void setNextSibling (Node nextSibling) {
        this.nextSibling = nextSibling;
    }

    public Node getNextSibling() {
        return this.nextSibling;
    }

    public void setParent (Node parent) {
        this.parent = parent;
    }

    public Node getParent() {
        return this.parent;
    }

 /*   private static void printTreeRic(Node n, int depth) {

        if (n == null)
            return;

        for (int i = 0; i < depth; i++)
            System.out.print("-");

        System.out.println(n.getNodeInfo());
        printTreeRic(n.getFirstChild(), depth + 1);
        printTreeRic(n.getNextSibling(), depth);
    }

    public void printTree() {
        printTreeRic(this, 0);
    }
*/}
