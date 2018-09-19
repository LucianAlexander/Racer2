public class Kth {

    private Heap minHeap;
    private Heap maxHeap;
    private int k;

    public Kth(int k) {

        this.minHeap = new Heap(Heap.HEAP_TYPE.MIN_HEAP, k);
        this.maxHeap = new Heap(Heap.HEAP_TYPE.MAX_HEAP, k);
        this.k = k;
    }

    private void print() {

        this.maxHeap.print();
        this.minHeap.print();

    }


    public void insert(int key) {

        if (this.maxHeap.size() < this.k) {

            this.maxHeap.add(key);

        } else if (key >= this.maxHeap.peek()) {

            this.minHeap.add(key);

        } else {

            int old = this.maxHeap.poll();
            this.maxHeap.add(key);
            this.minHeap.add(old);

        }
    }

    public int get() {
        return maxHeap.peek();
    }

    public void remove() {

        if (this.minHeap.size() == 0) {

            this.maxHeap.poll();

        } else {

            int key = this.minHeap.poll();
            this.maxHeap.poll();
            this.maxHeap.add(key);

        }
    }

}
--------------------------------------------------
public class Kth {

    private Heap minHeap;
    private Heap maxHeap;
    private int k;

    public Kth(int k) {

        this.minHeap = new Heap(Heap.HEAP_TYPE.MIN_HEAP, k);
        this.maxHeap = new Heap(Heap.HEAP_TYPE.MAX_HEAP, k);
        this.k = k;
    }

    private void print() {

        this.maxHeap.print();
        this.minHeap.print();

    }


    public void insert(int key) {

        if (this.maxHeap.size() < this.k) {

            this.maxHeap.add(key);

        } else if (key >= this.maxHeap.peek()) {

            this.minHeap.add(key);

        } else {

            int old = this.maxHeap.poll();
            this.maxHeap.add(key);
            this.minHeap.add(old);

        }
    }

    public int get() {
        return maxHeap.peek();
    }

    public void remove() {

        if (this.minHeap.size() == 0) {

            this.maxHeap.poll();

        } else {

            int key = this.minHeap.poll();
            this.maxHeap.poll();
            this.maxHeap.add(key);

        }
    }

}
