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
    static Details[] insertionsort(final Details[] list, final int n) {
        for (int  i = 0; i < n; i++) {
            for (int j = i ; j > 0; j--) {
                int min = j-1;
                if (list[j].getwins() == (list[j-1].getwins())) {
                    if (list[j].getlost() == (list[j-1].getlost())) {
                        if (list[j].getdraws() > list[j-1].getdraws()) {
                            min = j;
                        }
                    } else {
                        if (list[j].getlost() < list[j - 1].getlost()) {
                            min = j;
                        }
                    }
                } else {
                    if (list[j].getwins() > list[j-1].getwins()) {
                        min = j;
                    }
                }
                Details temp = list[j-1];
                list[j-1] = list[min];
                list[min] = temp;
            }
            
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
        list = insertionsort(list, n);
        for (int i = 0; i < n - 1; i++) {
            System.out.print(list[i].getname() + ",");
        }
        System.out.print(list[n - 1].getname());
    }
}
