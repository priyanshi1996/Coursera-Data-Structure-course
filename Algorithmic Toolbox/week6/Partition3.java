
//Assignment2
import java.util.HashMap;
import java.util.Scanner;

public class Partition3 {
	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		int N = s.nextInt();
		int[] value = new int[N];
		int sum =0;
		for(int i=0;i<N;i++) {
			value[i] = s.nextInt();
			sum = sum + value[i];
		}
		HashMap<String,Boolean> map = new HashMap<String,Boolean>();
		if(N<3 || sum%3!=0)
			System.out.println(0);
		else {
			boolean output = subset(N-1,sum/3,sum/3,sum/3,value,map);
			if(output)
				System.out.println(1);
			else
				System.out.println(0);
		}
	}
	public static boolean subset(int N,int a,int b,int c,int[] value,HashMap<String,Boolean> map) {
		
		if(a==0 && b==0 && c==0)
			return true;
		if(N<0)
			return false;
		
		String key = a + "|" + b + "|" + c + "|" + N;
		if(!map.containsKey(key)) {
			boolean A = false;
			if(a-value[N]>=0)
				A = subset(N-1,a-value[N],b,c,value,map);
			
			boolean B = false;
			if(!A && b-value[N]>=0)
				B = subset(N-1,a,b-value[N],c,value,map);
			
			boolean C = false;
			if(!A && !B && c-value[N]>=0)
				C = subset(N-1,a,b,c-value[N],value,map);
			
			map.put(key, A || B || C);
		}
		return map.get(key);
	}

}
