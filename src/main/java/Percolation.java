
/**
 * Created by kunkunur on 2/13/14.
 */
public class Percolation {
    private final boolean[][] open;
    private final int size;
    private final WeightedQuickUnionUF uf;

    // create N-by-N grid, with all sites blocked
    public Percolation(int N) {
        size = N;
        open = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                open[i][j] = false;
            }
        }

        uf = new WeightedQuickUnionUF(size * size + 2);

        for (int i = 1; i <= size; i++) {
            uf.union(0, i);
            uf.union(size * size + 1, size * (size - 1) + i);
        }
    }

    // open site (row i, column j) if it is not already
    public void open(int i, int j) {
        isValid(--i, --j);

        open[i][j] = true;

        if (i < size - 1 && isBlockOpen(i + 1, j)) {
            uf.union(i * size + j + 1, (i + 1) * size + j + 1);
        }

        if (i > 0 && isBlockOpen(i - 1, j)) {
            uf.union(i * size + j + 1, (i - 1) * size + j + 1);
        }

        if (j < size - 1 && isBlockOpen(i, j + 1)) {
            uf.union(i * size + j + 1, i * size + j + 1 + 1);
        }

        if (j > 0 && isBlockOpen(i, j - 1)) {
            uf.union(i * size + j + 1, i * size + j - 1 + 1);
        }

    }

    // is site (row i, column j) open?
    public boolean isOpen(int i, int j) {
        isValid(--i, --j);

        return isBlockOpen(i, j);
    }

    // is site (row i, column j) full?
    public boolean isFull(int i, int j) {
        isValid(--i, --j);

        if (isBlockOpen(i, j)) {
            if (uf.connected(0, (i * size) + j + 1)) {
                return true;
            }
        }

        return false;
    }

    // does the system percolate?
    public boolean percolates() {
        return size > 1 ? uf.connected(0, size * size + 1) : isOpen(size, size);
    }

    private void isValid(int i, int j) {
        if ((i < 0 || i >= size) || (j < 0 || j >= size)) {
            throw new ArrayIndexOutOfBoundsException("Invalid index i=" + i + " j=" + j + " and size = " + size);
        }
    }

    private boolean isBlockOpen(int i, int j) {
        return open[i][j];
    }

}