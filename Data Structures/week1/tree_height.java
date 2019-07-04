
//Assignment2
import java.util.*;
import java.io.*;

public class tree_height {
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
    
    public class Node{
    	int node;
    	int height;
    	Node(int node, int height){
    		this.node = node;
    		this.height = height;
    	}
    }

	public class TreeHeight {
		int n,root,maxHeight=0;
		int parent[];
		ArrayList<Integer>[] nodes;
		
		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			parent = new int[n];
			nodes = new ArrayList[n];
			for (int i = 0; i < n; i++) {
				parent[i] = in.nextInt();
				nodes[i] = new ArrayList<Integer>();
			}
		}

		int computeHeight() {
            // Replace this code with a faster implementation
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(new Node(root,1));
			while(!queue.isEmpty()) {
				Node n = queue.remove();
				ArrayList<Integer> childList = nodes[n.node];
				if(n.height > maxHeight)
					maxHeight = n.height;
				for(int child : childList) {
					queue.add(new Node(child,n.height+1));
				}
			}
			return maxHeight;
		}
		void computeTree(){
			for(int i=0;i<n;i++) {
				int parentIndex = parent[i];
				if(parentIndex==-1)
					root = i;
				else
					nodes[parentIndex].add(i);
			}
		}
	}

	static public void main(String[] args) throws IOException {
            new Thread(null, new Runnable() {
                    public void run() {
                        try {
                            new tree_height().run();
                        } catch (IOException e) {
                        }
                    }
                }, "1", 1 << 26).start();
	}
	public void run() throws IOException {
		TreeHeight tree = new TreeHeight();
		tree.read();
		tree.computeTree();
		
		System.out.println(tree.computeHeight());
	}
}
