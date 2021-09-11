package task2;

public class Tester {

	public static void main(String[] args) {
		int n = 10;
		int H = 10;
		ThreadGroup group = new ThreadGroup("group of bees");
		Thread[] bees = new Thread[n];
		for (int i = 0; i < bees.length; i++) {
			bees[i] = new Thread(group, new BeeThread("Bee", H));
			bees[i].start();
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}

	}

}
