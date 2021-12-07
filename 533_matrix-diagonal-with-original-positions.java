import java.util.*;

public class MatrixDiagonal {
	// class Position to create a type of Position
	static class Position {
    	String string;
    	Integer position;
    	
    	public Position(String string, Integer position) {
    		this.string = string;
    		this.position = position;
    	}
    }
	
	// Complete the length
	static void completion(StringBuilder sb, int length) {
		int currIndex = 0;
        while (sb.length() < length) {
        	sb.append(sb.charAt(currIndex));
        	currIndex++;
        }
	}
	
	// Traverse the matrix diagonally (two parts)
	static void diagonalTraverse(String[][] matrix, List<String> diagonalList) {
		int row = 0, col = 0;
        
		// Lower left part
		// Starting from last row is the lower left part
        for (int i = matrix.length - 1; i >= 0; i--) {
        	row = i;
        	col = 0;
        	StringBuilder sb = new StringBuilder();
        	
            while (row < matrix.length && col < matrix[0].length) {
            	sb.append(matrix[row][col]);
            	row++;
            	col++;
            }
            completion(sb, matrix.length);
            diagonalList.add(sb.toString());
        }
        
        // Upper right part
        // Starting from column 1, row 0 is the upper right part
        for (int j = 1; j < matrix[0].length; j++) {
        	row = 0;
        	col = j;
        	StringBuilder sb = new StringBuilder();
        	
            while (row < matrix.length && col < matrix[0].length) {
            	sb.append(matrix[row][col]);
            	row++;
            	col++;
            }
            completion(sb, matrix[0].length);
            diagonalList.add(sb.toString());
        }
	}
	
    public static void main(String[] args) {
        String[][] matrix = {{"a","b","c"},{"d","e","f"},{"g","h","i"}};
    	
        // Output diagonal list (completed with same length)
        List<String> diagonalList = new ArrayList<>();
        diagonalTraverse(matrix, diagonalList);
        System.out.println(diagonalList.toString());
        
        // Position list keeps original positions
        List<Position> positions = new ArrayList<>();
        
        for (int i = 0; i < diagonalList.size(); i++) {
        	// Create an object of type Position
        	Position p = new Position(diagonalList.get(i), i);
        	positions.add(p);
        }
        
        // Sort the position list, using new comparator
        Collections.sort(positions, new Comparator<Position>() {
            public int compare(Position p1, Position p2) {
				return p1.string.compareTo(p2.string);
        }});
        
        // Result list for final result
        List<Integer> result = new ArrayList<>();
        
        for (Position p : positions) {
        	result.add(p.position + 1);
        } 
        System.out.println(result.toString());
    }
}