package task2;

public class BearThread extends Thread {
	public BearThread() {
	}

	public void run() {
		System.out.println("Bear wakes up");
		System.out.println("Bear drinks honey...");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		BeeThread.amountOfHoney = 0;
		BeeThread.limit--;
		System.out.println("Amount of honey : " + BeeThread.amountOfHoney + " Times to eat: " + BeeThread.limit);
		if (BeeThread.limit == 0) {
			System.exit(0);
		}
	}
}
