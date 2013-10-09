package me.tingri.courses.algorithms.uf;

/**
 * Created with IntelliJ IDEA.
 * User: kunkunur
 * Date: 9/13/13
 * Time: 9:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class Item<U> {
    U  value;
    int id;

    public Item(U value, int id){
       this.value = value;
       this.id = id;
    }

    @Override
	public String toString(){
        return this.id + "(" + this.value + ")";
    }

}
