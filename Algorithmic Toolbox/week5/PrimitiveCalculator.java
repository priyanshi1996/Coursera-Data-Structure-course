//Assignment2

import java.util.Scanner;

public class PrimitiveCalculator {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] A = new int[n+1];
		int[] pos = new int[n+1];
		int min;
		int p=0;
//		A[1]=1;
		
		for(int i=2;i<=n;i++) {
			min=Integer.MAX_VALUE;
			if((A[i-1]+1)<min) {
				min = A[i-1]+1;
				p = i-1;
			}
			if(i%2==0)
				if(A[i/2]+1<min) {
					min = A[i/2]+1;
					p = i/2;
			}
			if(i%3==0)
				if(A[i/3]+1<min) {
					min = A[i/3]+1;
					p = i/3;
			}
			A[i] = min;
			pos[i] = p;
		}
		System.out.println(A[n]);
		p=n;
		String sb = "";
		while(p>=1) {
//			System.out.print(p+" ");
			sb = p+" "+sb;
			p = pos[p];
		}
		System.out.println(sb);
	}

}
