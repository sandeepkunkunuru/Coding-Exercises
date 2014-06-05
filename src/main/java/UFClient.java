import java.util.Arrays;

/**
 * Created by kunkunur on 2/7/14.
 */
public class UFClient {

    public static void main(String[] args) throws Exception {
        String alg = args[0];

        int n = StdIn.readInt();
        IUF uf;

        switch (alg) {
            case "QUICKFIND":
                uf = new QuickFind(n);
                testQuickUnion(uf);
                break;
            case "QUICKUNION":
                uf = new QuickUnion(n);
                testQuickUnion(uf);
                break;
            case "WEIGHTEDQUICKUNION":
                uf = new WeightedQuickUnion(n);
                testQuickUnion(uf);
                break;
            case "WEIGHTEDQUICKUNIONWITHPATHCOMPRESSION":
                uf = new WeightedQuickUnionWithPathCompression(n);
                testQuickUnion(uf);
                break;
            default:
                throw new Exception("Invalid Algorithm Selection");

        }

        System.out.println("Final Array:" + Arrays.toString(uf.getObjects()));
    }

    private static void testQuickUnion(IUF uf) {
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();

            if (!uf.connected(p, q)) {
                uf.union(p, q);
                StdOut.println(p + "   " + q);
            }
        }
    }
}
