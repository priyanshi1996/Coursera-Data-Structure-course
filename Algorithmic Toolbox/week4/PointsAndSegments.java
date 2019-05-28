//Assignment5
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PointsAndSegments {


	public static final int LEFT=1 , POINT=2, RIGHT=3;
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int s = scanner.nextInt();
		int p = scanner.nextInt();
		int[][] arr = new int[s+s+p][3];
		for(int i=0;i<s*2;i=i+2) {
			arr[i][0] = scanner.nextInt();
			arr[i][1] = LEFT;
			arr[i+1][0] = scanner.nextInt();
			arr[i+1][1] = RIGHT;
		}
		int pos = s*2;
		for(int i=0;i<p;i++) {
			arr[i+pos][0] = scanner.nextInt();
			arr[i+pos][1] = POINT;
			arr[i+pos][2] = i;
		}
		Arrays.sort(arr, new Comparator<int[]>(){

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]<o2[0])
					return -1;
				else if(o1[0]==o2[0]) {
					if(o1[1]<o2[1])
						return -1;
					else 
						return 1;
				}
					return 1;
			}
			
		});

		int []ans = new int[p];
		int count=0;
		int length = arr.length;
		for(int i=0;i<length;i++) {
			if(arr[i][1]==LEFT)
				count++;
			else if(arr[i][1]==RIGHT)
				count--;
			else if(arr[i][1] == POINT)
				ans[arr[i][2]] = count;
			
		}
		
		for(int i=0;i<p;i++)
			System.out.print(ans[i]+" ");
		
	}
	
}
