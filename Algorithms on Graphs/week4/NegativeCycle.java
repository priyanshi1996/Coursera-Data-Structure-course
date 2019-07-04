//Assignment2
import java.util.ArrayList;
import java.util.Scanner;

public class NegativeCycle {
	static int[] dist;
	static boolean isNegativeCycle=false;
    private static int negativeCycle(ArrayList<Node1>[] adj,int s,int len) {
        // write your code here
    	dist[s] = 0;
    	for(int i=0;i<len;i++) {
    		for(int j=0;j<len;j++) {
    			for(Node1 node:adj[j]) {
    				if(dist[j]!=Integer.MAX_VALUE && dist[node.key]>dist[j]+node.cost) {
    					dist[node.key]=dist[j]+node.cost;
    					if(i==len-1)
    						isNegativeCycle = true;
    				}
    			}
    		}
//    		for(int k=0;k<len;k++)
//    			System.out.println(k+" "+dist[k]);
    	}
    	
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Node1>[] adj = (ArrayList<Node1>[])new ArrayList[n];
//        ArrayList<Integer>[] cost = (ArrayList<Integer>[])new ArrayList[n];
        dist = new int[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Node1>();
            dist[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < m; i++) {
            int x, y, w;
            x = scanner.nextInt();
            y = scanner.nextInt();
            w = scanner.nextInt();
            adj[x - 1].add(new Node1(y - 1,w));
        }
        for(int i=0;i<n;i++) {
        	if(dist[i]==Integer.MAX_VALUE && !isNegativeCycle)
        		negativeCycle(adj,i,n);
        }
        if(isNegativeCycle)
        	System.out.println(1);
        else
        	System.out.println(0);
    }
}
class Node1 {
	int key;
	int cost;
	Node1(int key,int cost){
		this.key = key;
		this.cost = cost;
	}
}


