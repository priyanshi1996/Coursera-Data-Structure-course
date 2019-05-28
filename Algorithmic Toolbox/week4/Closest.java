
//Assignment6
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Closest {

    static class Point  {
        long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

    }

    public static double large_min_dist(int[][] points,int start,int end) {
		int mid = (end-start)/2;
		if(mid<=3)
			return small_min_dist(points,start,end);
		double left_min = large_min_dist(points, start, start+mid);
		double right_min = large_min_dist(points, start+mid+1, end);
		double seperated_min = Double.min(left_min, right_min);
		double line = (points[start+mid][0]+points[start+mid+1][0])/2;
		double hybrid_min = calculate_hybrid_min(points,start,end,line,seperated_min);
		return Double.min(seperated_min, hybrid_min);
		
	}
	public static double calculate_hybrid_min(int[][] points,int start,int end, double line, double seperated_min) {
		ArrayList<Point> set = new ArrayList<Point>();
		Collections.sort(set, (new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				if(o1.y<o2.y)
					return -1;
				return 1;
			}
		}));
		for(int i=start;i<=end;i++) {
			if((points[i][0]-line)<=seperated_min)
				set.add(new Point(points[i][0],points[i][1]));
		}
		int length = set.size();
		double min_dist = seperated_min;
		for(int i=0;i<length;i++) {
			for(int j=i+1;j<Integer.min(i+8, length);j++) {
				double dist = distance(set.get(i).x ,set.get(j).x,set.get(i).y,set.get(j).y);
				min_dist = Double.min(dist, min_dist);
			}
		}
		return min_dist;
	}
	public static double small_min_dist(int[][] points,int start,int end) {
		double minDist=Double.MAX_VALUE;
		for(int i=start;i<=end;i++) {
			for(int j=i+1;j<=end;j++) {
				double dist = distance(points[i][0],points[j][0],points[i][1],points[j][1]);
				if(dist<minDist)
					minDist = dist;
			}
		}
		return minDist;
	}
	
	public static double distance(double x1,double x2, double y1, double y2) {
		double dist = (x2-x1)*(x2-x1) + (y2-y1)*(y2-y1);
		return Math.pow(dist,0.5);
	}

    public static void main(String[] args) throws Exception {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new PrintWriter(System.out);
        int n = nextInt();
        int[][] points = new int[n][2];
        for (int i = 0; i < n; i++) {
            points[i][0] = nextInt();
            points[i][1] = nextInt();
        }
        Arrays.sort(points,new Comparator<int[]>() {
			public int compare(int[] o1,int[] o2) {
				if(o1[0]<o2[0])
					return -1;
				else
					return 1;
			}
		});
		
        double ans = large_min_dist(points,0,n-1);
		DecimalFormat numberFormat = new DecimalFormat("0.0000");
		System.out.println(numberFormat.format(ans));
        writer.close();
    }

    static BufferedReader reader;
    static PrintWriter writer;
    static StringTokenizer tok = new StringTokenizer("");


    static String next() {
        while (!tok.hasMoreTokens()) {
            String w = null;
            try {
                w = reader.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (w == null)
                return null;
            tok = new StringTokenizer(w);
        }
        return tok.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(next());
    }
}
