
public class GraduateStudent extends Student{
	String major;
	String advisor;
	int multiplier = 5;
	public void setAdvisor(String advisor){
		this.advisor = advisor;
	}
	public String getAdvisor(){
		return advisor;
	}
	public void setMajor(String major){
		this.major=major;
	}
	public String getMajor(){
		return major;
	}
	public String toString(){
		return "Graduate " + super.toString() + "\nMajor: "+ major
					+ "\nAdvisor: " + advisor;
	}
	public int getMult(){
		return multiplier;
	}
	public GraduateStudent(String n, int id, String major, String advisor){
		super(n,id);
		this.setMajor(major);
		this.setAdvisor(advisor);
	}

}
