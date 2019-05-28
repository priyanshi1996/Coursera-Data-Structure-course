
import java.util.Scanner;

public class FibonacciPartialSum {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		long M = s.nextLong();
		long N= s.nextLong();
//		int M = 10;
		int period = findPisanoPeriod(10);
		
		System.out.print(lastDigitOfSum(N,M,period));

		}
	
	public static long lastDigitOfSum(long N,long M,long period) {
		long a = 0;
		long b=1;
		long temp =0;
		long sum=0;
		long start = M%period;
		long range = (N-M)%period + start;
		if(N<=1)
			return N;
		for(int i=1;i<=range;i++) {
			temp=a;
			a=b%10;
			b=(temp+b)%10;
			if(i>=start)
			{
				sum=(sum+a)%10;
			}
		}
		return sum;
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
