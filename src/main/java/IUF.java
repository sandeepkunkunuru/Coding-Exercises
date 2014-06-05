/**
 * Created by kunkunur on 2/9/14.
 */
interface IUF {
    boolean connected(int p, int q);

    void union(int p, int q);

    int[] getObjects();
}
