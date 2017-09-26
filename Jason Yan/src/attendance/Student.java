package attendance;

public class Student implements Attendee{
	private String firstName;
	private String lastName;
	private boolean present;
	public Student(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public boolean isPresent() {
		return present;
	}
	public void setPresent() {
		present = true;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastname() {
		return lastName;
	}
}
