package arrays;

import java.util.Arrays;

public class ArraysMain {
	private String[] testArray;
	private int[] intRay;
	
	public ArraysMain() {
		intRay = new int[100];
		//populate(intRay);
		//checkOccurences(intRay,2,12);
		populate1ToN(intRay);
		swap(intRay, 0, 1);
		shuffle(intRay);
		//Arrays is a Utility class included in Java
		System.out.println(Arrays.toString(intRay));
	}

	private void shuffle(int[] arr) {
		for (int i=0; i<arr.length-1; i++) {
			swap(arr,(int)(Math.random()*arr.length),(int)(Math.random()*arr.length));
		}
	}

	private void swap(int[] arr, int i, int j) {
		int num1 = arr[i];
	    arr[i] = arr[j];
		arr[j] = num1;
	}
	private void populate1ToN(int[] arr) {
		for (int i=0; i<= arr.length-1; i++) {
			arr[i] = i +1;
		}
	}
	private void checkOccurences(int[] arr, int start, int end) {
		int[] counter = new int[end-start+1];
		for (int value: arr) {
			counter[value-start]++;
		}
		for (int i=0; i <counter.length; i++) {
			System.out.println("A "+(start+i)+" was rolled "+counter[i]+" times.");
		}
		
	}
	private void populate(int[] intRay) {
		for (int i=0; i<= intRay.length-1; i++) {
			intRay[i] = diceRoll(2);
		}
	}
	public void notes() {
		//1.collection of primitives or objects
		//2.SPECIAL NOTE: This is the ONLY collection of primitives 
		/*3. Elements of an array are REFERENCES to objects. 
		 * In other words, changing an element of an array changes
		 * the REFERENCE, not the object
		 */
		
		//There are two types of constructors
		int[] firstType = {3,14,-9,10};
		//This constructor can only be used at the declaration
		
		//The 2nd type
		testArray = new String[50];
		/*SPECIAL NOTE: for primitive arrays, when are instantiated
		 * they are automatically populated with 0s. This is not the case with
		   Object arrays, which are populated with 'null'
		 */
		
		for (int i=0; i<testArray.length; i++) {
			System.out.println(testArray[i]);
		}
	
	
	//for each loop (useful only when you don't need to keep tarck of the index
	for (String value:testArray) {
		//"for each int in testArray..."
		System.out.println(value);
	}
	}
	public static void main(String[] args) {
		ArraysMain arrayPractice = new ArraysMain();
	}
	public int diceRoll(int numberOfDice) {
		int roll=0;
		for(int i=0; i< numberOfDice; i++) {
			roll = roll + 1 + (int)(Math.random()*6);
		}
		return roll;
	}
}
