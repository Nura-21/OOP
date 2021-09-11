package task2;

public class BeeThread extends Thread {
	static int amountOfHoney = 0;
	static int limit = 3;
	static int honeyMaxCapacity;
	String name;

	public BeeThread() {
	}

	public BeeThread(String name, int honeyMaxCapacity) {
		BeeThread.honeyMaxCapacity = honeyMaxCapacity;
		this.name = name;
	}

	static synchronized void fill() {
		amountOfHoney += 1;
		System.out.println("Bee " + Thread.currentThread().getId() + " deliver one unit of honey. Current amount: "
				+ amountOfHoney);
		if (amountOfHoney == honeyMaxCapacity) {
			System.out.println("The barrel is full");
			System.out.println("Bee " + Thread.currentThread().getId() + " woke up the bear");
			BearThread bear = new BearThread();
			bear.start();
			try {
				bear.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public String toString() {
		return name;
	}

	public void run() {
		while (limit != 0) {
			fill();
		}
	}
}
