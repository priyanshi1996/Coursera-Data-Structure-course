//Assignment1
import java.util.Scanner;

public class Change {

	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int result = findMinNoOfDenomination(N);
		System.out.println(result);
		
	}
	
	public static int findMinNoOfDenomination(int no) {
		int maxTenCoins = no/10;
		no = no%10;
		int maxFiveCoins = no/5;
		no = no%5;
		int maxOneCoins = no;
		return (maxTenCoins + maxFiveCoins + maxOneCoins);
	}
}
