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
	private String nickname;
	
	public Person(String first, String last, Borough home) {
		firstName = first;
		lastName = last;
		this.home = home;
		this.hobby = Hobby.randomHobby();
		friends = new Person[3]; 
		this.nickname= createNickName(first);
		
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
		return "My name is " + firstName + " " + lastName + " and I live in " + home + ". Call me " +nickname;
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
	//JAVA IS PASS-BY-VALUE
	//meaning the parameters of a method are just values, not reference
	//so if you change those values, the original object is not affected.
	//In this case, 'name' will not be changed. In fact, nothing can be changed
	public static String createNickName(String name) {
		boolean firstVowel = true;
		for (int i=0; i<= name.length()-1; i++) {
			if (isVowel(name.substring(i,i+1))) {
				if (firstVowel) {
					firstVowel = false;
				}
				else {
					return name.substring(0,i);
				}
			}
		}
		return name;
	}
	public static boolean isVowel(String a) {
		a = a.toLowerCase();
		if (a.equals("a")|| a.equals("e")|| a.equals("i")|| a.equals("o")||a.equals("u")) {
			return true;
		}
		return false;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String s) {
		this.firstName = s;
		nickname = createNickName(s);
	}
}
