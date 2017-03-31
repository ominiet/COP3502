
public class UndergraduateStudent extends Student{
	String major;
	int multiplier = 3;
	public void setMajor(String major){
		this.major=major;
	}
	public String getMajor(){
		return major;
	}
	public String toString(){
		return "UnderGraduate " + super.toString() + "\nMajor: "+ major;
	}
	public int getMult(){
		return multiplier;
	}
	public UndergraduateStudent(String n, int id, String major){
		super(n,id);
		this.setMajor(major);
	}

}
