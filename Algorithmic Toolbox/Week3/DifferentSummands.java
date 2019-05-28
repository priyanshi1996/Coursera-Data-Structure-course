//Assignment6

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DifferentSummands {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		List<Integer>  ans = maxNoOFPrizes(N);
		System.out.println(ans.size());
		for(Integer i : ans)
			System.out.print(i+" ");
		
	}
	public static List<Integer> maxNoOFPrizes(int N){
		int no = 1;
		List<Integer> list = new ArrayList<Integer>();
		while( N-no >= 0) {
			list.add(no);
			N = N-no;
			no++;
		}
		int size = list.size();
		list.remove(size-1);
		list.add(no+N-1);
		return list;
	}
}
