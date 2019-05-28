//Assignmet2

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class FractionalKnapsack {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int W = s.nextInt();
		Set<Item> set = new TreeSet<Item>(new Comparator<Item>() {

			@Override
			public int compare(Item item1, Item item2) {
				if( ((double)(item1.value)/(double)(item1.weight)) >= ((double)(item2.value)/(double)(item2.weight)))
					return -1;
				else
					return 1;
			}
			
		});
		
		for(int i=0;i<N;i++) {
			double value = s.nextDouble();
			double weight = s.nextDouble();
			set.add(new Item(value,weight));
		}
		double ans = fractionalKnapsack(set, N, W);
		DecimalFormat numberFormat = new DecimalFormat("#.0000");
		System.out.println(numberFormat.format(ans));
	}
	
	public static double fractionalKnapsack(Set<Item> set, int N, double W){
		double value = 0.0;
		for(Item item:set) {
			if(W==0)
				return value;
			double a = Double.min(W, item.weight);
			value = value +((double)(item.value)/(double)(item.weight))*a;
			W = W - a;
		}
		return value;
	}

}
class Item{
	double weight;
	double value;
	
	Item(double value, double weight){
		this.value = value;
		this.weight = weight;
	}
}
