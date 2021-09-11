package task4;

public class Course {
	private String name;
	private String desc; // description
	private int cr; // credits
	private Course prereq; // prerequisite
	
	public Course(){
	    	
    }
	public Course(String name) {
        this.name = name;
    }
	public Course(String name, String desc) {
        this(name);
        this.desc = desc;
    }
	public Course(String name, String desc,int cr) {
        this(name,desc);
        this.cr = cr;
    }
	public Course(String name, String desc,int cr,Course prereq) {
        this(name,desc,cr);
        this.prereq = prereq;
    }
	
	public String getName() {
    	return name;
    }
    public String getDesc() {
    	return desc;
    }
    public int getCr() {
        return cr;
    }
    public String getPrereq() {
    	return prereq.getName();
    }
    
    public String toString() {
    	if (prereq == null)
    		return "Subject: " + name 
    				+ "\nDescription: " +desc
    				+ "\nCredits: " + cr
    				+ "\nPrerequisites: " + "No prerequisites, be happy." + "\n";
		return "Subject: " + name 
			+ "\nDescription: " +desc
			+ "\nCredits: " + cr
			+ "\nPrerequisites:\n" + prereq.toString();
	}
	
}
