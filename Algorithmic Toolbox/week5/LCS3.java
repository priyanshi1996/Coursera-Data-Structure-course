import java.util.Scanner;

public class LCS3 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int l = s.nextInt();
		int[] A = new int[l];
		for(int i=0;i<l;i++)
			A[i] = s.nextInt();
		
		int n = s.nextInt();
		int[] B = new int[n];
		for(int i=0;i<n;i++)
			B[i] = s.nextInt();
		
		int m = s.nextInt();
		int[] C = new int[m];
		for(int i=0;i<m;i++)
			C[i] = s.nextInt();
		
		int max = 0;
		int[][][] Arr = new int[l+1][n+1][m+1];
		
		for(int i=1;i<=l;i++) {
			for(int j=1;j<=n;j++) {
				for(int k=1;k<=m;k++) {
					max = Integer.MIN_VALUE;
					if(Arr[i-1][j][k] > max)
						max = Arr[i-1][j][k];
					if(Arr[i][j-1][k] > max)
						max = Arr[i][j-1][k];
					if(Arr[i][j][k-1] > max)
						max = Arr[i][j][k-1];
					if(Arr[i-1][j-1][k] > max)
						max = Arr[i-1][j-1][k];
					if(Arr[i][j-1][k-1] > max)
						max = Arr[i][j-1][k-1];
					if(Arr[i-1][j][k-1] > max)
						max = Arr[i-1][j][k-1];
					if(Arr[i-1][j-1][k-1] > max)
						max = Arr[i-1][j-1][k-1];
					
					if(A[i-1] == B[j-1] && B[j-1]== C[k-1]) 
						Arr[i][j][k] = Arr[i-1][j-1][k-1]+1;
					else Arr[i][j][k] = max;
				}
			}
		}
		System.out.println(Arr[l][n][m]);
	}
}
