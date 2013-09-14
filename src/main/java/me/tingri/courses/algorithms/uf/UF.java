package me.tingri.courses.algorithms.uf;

/**
 * Created with IntelliJ IDEA.
 * User: kunkunur
 * Date: 9/9/13
 * Time: 11:04 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class UF<T extends Item> implements UnionFind {
    protected T[] items;

    public UF(T[] items){
         this.items = items;
    }
}
