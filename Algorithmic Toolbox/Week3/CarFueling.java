
//Assignment3
import java.util.Scanner;

public class CarFueling {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int distance = s.nextInt();
		int maxLimit = s.nextInt();
		int N = s.nextInt();
		int[] stops = new int[N+2];
		for(int i=1; i<=N;i++)
			stops[i]=s.nextInt();
		stops[N+1] = distance;
		int ans = carFueling(stops, distance, maxLimit, N);
		System.out.println(ans);
	}
	
	public static int carFueling(int[] stops,int distance, int maxLimit, int N) {
		int current = 0, noOfRefils = 0,last =0;
		while(current<=N) {
			last = current;
			while(current<=N && (stops[current+1]-stops[last]) <= maxLimit)
				current++;
			if(current == last)
				return -1;
			if(current <= N)
				noOfRefils ++;
		}
		return noOfRefils;
	}
}
