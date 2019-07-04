//assignment3
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class StronglyConnected {
	static boolean[] visited ;
	static int count=0;
	
    private static int numberOfStronglyConnectedComponents(ArrayList<Integer>[] adj,ArrayList<Integer>[] adjReverse,int n) {
        //write your code here
    	Stack<Integer> order = new Stack<Integer>();
    	visited = new boolean[n];
        for(int i=0;i<n;i++) {
        	if(!visited[i])
        		dfs(adj,i,order);
        }
        
        visited = new boolean[n];
        while(!order.isEmpty()) {
        	int i = order.pop();
        	if(!visited[i]) {
        		dfs(adjReverse,i,order);
        		count++;
        	}
        }
        return count;
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
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        ArrayList<Integer>[] adjReverse = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
            adjReverse[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
            adjReverse[y-1].add(x-1);
        }
        System.out.println(numberOfStronglyConnectedComponents(adj,adjReverse,n));
    }
}

