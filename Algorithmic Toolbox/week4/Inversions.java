//Assignment4
import java.util.Scanner;

public class Inversions {
	
	static int ans=0;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] A = new int[n];
		for(int i=0;i<n;i++)
			A[i] = s.nextInt();
		
		mergesort(A,0,n-1);
//		
		System.out.println(ans);
	}
	public static void mergesort(int[] A,int l,int r) {
		if(l<r) { 
			int mid = l + (r-l)/2;
			mergesort(A,l,mid);
			mergesort(A,mid+1,r);
		    merge(A,l,mid,r);
		}
	}
	public static void merge(int[] A,int l ,int mid ,int r) {
		int n = mid - l +1;
		int m = r-mid;
		int i=0,j=0;
		int[] left = new int[n+1];
		int[] right = new int[m+1];
		for(int k=0;k<n;k++)
			left[k]=A[l+k];
		for(int k=0;k<m;k++)
			right[k] = A[mid+1+k];
		left[n] = Integer.MAX_VALUE;
		right[m] = Integer.MAX_VALUE;
		
		for(int k=l;k<=r;k++) {
			
			if(left[i]<=right[j]) {
				A[k]=left[i];
				i++;
				}
			else {
				A[k]=right[j];
				j++;
				if(left[i]!=Integer.MAX_VALUE)
					ans = ans + (n-i);
			}
			}
		}
}
