import java.util.Scanner;
import java.util.ArrayList;
/**
 * Class for stock.
 */
class Stock implements Comparable<Stock> {
    /**
     * stock name.
     */
    private String name;
    /**
     * %change
     */
    private Double change;
    /**
     * Constructs the object.
     *
     * @param      n     { parameter_description }
     * @param      c     { parameter_description }
     */
    Stock(final String n, final Double c) {
        this.name = n;
        this.change = c;
    }
    /**
     * gets name.
     *
     * @return     { description_of_the_return_value }
     */
    String getname() {
        return this.name;
    }
    /**
     * returns change.
     *
     * @return     { description_of_the_return_value }
     */
    Double getchange() {
        return this.change;
    }
    /**
     * prints stock.
     *
     * @return     { description_of_the_return_value }
     */
    String print() {
        return this.name + " " + this.change;
    }
    /**
     * compares.
     * best case: O(1)
     * worst case: O(1)
     * Average case : O(1)
     * @param      that  The that
     *
     * @return     { description_of_the_return_value }
     */
    public int compareTo(final Stock that) {
        if (this.change > that.change) {
            return 1;
        } else if (this.change < that.change) {
            return -1;
        } else {
            return this.name.compareTo(that.name);
        }
    }
}
/**
 * Class for solution.
 */
final class Solution {
    /**
     * main.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        SymbolTable best = new SymbolTable(n);
        SymbolTable worst = new SymbolTable(n);
        for (int i = 0; i < 6; i++) {
            MaxPQ<Stock> maxpq = new MaxPQ<Stock>();
            MinPQ<Stock> minpq = new MinPQ<Stock>();
            for (int j = 0; j < n; j++) {
                String[] input = sc.nextLine().split(",");
                maxpq.insert(new Stock(input[0], Double.parseDouble(input[1])));
                minpq.insert(new Stock(input[0], Double.parseDouble(input[1])));
            }
            int top = 5;
            while (top > 0) {
                Stock res = maxpq.delMax();
                System.out.println(res.print());
                Integer val = best.get(res.getname());
                if (val == null) {
                    best.put(res.getname(), 1);
                } else {
                    best.put(res.getname(), val + 1);
                }
                top--;
            }
            System.out.println();
            top = 5;
            while (top > 0) {
                Stock res = minpq.delMin();
                System.out.println(res.print());
                Integer val = worst.get(res.getname());
                if (val == null) {
                    worst.put(res.getname(), 1);
                } else {
                    worst.put(res.getname(), val + 1);
                }
                top--;
            }
            System.out.println();
        }
        int m = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < m; i++) {
            String tokens[] = sc.nextLine().split(",");
            if (tokens[0].equals("get")) {
                if (tokens[1].equals("maxST")) {
                    Integer res = best.get(tokens[2]);
                    if (res == null) {
                        System.out.println("0");
                    } else {
                        System.out.println(res);
                    }
                } else {
                    Integer res = worst.get(tokens[2]);
                    if (res == null) {
                        System.out.println("0");
                    } else {
                        System.out.println(res);
                    }
                }
            } else {
                String[] keys = best.keys();
                for (String each : keys) {
                    if (worst.contains(each)) {
                        System.out.println(each);
                    }
                }
            }
        }
    }
}