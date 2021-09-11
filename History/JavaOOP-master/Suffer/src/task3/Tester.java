package task3;

import java.util.concurrent.Semaphore;

public class Tester {

	public static void main(String[] args) {
		Semaphore sem = new Semaphore(2);
		for (int i = 0; i < 5; i++)
			new Philosopher(sem, i).start();
	}
}