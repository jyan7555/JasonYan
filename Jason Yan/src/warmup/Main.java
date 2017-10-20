package warmup;

import java.util.Arrays;

public class Main{

	public static void main(String[] args) {
		//ObjectArrays oA = new ObjectArrays();
		Person s= new Person("Ben","Nockles", Borough.NY_BOROUGHS[0]);
		//String s = "Hello";
		int x= 10;
		int[] a = {5,6,7};
		test2(s,x,a);
		System.out.println(s+", "+x+", "+ Arrays.toString(a));
	}
	

		
/**
 * PASS-BY-VALUE EXAMPLES
 * THIS CHANGES NAME
*/
	public static void test1(Person s, int x, int[] arr) {
		String name = s.getFirstName();
		name = "Ilona";
		x = 5;
		arr = new int[3];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
	}
	public static void test2(Person s, int x, int[] arr) {
		s.setFirstName("Ilona");
		x = 5;
		arr = new int[3];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
	}
	public static void test3(Person s, int x, int[] arr) {
		s.setFirstName("Ilona");
		x = 5;
		//arr = new int[3]; AS LONG AS DONT MAKE A NEW ARRAY
		//THE REFERENCES THEMSELVES WILL CHANGE
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
	}
}
