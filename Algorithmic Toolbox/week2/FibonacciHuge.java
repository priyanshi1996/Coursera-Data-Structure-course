
import java.util.Scanner;

public class FibonacciHuge {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		long N = s.nextLong();
		int M = s.nextInt();
		int period = findPisanoPeriod(M);
		
		
		System.out.print(fibonicci(N%period,M));

		}
	
	public static long fibonicci(long N,int m) {
		long a =0;
		long b=1;
		long temp =0;
		if(N<=1)
			return N;
		for(int i=2;i<=N;i++) {
			temp=a;
			a=b%m;
			b=(temp+b)%m;
		}
		return b;
	}
	
	public static int findPisanoPeriod(int m) {
		int a=0,b=1,temp=0;
		for(int i=2;i<=m*m;i++)
		{
			temp=a;
			a=b%m;
			b=(b+temp)%m;
			if(a==0 && b==1) {
				return i-1;
			}
		}
		return 1;
	}
}
