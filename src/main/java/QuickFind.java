/**
 * Created by kunkunur on 2/9/14.
 */
public class QuickFind implements IUF {
    private final int[] objects;
    private final int size;

    public QuickFind(int n) {
        size = n;
        objects = new int[n];

        for (int i = 0; i < n; i++) {
            objects[i] = i;
        }
    }

    @Override
    public boolean connected(int p, int q) {
        return (objects[p] == objects[q]);
    }

    @Override
    public void union(int p, int q) {
        int connected_component_id_p = objects[p];
        int connected_component_id_q = objects[q];

        for (int i = 0; i < size; i++) {
            if (objects[i] == connected_component_id_p) {
                objects[i] = connected_component_id_q;
            }
        }
    }

    @Override
    public int[] getObjects() {
        return objects;
    }
}
