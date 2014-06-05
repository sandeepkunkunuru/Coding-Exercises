/**
 * Created by kunkunur on 2/9/14.
 */
public class QuickUnion implements IUF {
    final int[] objects;

    public QuickUnion(int n) {
        objects = new int[n];

        for (int i = 0; i < n; i++) {
            objects[i] = i; // Each object is in a component tree with itself as the root.
        }
    }

    @Override
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    @Override
    public void union(int p, int q) {
        int root_p = root(p);
        int root_q = root(q);

        objects[root_p] = root_q;  //Making root of p point to root of q
    }

    @Override
    public int[] getObjects() {
        return objects;
    }

    int root(int p) {
        while (p != objects[p]) { //while root and open are not same.
            p = objects[p];
        }
        return p;
    }
}
