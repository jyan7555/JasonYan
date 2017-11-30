package search;

public class LionPuzzle {
	public static void main(String[] args) {
		int lions = 100;
		System.out.println(lions + " lions decide to eat the sheep? " + eatSheepOrNot(lions));
	}
	
	public static boolean eatSheepOrNot(int lions) {
		if (lions == 1) {
			return true;
		}
		else {
			return !eatSheepOrNot(lions-1);
		}
	}
}
