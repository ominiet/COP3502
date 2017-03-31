
public class Student {
	String name;
	int id;
	
	public void setName(String name){
		this.name= name;
	}
	public String getName(){
		return name;
	}
	public void setId(int id){
		this.id=id;
	}
	public int getId(){
		return id;
	}
	public String toString(){
		return "Student " + this.getName() + "\nStudent ID: " + this.getId();
	}
	public Student(String name, int id){
		this.setName(name);
		this.setId(id);
	}

}
