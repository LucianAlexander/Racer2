public class BST<V> {

    private Node<V> root;

    private class Node<V> {
        private int key;
        private V value;
        private Node<V> left;
        private Node<V> right;

        public Node(int key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public BST(int key, V value) {
        this.root = new Node<V>(key, value);
    }

    private void insert(Node<V> t, int k, V v) {

        if (t.key == k) {

            t.value = v;

        } else if (k < t.key) {

            if (t.left == null)
                t.left = new Node<V>(k, v);
            else
                insert(t.left, k, v);

        } else {

            if (t.right == null)
                t.right = new Node<V>(k, v);
            else
                insert(t.right, k, v);

        }
    }

    public void insert(int k, V v) {

        if (this.root == null)
            this.root = new Node<V>(k, v);

        else
            insert(this.root, k, v);
    }

    private V find(Node<V> t, int k) {

        if (t == null)
            return null;

        else if (t.key == k)
            return t.value;

        else if (k < t.key)
            return find(t.left, k);

        else
            return find(t.right, k);
    }

    public V find(int k) {
        if (this.root == null)
            return null;
        else
            return find(this.root, k);
    }

    private Node<V> findMin(Node<V> t) {

        if (t.left == null)
            return t;

        return findMin(t.left);
    }

    public int findMin() {

        if (this.root == null)
            return -1;

        return findMin(this.root).key;
    }

    private Node<V> removeMin(Node<V> t) {

        // we are on the min key
        if (t.left == null) {
            return t.right;
        }

        t.left = removeMin(t.left);
        return t;
    }

    public void removeMin() {

        if (this.root == null)
            return;

        this.root = removeMin(this.root);
    }

    private Node<V> remove(Node<V> n, int k) {

        if (n == null) return null;

        else if (k < n.key)
            n.left = remove(n.left, k);

        else if (k > n.key)
            n.right = remove(n.right, k);

        else {

            if (n.right == null) {
                return n.left;
            }

            if (n.left == null) {
                return n.right;
            }

            // two children case
            Node<V> to_remove = n;

            n = findMin(to_remove.right);
            Node<V> nn = new Node<V>(n.key, n.value);
            nn.right = removeMin(to_remove.right);
            nn.left = to_remove.left;
            n = nn;
        }

        return n;
    }

    public void remove(int k) {

        if (this.root == null)
            return;

        this.root = remove(this.root, k);
    }

    private void print(Node<V> t, int level) {

        if (t == null)
            return;

        for (int i = 0; i < level - 1; i++) {
            System.out.print("   ");
        }

        if (level > 0) {
            System.out.print(" |--");
        }

        System.out.println(t.key);

        print(t.left, level + 1);
        print(t.right, level + 1);
    }

    void print(){
        print(this.root, 0);
    }


    private Node<V> predecessor(Node<V> n, int k) {

        if (n == null)
            return null;

        else if (k <= n.key)
            return predecessor(n.left, k);

        Node<V> t = predecessor(n.right, k);
        if (t == null)
            return n;

        return t;
    }

    int predecessor(int k) {

        Node<V> predecessor = predecessor(this.root, k);
        if (predecessor == null)
            return -1;
        else
            return predecessor.key;
    }

}
--------------------------------------
public class BST<V> {

    private Node<V> root;

    private class Node<V> {
        private int key;
        private V value;
        private Node<V> left;
        private Node<V> right;

        public Node(int key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public BST(int key, V value) {
        this.root = new Node<V>(key, value);
    }

    private void insert(Node<V> t, int k, V v) {

        if (t.key == k) {

            t.value = v;

        } else if (k < t.key) {

            if (t.left == null)
                t.left = new Node<V>(k, v);
            else
                insert(t.left, k, v);

        } else {

            if (t.right == null)
                t.right = new Node<V>(k, v);
            else
                insert(t.right, k, v);

        }
    }

    public void insert(int k, V v) {

        if (this.root == null)
            this.root = new Node<V>(k, v);

        else
            insert(this.root, k, v);
    }

    private V find(Node<V> t, int k) {

        if (t == null)
            return null;

        else if (t.key == k)
            return t.value;

        else if (k < t.key)
            return find(t.left, k);

        else
            return find(t.right, k);
    }

    public V find(int k) {
        if (this.root == null)
            return null;
        else
            return find(this.root, k);
    }

    private Node<V> findMin(Node<V> t) {

        if (t.left == null)
            return t;

        return findMin(t.left);
    }

    public int findMin() {

        if (this.root == null)
            return -1;

        return findMin(this.root).key;
    }

    private Node<V> removeMin(Node<V> t) {

        // we are on the min key
        if (t.left == null) {
            return t.right;
        }

        t.left = removeMin(t.left);
        return t;
    }

    public void removeMin() {

        if (this.root == null)
            return;

        this.root = removeMin(this.root);
    }

    private Node<V> remove(Node<V> n, int k) {

        if (n == null) return null;

        else if (k < n.key)
            n.left = remove(n.left, k);

        else if (k > n.key)
            n.right = remove(n.right, k);

        else {

            if (n.right == null) {
                return n.left;
            }

            if (n.left == null) {
                return n.right;
            }

            // two children case
            Node<V> to_remove = n;

            n = findMin(to_remove.right);
            Node<V> nn = new Node<V>(n.key, n.value);
            nn.right = removeMin(to_remove.right);
            nn.left = to_remove.left;
            n = nn;
        }

        return n;
    }

    public void remove(int k) {

        if (this.root == null)
            return;

        this.root = remove(this.root, k);
    }

    private void print(Node<V> t, int level) {

        if (t == null)
            return;

        for (int i = 0; i < level - 1; i++) {
            System.out.print("   ");
        }

        if (level > 0) {
            System.out.print(" |--");
        }

        System.out.println(t.key);

        print(t.left, level + 1);
        print(t.right, level + 1);
    }

    void print(){
        print(this.root, 0);
    }


    private Node<V> predecessor(Node<V> n, int k) {

        if (n == null)
            return null;

        else if (k <= n.key)
            return predecessor(n.left, k);

        Node<V> t = predecessor(n.right, k);
        if (t == null)
            return n;

        return t;
    }

    int predecessor(int k) {

        Node<V> predecessor = predecessor(this.root, k);
        if (predecessor == null)
            return -1;
        else
            return predecessor.key;
    }

}

----------------------------------
public class BST<V> {
    //dichiaro la costante nodo radice del BST
    private Node<V> root;
    //dichiaro la classe Node
    private class Node<V> {
        private int key;
        private V value;
        private Node<V> left;
        private Node<V> right;
    // funzione/costruttore che costruisce un nodo con chiave e valore
        public Node(int key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    // 1.una funzione che construisce un BST che contiene un unico nodo (k, v):
    public BST(int key, V value) {
        this.root = new Node<V>(key, value);
    }
    // 3.1 chiamato ricorsivamente da 3 insert(chiave,valore)
    private void insert(Node<V> t, int k, V v) {

        if (t.key == k) {

            t.value = v;

        } else if (k < t.key) {

            if (t.left == null)
                t.left = new Node<V>(k, v);
            else
                insert(t.left, k, v);

        } else {

            if (t.right == null)
                t.right = new Node<V>(k, v);
            else
                insert(t.right, k, v);

        }
    }
    // 3.una funzione che inserisce la coppia (k, value) nel punto appropriato del BST:
    public void insert(int k, V v) {

        if (this.root == null)
            this.root = new Node<V>(k, v);

        else
            insert(this.root, k, v);
    }
    //2.1 viene chiamato ricorsivamente
    private V find(Node<V> t, int k) {

        if (t == null)
            return null;

        else if (t.key == k)
            return t.value;

        else if (k < t.key)
            return find(t.left, k);

        else
            return find(t.right, k);
    }
  // 2.una funzione che restituisce l’unico valore associato ad una chiave k:
    public V find(int k) {
        if (this.root == null)
            return null;
        else
            return find(this.root, k);
    }

    private Node<V> findMin(Node<V> t) {

        if (t.left == null)
            return t;

        return findMin(t.left);
    }

    public int findMin() {

        if (this.root == null)
            return -1;

        return findMin(this.root).key;
    }
  // 4.1 chiamato ricorsivamente da removeMin() passandoli la radice
    private Node<V> removeMin(Node<V> t) {

        // we are on the min key
        if (t.left == null) {
            return t.right;
        }

        t.left = removeMin(t.left);
        return t;
    }
   // 4 una funzione che elimina il nodo con la chiave minima contenuta dal BST:
    public void removeMin() {

        if (this.root == null)
            return;

        this.root = removeMin(this.root);
    }
   // 5.1 Chiamato ricorsivamente da remove(k) passandoli il nodo root da cui iniziare
    private Node<V> remove(Node<V> n, int k) {

        if (n == null) return null;

        else if (k < n.key)
            n.left = remove(n.left, k);

        else if (k > n.key)
            n.right = remove(n.right, k);

        else {

            if (n.right == null) {
                return n.left;
            }

            if (n.left == null) {
                return n.right;
            }

            // two children case
            Node<V> to_remove = n;

            n = findMin(to_remove.right);
            Node<V> nn = new Node<V>(n.key, n.value);
            nn.right = removeMin(to_remove.right);
            nn.left = to_remove.left;
            n = nn;
        }

        return n;
    }
    // 5.una funzione che elimina dal BST il nodo con chiave k (se esiste):
    public void remove(int k) {

        if (this.root == null)
            return;

        this.root = remove(this.root, k);
    }
    // 6.1 chiamato ricorsivamente da 6
    private void print(Node<V> t, int level) {

        if (t == null)
            return;

        for (int i = 0; i < level - 1; i++) {
            System.out.print("   ");
        }

        if (level > 0) {
            System.out.print(" |--");
        }

        System.out.println(t.key);

        print(t.left, level + 1);
        print(t.right, level + 1);
    }
    //6. una funzione che stampa in stdout una qualsiasi rappresentazione dell’albero:
    void print(){
        print(this.root, 0);
    }


    private Node<V> predecessor(Node<V> n, int k) {

        if (n == null)
            return null;

        else if (k <= n.key)
            return predecessor(n.left, k);

        Node<V> t = predecessor(n.right, k);
        if (t == null)
            return n;

        return t;
    }

    int predecessor(int k) {

        Node<V> predecessor = predecessor(this.root, k);
        if (predecessor == null)
            return -1;
        else
            return predecessor.key;
    }

}
-----------------------------------------
public class BST<V> {

    private Node<V> root;

    private class Node<V> {
        private int key;
        private V value;
        private Node<V> left;
        private Node<V> right;

        public Node(int key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public BST(int key, V value) {
        this.root = new Node<V>(key, value);
    }

    private void insert(Node<V> t, int k, V v) {

        if (t.key == k) {

            t.value = v;

        } else if (k < t.key) {

            if (t.left == null)
                t.left = new Node<V>(k, v);
            else
                insert(t.left, k, v);

        } else {

            if (t.right == null)
                t.right = new Node<V>(k, v);
            else
                insert(t.right, k, v);

        }
    }

    public void insert(int k, V v) {

        if (this.root == null)
            this.root = new Node<V>(k, v);

        else
            insert(this.root, k, v);
    }

    private V find(Node<V> t, int k) {

        if (t == null)
            return null;

        else if (t.key == k)
            return t.value;

        else if (k < t.key)
            return find(t.left, k);

        else
            return find(t.right, k);
    }

    public V find(int k) {
        if (this.root == null)
            return null;
        else
            return find(this.root, k);
    }

    private Node<V> findMin(Node<V> t) {

        if (t.left == null)
            return t;

        return findMin(t.left);
    }

    public int findMin() {

        if (this.root == null)
            return -1;

        return findMin(this.root).key;
    }

    private Node<V> removeMin(Node<V> t) {

        // we are on the min key
        if (t.left == null) {
            return t.right;
        }

        t.left = removeMin(t.left);
        return t;
    }

    public void removeMin() {

        if (this.root == null)
            return;

        this.root = removeMin(this.root);
    }

    private Node<V> remove(Node<V> n, int k) {

        if (n == null) return null;

        else if (k < n.key)
            n.left = remove(n.left, k);

        else if (k > n.key)
            n.right = remove(n.right, k);

        else {

            if (n.right == null) {
                return n.left;
            }

            if (n.left == null) {
                return n.right;
            }

            // two children case
            Node<V> to_remove = n;

            n = findMin(to_remove.right);
            Node<V> nn = new Node<V>(n.key, n.value);
            nn.right = removeMin(to_remove.right);
            nn.left = to_remove.left;
            n = nn;
        }

        return n;
    }

    public void remove(int k) {

        if (this.root == null)
            return;

        this.root = remove(this.root, k);
    }

    private void print(Node<V> t, int level) {

        if (t == null)
            return;

        for (int i = 0; i < level - 1; i++) {
            System.out.print("   ");
        }

        if (level > 0) {
            System.out.print(" |--");
        }

        System.out.println(t.key);

        print(t.left, level + 1);
        print(t.right, level + 1);
    }

    void print(){
        print(this.root, 0);
    }


    private Node<V> predecessor(Node<V> n, int k) {

        if (n == null)
            return null;

        else if (k <= n.key)
            return predecessor(n.left, k);

        Node<V> t = predecessor(n.right, k);
        if (t == null)
            return n;

        return t;
    }

    int predecessor(int k) {

        Node<V> predecessor = predecessor(this.root, k);
        if (predecessor == null)
            return -1;
        else
            return predecessor.key;
    }

}
--------------------------
public class BST{

    private BinNode root;

    public BST() {
        /* NON MODIFICARE */
        this.root = null;
    }

    public BinNode BST_insert(int x, int y) {
        /*DA IMPLEMENTARE*/
        return null; //istruzione aggiunta per permettere la compilazione
    }

     public void print(BinNode t, int level) {
        /* MODOFICABILE*/
        for (int i = 0; i < level - 1; i++) {
            System.out.print("   ");
        }

        if (level > 0) {
            System.out.print(" |--");
        }
        if (t == null){
            System.out.println("#");
            return;
        }


        System.out.println( "(" + t.getCoordinates()[0] + "," + t.getCoordinates()[1] + ")" );

        print(t.getLeft(), level + 1);
        print(t.getRight(), level + 1);
    }
    public void BST_print(){
        /* MODOFICABILE*/
        print(root, 0);
    }

    public int aligned(int x){
        /*DA IMPLEMENTARE*/
        return 0; //istruzione aggiunta per permettere la compilazione
    }

    public int rangeQ(int x1, int y1, int x2, int y2){
        /*DA IMPLEMENTARE*/
        return 0; //istruzione aggiunta per permettere la compilazione
    }

}
public class BST{

    private BinNode root;
    private int size;
//Pi greco: Math.PI

    public BST() {
        /*NON MODIFICARE*/
        this.root = null;
        size = 0;
    }


    private double getRadius(double x, double y){
        return Math.sqrt(x*x+y*y);
    }

     private double getRadius(BinNode t){
        return getRadius(t.getCoordinates()[0],t.getCoordinates()[1]);
    }

    private double getPhase(double x, double y){
        return Math.atan2(y,x);
    }

    private double getPhase(BinNode t){
        return getPhase(t.getCoordinates()[0],t.getCoordinates()[1]);
    }



    public BinNode BST_insert(double x, double y) {
        /****DA IMPLEMENTARE****/
        return null; //istruzione aggiunta per permettere la compilazione

    }

    private void print(BinNode t, int level, char pos) {
        /*NODIFICABILE*/
        if (t==null) return;
        for (int i = 0; i < level - 1; i++) {
            System.out.print("   ");
        }

        if (level > 0) {
            System.out.print(" "+pos+":--");
        }

        System.out.println("coordinate: ("+ t.getCoordinates()[0]+","+t.getCoordinates()[1]+"); radius="
            + getRadius(t) + " ; phase=" + getPhase(t) );

        print(t.getLeft(), level + 1,'l');
        print(t.getRight(), level + 1,'r');
    }
    public void BST_print(){
        /*MODIFICABILE*/
        if (root!=null)
            print(this.root, 0,' ');
    }


    public int corona(double r1, double r2){
        /****DA IMPLEMENTARE****/
        return -1; //istruzione aggiunta per permettere la compilazione
    }

    public double maxCorona(){
        /****DA IMPLEMENTARE****/
        return -1; //istruzione aggiunta per permettere la compilazione
    }






}
