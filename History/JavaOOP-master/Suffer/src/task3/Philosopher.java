package task3;

import java.util.concurrent.Semaphore;

public class Philosopher extends Thread {
	Semaphore sem;
	static boolean[] forks;
	boolean isFull;
	int id;
	static {
		forks = new boolean[] { true, true, true, true, true };
	}

	public Philosopher() {
	}

	public Philosopher(Semaphore sem, int id) {
		this.sem = sem;
		this.id = id;
		this.isFull = false;
	}

	public void run() {
		try {
			while (!isFull) {
				if (forks[id] && forks[(id + 1) % 5]) { // philosopher with id 0 has forks 0 from left, and fork 1 from right
					forks[id] = forks[(id + 1) % 5] = false;
					sem.acquire();
					System.out.println("Philosopher " + id + " takes forks: " + id + " and " + (id + 1) % 5);
					Thread.sleep(500);
					System.out.println("Philosopher " + id + " free forks: " + id + " and " + (id + 1) % 5);
					forks[id] = forks[(id + 1) % 5] = true;
					isFull = true;
					sem.release();
				}
				Thread.sleep(100);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
