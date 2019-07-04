//Assignment2
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bipartite {
	static private boolean[] visited; 
	static private int[] color; 
    private static int bipartite(ArrayList<Integer>[] adj,int s) {
        //write your code here
    	Queue<Integer> queue= new LinkedList<Integer>();
    	queue.add(s);
    	visited[s] = true;
    	color[s] = 0;
    	while(!queue.isEmpty()) {
    		int node = queue.remove();
    		for(int v: adj[node]) {
    			if(!visited[v]) {
    				visited[v] = true;
    				color[v] = reverseColor(color[node]);
    				queue.add(v);
    			}
    			else {
    				if(color[v]!=reverseColor(color[node]))
    					return 0;
    			}
    		}
    	}
        return 1;
    }
    
    private static int reverseColor(int actualColor) {
    	if(actualColor==0)
    		return 1;
    	else
    		return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        visited = new boolean[n];
        color = new int[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
            color[i]=-1;
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        
        System.out.println(bipartite(adj,0));
    }
}

