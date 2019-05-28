//Assignment4

import java.util.Arrays;
import java.util.Scanner;

public class DotProduct {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int[] a = new int[N];
		int[] b = new int[N];
		for(int i=0;i<N;i++)
			a[i] = s.nextInt();
		for(int i=0;i<N;i++)
			b[i] = s.nextInt();
		Arrays.sort(a);
		Arrays.sort(b);
		
		long sum =0l;
		for(int i=0;i<N;i++) {
			long a1 = a[i];
			long b1 = b[i];
			sum = sum + (a1*b1);
		}
		System.out.println(sum);
	}

}
