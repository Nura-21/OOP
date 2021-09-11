package task4;

public class Student {
    private String name;
    private static int cnt = 1;
    private int id = cnt;
    private int yearOfStudy = 1;
    private int grade;
    
    public Student(){
    	
    }
 
    public Student(String name) {
        this.name = name;
    }
    public Student(String name, int yearOfStudy) {
        this(name);
        this.yearOfStudy = yearOfStudy;
    }
 
    {
    	id = cnt;
    	cnt++;
    }
    
    public String getName() {
    	return name;
    }
    public int getId() {
        return id;
    }
    public int getYearOfStudy() {
        return yearOfStudy;
    }
    public int getGrade() {
        return grade;
    }

    public void setName(String name) {
    	this.name = name;
    }
    public void setYear(int yearOfStudy) {
    	this.yearOfStudy = yearOfStudy;
    }
    public void setGrade(int grade) {
    	this.grade = grade;
    }

    
    public String toString() {
    	return "Name: " + name
    			+ "\nYear: " + yearOfStudy
    			+ "\nID: " + id
    			+ "\nGrade: " + grade + "\n";
    }
    
  }

