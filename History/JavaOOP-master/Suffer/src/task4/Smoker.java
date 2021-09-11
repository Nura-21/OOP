package task4;

public class Smoker extends Thread {
	int material; // material that available

	public Smoker() {
	}

	public Smoker(int material) {
		this.material = material;
	}

	public synchronized void run() {
		if (!Diller.materials[0] || !Diller.materials[1] || !Diller.materials[2]) {
			try {
				System.out.println("Smoker with material " + material + " takes materials from diller");
				Thread.sleep(500);
				System.out.println("Smoking...");
				Thread.sleep(500);
				System.out.println("Ends smoking...");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
