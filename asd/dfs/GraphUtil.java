import java.util.*;

public class GraphUtil {

	public static void stampa(Graph<String> g) {
		for (Node<String> v : g.getNodes()) {
			System.out.print(v + " : ");

			for (Node<String> u : g.getOutEdges(v)) {
				System.out.print(u+" ");
			}
			System.out.println();
		}
	}

}

---
import java.util.*;

public class GraphUtil {

	public static void stampa(Graph<String> g) {
		for (Node<String> v : g.getNodes()) {
			System.out.print(v + " : ");

			for (Node<String> u : g.getOutEdges(v)) {
				System.out.print(u+" ");
			}
			System.out.println();
		}
	}

}
