package me.tingri.courses.algorithms.uf;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: kunkunur
 * Date: 9/9/13
 * Time: 10:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class QuickFindUF<T extends Item>  extends UF<T>{

    public QuickFindUF(T[] items) {
        super(items);
    }

    @Override
    public boolean connected(int p, int q) {
        return items[p].id == items[q].id;
    }

    @Override
    public void union(int p, int q) {
        int pid =  items[p].id;
        int qid =  items[q].id;

        for(int i=0; i < items.length; i++){
            if(items[i].id == pid ){
                  items[i].id = qid;
            }
        }
    }

    @Override
	public String toString(){
        return Arrays.toString(items);
    }
}
