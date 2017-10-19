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
	private Hobby hobby;
	private Person[] friends;
	
	public Person(String first, String last, Borough home) {
		firstName = first;
		lastName = last;
		this.home = home;
		this.hobby = Hobby.randomHobby();
		friends = new Person[3]; 
		
	}
	/** Chooses friends from People based on who is of the same class
	 * as this instance and who has the same hobbies
	 * @param people
	 */
	public void mingle(Person[] people) {
		for (Person p: people) {
			if (p != this) {
				//reassign p to the better of the two friends you current
				//best friend or p
				p = betterFriend(p, friends[0]);
				addFriendToFirstPlace(p);
			}
		}
	}
	public void printFriends() {
		System.out.println("My name is "+ firstName + " " + lastName + " and these are my friends:");
		for (Person f: friends) {
			if (f != null) {
				System.out.print(f);
			}
		}
	}
	/**
	 * Move all Person in friends back one index and puts p at index 0
	 * @param p
	 */
	public void addFriendToFirstPlace(Person p) {
		for (int i=friends.length-1; i> 0;i--) {
			friends[i]= friends[i-1];
		}
		friends[0] = p;
	}
	public String toString() {
		return "My name is " + firstName + " " + lastName + " and I live in " + home + ".";
	}
	public Person betterFriend(Person p, Person q) {
		if (p == null) {
			return q;
		}
		if (q == null) {
			return p;
		}
		if (p.getClass() == this.getClass()) {
			return q;
		}
		return p;
		
	}
}
