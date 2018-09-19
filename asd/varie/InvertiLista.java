
import java.util.*;

public class InvertiLista {

	public static LinkedList<Integer> invertiLista(ListIterator<Integer> li) {
		if(!li.hasNext()) return new LinkedList<Integer>();
		Integer i = li.next();
		LinkedList<Integer> cat = invertiLista(li);
		cat.add(i);
		return cat;
	}

}

-----------------------------

import java.util.*;

public class InvertiLista {

	public static void invertiLista(LinkedList<Integer> list) {
		if(list.size() > 1) {
			//ci sono almeno 2 elementi
			Integer head = list.pop();
			invertiLista(list);
			list.addLast(head);
		}
	}
}
