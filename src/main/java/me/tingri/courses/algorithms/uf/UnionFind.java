package me.tingri.courses.algorithms.uf;

/**
 * Created with IntelliJ IDEA.
 * User: kunkunur
 * Date: 9/9/13
 * Time: 11:00 PM
 * To change this template use File | Settings | File Templates.
 */
public interface UnionFind {

    public boolean connected(int p, int q);

    public void union(int p, int q);

}
