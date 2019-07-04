//assignment2
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Toposort {
	static boolean[] visited ;
    private static Stack<Integer> toposort(ArrayList<Integer>[] adj) {
        int n = adj.length;
        Stack<Integer> order = new Stack<Integer>();
        for(int i=0;i<n;i++) {
        	if(!visited[i])
        		dfs(adj,i,order);
        }
        return order;
    }

    private static void dfs(ArrayList<Integer>[] adj, int x, Stack<Integer> order) {
    	if(!visited[x]) {
    		visited[x] = true;
    		for(int neighbour:adj[x]) 
    				dfs(adj,neighbour,order);
    		order.push(x);	
    	}
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        visited = new boolean[n];
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
        }
        Stack<Integer> order = toposort(adj);
        while(!order.isEmpty()) {
            System.out.print((order.pop() + 1) + " ");
        }
    }
}

