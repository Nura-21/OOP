package task1;

public class Data {
	static private int cnt;
	private double sum = 0;
	private double largest = Double.MIN_VALUE;
	
	public Data() {}

	void addValue(int n){
		largest = Math.max(largest,n);
		sum+=n;
		cnt++;
	}
	double getAverage() {
		return sum/cnt;
	}
	double getLargest() {
		return largest;
	}
}
