public class w5{
	public static void main(String[] args) {
        String[] names = new String[]{
            "A","B","C","D","E","F","G","H","I","J"
        };
        Student[] students_1 = new Student[names.length];
        Student[] students_2 = new Student[names.length];
        for(int i=0; i<names.length; i++){
            students_1[i] = new Student(names[i],i + 1);
            students_2[i] = new Student(names[i],i + 1);
        }
	}
}

/*
TASK-1: Create two groups of students (2 arrays), and initialize them;
TASK-2: Create a static method that compares two student arrays, 
		and returns how many students from 2 have the same name;
TASK-3: Modify the Student to make it an immutable class;
TASK-4: Create the Classes Course and Faculty, 
		and demonstrate their relationships to the Student class like in the lecture slides.
*/