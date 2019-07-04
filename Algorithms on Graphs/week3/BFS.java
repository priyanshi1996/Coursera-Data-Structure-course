//Assignment1
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
	
	static private boolean[] visited; 
	static private int[] dist; 
    private static int distance(ArrayList<Integer>[] adj, int s, int t) {
        //write your code here
    	Queue<Integer> queue= new LinkedList<Integer>();
    	
    	queue.add(s);
    	visited[s] = true;
    	dist[s] = 0;
    	while(!queue.isEmpty()) {
    		int node = queue.remove();
    		for(int v: adj[node]) {
    			if(!visited[v]) {
    				visited[v] = true;
    				dist[v] = dist[node]+1;
    				queue.add(v);
    			}
    		}
    	}
        return dist[t];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        visited = new boolean[n];
        dist = new int[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
            dist[i] = -1;
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(distance(adj, x, y));
    }
}

