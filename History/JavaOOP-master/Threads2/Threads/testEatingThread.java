
public class testEatingThread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EatingThread m = new EatingThread(6);
		EatingThread m2 = new EatingThread(4);
		m.setName("Gauhar");
		m2.setName("Ernar");
		m.start();
		m2.start();
	}

}
