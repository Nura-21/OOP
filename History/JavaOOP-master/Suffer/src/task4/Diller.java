package task4;

import java.util.Random;


public class Diller extends Thread {
	static int maxDeals = 3;
	static boolean[] materials; // 0 - tobacco, 1 - paper, 2 - matches
	static {
		materials = new boolean[] { true, true, true }; // initially all available
	}

	public Diller() {
	}

	public void run() {
		final Random random = new Random();
		System.out.println("Diller starts deals");
		System.out.println("0 - tobacco, 1 - paper, 2 - matches");
		Thread[] smokers = new Thread[] { new Smoker(0), new Smoker(1), new Smoker(2) };
		for (Thread smoker : smokers)
			smoker.start();
		try {
			while (maxDeals > 0) {
				Thread.sleep(2000);
				int material = random.nextInt(3);
				materials[material] = false;
				System.out.println("Material: " + material + " is not available, other available");
				System.out.println("Diller waiting for smoker...");
				smokers[material].run();
				smokers[material].join();
				maxDeals--;
				materials[0] = materials[1] = materials[2] = true;
			}
			System.out.println("Diller ends deals");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}