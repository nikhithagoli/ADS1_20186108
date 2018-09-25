import java.util.Scanner;
/**
union find class.
*/
class WeightedQuickUnionUF {
    /**
     * parent.
     */
    private int[] parent;
    /**
     * size array.
     */
    private int[] size;
    /**
     * count.
     */
    private int count;
    /**
     * Constructs the object.
     *
     * @param      n     { parameter_description }
     */
    WeightedQuickUnionUF(final int n) {
        count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    /**
     * finds root.
     *
     * @param      p     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int root(final int p) {
        int q = p;
        while (q != parent[q]) {
            q = parent[q];
        }
        return q;
    }
    /**
     * connected.
     *
     * @param      p     { parameter_description }
     * @param      q     The quarter
     *
     * @return     { description_of_the_return_value }
     */
    public boolean connected(final int p, final int q) {
        return root(p) == root(q);
    }
    /**
     * union.
     *
     * @param      p     { parameter_description }
     * @param      q     The quarter
     */
    public void union(final int p, final int q) {
        int rootP = root(p);
        int rootQ = root(q);
        if (rootP == rootQ) {
            return;
        }
        // make smaller root point to larger one
        if (size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        } else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
        count--;
    }
}
/**
 * Class for percolation.
 */
class Percolation {
    /**
     * grid.
     */
    private boolean[][] grid;
    /**
     * top.
     */
    private int top = 0;
    /**
     * bottom.
     */
    private int bottom;
    /**
     * size.
     */
    private int size;
    /**
     * uf object.
     */
    private WeightedQuickUnionUF uf;
    /**
     * open count.
     */
    private int opencount = 0;
    /**
     * Constructs the object.
     *
     * @param      n     { parameter_description }
     */
    Percolation(final int n) {
        size = n;
        bottom = (n * n) + 1;
        uf = new WeightedQuickUnionUF((n * n) + 2);
        grid = new boolean[n][n];
    }
    /**
     * open.
     *
     * @param      row   The row
     * @param      col   The col
     */
    public void open(final int row, final int col) {
        if (!isOpen(row, col)) {
            grid[row - 1][col - 1] = true;
            opencount++;
        }
        if (row == 1) {
            uf.union(getIndex(row, col), top);
        }
        if (row == size) {
            uf.union(getIndex(row, col), bottom);
        }
        if (col > 1 && isOpen(row, col - 1)) {
            uf.union(getIndex(row, col), getIndex(row, col - 1));
        }
        if (col < size && isOpen(row, col + 1)) {
            uf.union(getIndex(row, col), getIndex(row, col + 1));
        }
        if (row > 1 && isOpen(row - 1, col)) {
            uf.union(getIndex(row, col), getIndex(row - 1, col));
        }
        if (row < size && isOpen(row + 1, col)) {
            uf.union(getIndex(row, col), getIndex(row + 1, col));
        }
    }
    /**
     * Determines if open.
     *
     * @param      row   The row
     * @param      col   The col
     *
     * @return     True if open, False otherwise.
     */
    public boolean isOpen(final int row, final int col) {
        return grid[row - 1][col - 1];
    }
    /**
     * Determines if full.
     *
     * @param      row   The row
     * @param      col   The col
     *
     * @return     True if full, False otherwise.
     */
    public boolean isFull(final int row, final int col) {
        if (0 < row && row <= size && 0 < col && col <= size) {
            return uf.connected(top, getIndex(row, col));
        }
        return false;
    }
    /**
     * opensites.
     *
     * @return     { description_of_the_return_value }
     */
    public int numberOfOpenSites() {
        return opencount;
    }
    /**
     * percolates.
     *
     * @return     { description_of_the_return_value }
     */
    public boolean percolates() {
        return uf.connected(top, bottom);
    }
    /**
     * getInex.
     *
     * @param      row   The row
     * @param      col   The col
     *
     * @return     The index.
     */
    private int getIndex(final int row, final int col) {
        return size * (row - 1) + col;
    }
}
/**
 * soluton class.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //constructor.
    }
    /**
     * main.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Percolation p = new Percolation(n);
        while (sc.hasNext()) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            p.open(r, c);
        }
        //System.out.println(Arrays.deepToString(p.grid));
        System.out.println(p.percolates());
    }
}
