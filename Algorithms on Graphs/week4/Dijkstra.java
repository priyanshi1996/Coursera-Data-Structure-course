//Assignment1
import java.util.*;

public class Dijkstra {
	static boolean[] visited;
	static int[] dist;
    private static int distance(ArrayList<Node>[] adj, int s, int d) {
    	Queue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
    		public int compare(Node o1, Node o2) {
    			if(o1.cost<o2.cost)
    				return -1;
    			return 1;
    		}; 
		});
    	queue.add(new Node(s,0));
    	dist[s] = 0;
    	int n =adj.length;
    	for(int i=0;i<n;i++) {
    		if(queue.isEmpty())
    			break;
    		Node node2 = queue.remove();
    		while(!queue.isEmpty() && visited[node2.key])
    			node2 = queue.remove();
    		if(node2==null)
    			break;
    		visited[node2.key] = true;
    		for(Node node: adj[node2.key]) {
    			if(!visited[node.key]) {
    				if(dist[node.key]>dist[node2.key]+node.cost) {
    					dist[node.key] = dist[node2.key]+node.cost;
    					queue.add(new Node(node.key,dist[node.key]));
    				}
    				
    			}
    		}
    		
    	}
    	if(visited[d])
    		return dist[d];
    	else 
    		return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Node>[] adj = (ArrayList<Node>[])new ArrayList[n];
        visited = new boolean[n];
        dist = new int[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Node>();
            dist[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < m; i++) {
            int x, y, w;
            x = scanner.nextInt();
            y = scanner.nextInt();
            w = scanner.nextInt();
            adj[x - 1].add(new Node(y - 1,w));
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(distance(adj, x, y));
    }
}

 class Node {
	int key;
	int cost;
	Node(int key,int cost){
		this.key = key;
		this.cost = cost;
	}
}

