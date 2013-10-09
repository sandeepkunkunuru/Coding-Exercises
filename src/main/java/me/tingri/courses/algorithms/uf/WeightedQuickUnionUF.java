package me.tingri.courses.algorithms.uf;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: kunkunur
 * Date: 9/9/13
 * Time: 10:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class WeightedQuickUnionUF<T extends Item> extends UF<T> {
    private int[] size;

    public WeightedQuickUnionUF(T[] items) {
        super(items);
        size = new int[items.length];
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

        if(size[root_q] >= size[root_p]){
            items[root_p].id = items[root_q].id;
            size[root_q] += size[root_p];
        } else {
            items[root_q].id = items[root_p].id;
            size[root_p] += size[root_q];
        }
    }

    @Override
	public String toString() {
        return Arrays.toString(items);
    }
}
