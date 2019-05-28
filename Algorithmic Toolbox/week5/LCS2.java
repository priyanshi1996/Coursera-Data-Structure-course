//Assignment4
import java.util.Scanner;

public class LCS2 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] A = new int[n];
		for(int i=0;i<n;i++)
			A[i] = s.nextInt();
		
		int m = s.nextInt();
		int[] B = new int[m];
		for(int i=0;i<m;i++)
			B[i] = s.nextInt();
		
		int max = 0;
		int[][] Arr = new int[n+1][m+1];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {

				if(A[i-1]==B[j-1]) 
					Arr[i][j] = Arr[i-1][j-1]+1;
				else 
					Arr[i][j] = max(Arr[i][j-1],Arr[i-1][j],Arr[i-1][j-1]);
			}
		}
		System.out.println(Arr[n][m]);
	}
	
	public static int max(int a,int b,int c) {
		return Integer.max(a, Integer.max(b, c));
	}
}
