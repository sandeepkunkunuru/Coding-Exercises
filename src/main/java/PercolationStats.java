/**
 * Created by kunkunur on 2/21/14.
 */
public class PercolationStats {
    private final int size;
    private final int number;
    private final double[] experiments;
    private double mu;
    private double sigma;

    // perform T independent computational experiments on an N-by-N grid
    public PercolationStats(int N, int T) {
        size = N;
        number = T;
        experiments = new double[number];
    }

    // sample mean of percolation threshold
    public double mean() {
        double sum = 0;

        for (int i = 0; i < number; i++) {
            sum += experiments[i];
        }

        return sum / number;
    }


    // returns lower bound of the 95% confidence interval
    public double stddev() {
        double variance = 0;

        for (int i = 0; i < number; i++) {
            variance += Math.pow(experiments[i] - mu, 2);
        }

        variance = Math.sqrt(variance / number);
        return variance;
    }

    // sample standard deviation of percolation threshold
    public double confidenceLo() {
        return (mu - ((1.96 * sigma) / Math.sqrt(number)));
    }

    // returns upper bound of the 95% confidence interval
    public double confidenceHi() {
        return (mu + ((1.96 * sigma) / Math.sqrt(number)));
    }

    // test client, described below
    public static void main(String[] args) {
        int size = Integer.parseInt(args[0]);
        int number = Integer.parseInt(args[1]);
        PercolationStats percStats = new PercolationStats(size, number);

        int blocks = percStats.size * percStats.size;
        Stopwatch sw = new Stopwatch();

        for (int i = 0; i < number; i++) {
            Percolation perc = new Percolation(percStats.size);


            while (!perc.percolates()) {
                int block = (int) (Math.random() * blocks);
                //StdOut.println("Block to be opened:" + (block / size) + 1 + ", " + (block % size) + 1);
                perc.open((block / size) + 1, (block % size) + 1);
            }

            int counter = 0;

            for (int j = 1; j <= size; j++) {
                for (int k = 1; k <= size; k++) {
                    if (perc.isOpen(j, k)) {
                        counter++;
                    }
                }
            }

            //StdOut.println("Blocks " + blocks + " Open Blocks " + counter);
            percStats.experiments[i] = (double) counter / blocks;
        }

        percStats.mu = percStats.mean();
        percStats.sigma = percStats.stddev();

        StdOut.println("mean                    =" + percStats.mu);
        StdOut.println("stddev                  =" + percStats.sigma);
        StdOut.println("95% confidence interval =" + percStats.confidenceLo() + "," + percStats.confidenceHi());
        StdOut.println("Total elapsed Time      =" + sw.elapsedTime());
        //StdOut.println("PercStats                  =" + Arrays.toString(percStats.experiments));

    }
}
