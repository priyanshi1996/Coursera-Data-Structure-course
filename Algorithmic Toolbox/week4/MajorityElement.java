//Assignment2
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class MajorityElement {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] A = new int[n];
//		for(int i=0;i<n;i++)
//			A[i] = s.nextInt();
		
//		mergesort(A,0,n-1);
//		Arrays.sort(A);
//		for(int i=0;i<n;i++)
//			System.out.print(A[i]+" ");
//		int ans = findMajorityElement(A, n);
//		System.out.println(ans);
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		
		for(int i=0;i<n;i++) {
			int no = s.nextInt();
			if(map.containsKey(no))
			{
				int val = map.get(no);
				map.put(no,val+1);
			}
			else
				map.put(no, 1);
		}
		
		int maxCount=0;
		for(int val:map.values()) {
			if(val>maxCount)
				maxCount = val;
		}
		if(maxCount>n/2)
			System.out.println(1);
		else
			System.out.println(0);
		
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
			
			if(left[i]<right[j]) {
				A[k]=left[i];
				i++;
				}
			else {
				A[k]=right[j];
				j++;
			}
			}
	}
	
	public static int findMajorityElement(int[] A,int n) {
		
		int majorityElementCount = 0;
		int count =1;
		int majorityElement = A[0];
		for(int i=1;i<n;i++) {
			if(A[i]==majorityElement)
				count++;
			else {
				if(count>majorityElementCount)
					majorityElementCount = count;
				majorityElement = A[i];
				count = 1;
			}
		}
		if(count>majorityElementCount)
			majorityElementCount = count;
		if(majorityElementCount>n/2)
			return 1;
		else 
			return 0;
	}
}
