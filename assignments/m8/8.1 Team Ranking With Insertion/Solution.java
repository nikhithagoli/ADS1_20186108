import java.util.Scanner;
/**
 * Class for details.
 */
class Details {
    /**
     * name.
     */
    private String name;
    /**
     * no of wins.
     */
    private int wins;
    /**
     * no of lost.
     */
    private int lost;
    /**
     * no of draws.
     */
    private int draws;
    /**
     * constuctor.
     *
     * @param      n   The name
     * @param      w   The wins
     * @param      l  The lost
     * @param      d  The draws
     */
    Details(final String n, final int w, final int l, final int d) {
        this.name = n;
        this.wins = w;
        this.lost = l;
        this.draws = d;
    }
    /**
     * returns name.
     *
     * best case: O(1)
     * worst case: O(1)
     * aversge case: O(1)
     *
     * @return     { description_of_the_return_value }
     */
    String getname() {
        return this.name;
    }
    /**
     * returns no of wins.
     *
     * best case: O(1)
     * worst case: O(1)
     * aversge case: O(1)
     *
     * @return     { description_of_the_return_value }
     */
    int getwins() {
        return this.wins;
    }
    /**
     * returns no of lost.
     *
     * best case: O(1)
     * worst case: O(1)
     * aversge case: O(1)
     *
     * @return     { description_of_the_return_value }
     */
    int getlost() {
        return this.lost;
    }
    /**
     * returns no of draws.
     *
     * best case: O(1)
     * worst case: O(1)
     * aversge case: O(1)
     * @return     { description_of_the_return_value }
     */
    int getdraws() {
        return this.draws;
    }
    /**
     * comapares.
     *
     * @param      that  The that
     *
     * @return     { description_of_the_return_value }
     */
    public int compareTo(final Details that) {
        if (this.getwins() > that.getwins()) {
            return 1;
        } else if (this.getwins() < that.getwins()) {
            return -1;
        } else {
            if (this.getlost() > that.getlost()) {
                return -1;
            } else if (this.getlost() < that.getlost()) {
                return 1;
            } else {
                if (this.getdraws() > that.getdraws()) {
                    return 1;
                } else if (this.getdraws() < that.getdraws()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }
    }
}
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //function.
    }
    /**
     * sorts.
     *
     * best case: O(n^2)
     * worst case: O(n^2)
     * average case: O(n^2)
     *
     * @param      list  The list
     *
     * @param      n  The size
     * @return     { description_of_the_return_value }
     */
    static Details[] selectionsort(final Details[] list, final int n) {
        for (int  i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (list[j].compareTo(list[min]) > -1) {
                    min = j;
                }
            }
            Details temp = list[i];
            list[i] = list[min];
            list[min] = temp;
        }
        return list;
    }
    /**
     * main.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        Details[] list = new Details[2 * (2 + 2 + 1)];
        int n = 0;
        while (sc.hasNextLine()) {
            String[] tokens = sc.nextLine().split(",");
            list[n++] = new Details(tokens[0], Integer.parseInt(tokens[1]),
                Integer.parseInt(tokens[2]), Integer.parseInt(tokens[2 + 1]));
        }
        list = selectionsort(list, n);
        for (int i = 0; i < n - 1; i++) {
            System.out.print(list[i].getname() + ",");
        }
        System.out.print(list[n - 1].getname());
    }
}
