import java.util.Scanner;
import java.util.ArrayList;
class Stock implements Comparable<Stock> {
	private String name;
	private Double change;
	Stock(String n, Double c) {
		this.name = n;
		this.change = c;
	}
	String getname() {
		return this.name; 
	}
	Double getchange() {
		return this.change;
	}
	String print() {
		return this.name + " " + this.change;
	}
	public int compareTo(final Stock that) {
        if (this.change > that.change) {
            return 1;
        } else if(this.change < that.change) {
        	return -1;
        } else {
        	return this.name.compareTo(that.name);
        }
    }
}
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		SymbolTable<String, Integer> best = new SymbolTable<String, Integer>(n);
		SymbolTable<String, Integer> worst = new SymbolTable<String, Integer>(n);
		for(int i = 0; i < 6; i++) {
			MaxPQ<Stock> maxpq = new MaxPQ<Stock>();
        	MinPQ<Stock> minpq = new MinPQ<Stock>();
			for(int j = 0; j < n; j++) {
				String[] input = sc.nextLine().split(",");
            	maxpq.insert(new Stock(input[0], Double.parseDouble(input[1])));
            	minpq.insert(new Stock(input[0], Double.parseDouble(input[1])));
        	}
        		int top = 5;
        		while(top > 0) {
        			Stock res = maxpq.delMax();
        			System.out.println(res.print());
        			Integer val = best.get(res.getname());
        			if(val == null){
        				best.put(res.getname(), 1);
        			} else {
        				best.put(res.getname(), val++);
        			}
        			top--;
        		}
        		System.out.println();
        		top = 5;
        		while(top > 0) {
        			Stock res = minpq.delMin();
        			System.out.println(res.print());
        			Integer val = worst.get(res.getname());
        			if(val == null){
        				worst.put(res.getname(), 1);
        			} else {
        				worst.put(res.getname(), val++);
        			}
        			top--;
        		}
        		System.out.println();
		}
		int m = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < m; i++) {
			String tokens[] = sc.nextLine().split(",");
			if(tokens[0].equals("get")) {
				if(tokens[1].equals("maxST")) {
					Integer res = best.get(tokens[2]);
					if(res == null) {
						System.out.println("0");
					} else {
						System.out.println(res);
					}
				}
				else {
					Integer res = worst.get(tokens[2]);
					if(res == null) {
						System.out.println("0");
					} else {
						System.out.println(res);
					}
				}
			} else {
				String[] keys = best.keys();
				for(String each: keys){
					if(worst.contains(each)) {
						System.out.println(each);
					}
				}
			}
		}
	}
}