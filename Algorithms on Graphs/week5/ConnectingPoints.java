import java.text.DecimalFormat;
//Assignment1
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class ConnectingPoints {
	static boolean[] visited;
	static double[] dist;
    private static double minimumDistance(int[] x, int[] y, int n) {
        double result = 0.;
        //write your code here
        
        Queue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
    		public int compare(Node o1, Node o2) {
    			if(o1.cost<o2.cost)
    				return -1;
    			return 1;
    		}; 
		});
        
        queue.add(new Node(0,0));
        dist[0] = 0;
        for(int i=0;i<n;i++) {
        	if(queue.isEmpty())
    			break;
        	Node node = queue.remove();
        	while(!queue.isEmpty() &&  visited[node.key])
        		node = queue.remove();
        	if(node==null || visited[node.key])
    			break;
        	visited[node.key] = true;
        	for(int j=0;j<n;j++) {
        		if(!visited[j] && j!=node.key) {
        			if(dist[j]> calculateDistance(x[j], x[node.key], y[j], y[node.key])) {
        				dist[j] = calculateDistance(x[j], x[node.key], y[j], y[node.key]);
        				queue.add(new Node(j,dist[j]));
        			}
        		}
        	}
        }
        
        for(int i=0;i<n;i++) {
        	result += dist[i];
        }
        return result;
    }
    
    private static double calculateDistance(int x1,int x2,int y1,int y2) {
    	return Math.pow((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2), 0.5) ;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        visited = new boolean[n];
        dist = new double[n];
        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextInt();
            y[i] = scanner.nextInt();
            dist[i] = Double.MAX_VALUE;
        }
        double result = minimumDistance(x, y, n);
        DecimalFormat numberFormat = new DecimalFormat("#.0000000");
		System.out.println(numberFormat.format(result));
    }
}

class Node {
	int key;
	double cost;
	Node(int key,double cost){
		this.key = key;
		this.cost = cost;
	}
}

