package arrays;

import java.util.Arrays;

public class ArraysMain {
	private String[] testArray;
	private int[] intRay;
	
	public ArraysMain() {
		intRay = new int[10];
		int[] randomRolls = new int[1000];
		populate(randomRolls);
		int[] result = longestConsecSeqAndPos(randomRolls);
		int[] test3= {2,3,4,5,6,7,8,9,10,11,12};
		//int[] test1 = {1,2,3,6,7,8,9,10,11,45,46,47};
		int[] test2 = {10,11,12,13,14,15,6,7,8,9,10,11,45,46,47};
		//int[] newRay = reverseOrder(intRay);
		//populate(intRay);
		//checkOccurences(intRay,2,12);
		//populate1ToN(intRay);
		//reverseOrder(intRay);
		//swap(intRay, 0, 1);
		//shuffle(intRay);
		//Arrays is a Utility class included in Java
		System.out.println(longestConsecutiveSequence(test2));
		System.out.println("The longest sequence of dice rolls is " + result[0]+
				" it happened on the " + (result[1]+1) + "the roll. Starting with a roll of " + randomRolls[result[1]]+".");
	}
	public int[] longestConsecSeqAndPos(int[] arr) {
		int count = 1;
		int count2 = 1;
		int pos = 0;
		boolean newSeq = true;
		int[] data = new int[2];
		for (int i=0; i <= arr.length-2;i++) {
			 if (arr[i] == arr[i+1]-1 ) {
				count2++;
				if (newSeq){
					pos = i;
					newSeq = false;
				}
			}
			else {
				if (count2 > count) {
					count = count2;
					count2 = 1;
					newSeq= true;
				}
			}
		}
		data[0] = count;
		data[1] = pos;
		return data;
	}
	public int[] reverseOrder(int[] arr) {
		int[] newArr = new int[arr.length];
		for (int i=0; i <= arr.length-1;i++) {
			newArr[i] = arr[arr.length-1-i];
		}
		return newArr;
	}
	public void reverseOrderOriginal(int[] arr) {
		int[] newArr = new int[arr.length];
		for (int i=0; i< arr.length; i++) {
		    swap(arr, i, arr.length-1-i);
		}
	}
	public int longestConsecutiveSequence(int[] arr) {
		int count = 1;
		int count2 = 1;
	
		for (int i=0; i <= arr.length-2;i++) {
			 if (arr[i] == arr[i+1]-1 ) {
				count2++;
			}
			else {
				if (count2 > count) {
					count = count2;
					count2 = 1;
				}
			}
		}
		return count;
	}
	public int countLessThan(int[] arr, int n) {
		int count = 0;
		for (int value: arr) {
			if (value < n) {
					count++;
			}
		}
		return count;
	}
	public void frontToBack(int[] arr) {
		int num = arr[0];
		for (int i=0; i <=arr.length-2; i++) {
			arr[i] = arr[i+1];
		}
		arr[arr.length-1] = num;
	}
	public void cycleThrough(int[] arr, int n) {
		for (int i=0; i <n; i++) {
			frontToBack(arr);
		}
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
