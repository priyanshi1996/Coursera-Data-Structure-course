
//Assignment1
import java.util.ArrayList;
import java.util.Scanner;

public class Reachability {
	static boolean found = false;
    private static void reach(ArrayList<Integer>[] adj, int x, int y, boolean[] visited) {
        //write your code here
    	if(!visited[x] && !found) {
    		if(x == y) {
    			found = true;
    			return;
    		}
    		visited[x] = true;
    		for(int vertex:adj[x]) {
    			reach(adj,vertex,y,visited);
    		}
    	}
        
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        boolean[] visited = new boolean[n];
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
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
        reach(adj, x, y,visited);
        if(found)
        	System.out.println(1);
        else
        	System.out.println(0);
    }
}

