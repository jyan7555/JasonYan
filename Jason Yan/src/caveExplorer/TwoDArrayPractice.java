package caveExplorer;

public class TwoDArrayPractice {
	public static void main(String[] args) {
		String[][] pic = new String[6][10];
		for (int row=0; row < pic.length; row++) {
			for (int col=0; col <pic[row].length;col++) {
				pic[row][col] = " ";
			}
		}
		drawHorizontalLine(pic,1);
		drawHorizontalLine(pic,3);
		drawHorizontalLine(pic,5);
		drawVerticalLine(pic,2);
		drawBox(pic,3,4);
		print(pic);
	}
	    
/*	___
	|*|
	|_| */
	private static void drawBox(String[][] pic, int i, int j) {
		drawSlot(pic,i,j);
		drawSlot(pic, i+1,j);
		drawIfInBounds("_",pic,i,j);
		for (int col= j-1; col <= j+1; col++) {
			drawIfInBounds("_", pic,i-1,col);
		}
	}

	private static void drawIfInBounds(String string, String[][] pic, int i, int j) {
		if (i>= 0 && i <pic.length&& j>= 0 && j <pic[i].length) {
			pic[i][j] = string;
		}
}

	private static void drawSlot(String[][] pic, int i, int j) {
		if (i >0 && i < pic.length-1) {
			if (j >0) {
				pic[i][j-1] = "|";
			}
			if (j<pic[i].length) {
				pic[i][j+1] = "|";
			}
		} 
	}

	private static void drawVerticalLine(String[][] pic, int col) {
		for (int row =0; row < pic.length; row++) {
			pic[row][col] = "|";
		}
	}

	private static void drawHorizontalLine(String[][] pic, int row) {
		for (int col =0; col < pic[row].length; col++) {
			pic[row][col] = "-";
		}
	}

	private static void print(String[][] pic) {
		String output = "";
		for (int row=0; row < pic.length; row++) {
			for (int col=0; col <pic[row].length;col++) {
				output += pic[row][col];
			}
			output += "\n";
		}
		System.out.println(output);
	}
}
