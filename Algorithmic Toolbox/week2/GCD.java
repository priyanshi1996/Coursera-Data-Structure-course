import java.util.Scanner;
public class GCD {

	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int no1 = s.nextInt();
		int no2 = s.nextInt();
		int ans =1;
		if(no1>no2)
			ans =findGcd(no1,no2);
		else
			ans = findGcd(no2,no1);
		
		System.out.println(ans);
	}
	
	public static int findGcd(int a,int b) {
		if(b==0)
			return a;
		return findGcd(b,a%b);
	}
}
