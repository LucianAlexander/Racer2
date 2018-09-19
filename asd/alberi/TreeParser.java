
import java.io.*; 
import java.util.*;

public class TreeParser {
	
	public static Tree<Integer> readTree() throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in)); 
		String s = r.readLine(); 
		StringTokenizer st = new StringTokenizer(s); 
		return readTree(st, st.nextToken()); 
	}

	private static Tree<Integer> readTree(StringTokenizer st, String nextToken) throws IOException {
		// Parsing della parentesi aperta
		assert nextToken.equals("("); 
		nextToken = st.nextToken(); 

		// Parsing della chiave
		int key = Integer.parseInt(nextToken); 
		nextToken = st.nextToken(); 

		Tree<Integer> t = new Tree<Integer>(key); 
		
		// Parsing dei sottoalberi
		while(!nextToken.equals(")")) {
			Tree<Integer> s = readTree(st, nextToken); 
			t.addSubtree(s); 
			nextToken = st.nextToken(); 
		}
		 
		return t; 
	}
		
}


