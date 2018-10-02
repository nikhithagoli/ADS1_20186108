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
     * @param      name   The name
     * @param      wins   The wins
     * @param      lost   The lost
     * @param      draws  The draws
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
     * @return     { description_of_the_return_value }
     */
    String getname() {
        return this.name;
    }
    /**
     * returns no of wins.
     *
     * @return     { description_of_the_return_value }
     */
    int getwins() {
        return this.wins;
    }
    /**
     * returns no of lost.
     *
     * @return     { description_of_the_return_value }
     */
    int getlost() {
        return this.lost;
    }
    /**
     * returns no of draws.
     *
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
     * main.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        Details[] list = new Details[2*(2+2+1)];
        int n = 0;
        while (sc.hasNextLine()) {
            String[] tokens = sc.nextLine().split(",");
            list[n++] = new Details(tokens[0], Integer.parseInt(tokens[1]),
             Integer.parseInt(tokens[2]), Integer.parseInt(tokens[2+1]));
        }
        for (int  i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (list[j].getwins() == (list[min].getwins())) {
                    if (list[j].getlost() == (list[min].getlost())) {
                        if (list[j].getdraws() > list[min].getdraws()) {
                            min = j;
                        }
                    } else {
                        if (list[j].getlost() < list[min].getlost()) {
                            min = j;
                        }
                    }
                } else {
                    if (list[j].getwins() > list[min].getwins()) {
                        min = j;
                    }
                }
            }
            Details temp = list[i];
            list[i] = list[min];
            list[min] = temp;
        }
        for (int i = 0; i < n - 1; i++) {
            System.out.print(list[i].getname() + ",");
        }
        System.out.print(list[n - 1].getname());
    }
}