//Assignment3
import java.util.Scanner;

public class Sorting {
	
	public static int pivot1=0,pivot2=0;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] A = new int[n];
		for(int i=0;i<n;i++)
			A[i] = s.nextInt();
		
		quicksort(A, 0, n-1);
		for(int i=0;i<n;i++)
			System.out.print(A[i]+" ");
		
	}
	public static void quicksort(int[] A, int l,int r) {
		if(l<r) {
			findpivot(A,l,r);
			
			quicksort(A,l,pivot1-1);
			quicksort(A,pivot2+1,r);
		}		
	}
	public static void findpivot(int[] A,int l,int r) {

		int p = A[r];
		int start = l;
		int last = r;
		int sameElement = l-1;
		int count=0;
		for(int i=l;i<r;i++) {
			if(A[i]<=p) {
				swap(A,start,i);
				start++;
			}
			if(A[i]==p) {
				swap(A,start-1,++sameElement);
				count++;
			}
		}
		pivot2 = start;
		pivot1 = start-count;
		swap(A,start,r);
		for(int i=0;i<count;i++) {
			swap(A,l+i,--start);
		}
			
	}
	public static void swap(int[] A, int a, int b) {
		int temp = A[a];
		A[a] = A[b];
		A[b] = temp;
	}
}
