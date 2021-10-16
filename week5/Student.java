public class Student{
	public String name;
	public int id;
	private double gpa;
	public String specialty;

    public static int numberofstudents = 0;
    
	Student(String name,int id){
        this.name = name;
        this.id = id;
        numberofstudents++;
    }
    public String getName(){return name;}
    public int getId(){return id;}
	public double getGPA(){return gpa;}
}
