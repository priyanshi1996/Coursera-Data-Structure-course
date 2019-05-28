//Assignment7

import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class LargestNumber {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		Set<String> set = new TreeSet<String>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if((o1+o2).compareTo(o2+o1)>=0)
					return -1;
				return 1;
			}
		});
		
		for(int i=0;i<n;i++) {
			String no = s.next();
			set.add(no);
		}
		
		String ans="";
		for(String no:set)
			ans = ans+no;
		System.out.println(ans);
	}
}
