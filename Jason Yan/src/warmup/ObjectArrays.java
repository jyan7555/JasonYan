package warmup;

import java.util.Arrays;

public class ObjectArrays {
	
	public ObjectArrays() {
		Person[] people = new Person[12];
		populate(people);
		//people[0] = new Thing("toaster oven");
		for (Person p: people) {
			p.mingle(people);
			p.printFriends();
		}
		//Person[] group = selectGroup(people,4);
		//System.out.println(Arrays.toString(group));
	}

	public void populate(Object[] people) {
		for (int i=0; i <people.length; i++) {
			String firstName = randomNameFrom(Person.FIRST_START, Person.FIRST_MIDDLE, Person.FIRST_END);
			String lastName = randomNameFrom(Person.LAST_START, Person.LAST_MIDDLE, Person.LAST_END);
			Borough b = randomBorough();
			//BIG IDEA!!!
			//In Object[] (but not primitive arrays like int[] or double[])
			//You can have multiple data types (sub-classes of the declared type)
			if (Math.random() < .6) {
				int grade = (int)(Math.random()*5)+9;
				people[i] = new Student(firstName,lastName,b,grade);
			}else {
				people[i] =  new Person(firstName,lastName,b);
			}
		}
	}

	public Borough randomBorough() {
		return Borough.NY_BOROUGHS[(int)(Math.random()*Borough.NY_BOROUGHS.length)];
	}

	public String randomNameFrom(String[] a, String[] b, String[] c) {
		return get(a)+get(b)+get(c);
	}

	public String get(String[] a) {
		return a[(int)(Math.random()*a.length)];
	}
	public Person[] selectGroup(Person[] population, int length) {
		Person[] array = new Person[length];
		int[] numArr = new int[length];
		for (int i=0; i<=length-1;i++) {
			int randomNum = 0;
			while(!noRepeat(numArr, randomNum)) {
				randomNum = (int)(Math.random()*population.length);
			}
			numArr[i] = randomNum;
			array[i] = population[randomNum];
		}
		return array;
		
	}
	public boolean noRepeat(int[] arr, int num) {
		for (int i=0; i<= arr.length-1;i++) {
			if (arr[i] == num) {
				return false;
			}
		}
		return true;
	}
	/**
	 * return the number of differences between the two arrays
	 * A "difference" means they don't have the same element at the same position
	 * @param arr1
	 * @param arr2
	 * @return
	 */
	public double countDifferences(Person[] arr1, Person[] arr2) {
		int count = 0;
		for (int i=0; i< arr1.length; i++) {
			if (arr1[i] == arr2[i]) {
				count++;
			}
		}
		return count;
	}
	/**
	 * calls count differences on two Person arrays,
	 * each array must contain the same elements, but randomly ordered
	 * print the number of differences between the two arrays
	 * Do this 100 times, print the average
	 */
	public void testShuffling() {
		Person[] arr1 = new Person[50];
		Person[] arr2 = new Person[50];
		populate(arr1);
	
		
	}
}
