import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Trie {
    class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
    class TrieNode{
    	int index;
    	boolean isLeaf;
    	TrieNode[] children;
    	TrieNode(){
    		index = 0;
    		isLeaf = false;
    		children = new TrieNode[4];
    	}
    }
    
    

//    List<Map<Character, Integer>> buildTrie(String[] patterns) {
//        List<Map<Character, Integer>> trie = new ArrayList<Map<Character, Integer>>();
//
//        // write your code here
//
//        return trie;
//    }
    TrieNode root;
    int indexing = 0;
    
    void buildTrie(String[] patterns) {
    	for(String pattern:patterns)
    		insert(pattern);
    }
    void insert(String pattern) {
    	int length = pattern.length();
    	TrieNode currentNode = root;
    	for(int i=0;i<length;i++) {
    		char c = pattern.charAt(i);
    		int index = findIndex(c);
    		if(currentNode.children[index]==null) {
    			currentNode.children[index] = new TrieNode();
    			currentNode = currentNode.children[index];
        		currentNode.index = indexing + 1;
        		indexing++;
    		}
    		else
    			currentNode = currentNode.children[index];
    	}
    	currentNode.isLeaf= true;
    }
    
    int findIndex(char c) {
    	if(c=='A')
    		return 0;
    	else if(c=='C')
    		return 1;
    	else if(c=='G')
    		return 2;
    	else 
    		return 3;
    }
    
    char findChar(int i) {
    	if(i==0)
    		return 'A';
    	else if(i==1)
    		return 'C';
    	else if(i==2)
    		return 'G';
    	else 
    		return 'T';
    }

    static public void main(String[] args) throws IOException {
        new Trie().run();
    }

//    public void print(List<Map<Character, Integer>> trie) {
//        for (int i = 0; i < trie.size(); ++i) {
//            Map<Character, Integer> node = trie.get(i);
//            for (Map.Entry<Character, Integer> entry : node.entrySet()) {
//                System.out.println(i + "->" + entry.getValue() + ":" + entry.getKey());
//            }
//        }
//    }
    
    void print() {
    	Queue<TrieNode> queue = new LinkedList<TrieNode>();
    	queue.add(root);
    	while(!queue.isEmpty()) {
    		TrieNode node = queue.remove();
    		for(int i=0;i<4;i++) {
    			if(node.children[i]!=null) {
    				queue.add(node.children[i]);
    				System.out.println(node.index+"->"+node.children[i].index+":"+ findChar(i));
    			}
    		}
    	}
    }

    public void run() throws IOException {
        FastScanner scanner = new FastScanner();
        int patternsCount = scanner.nextInt();
        String[] patterns = new String[patternsCount];
        for (int i = 0; i < patternsCount; ++i) {
            patterns[i] = scanner.next();
        }
        root = new TrieNode();
        buildTrie(patterns);
        print();
    }
}
