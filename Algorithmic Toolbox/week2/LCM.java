import java.util.Scanner;

public class LCM {

	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		long no1 = s.nextInt();
		long no2 = s.nextInt();
		long ans =0;
		long gcd=1;
		if(no1>no2)
			gcd =findGcd(no1,no2);
		else
			gcd = findGcd(no2,no1);
		
		ans = (no1/gcd)*no2;
		
		System.out.println(ans);
	}
	
	public static long findGcd(long a,long b) {
		if(b==0)
			return a;
		return findGcd(b,a%b);
	}
}
