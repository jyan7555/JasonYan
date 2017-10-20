package arrays2d;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static void changeNeighbors(int[] arr, int psn) {
		if (psn >=0 && psn<= arr.length-1)
			if (psn == 0 ) {
				arr[0] = arr[0]+1;
				arr[1] = arr[1]-1;
			}
			else if (psn==arr.length-1) {
				arr[psn] = arr[psn] +1;
				arr[psn-1] = arr[psn-1] -1;
			}
			else {
				arr[psn] = arr[psn] +1;
				arr[psn-1] = arr[psn-1]+1;
				arr[psn+1] = arr[psn+1]+1;
			}
	}

}
