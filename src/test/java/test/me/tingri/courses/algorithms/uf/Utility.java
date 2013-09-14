package test.me.tingri.courses.algorithms.uf;

import me.tingri.courses.algorithms.uf.Item;

/**
 * Created with IntelliJ IDEA.
 * User: kunkunur
 * Date: 9/13/13
 * Time: 11:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class Utility {

    public static Item<Integer>[] getItemArray(int[] values){
        Item<Integer>[] items  = new Item[values.length];

        for(int i =0; i< values.length; i++){
             items[i] = new Item<Integer>(values[i], i);
        }

        return items;
    }

    public static Item<String>[] getItemArray(String[] values){
        Item<String>[] items  = new Item[values.length];

        for(int i =0; i< values.length; i++){
            items[i] = new Item<String>(values[i], i);
        }

        return items;
    }
}
