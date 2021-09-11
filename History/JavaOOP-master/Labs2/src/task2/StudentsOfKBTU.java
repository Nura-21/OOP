package task2;

public class StudentsOfKBTU {
	private String name;
	static private int cnt;
	private double gpa;
	private Degree degree;
	private int id = cnt;
	final private String university = "KBTU";
	
	{
		cnt++;
		id = cnt;
	}
	public StudentsOfKBTU() {
		
	}
	public StudentsOfKBTU(String name) {
		this.name = name;
	}
	public StudentsOfKBTU(String name, Degree degree) {
		this(name);
		this.degree = degree;
	}
	public StudentsOfKBTU(String name, Degree degree,double gpa) {
		this(name,degree);
		this.gpa = gpa;
	}
	
	void setInfo(double gpa) {
		this.gpa = gpa;
	}
	void setInfo(double gpa, Degree degree) {
		setInfo(gpa);
		this.degree = degree;
	}

    String getName() {
    	return name;
    }
    
    int getId() {
        return id;
    }
    
	public String toString() {
		return name+ ", "+gpa+", "+degree+ ", "+id+ ", "+university;
	}
    	
}	
