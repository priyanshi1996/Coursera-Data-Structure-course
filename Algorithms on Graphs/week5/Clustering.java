
import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

//Assignment2
//Using kruskal
public class Clustering {

	static boolean[] visited;
	static int[] parent;
	static Queue<Edge> queue;
	
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        queue =  new PriorityQueue<Edge>(new Comparator<Edge>() {

			@Override
			public int compare(Edge o1, Edge o2) {
				if(o1.cost<o2.cost)
					return -1;
				else 
					return 1;
			}
		});
        
        int[] x = new int[n];
        int[] y = new int[n];
        visited = new boolean[n];
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextInt();
            y[i] = scanner.nextInt();
            parent[i] = i;
        }
        int k = scanner.nextInt();
        double result = minimumDistance(x, y, n, k);
//        System.out.println(String.format("%.8g%n", result));
        DecimalFormat numberFormat = new DecimalFormat("#.0000000");
		System.out.println(numberFormat.format(result));
    }
	
	public static void findDistances(int[] x, int [] y, int n) {
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n;j++) {
				double distance = calculateDistance(x[i], x[j], y[i], y[j]);
				queue.add(new Edge(i,j,distance));
			}
		}
	}
	
	private static double minimumDistance(int[] x,int[] y, int n, int k) {
		findDistances(x, y, n);
		int m = n;
		double minDist ;
		while(m>k) {
			Edge edge = queue.remove();
			if(find(edge.node1)!=find(edge.node2)) {
				merge(find(edge.node1),find(edge.node2));
//				System.out.println(edge.node1 +" "+edge.node2);
				m--;
			}
		}
		while(true) {
			Edge edge = queue.remove();
			if(find(edge.node1)!=find(edge.node2)) {
				minDist = edge.cost;
				break;
			}
		}
		return minDist;
	}
	
	private static double calculateDistance(int x1,int x2,int y1,int y2) {
	    	return Math.pow((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2), 0.5) ;
	   }
	
	private static void merge(int a,int b) {
		parent[a] = b;
	}
	
	private static int find(int a) {
		if(a != parent[a]) {
			parent[a] = find(parent[a]);
		}
		return parent[a];
	}
}
class Edge {
	int node1;
	int node2;
	double cost;
	Edge(int node1, int node2, double cost){
		this.node1 = node1;
		this.node2 = node2;
		this.cost = cost;
	}
}