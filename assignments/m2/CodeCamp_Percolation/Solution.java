import java.util.Scanner;
import java.util.Arrays;

// public class Percolation {
//    public Percolation(int n)                // create n-by-n grid, with all sites blocked
//    public    void open(int row, int col)    // open site (row, col) if it is not open already
//    public boolean isOpen(int row, int col)  // is site (row, col) open?
//    public boolean isFull(int row, int col)  // is site (row, col) full?
//    public     int numberOfOpenSites()       // number of open sites
//    public boolean percolates()              // does the system percolate?
// }


// You can implement the above API to solve the problem

class WeightedQuickUnionUF {
    private int[] parent;
    private int[] size;
    private int count;
    public WeightedQuickUnionUF(int n) {
        count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    public int root(int p) {
        while (p != parent[p])
            p = parent[p];
        return p;
    }
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }
    public void union(int p, int q) {
        int rootP = root(p);
        int rootQ = root(q);
        if (rootP == rootQ) return;

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

class Percolation {
    private boolean[][] grid;
    private int top = 0;
    private int bottom;
    private int size;
    private WeightedQuickUnionUF uf;
    private int opencount = 0;
    public Percolation(int n) {
        size = n;
        bottom = (n * n) + 1;
        uf = new WeightedQuickUnionUF((n * n) + 2);
        grid = new boolean[n][n];
    }
    public void open(int row, int col) {
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
    public boolean isOpen(int row, int col) {
        return grid[row - 1][col - 1];
    }
    public boolean isFull(int row, int col) {
        if (0 < row && row <= size && 0 < col && col <= size) {
            return uf.connected(top, getIndex(row, col));
        }
        return false;
    }
    public int numberOfOpenSites() {
        return opencount;
    }
    public boolean percolates() {
        return uf.connected(top, bottom);
    }
    private int getIndex(int row, int col) {
        return size * (row - 1) + col;
    }
}

public final class Solution {
    private Solution() {
        //constructor.
    }
    public static void main(String[] args) {
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
