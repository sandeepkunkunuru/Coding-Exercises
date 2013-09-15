package test.me.tingri.courses.algorithms.uf;

import com.google.common.base.Stopwatch;
import me.tingri.courses.algorithms.uf.*;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: kunkunur
 * Date: 9/10/13
 * Time: 9:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class PerformanceTest {
    @Test
    /**
     * Dynamic connectivity use case
     */
    public void testPerformance() throws Exception {
        int[] items = new int[200000];


        for (int i = 0; i < items.length; i++) {
            items[i] = i;
        }

        UnionFind uf = new QuickFindUF<Item>(Utility.getItemArray(items));
        Stopwatch sw = new Stopwatch();
        sw.start();

        for (int i = 0; i < items.length; i = i + 4) {
            uf.union(i, i + 1);
            uf.union(i + 2, i + 3);
        }


        for (int i = 0; i < items.length; i = i + 4) {
            assert (uf.connected(i, i + 1));
            assert (uf.connected(i + 2, i + 3));
            assert (!uf.connected(i + 1, i + 2));
        }

        System.out.println("Quick Find...." + sw.elapsed(TimeUnit.NANOSECONDS));

        //---------------------------------------

        uf = new QuickUnionUF<Item>(Utility.getItemArray(items));
        sw = new Stopwatch();
        sw.start();

        for (int i = 0; i < items.length; i = i + 4) {
            uf.union(i, i + 1);
            uf.union(i + 2, i + 3);
        }


        for (int i = 0; i < items.length; i = i + 4) {
            assert (uf.connected(i, i + 1));
            assert (uf.connected(i + 2, i + 3));
            assert (!uf.connected(i + 1, i + 2));
        }

        System.out.println("Quick Union...." + sw.elapsed(TimeUnit.NANOSECONDS));

        //---------------------------------------

        uf = new WeightedQuickUnionUF<Item>(Utility.getItemArray(items));
        sw = new Stopwatch();
        sw.start();

        for (int i = 0; i < items.length; i = i + 4) {
            uf.union(i, i + 1);
            uf.union(i + 2, i + 3);
        }


        for (int i = 0; i < items.length; i = i + 4) {
            assert (uf.connected(i, i + 1));
            assert (uf.connected(i + 2, i + 3));
            assert (!uf.connected(i + 1, i + 2));
        }


        System.out.println("Weighted Quick Union...." + sw.elapsed(TimeUnit.NANOSECONDS));

    }

}
