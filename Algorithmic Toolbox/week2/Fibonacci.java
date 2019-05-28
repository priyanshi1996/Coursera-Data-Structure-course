
import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int[] F = new int[N+1];
		if(N<=1)
			System.out.println(N);
		else {
			F[0]=0;F[1]=1;
			for(int i=2;i<=N;i++) {
				F[i]=F[i-1]+F[i-2];
			}
			System.out.println(F[N]);
		}
	}
}
