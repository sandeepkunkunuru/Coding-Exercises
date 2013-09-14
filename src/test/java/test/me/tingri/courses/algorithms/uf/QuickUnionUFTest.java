package test.me.tingri.courses.algorithms.uf;

import me.tingri.courses.algorithms.uf.Item;
import me.tingri.courses.algorithms.uf.QuickUnionUF;
import me.tingri.courses.algorithms.uf.UnionFind;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: kunkunur
 * Date: 9/10/13
 * Time: 9:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class QuickUnionUFTest {
    @Test
    /**
     * Dynamic connectivity use case
     */
    public void testQuickFindUF_Dynamic_Connectivity() throws Exception {
        int[] items = new int[10];


        for(int i=0; i<items.length; i++) {
            items[i] = i;
        }

        UnionFind uf = new QuickUnionUF<Item>(Utility.getItemArray(items));

        System.out.println(uf);

        uf.union(0, 5);
        uf.union(5, 6);
        uf.union(6, 1);
        uf.union(1, 2);
        uf.union(2, 7);
        uf.union(3, 4);
        uf.union(3, 8);
        uf.union(4, 9);

        System.out.println(uf);

        assert(uf.connected(1, 5));
        assert(uf.connected(1, 7));
        assert(uf.connected(5, 1));
        assert(!uf.connected(2, 8));
        assert(!uf.connected(4, 6));

    }


    @Test
    /**
     * Ancestors
     */
    public void testQuickFindUF_Ancestors() throws Exception {
        String[] items = new String[]{"Seetharamaiah", "Sandeep", "China Sobhanam", "Alivelu", "Madhu",
                "Jyothsna", "Sudheer", "KoteswaraRao", "G.Seetharamaiah",
                "Raju", "Saritha", "Hymi"};


        UnionFind uf = new QuickUnionUF<Item>(Utility.getItemArray(items));

        System.out.println(uf);

        uf.union(0, 1); //Seetharamaiah is father of Sandeep
        uf.union(2, 0); //Seetharamaiah is son of China Sobhanam
        uf.union(3, 4); //Alivelu is mother of Madhu
        uf.union(5, 3); //Alivelu is mother of Jyothsna
        uf.union(0, 6); //Seetharamaiah is father of Sudheer
        uf.union(7, 8); //Koteswara Rao is son of G.Seetharamaiah
        uf.union(9, 3); //Alivelu is mother of Raju
        uf.union(10, 0); //Seethramaiah is father of Saritha
        uf.union(11, 5); //Jyothsna is mother of Hymi

        System.out.println(uf);

        assert(uf.connected(1, 2)) ; //Sandeep is related to China Sobhanam
        assert(!uf.connected(9, 7));  //Raju is not related to Koteswara Rao
        assert(uf.connected(3, 11));  //Alivelu is related to Hymi
        assert(!uf.connected(2, 8));  //China Sobhanam and koteswara Rao are not related
        assert(!uf.connected(4, 6));  //Madhu is not related to Sudheer

    }



}
