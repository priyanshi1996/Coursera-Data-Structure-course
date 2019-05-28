import java.util.Scanner;

//Assignment3
public class PlacingParentheses {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String exp = s.next();
		int length = exp.length();
		int N = (length-1)/2 + 1;
		int[][] max = new int[N][N];
		int[][] min = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				max[i][j] = Integer.MIN_VALUE;
				min[i][j] = Integer.MAX_VALUE;
			}
		}
		recurrences(exp, N, min, max);
		System.out.println(max[0][N-1]);
	}

	public static void recurrences(String exp, int N, int[][] min,int[][] max) {
		
		for(int i=0;i<N;i++) {
			max[i][i]=(int)exp.charAt(i*2)-48;
			min[i][i]=(int)exp.charAt(i*2)-48;
		}
		for(int s=1;s<N;s++) {
			for(int i=0;i<N-s;i++) {
				int j = i+s;
				maxAndMin(exp,max,min,N,i,j);
			}
		}
	}
	public static void maxAndMin(String exp,int[][]max,int[][]min,int N,int i,int j) {
		for(int k=i;k<j;k++) {
			int a = eval(max[i][k], max[k+1][j], exp.charAt(2*k+1));
			int b = eval(max[i][k], min[k+1][j], exp.charAt(2*k+1));
			int c = eval(min[i][k], max[k+1][j], exp.charAt(2*k+1));
			int d = eval(min[i][k], min[k+1][j], exp.charAt(2*k+1));
			max[i][j] = Integer.max(max[i][j],findMax(a, b, c, d));
			min[i][j] = Integer.min(min[i][j],findMin(a, b, c, d));
			
		}
	}
	private static int eval(int a, int b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }
	private static int findMin(int a,int b,int c,int d) {
		return Integer.min(Integer.min(a, b), Integer.min(c, d));
	}
	private static int findMax(int a,int b,int c,int d) {
		return Integer.max(Integer.max(a, b), Integer.max(c, d));
	}
}
