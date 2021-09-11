package taskFive;

public class Time implements Comparable {
	private int hour;
	private int minute;
	private int second;

	public Time() {
	}

	public Time(int hour, int minute, int second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	@Override
	public int compareTo(Object o) {
		Time t = (Time) o;
		if (hour > t.hour)
			return 1;
		if (hour < t.hour)
			return -1;
		if (hour == t.hour) {
			if (minute > t.minute)
				return 1;
			if (minute < t.minute)
				return -1;
			if (minute == t.minute) {
				if (second > t.second)
					return 1;
				if (second < t.second)
					return -1;
			}
		}
		return 0;
	}

	@Override
	public String toString() {
		return "Time [hour=" + hour + ", minute=" + minute + ", second=" + second + "]";
	}

}
