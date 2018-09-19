
import java.util.*;


public class PostOrderIterator<E> implements Iterator<Tree<E>> {

	private Stack<Tree<E>> pila;

	/*
	 * Inizializza l'iteratore sull'albero T
	 */
	PostOrderIterator(Tree<E> t) {
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
		/*
			Nel caso della visita in postordine, non è possibile scartare il nodo in cima alla pila
			non appena lo si incontra, in quanto non sappiamo se il sottoalbero corrispondente
			è già stato processato oppure va ancora inserito in pila.
			Utilizziamo a questo scopo uno speciale nodo "marcatore" di valore null, che se incontrato
			in cima alla pila segnala che tutti i figli del nodo che si trova sotto al marcatore (nella
			pila) sono stati processati.
			Nota. In questo caso il costo della next() è lineare nel numero di discendenti
			(anziché di figli) del nodo in cima alla pila prima della chiamata a next().
		*/

		// Leggiamo l'elemento in cima alla pila, senza (per ora) rimuoverlo
		Tree<E> tree = pila.peek();

		// Finché pila.peek() non è null, dobbiamo continuare a inserire le liste dei figli
		while(tree != null) {
			List<Tree<E>> subtrees = tree.getSubtrees();

			// Inseriamo ora il marcatore speciale (null) che segnalerà
			// che tutti i figli sono stati processati
			pila.push(null);

			// Inizializziamo un iteratore bidirezionale posizionato alla fine della lista
			ListIterator<Tree<E>> lit = subtrees.listIterator(subtrees.size());
			// ed inseriamo i figli scorrendo la lista in senso inverso
			while(lit.hasPrevious()) pila.push(lit.previous());

			// Verifichiamo qual è il prossimo elemento in pila
			tree = pila.peek();
		}

		// Giunti a questo punto sappiamo che pila.peek() == null
		// quindi tutti i figli del nodo sotto il marcatore sono già stati processati

		// Rimuoviamo il marcatore
		pila.pop();

		// Possiamo ora processare il padre (ora in cima alla pila)
		// e rimuoverlo dalla pila
		Tree<E> parent = pila.pop();

		return parent;
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
