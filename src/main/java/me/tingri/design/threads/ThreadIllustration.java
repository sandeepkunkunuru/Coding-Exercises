package me.tingri.design.threads;

import java.util.LinkedList;
import java.util.Queue;

public class ThreadIllustration {
	private static Queue<Integer> jobQueue = new LinkedList<Integer>();
    private static final int MAXIMUM_JOBS = 100 ;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadIllustration monitor = new ThreadIllustration();

		Thread controller = new Thread(new Controller(monitor));

		controller.start();
	}

	private static class Controller implements Runnable {
		private Object monitor;

		public Controller(Object monitor) {
			this.monitor = monitor;
		}

		@Override
		public void run() {
			try {
				Thread producer = new Thread(new Producer(monitor));
				Thread consumer = new Thread(new Consumer(monitor));

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
        private Object monitor;

		public Producer(Object monitor) {
			this.monitor = monitor;

		}

		@Override
		public void run() {
			try {
                System.out.println("This will always get printed ahead");
                int counter = MAXIMUM_JOBS;

                while (true && counter > 0) {
					synchronized (monitor) {
						if (jobQueue.isEmpty() ) {
							System.out
									.println(Thread.currentThread().getName());
							jobQueue.add(1);
                            counter--;
							monitor.notify();
						} else {
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
		private Object monitor;

		public Consumer(Object monitor) {
			this.monitor = monitor;
		}

		@Override
		public void run() {
			try {
                System.out.println("This will always get printed ahead");
                int counter = MAXIMUM_JOBS;

                while (true && counter > 0 ) {
					synchronized (monitor) {
						if (jobQueue.isEmpty()) {
							monitor.wait();
						} else {
							System.out.println(Thread.currentThread().getName() + jobQueue.remove());
                            counter--;
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
