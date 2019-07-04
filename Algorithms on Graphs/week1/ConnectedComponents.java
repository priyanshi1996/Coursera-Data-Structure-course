//Assignment2
import java.util.ArrayList;
import java.util.Scanner;

public class ConnectedComponents {
	static boolean[] visited ;
    private static void numberOfComponents(ArrayList<Integer>[] adj,int x) {
        //write your code here
    	if(!visited[x]) {
    		visited[x] = true;
    		for(int vertex:adj[x])
    			numberOfComponents(adj,vertex);
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
            adj[y - 1].add(x - 1);
        }
        int count = 0;
        for(int i=0;i<n;i++) {
        	if(!visited[i]) {
        		numberOfComponents(adj,i);
        		count++;
        	}
        }
        System.out.println(count);
    }
}

