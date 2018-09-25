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
    int[][] grid;
    int opencount;
    int size;
    WeightedQuickUnionUF uf;
    // create n-by-n grid, with all sites blocked
    public Percolation(int n) {
        uf = new WeightedQuickUnionUF((n * n) + 1);
        grid = new int[n][n];
        opencount = 0;
        size = n;
    }
    //connect adjacents.
    void connectadjacents(int x, int y) {
        int s1 = size * size - 1;
        int s = x + (y * size);
        if ((s + 1 < s1) && (x < size - 1)) { //right 1
            if (this.isOpen(x + 1, y)) {
                this.uf.union(s, s + 1);
            }
        }
        if ((s - 1 > 0) && (x > 0)) { //left 1
            if (this.isOpen(x - 1, y)) {
                this.uf.union(s, s - 1);
            }
        }
        if ((s - size > 0) && (y - 1 > 0)) { //up 1
            if (this.isOpen(x, y - 1)) {
                this.uf.union(s, s - size);
            }
        }
        if ((s + size < s1) && (y + 1 <= size)) { //down 1
            if ((this.isOpen(x, y + 1))) {
                this.uf.union(s, s + size);
            }
        }
    }
    // open site (row, col) if it is not open already
    public void open(int row, int col) {
        if (!isOpen(row, col)) {
            grid[row][col] = 1;
            opencount++;
            connectadjacents(row, col);
            //System.out.println(Arrays.deepToString(grid));
        }
    }
    // is site (row, col) open?
    public boolean isOpen(int row, int col) {
        return grid[row][col] == 1;
    }
    // is site (row, col) full?
    public boolean isFull(int row, int col) {
        if (isOpen(row, col)) {
            if (uf.connected(0, ((row*size) + col))) {
                return true;
            }
        }
        return false;
    }
    // number of open sites
    public int numberOfOpenSites() {
        return opencount;
    }
    // does the system percolate?
    public boolean percolates() {
        for (int i = 0; i < size; i++ ) {
            if (isFull(size - 1, i)) {
                return true;
            }
        }
        return false;
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
            p.open(r - 1, c - 1);
        }
        //System.out.println(p.percolates());
    }
}
