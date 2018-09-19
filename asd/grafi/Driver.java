import java.util.Iterator;
import java.util.List;

public class Driver {

    public static void print() {
        System.out.println("Richiesto argomento: {graph, path, bst}");
    }

    public static void main(String[] argv) {

        if (argv.length < 1) {
            print();
            return;
        }

        if (argv[0].equals("graph")) {

            Graph graph = new Graph<String>(Graph.GRAPH_TYPE.UNDIRECTED);

            Graph.GraphNode<String> a = graph.addNode("a");
            Graph.GraphNode<String> b = graph.addNode("b");
            Graph.GraphNode<String> c = graph.addNode("c");
            Graph.GraphNode<String> d = graph.addNode("d");
            Graph.GraphNode<String> e = graph.addNode("e");
            Graph.GraphNode<String> f = graph.addNode("f");
            Graph.GraphNode<String> g = graph.addNode("g");
            Graph.GraphNode<String> h = graph.addNode("h");

            graph.addEdge(a, b);
            graph.addEdge(a, f);
            graph.addEdge(b, c);
            graph.addEdge(b, f);
            graph.addEdge(c, d);
            graph.addEdge(d, b);
            graph.addEdge(e, f);
            graph.addEdge(f, c);
            graph.addEdge(g, h);

            System.out.print("Grafo UNDIRECTED\n\n");
            graphPrint(graph);
            System.out.print("\n");

            //

            graph = new Graph<String>(Graph.GRAPH_TYPE.DIRECTED);

            a = graph.addNode("a");
            b = graph.addNode("b");
            c = graph.addNode("c");
            d = graph.addNode("d");
            e = graph.addNode("e");
            f = graph.addNode("f");
            g = graph.addNode("g");
            h = graph.addNode("h");

            graph.addEdge(a, b);
            graph.addEdge(a, f);
            graph.addEdge(b, c);
            graph.addEdge(b, f);
            graph.addEdge(c, d);
            graph.addEdge(d, b);
            graph.addEdge(e, f);
            graph.addEdge(f, c);
            graph.addEdge(g, h);

            System.out.print("Grafo DIRECTED\n\n");
            graphPrint(graph);
            System.out.print("\n");

        } else if (argv[0].equals("path")) {

            Graph graph = new Graph<String>(Graph.GRAPH_TYPE.UNDIRECTED);

            Graph.GraphNode<String> a = graph.addNode("a");
            Graph.GraphNode<String> b = graph.addNode("b");
            Graph.GraphNode<String> c = graph.addNode("c");
            Graph.GraphNode<String> d = graph.addNode("d");
            Graph.GraphNode<String> e = graph.addNode("e");
            Graph.GraphNode<String> f = graph.addNode("f");
            Graph.GraphNode<String> g = graph.addNode("g");
            Graph.GraphNode<String> h = graph.addNode("h");

            graph.addEdge(a, b);
            graph.addEdge(a, f);
            graph.addEdge(b, c);
            graph.addEdge(b, f);
            graph.addEdge(c, d);
            graph.addEdge(d, b);
            graph.addEdge(e, f);
            graph.addEdge(f, c);
            graph.addEdge(g, h);

            System.out.print("Grafo UNDIRECTED\n\n");
            graphPrint(graph);
            System.out.print("\n");

            List<String> path = graph.getPath(a, f);
            Iterator<String> i = path.iterator();
            while (i.hasNext()) {
                System.out.print(i.next());
                if (i.hasNext())
                    System.out.print(" -> ");
            }
            System.out.print("\n");

        } else if (argv[0].equals("sweep")) {

            Graph graph = new Graph<String>(Graph.GRAPH_TYPE.DIRECTED);

            Graph.GraphNode<String> a = graph.addNode("a");
            Graph.GraphNode<String> b = graph.addNode("b");
            Graph.GraphNode<String> c = graph.addNode("c");
            Graph.GraphNode<String> d = graph.addNode("d");
            Graph.GraphNode<String> e = graph.addNode("e");
            Graph.GraphNode<String> f = graph.addNode("f");
            Graph.GraphNode<String> g = graph.addNode("g");
            Graph.GraphNode<String> h = graph.addNode("h");

            graph.addEdge(a, b);
            graph.addEdge(a, f);
            graph.addEdge(b, c);
            graph.addEdge(b, f);
            graph.addEdge(c, d);
            graph.addEdge(d, b);
            graph.addEdge(e, f);
            graph.addEdge(f, c);
            graph.addEdge(g, h);

            System.out.print("Grafo UNDIRECTED\n\n");
            graphPrint(graph);
            System.out.print("\n");

            graph.sweep();

        } else {
            print();
        }

    }

    private static <V> void graphPrint(Graph<V> g) {

        for (Graph.GraphNode<V> node : g.getNodes()) {

            System.out.print(g.getNodeValue(node) + " : ");
            for (Graph.GraphNode<V> n : g.getNeighbors(node))
                System.out.print(g.getNodeValue(n) + " ");

            System.out.print("\n");
        }
    }

}
----------------------------------
import java.io.File;

public class Driver {

    public static void print() {
        System.out.println("Richiesto argomento: {graph, input, count_comp, get_comp}");
    }

    public static void main(String[] argv) {

        if (argv.length < 1) {
            print();
            return;
        }

        if (argv[0].equals("graph")) {
            Graph<String> graph = new Graph<String>();

            Graph.GraphNode<String> a = graph.addNode("a");
            Graph.GraphNode<String> b = graph.addNode("b");
            Graph.GraphNode<String> c = graph.addNode("c");
            Graph.GraphNode<String> d = graph.addNode("d");
            Graph.GraphNode<String> e = graph.addNode("e");
            Graph.GraphNode<String> f = graph.addNode("f");
            Graph.GraphNode<String> g = graph.addNode("g");
            Graph.GraphNode<String> h = graph.addNode("h");

            graph.addEdge(a, b);
            graph.addEdge(a, f);
            graph.addEdge(b, c);
            graph.addEdge(b, f);
            graph.addEdge(c, d);
            graph.addEdge(d, b);
            graph.addEdge(e, f);
            graph.addEdge(f, c);
            graph.addEdge(g, h);

            System.out.println("Grafo iniziale");
            System.out.println(graph.printAdj());

            System.out.println("Rimozione " + f + "," + c);
            graph.removeEdge(f,c);
            System.out.println(graph.printAdj());

            System.out.println("Rimozione " + c + "," + b);
            graph.removeEdge(c,b);
            System.out.println(graph.printAdj());

            System.out.println("Rimozione " + d + "," + c);
            graph.removeEdge(d,c);
            System.out.println(graph.printAdj());

            System.out.println("Aggiunta " + c + "," + f);
            graph.addEdge(c,f);
            System.out.println(graph.printAdj());

            System.out.println("Aggiunta " + d + "," + c);
            graph.removeEdge(d,c);
            System.out.println(graph.printAdj());

            System.out.println("Rimozione nodo" + d);
            graph.removeNode(d);
            System.out.println(graph.printAdj());

            System.out.println("Rimozione nodo" + f);
            graph.removeNode(f);
            System.out.println(graph.printAdj());

            System.out.println("Rimozione nodo" + c);
            graph.removeNode(c);
            System.out.println(graph.printAdj());
        }
        else if(argv[0].equals("input")) {
        	File f = new File("graph.in");
        	Graph<String> g = Graph.readFF(f);
        	System.out.println("Rappresentazione ad archi:");
        	System.out.println(g);
        	System.out.println("Rappresentazione adiacenze:");
        	System.out.println(g.printAdj());
        }
        else if(argv[0].equals("count_comp")) {
        	Graph<String> graph = new Graph<String>();

            Graph.GraphNode<String> a = graph.addNode("a");
            Graph.GraphNode<String> b = graph.addNode("b");
            Graph.GraphNode<String> c = graph.addNode("c");
            Graph.GraphNode<String> d = graph.addNode("d");
            Graph.GraphNode<String> e = graph.addNode("e");
            Graph.GraphNode<String> f = graph.addNode("f");
            Graph.GraphNode<String> g = graph.addNode("g");
            Graph.GraphNode<String> h = graph.addNode("h");
            Graph.GraphNode<String> i = graph.addNode("i");

            graph.addEdge(a, b);
            graph.addEdge(a, f);
            graph.addEdge(b, c);
            graph.addEdge(b, f);
            graph.addEdge(c, d);
            graph.addEdge(d, b);
            graph.addEdge(e, f);
            graph.addEdge(f, c);
            graph.addEdge(g, h);

            System.out.println("Grafo:");
            System.out.println(graph.printAdj());
            System.out.println("Il grafo ha " + graph.nConComp() + " componenti connesse.");
        }
        else if(argv[0].equals("get_comp")) {
        	Graph<String> graph = new Graph<String>();

            Graph.GraphNode<String> a = graph.addNode("a");
            Graph.GraphNode<String> b = graph.addNode("b");
            Graph.GraphNode<String> c = graph.addNode("c");
            Graph.GraphNode<String> d = graph.addNode("d");
            Graph.GraphNode<String> e = graph.addNode("e");
            Graph.GraphNode<String> f = graph.addNode("f");
            Graph.GraphNode<String> g = graph.addNode("g");
            Graph.GraphNode<String> h = graph.addNode("h");
            Graph.GraphNode<String> i = graph.addNode("i");

            graph.addEdge(a, b);
            graph.addEdge(a, f);
            graph.addEdge(b, c);
            graph.addEdge(b, f);
            graph.addEdge(c, d);
            graph.addEdge(d, b);
            graph.addEdge(e, f);
            graph.addEdge(f, c);
            graph.addEdge(g, h);

            System.out.println("Grafo:");
            System.out.println(graph.printAdj());
            int k = 1;
            for(Graph<String> sub : graph.getConComp()) {
            	System.out.println("Sottografo " + k);
            	System.out.println(sub.printAdj());
            	k++;
            }
        }
    }
}
-----------------------------------------------
public class Driver {

    public static void print() {
        System.out.println("Richiesto argomento: {graph, sweep, top_sort, strong_cc}");
    }

    public static void main(String[] argv) {

        if (argv.length < 1) {
            print();
            return;
        }

        if (argv[0].equals("graph")) {
            Graph<String> graph = new Graph<String>();

            Graph.GraphNode<String> a = graph.addNode("a");
            Graph.GraphNode<String> b = graph.addNode("b");
            Graph.GraphNode<String> c = graph.addNode("c");
            Graph.GraphNode<String> d = graph.addNode("d");
            Graph.GraphNode<String> e = graph.addNode("e");
            Graph.GraphNode<String> f = graph.addNode("f");
            Graph.GraphNode<String> g = graph.addNode("g");
            Graph.GraphNode<String> h = graph.addNode("h");

            graph.addEdge(a, b);
            graph.addEdge(a, f);
            graph.addEdge(b, c);
            graph.addEdge(b, f);
            graph.addEdge(c, d);
            graph.addEdge(d, b);
            graph.addEdge(e, f);
            graph.addEdge(f, c);
            graph.addEdge(g, h);

            System.out.println("Grafo iniziale");
            System.out.println(graph);

            System.out.println("Rimozione " + f + "," + c);
            graph.removeEdge(f,c);
            System.out.println(graph);

            System.out.println("Rimozione " + c + "," + b);
            graph.removeEdge(c,b);
            System.out.println(graph);

            System.out.println("Rimozione " + d + "," + c);
            graph.removeEdge(d,c);
            System.out.println(graph);

            System.out.println("Aggiunta " + c + "," + f);
            graph.addEdge(c,f);
            System.out.println(graph);

            System.out.println("Aggiunta " + d + "," + c);
            graph.removeEdge(d,c);
            System.out.println(graph);

            System.out.println("Rimozione nodo" + d);
            graph.removeNode(d);
            System.out.println(graph);

            System.out.println("Rimozione nodo" + f);
            graph.removeNode(f);
            System.out.println(graph);

            System.out.println("Rimozione nodo" + c);
            graph.removeNode(c);
            System.out.println(graph);
        }
        else if (argv[0].equals("sweep")) {
        	Graph<String> graph = new Graph<String>();

            Graph.GraphNode<String> a = graph.addNode("a");
            Graph.GraphNode<String> b = graph.addNode("b");
            Graph.GraphNode<String> c = graph.addNode("c");
            Graph.GraphNode<String> d = graph.addNode("d");
            Graph.GraphNode<String> e = graph.addNode("e");
            Graph.GraphNode<String> f = graph.addNode("f");
            Graph.GraphNode<String> g = graph.addNode("g");
            Graph.GraphNode<String> h = graph.addNode("h");

            graph.addEdge(a, b);
            graph.addEdge(a, f);
            graph.addEdge(b, c);
            graph.addEdge(b, f);
            graph.addEdge(c, d);
            graph.addEdge(d, b);
            graph.addEdge(e, f);
            graph.addEdge(f, c);
            graph.addEdge(g, h);

            System.out.println("Grafo:");
            System.out.println(graph);
            GraphServices.sweep(graph);
        }
        else if (argv[0].equals("top_sort")) {
        	Graph<String> graph = new Graph<String>();

            Graph.GraphNode<String> a = graph.addNode("a");
            Graph.GraphNode<String> b = graph.addNode("b");
            Graph.GraphNode<String> c = graph.addNode("c");
            Graph.GraphNode<String> d = graph.addNode("d");
            Graph.GraphNode<String> e = graph.addNode("e");
            Graph.GraphNode<String> f = graph.addNode("f");
            Graph.GraphNode<String> g = graph.addNode("g");
            Graph.GraphNode<String> h = graph.addNode("h");

            graph.addEdge(a, b);
            graph.addEdge(a, f);
            graph.addEdge(b, c);
            graph.addEdge(b, f);
            graph.addEdge(c, d);
            graph.addEdge(d, b);
            graph.addEdge(e, f);
            graph.addEdge(f, c);
            graph.addEdge(g, h);

            System.out.println("Grafo:");
            System.out.println(graph);

            System.out.println("Primo tentativo: (dovrebbe fallire)");
            GraphServices.topologicalSort(graph);

            System.out.println("Rimozione arco (d,b)");
            graph.removeEdge(d, b);

            System.out.println("Nuovo Grafo:");
            System.out.println(graph);

            System.out.println("Secondo tentativo: (dovrebbe riuscire)");
            GraphServices.topologicalSort(graph);
        }
        else if (argv[0].equals("strong_cc")) {
        	Graph<String> graph = new Graph<String>();

            Graph.GraphNode<String> a = graph.addNode("a");
            Graph.GraphNode<String> b = graph.addNode("b");
            Graph.GraphNode<String> c = graph.addNode("c");
            Graph.GraphNode<String> d = graph.addNode("d");
            Graph.GraphNode<String> e = graph.addNode("e");
            Graph.GraphNode<String> f = graph.addNode("f");
            Graph.GraphNode<String> g = graph.addNode("g");
            Graph.GraphNode<String> h = graph.addNode("h");

            graph.addEdge(a, b);
            graph.addEdge(a, f);
            graph.addEdge(b, c);
            graph.addEdge(b, f);
            graph.addEdge(c, d);
            graph.addEdge(d, b);
            graph.addEdge(e, f);
            graph.addEdge(f, c);
            graph.addEdge(g, h);

            System.out.println("Grafo:");
            System.out.println(graph);

            GraphServices.strongConnectedComponents(graph);
        }
    } //main
} // class
-------------------------------------------
public class Driver {

	private Driver() {}

	public static void main(String[] args) {
		Graph<String> gra = new Graph<String>();

		Node<String> a = new Node<String>(new String("a"));
		Node<String> b = new Node<String>(new String("b"));
		Node<String> c = new Node<String>(new String("c"));
		Node<String> d = new Node<String>(new String("d"));
		Node<String> e = new Node<String>(new String("e"));
		Node<String> f = new Node<String>(new String("f"));

		gra.insertNode(a);
		gra.insertNode(b);
		gra.insertNode(c);
		gra.insertNode(d);
		gra.insertNode(e);
		gra.insertNode(f);

		gra.insertEdge(a, b, 2);
		gra.insertEdge(a, c, 1);
		gra.insertEdge(a, d, 5);
		gra.insertEdge(b, c, 2);
		gra.insertEdge(b, d, 3);
		gra.insertEdge(c, d, 3);
		gra.insertEdge(c, e, 1);
		gra.insertEdge(e, d, 1);
		gra.insertEdge(d, f, 5);
		gra.insertEdge(e, f, 2);

		System.out.println("Grafo:");
		System.out.println(gra);

		// Test per BFS
		System.out.println("BFS: ");
		GraphServices.bfs(gra);
		System.out.println("");

		// Test per SSSP
		System.out.println("SSSP dal nodo 'a':");
		GraphServices.sssp(gra, a);
		System.out.println("");

		// Test per MST
		System.out.println("MST:");
		GraphServices.mst(gra);
	}
}
