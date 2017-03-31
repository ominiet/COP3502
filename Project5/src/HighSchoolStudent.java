
public class HighSchoolStudent extends Student{
	String schoolname;
	int multiplier = 1;
	public void setNameOfSchool(String schoolname){
		this.schoolname=schoolname;
	}
	public String getNameofSchool(){
		return schoolname;
	}
	public String toString(){
		return "High School " + super.toString() + "\nName of School: "+ schoolname;
	}
	public int getMult(){
		return multiplier;
	}
	public HighSchoolStudent(String n, int id, String schoolName){
		super(n,id);
		this.setNameOfSchool(schoolName);
	}

}
