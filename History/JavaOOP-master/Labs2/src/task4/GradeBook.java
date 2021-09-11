package task4;

import java.util.Vector;

public class GradeBook {
	public Course course;
	public Vector<Student> students;
	
	
	public GradeBook() {
		
	}
	public GradeBook(Course course) {
		this.course = course;
	}
	public GradeBook(Vector<Student> students) {
		this.students = students;
	}
	public GradeBook(Course course,Vector<Student> students) {
		this(course);
		this.students = students;
	}
	
	public void displayMessage() {
		System.out.println("Hello! Welcome to the grade book for "+course.getDesc()+"!\n");
		System.out.println("Please, input grades for each student: \n");
	}
	public void displayGradeReport() {
		System.out.println("\nStatistics:");
		this.displayAverage();
		this.displayMin();
		this.displayMax();
		this.displayDistribution();
	}
	public void displayAverage() {
		double sum = 0;
		int cnt = 0;
		for(Student student: students) {
			sum+=student.getGrade();
			cnt++;
		}
		System.out.println("Class average is: " + sum/cnt);
	}
	public void displayMax() {
		int mx = -100000;
		String nameMx = "";
		int idMx = 0;
		for(Student student: students) {
			if(student.getGrade()>mx) {
				mx = student.getGrade();
				nameMx = student.getName();
				idMx = student.getId();
			}
		}
		System.out.println("Highest grade is : " + mx + ". Student: " + nameMx + ", " + "id: " + idMx);
	}
	public void displayMin() {
		int mn = 100000;
		String nameMn = "";
		int idMn = 0;
		for(Student student: students) {
			if(student.getGrade()<mn) {
				mn = student.getGrade();
				nameMn = student.getName();
				idMn = student.getId();
			}
		}
		System.out.println("Lowest grade is : " + mn + ". Student: " + nameMn + ", " + "id: " + idMn);
	}
	public void displayDistribution() {
		System.out.println("\nGrades distribution:");
		String[] arr = new String[11];
		for(int i = 0; i < 11; i++)
			arr[i] = "";
		for(Student student: students) {
			if(student.getGrade()<=9)
				arr[0]+="*";
			else if(student.getGrade()<=19)
				arr[1]+="*";
			else if(student.getGrade()<=29)
				arr[2]+="*";
			else if(student.getGrade()<=39)
				arr[3]+="*";
			else if(student.getGrade()<=49)
				arr[4]+="*";
			else if(student.getGrade()<=59)
				arr[5]+="*";
			else if(student.getGrade()<=69)
				arr[6]+="*";
			else if(student.getGrade()<=79)
				arr[7]+="*";
			else if(student.getGrade()<=89)
				arr[8]+="*";
			else if(student.getGrade()<=99)
				arr[9]+="*";
			else if(student.getGrade()==100)
				arr[10]+="*";	
		}	
		
		for(int i = 0; i < 10; i++)
			System.out.println(i+"0-"+i+"9: " + arr[i]);
		System.out.println("100:   " + arr[10]);			
	}
    public String toString() {
    	String ans = "";
    	ans += course.toString();
    	ans+="\n";
    	for(Student student: students)
    		ans+=student.toString();
    	return ans;
    	
    }
		
}
