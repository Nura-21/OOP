
public class Student {
	    private String name;
	    private String  id;
	    public int year = 1;
	    private int age;
	    Student(){}
	    String getName() {
	    	return name;
	    }
	    String getId() {
	        return id;
	    }
	    void setName(String name) {
	    	this.name = name;
	    }
	    void nextCourse() {
	        year++;
	    }
	    Student(String name, String id) {
	        this.name = name;
	        this.id = id;
	    }
	    Student(String name, String id,int age) {
	        this(name,id);
	        this.setAge(age);
	    }
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
	    
	  }

