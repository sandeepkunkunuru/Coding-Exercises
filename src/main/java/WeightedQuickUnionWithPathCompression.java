/**
 * Created by kunkunur on 2/9/14.
 */
class WeightedQuickUnionWithPathCompression extends WeightedQuickUnion {

    public WeightedQuickUnionWithPathCompression(int n) {
        super(n);
    }

    @Override
    protected int root(int p) {
        while (p != objects[p]) {
            objects[p] = objects[objects[p]];
            p = objects[p];
        }

        return p;
    }
}
