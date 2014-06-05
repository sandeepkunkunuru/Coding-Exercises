/**
 * Created by kunkunur on 2/9/14.
 */
public class WeightedQuickUnion extends QuickUnion {
    private final int[] size;

    public WeightedQuickUnion(int n) {
        super(n);
        size = new int[n];


        for (int i = 0; i < n; i++) {
            size[i] = 1; // Each component tree is of size 1 to start with.
        }
    }

    @Override
    public void union(int p, int q) {
        int root_p = root(p);
        int root_q = root(q);

        System.out.println(root_p + "" + p + "" + root_q + "" + q);

        System.out.println(size[root_p] + "" + size[root_q]);

        if (size[root_p] < size[root_q]) {
            objects[root_p] = root_q;
            size[root_q] += size[root_p];
        } else {
            objects[root_q] = root_p;
            size[root_p] += size[root_q];
        }

    }
}
