//Assignment5

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class CoveringSegments {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		Set<Segment> set = new TreeSet<Segment>(new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				Segment seg1 = (Segment)o1;
				Segment seg2 = (Segment)o2;
				if(seg1.b<seg2.b)
					return -1;
				return 1;
			}
			
		});
		
		for(int i=0;i<N;i++) {
			int a = s.nextInt();
			int b = s.nextInt();
			set.add(new Segment(a,b));
		}
		List<Integer> ans = new ArrayList<Integer>();
		for(Segment segment : set) {
			if(!segment.alreadyUsed) {
				for(Segment seg:set) {
					if(!seg.alreadyUsed && seg.a<=segment.b && seg.b>=segment.b)
						seg.alreadyUsed = true;
				}
				ans.add(segment.b);
			}
		}
		System.out.println(ans.size());
		for(int i=0;i<ans.size();i++)
			System.out.print(ans.get(i)+" ");
	}
}
class Segment{
	int a, b;
	boolean alreadyUsed;
	Segment(int a, int b){
		this.a = a;
		this.b = b;
		alreadyUsed = false;
	}
}
