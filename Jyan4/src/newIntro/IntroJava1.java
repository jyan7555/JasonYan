package newIntro;

public class IntroJava1 {
	
	//constants (public)
	public static final String[] DESCRIPTIONS = {" is a teacher", " is a student", "is a human being", " is imaginary"};

	public static void main(String[] args) {
		/*
		 * declaration of a local variables 
		 * notice the use of the word 'new'
		 * new must be used to call a constructor 
		 */
		CodingConventions conventionsInstance = new CodingConventions("Mr. Nockles", 2);
		
		//instance method call
		conventionsInstance.doStuff();
	}

}
