//Assignment 1
import java.util.Scanner;

public class ChangeDP {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] A = new int[n+1];
		int min;
		for(int i=1;i<=n;i++) {
			min=Integer.MAX_VALUE;
			if(i-1>=0 && (A[i-1]+1)<min)
				min = A[i-1]+1;
			if(i-3>=0 && (A[i-3]+1)<min)
				min = A[i-3]+1;
			if(i-4>=0 && (A[i-4]+1)<min)
				min = A[i-4]+1;
			A[i] = min;
		}
		System.out.println(A[n]);
	}
}
