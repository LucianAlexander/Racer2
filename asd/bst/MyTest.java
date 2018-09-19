import java.util.*;

public class MyTest {

	public static void main(String[] args) {
		BSTree<String> t             = new MyBSTree<String>();
		BSPosition<String> a         = t.insert(1, "Nero");
		BSPosition<String> b         = t.insert(0, "Blu");		
		BSPosition<String> c         = t.insert(2, "Grigio");
		BSPosition<String> d         = t.insert(3, "Bianco");
		BSPosition<String> e         = t.insert(8, "Rosa");
		BSPosition<String> f         = t.insert(5, "Verde");		
		BSPosition<String> g         = t.insert(9, "Arancio");			
		BSTreeUtil.stampa(t);
		BSTreeUtil.stampaInOrdine(t);	
		System.out.println();
		
		t.remove(8, "Rosa");
		BSTreeUtil.stampa(t);
		BSTreeUtil.stampaInOrdine(t);				
		System.out.println();
		
		String val        = t.find(3);
		System.out.println("Trovato " + 3 + " -> " + val);
	}
}