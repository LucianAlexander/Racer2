    public class BinNode{
        private int key;
        private BinNode left;
        private BinNode right;

        public BinNode(int key) {
            this.key = key;
            this.left = null;
            this.right = null;
        }

        public BinNode getLeft(){
        	return left;
        }

        public BinNode getRight(){
        	return right;
        }

        public BinNode setLeft(BinNode n){
        	left = n;
        	return left;
        }

        public BinNode setRight(BinNode n){
        	right = n;
        	return right;
        }

        public int getKey(){
        	return key;
        }
    }
    ----------------------------
    public class BinNode{
        /* NON MODIFICARE NIENTE IN QUESTO FILE */
        protected int[] coordinates;
        protected BinNode left;
        protected BinNode right;

        public BinNode(int x, int y) {
            coordinates = new int[2];
            coordinates[0] = x;
            coordinates[1] = y;
            this.left = null;
            this.right = null;
        }

        public BinNode getLeft(){
          return left;
        }

        public BinNode getRight(){
          return right;
        }

        public BinNode setLeft(BinNode n){
          left = n;
          return left;
        }

        public BinNode setRight(BinNode n){
          right = n;
          return right;
        }

        public int[] getCoordinates(){
            return coordinates;
        }
    }
---------------------------
public class BinNode{
    protected double[] coordinates;
    protected BinNode left;
    protected BinNode right;

    public BinNode(double x, double y) {
        coordinates = new double[2];
        coordinates[0] = x;
        coordinates[1] = y;
        this.left = null;
        this.right = null;
    }

    public BinNode getLeft(){
      return left;
    }

    public BinNode getRight(){
      return right;
    }

    public BinNode setLeft(BinNode n){
      left = n;
      return left;
    }

    public BinNode setRight(BinNode n){
      right = n;
      return right;
    }

    public double[] getCoordinates(){
        return coordinates;
    }
}
