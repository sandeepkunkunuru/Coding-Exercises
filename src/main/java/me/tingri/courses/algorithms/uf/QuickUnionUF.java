package me.tingri.courses.algorithms.uf;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: kunkunur
 * Date: 9/9/13
 * Time: 10:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class QuickUnionUF<T extends Item> extends UF<T> {

    public QuickUnionUF(T[] items) {
        super(items);
    }

    @Override
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    private int root(int p) {
        while (p != items[p].id) {
            p = items[p].id;
        }

        return p;
    }

    @Override
    public void union(int p, int q) {
        int root_p = root(p);
        int root_q = root(q);

        items[root_p].id = items[root_q].id;
    }

    @Override
	public String toString() {
        return Arrays.toString(items);
    }
}
