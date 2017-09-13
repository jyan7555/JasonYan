package newIntro;

//class if a file describing a new data type
public class CodingConventions {
	//fields
	private String name;
	private String description;
	
	/*this is a special method, a "constructor"
	notice it does not 
	have a return type
	that is because the thing it returns is an instance of the class
		*therefore the name of a constructor must always
		*math the name of the class
		
	*/
	public CodingConventions(String name, int index) {
		//In Java fields are instantiated in a constructor 
		
		//There is a local variable called 'name' and a field called 'name'
		//the field persists, but the local variable is destroyed at the end of this method
		//distinguish the field by using the reserved word "this"
		this.name = name;
		description = IntroJava1.DESCRIPTIONS[index];
	}
	
	public void doStuff() {
		System.out.println(name + description);//use a space between your operations
		System.out.println("The square root of 12 is " + Math.sqrt(12));
	}
}
