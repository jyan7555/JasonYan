package attendance;

public class Student implements Attendee{
	private String firstName;
	private String lastName;
	private boolean present;
	public Student(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
		present = false;
	}
	public boolean isPresent() {
		return present;
	}
	public void setPresent(boolean present) {
		this.present = true;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public boolean mathces(String first, String last) {
		return first.toLowerCase().equals(last.toLowerCase());
	}
	public boolean matches(String first) {
		return firstName.toLowerCase().equals(first.toLowerCase());
	}
	public String getReportString() {
		String output = "";
		if (lastName.length() > 20) {
			output += lastName.substring(0, 17) + "...";
		}
		else {
			output += lastName;
		}
		while (output.length() < 20) {
			output += " ";
		}
		if (firstName.length() > 20) {
			output += firstName.substring(0, 17) + "...";
		}
		else {
			output += firstName;
		}
		while (output.length() < 40) {
			output += " ";
		}
		if (present) {
			output += "Present";
		}
		else {
			output += "Absent";
		}
		return output;
		
	}
}
