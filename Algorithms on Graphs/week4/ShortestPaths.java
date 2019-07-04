//Assignment3
import java.util.*;

public class ShortestPaths {
	
	static long MAX_VALUE = Long.MAX_VALUE;
	
	static long[] dist;
	static boolean[] visited;
	static HashSet<Integer> negativeCycle = new HashSet<Integer>();
	static HashSet<Integer> visitedNodes = new HashSet<Integer>();
    private static void shortestPaths(ArrayList<Node2>[] adj, int s,int len) {
      //write your code here
    	dist[s] = 0;
    	for(int i=0;i<len;i++) {
    		for(int j=0;j<len;j++) {
    			if(visitedNodes.contains(j)) {
	    			for(Node2 node:adj[j]) {
	    				if(dist[node.key]>dist[j]+node.cost) {
	    					visitedNodes.add(node.key);
	    					dist[node.key]=dist[j]+node.cost;
	    					if(i==len-1)
	    						negativeCycle.add(node.key);
	    				}
	    			}
    			}
    		}
    	}
    }
    
    public static void bfs(ArrayList<Node2>[] adj,int s) {
    	Queue<Integer> queue = new LinkedList<Integer>();
    	queue.add(s);
    	while(!queue.isEmpty()) {
    		int a = queue.remove();
    		visited[a] = true;
    		negativeCycle.add(a);
    		for(Node2 node2:adj[a]) {
    			if(!visited[node2.key])
    				queue.add(node2.key);
    		}
    	}
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Node2>[] adj = (ArrayList<Node2>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Node2>();
        }
        for (int i = 0; i < m; i++) {
            int x, y, w;
            x = scanner.nextInt();
            y = scanner.nextInt();
            w = scanner.nextInt();
            adj[x - 1].add(new Node2(y - 1,w));
        }
        int s = scanner.nextInt() - 1;
        dist = new long[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            dist[i] = MAX_VALUE;
        }
        visitedNodes.add(s);
        shortestPaths(adj, s,n);
        for(int i=0;i<n;i++) {
        	if(negativeCycle.contains(i) && !visited[i])
        		bfs(adj,i);
        }
//        System.out.println("Max_vlaue "+Long.MAX_VALUE);
        for (int i = 0; i < n; i++) {
//            if (dist[i] == MAX_VALUE) {
//                System.out.println('*');
//            } else if (negativeCycle.contains(i)) {
//                System.out.println('-');
//            } else {
//                System.out.println(dist[i]);
//            }
        	if(negativeCycle.contains(i))
        		System.out.println('-');
        	else if (visitedNodes.contains(i))
        		System.out.println(dist[i]);
        	else
        		System.out.println('*');
        }
    }

}

class Node2 {
	int key;
	long cost;
	Node2(int key,long cost){
		this.key = key;
		this.cost = cost;
	}
}

