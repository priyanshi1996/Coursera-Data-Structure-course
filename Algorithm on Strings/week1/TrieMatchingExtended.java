import java.io.*;
import java.util.*;

public class TrieMatchingExtended implements Runnable {
	class Node
	{
		public static final int Letters =  4;
		public static final int NA      = -1;
		public  boolean isLeaf;
		public Node next [];

		Node ()
		{
			next = new Node [Letters];
			isLeaf = false;
//			Arrays.fill (next, NA);
		}
	}
	
	Node root;
	int letterToIndex (char letter)
	{
		switch (letter)
		{
			case 'A': return 0;
			case 'C': return 1;
			case 'G': return 2;
			case 'T': return 3;
			default: assert (false); return Node.NA;
		}
	}

	List <Integer> solve (String text, int n, List <String> patterns) {
		List <Integer> result = new ArrayList <Integer> ();

		// write your code here
		for(String pattern:patterns)
			insert(pattern);
		
		int length = text.length();
		for(int i=0;i<length;i++) {
			if(find(text,i))
				result.add(i);
		}
		return result;
	}
	
	void insert(String pattern) {
    	int length = pattern.length();
    	Node currentNode = root;
    	for(int i=0;i<length;i++) {
    		char c = pattern.charAt(i);
    		int index = letterToIndex(c);
    		if(currentNode.next[index]==null) {
    			currentNode.next[index] = new Node();
    		}
    		currentNode = currentNode.next[index];
    	}
    	currentNode.isLeaf= true;
    }
	
	boolean find(String text,int index) {
		Node currentNode = root;
		int length = text.length();
		while(index<length) {
			char c = text.charAt(index);
			int i = letterToIndex(c);
			if(currentNode.isLeaf)
				return true;
			if(currentNode.next[i]==null)
				return false;
			currentNode = currentNode.next[i];
			index++;
		}
		if(currentNode.isLeaf)
			return true;
		return false;
	}
    

	public void run () {
		try {
			BufferedReader in = new BufferedReader (new InputStreamReader (System.in));
			String text = in.readLine ();
		 	int n = Integer.parseInt (in.readLine ());
		 	List <String> patterns = new ArrayList <String> ();
			for (int i = 0; i < n; i++) {
				patterns.add (in.readLine ());
			}
			root = new Node();
			List <Integer> ans = solve (text, n, patterns);

			for (int j = 0; j < ans.size (); j++) {
				System.out.print ("" + ans.get (j));
				System.out.print (j + 1 < ans.size () ? " " : "\n");
			}
		}
		catch (Throwable e) {
			e.printStackTrace ();
			System.exit (1);
		}
	}

	public static void main (String [] args) {
		new Thread (new TrieMatchingExtended()).start ();
	}
}
