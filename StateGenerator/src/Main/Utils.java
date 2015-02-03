package Main;

public class Utils {

	public static int[][] copyMatrix(int [][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		int[][] copy = new int[rows][cols];
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++) 
				copy[i][j] = matrix[i][j];
		
		return copy;
	}
}
