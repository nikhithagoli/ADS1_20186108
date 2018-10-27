import java.util.Scanner;

/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //unsed.
    }
    /**
     * main.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        BinarySearchTree bst = new BinarySearchTree();
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(",");
            bst.put(new Student(Integer.parseInt(input[0]),
             input[1], Double.parseDouble(input[2])), input[1]);
        }
        int m = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < m; i++) {
            String[] input = sc.nextLine().split(" ");
            if (input[0].equals("BE")) {
                bst.getbe(Double.parseDouble(input[1]),
                 Double.parseDouble(input[2]));
            } else if (input[0].equals("LE")) {
                bst.getle(Double.parseDouble(input[1]));
            } else {
                bst.getge(Double.parseDouble(input[1]));
            }
        }
    }
}
