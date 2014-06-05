package me.tingri.design.threads;

import java.util.LinkedList;
import java.util.Queue;

public class ThreadIllustration {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Monitor<Integer> monitor;
        if (args.length == 3) {
            monitor = new Monitor<Integer>(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]));
        } else {
            monitor = new Monitor<Integer>();
        }

        Thread controller = new Thread(new Controller(monitor));

        controller.start();
    }

    private static class Monitor<T> {
        private Queue<T> jobQueue = new LinkedList<T>();
        private int counter;
        private int leastQueueSize;
        private int maxQueueSize;

        Monitor() {
            this.leastQueueSize = 1;
            this.maxQueueSize = 1;
            this.counter = 5;
        }

        // if maximum jobs isn't a multiple of max queue size then some jobs will be left out in the queue
        Monitor(int leastQueueSize, int maxQueueSize, int maximumJobs) {
            this.leastQueueSize = leastQueueSize;
            this.maxQueueSize = maxQueueSize;
            this.counter = maximumJobs;
        }

        boolean hasSufficientQueue() {
            return jobQueue.size() >= leastQueueSize;
        }

        boolean reachedQueueSizeLimit() {
            return jobQueue.size() == maxQueueSize;
        }

        public void add(T value) {
            jobQueue.add(value);
        }

        public T remove() {
            counter--;
            return jobQueue.remove();
        }

        public boolean stop(){
            return counter < 0;
        }
    }

    private static class Controller implements Runnable {
        private Monitor monitor;

        public Controller(Monitor monitor) {
            this.monitor = monitor;
        }

        public void run() {
            try {
                Thread producer = new Thread(new Producer(monitor));
                Thread consumer = new Thread( new Consumer(monitor));

                System.out.println("This will always get printed at the very start");

                producer.start();
                consumer.start();

                //If t is a Thread object whose thread is currently executing,
                // t.join();
                // causes the current thread to pause execution until t's thread terminates.
                //Like sleep, join responds to an interrupt by exiting with an InterruptedException.

                producer.join();//Controller waits till producer is terminated
                consumer.join();//Controller waits till consumer is also terminated

                System.out.println("This will always get printed at the very end");
            } catch (InterruptedException ie) {
                System.out.println("Controller has been interrupted");
            }
        }
    }

    private static class Producer implements Runnable {
        private final Monitor monitor;

        public Producer(Monitor monitor) {
            this.monitor = monitor;

        }

        public void run() {
            try {
                while (true) {
                    synchronized (monitor) {
                        if(monitor.stop()){
                            break;
                        } else if (!monitor.reachedQueueSizeLimit()) {
                            int value = (int) Math.floor(Math.random() * 1000);
                            monitor.add(value);
                            System.out.println(Thread.currentThread().getName() + "-" + value);
                            System.out.println(Thread.currentThread().getName() + " is notifying other threads to wake up");
                            monitor.notify();
                        } else {
                            System.out.println(Thread.currentThread().getName() + " is going to wait state since queue size is " + monitor.jobQueue.size());
                            monitor.wait();
                        }
                    }
                }
            } catch (InterruptedException ie) {
                System.out.println("Producer has been interrupted");
            }
        }
    }

    private static class Consumer implements Runnable {
        private final Monitor monitor;

        public Consumer(Monitor monitor) {
            this.monitor = monitor;
        }

        public void run() {
            try {
                while (true) {
                    synchronized (monitor) {
                        if(monitor.stop()){
                            break;
                        } else if (!monitor.hasSufficientQueue()) {
                            System.out.println(Thread.currentThread().getName() + " is going to wait state since queue size is " + monitor.jobQueue.size());
                            monitor.wait();
                        } else {
                            System.out.println(Thread.currentThread().getName() + "-" + monitor.remove());
                            System.out.println(Thread.currentThread().getName() + " is notifying other threads to wake up");
                            monitor.notify();
                        }
                    }
                }
            } catch (InterruptedException ie) {
                System.out.println("consumer has been interrupted");
            }
        }
    }


}
