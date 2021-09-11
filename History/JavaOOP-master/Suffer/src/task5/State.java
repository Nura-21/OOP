package task5;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class State implements Runnable {
	public String name;
	public int budget;
	public int value;
	public State enemy;
	public Semaphore sem;

	public State() {
	}

	public State(String name, int budget, int value, State enemy, Semaphore sem) {
		this.name = name;
		this.budget = budget;
		this.value = value;
		this.enemy = enemy;
		this.sem = sem;
	}

	public synchronized void run() {
		final Random random = new Random();
		while (budget > 0 && value > 0 && enemy.budget > 0 && enemy.value > 0) {
			try {
				sem.acquire();
				System.out.println(name + " attacks...");
				int powerLevel = random.nextInt(4);
				budget -= 1000;
				enemy.value -= (powerLevel * 1000);
				Thread.sleep(1000);
				System.out.println(
						"The attack was carried out. We lost 1000 gold. Enemy lost - " + powerLevel * 1000 + " value");
				System.out.println("Attackers - State: " + name + " Budget: " + budget + " Value: " + value);
				System.out.println(
						"Defenders - State: " + enemy.name + " Budget: " + enemy.budget + " Value: " + enemy.value);
				sem.release();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public String toString() {
		return name + ". Budget: " + budget + ". Value: " + value;
	}
}
