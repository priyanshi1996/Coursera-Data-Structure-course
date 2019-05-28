import java.util.Scanner;

public class FibonacciSumSquares {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		long N = s.nextLong();
		int M= 10;
		int period = findPisanoPeriod(M);
		
		System.out.print(lastDigitOfSum(N%period));

		}
	
	public static long lastDigitOfSum(long N) {
		long a =0;
		long b=1;
		long temp =0;
		
		if(N<=1)
			return N;
		for(int i=2;i<=N;i++) {
			temp=a;
			a=b%10;
			b=(temp+b)%10;
			
		}
		return (b*(b+a))%10;
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
