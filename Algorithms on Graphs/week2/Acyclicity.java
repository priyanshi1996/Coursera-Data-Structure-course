//assignment1
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Acyclicity {
	static boolean[] visited ;
	static boolean[] recStack ;
	static int foundCycle = 0;
	
    private static int acyclic(ArrayList<Integer>[] adj,int n) {
        //write your code here
    	for(int i=0;i<n;i++) {
    		if(!visited[i] && foundCycle == 0) {
    			dfs(adj,i);
    		}
    	}
        return foundCycle;
    }
    
    static private void dfs(ArrayList<Integer>[] adj,int x) {
    	if(!visited[x] && foundCycle==0) {
    		visited[x] = true;
    		recStack[x] = true;
    		for(int neighbour:adj[x]) {
    			if(!recStack[neighbour])
    				dfs(adj,neighbour);
    			else
    				foundCycle = 1;
    		}
    		
    	}
    	recStack[x] = false;
    	
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        visited = new boolean[n];
        recStack = new boolean[n];
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
        System.out.println(acyclic(adj,n));
    }
}

