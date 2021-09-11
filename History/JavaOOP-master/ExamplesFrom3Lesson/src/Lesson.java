
public class Lesson {
	Time time;
	String name;
	Days day;
	Type type;
	static int cnt=0;
	
	int id;
	{
		id = cnt++;
	}
	public Lesson() {}
	public Lesson(Time time, String name) {
		this.time = time;
		this.name = name;
	}
	public Lesson(Time time, String name, Days day, Type type) {
		this(time, name);
		this.day = day;
		this.type = type;
	}
	public String toString() {
		return name+ " ,"+time.toString()+ " ,"+day+ " ,"+type;
	}
	public boolean equals(Lesson l) {
		return l.name.equals(name) && time.equals(l.time) && l.day == day;
	}
	
	void setData(Days d, Time t){
		this.day = d;
		this.time = t;
	}
	void setData(Days d, Time t, String name) {
		setData(d, t);
		this.name = name;
	}
	
	 boolean checkCollision(Lesson l) {
		 return checkCollision(l, this);
	 }
	static boolean checkCollision(Lesson a, Lesson b) {
		return a.time.equals(b.time) && a.day==b.day;
	}
	
	
}

