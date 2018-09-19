
import java.util.*;


public class PreOrderIterator<E> implements Iterator<Tree<E>> {

	private Stack<Tree<E>> pila;

	/*
	 * Inizializza l'iteratore sull'albero T
	 */
	PreOrderIterator(Tree<E> t) {
		pila = new Stack<Tree<E>>();
		pila.push(t);
	}

	/*
	 * Ritorna true se l'iterazione non si è conclusa
	 */
	public boolean hasNext() {
		return !pila.isEmpty();
	}

	/*
	 * Restituisce il successivo elemento dell'iterazione
	 */
	public Tree<E> next() {
		Tree<E> tree = pila.pop();

		List<Tree<E>> subtrees = tree.getSubtrees();

		/*
			Inserendo i figli nell'ordine dato dalla lista listaFigli,
			si ottiene la visita in preordine in cui i sottoalberi
			più a destra sono visitati prima di quelli a sinistra
			(nota bene: si tratta comunque di una visita in preordine)
		*/

		//for(Tree<E> s : subtrees)
		//	pila.push(s);


		/*
			In alternativa, per ottenere la visita in preordine
			che visita i sottoalberi da sinistra verso destra
			è sufficiente inserire i figli nell'ordine inverso.
			Inizializziamo un iteratore bidirezionale posizionato alla fine della lista
		*/
		ListIterator<Tree<E>> lit = subtrees.listIterator(subtrees.size());
		// 	ed inseriamo i figli scorrendo la lista in senso inverso
		while(lit.hasPrevious()) pila.push(lit.previous());

		return tree;
	}

	/*
		La remove rimuove dalla struttura dati sottostante l'iteratore (in questo
		caso, l'albero) l'ultimo elemento ritornato dalla next()
		E' un'operazione opzionale ovvero può non essere supportata dall'interfaccia
		(restituendo un'eccezione di tipo UnsupportedOperationException)
		In questo caso decidiamo di non supportarla
	*/
	public void remove() {
		throw new UnsupportedOperationException("remove non supportata");
	}

}
---------------------

import java.util.*;


public class PreOrderIterator<E> implements Iterator<Tree<E>> {

	private Stack<Tree<E>> pila;

	/*
	 * Inizializza l'iteratore sull'albero T
	 */
	PreOrderIterator(Tree<E> t) {
		pila = new Stack<Tree<E>>();
		pila.push(t);
	}

	/*
	 * Ritorna true se l'iterazione non si è conclusa
	 */
	public boolean hasNext() {
		return !pila.isEmpty();
	}

	/*
	 * Restituisce il successivo elemento dell'iterazione
	 */
	public Tree<E> next() {
		Tree<E> tree = pila.pop();

		List<Tree<E>> subtrees = tree.getSubtrees();

		/*
			Inserendo i figli nell'ordine dato dalla lista listaFigli,
			si ottiene la visita in preordine in cui i sottoalberi
			più a destra sono visitati prima di quelli a sinistra
			(nota bene: si tratta comunque di una visita in preordine)
		*/

		//for(Tree<E> s : subtrees)
		//	pila.push(s);


		/*
			In alternativa, per ottenere la visita in preordine
			che visita i sottoalberi da sinistra verso destra
			è sufficiente inserire i figli nell'ordine inverso.
			Inizializziamo un iteratore bidirezionale posizionato alla fine della lista
		*/
		ListIterator<Tree<E>> lit = subtrees.listIterator(subtrees.size());
		// 	ed inseriamo i figli scorrendo la lista in senso inverso
		while(lit.hasPrevious()) pila.push(lit.previous());

		return tree;
	}

	/*
		La remove rimuove dalla struttura dati sottostante l'iteratore (in questo
		caso, l'albero) l'ultimo elemento ritornato dalla next()
		E' un'operazione opzionale ovvero può non essere supportata dall'interfaccia
		(restituendo un'eccezione di tipo UnsupportedOperationException)
		In questo caso decidiamo di non supportarla
	*/
	public void remove() {
		throw new UnsupportedOperationException("remove non supportata");
	}

}
