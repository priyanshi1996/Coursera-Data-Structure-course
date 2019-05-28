
//Assignment 1
import java.util.Scanner;

public class Knapsack {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int W = s.nextInt();
		int N = s.nextInt();
		int[] weight = new int[N+1];
		for(int i=1;i<=N;i++)
			weight[i] = s.nextInt();
		
		int[][] Arr = new int[N+1][W+1];
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=W;j++) {
				Arr[i][j]=Arr[i-1][j];
				if(weight[i]<=j) {
					if(Arr[i-1][j-weight[i]]+weight[i]>Arr[i][j])
						Arr[i][j] = Arr[i-1][j-weight[i]]+weight[i];
				}
			}
		}
		System.out.println(Arr[N][W]);
	}

}
