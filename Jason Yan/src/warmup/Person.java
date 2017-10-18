package warmup;
	
public class Person {
	
	public static final String[] FIRST_START = {"Chr","M","L","Gr","Ph","B","Th"};
	public static final String[] FIRST_MIDDLE = {"isi","icha","era","eta","ala","ina","ara"};
	public static final String[] FIRST_END = {"","na","n","r","tian","s","rs","mp","les"};
	
	public static final String[] LAST_START = {"Tr","Br","L","Gr","Sh","B","Th"};
	public static final String[] LAST_MIDDLE = {"om","o","an","ola","et"};
	public static final String[] LAST_END = {"n","ng","eng","ou"};
			
	private String firstName;
	private String lastName;
	private Borough home;
	
	public Person(String first, String last, Borough home) {
		firstName = first;
		lastName = last;
		this.home = home;
	}
	public String toString() {
		return "My name is " + firstName + " " + lastName + " and I live in " + home + ".";
	}
}
