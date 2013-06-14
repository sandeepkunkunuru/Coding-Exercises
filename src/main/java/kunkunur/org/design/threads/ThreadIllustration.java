package kunkunur.org.design.threads;

import java.util.LinkedList;
import java.util.Queue;

public class ThreadIllustration {
	private static Queue<Integer> jobQueue = new LinkedList<Integer>();

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

		public void run() {
			try {
				Thread producer = new Thread(new Producer(monitor));
				producer.join();

				Thread consumer = new Thread(new Consumer(monitor));
				consumer.join();

				producer.start();
				consumer.start();

				System.out.println("This will always get printed first");
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

		public void run() {
			try {
				while (true) {
					synchronized (monitor) {
						if (jobQueue.isEmpty()) {
							System.out
									.println(Thread.currentThread().getName());
							jobQueue.add(1);
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

		public void run() {
			try {
				while (true) {
					synchronized (monitor) {
						if (jobQueue.isEmpty()) {
							monitor.wait();
						} else {
							System.out.println(Thread.currentThread().getName() + jobQueue.remove());
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
