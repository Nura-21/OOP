
public class Time {
	int h;
	int m;
	public Time() {
		
	}
	public Time(int h, int m) {
		this.h = h;
		this.m = m;
	}
	public String toString() {
		
		return h+ ":" +m;
	}
	public boolean equals(Time t) {
		return t.h==h && t.m == m;
	}
	
}
