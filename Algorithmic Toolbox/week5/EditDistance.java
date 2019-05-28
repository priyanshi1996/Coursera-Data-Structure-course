import java.util.Scanner;

public class EditDistance {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String A = scanner.nextLine();
		String B = scanner.nextLine();
//		System.out.println(A+" "+B);
		int min=0;
		int[][] Arr = new int[A.length()+1][B.length()+1];
		for(int i=0;i<=A.length();i++)
			Arr[i][0] =i;
		for(int i=0;i<=B.length();i++)
			Arr[0][i] =i;
		for(int i=1;i<=A.length();i++) {
			for(int j=1;j<=B.length();j++) {
				
				if(A.charAt(i-1)==B.charAt(j-1)) 
					Arr[i][j] = Arr[i-1][j-1];
				else 
					Arr[i][j] = 1 + min(Arr[i][j-1],Arr[i-1][j],Arr[i-1][j-1]);
			}
		}
		System.out.println(Arr[A.length()][B.length()]);
	}
	public static int  min(int a,int b,int c) {
		return Integer.min(a, Integer.min(b, c));
	}
}
//Arr[i][j-1] -> Insert
//Arr[i-1][j] -> Remove
//Arr[i-1][j-1] -> Replace