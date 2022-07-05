class Solution {
 	// Time, Space: O(n), n: len(s)
    public String convert(String s, int numRows) {
        if (s == null || s.length() <= 1 || numRows == 1) return s;
        
        // List of 'StringBuilder' to store the result rows
        List<StringBuilder> rows = new ArrayList<>();
        
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {  
            // For each row, add a new StringBuilder
            rows.add(new StringBuilder());
        }
        
        int currRow = 0;
        boolean down = false;
        
        // Place each char of s to the correct rows
        for (char c: s.toCharArray()) {
            rows.get(currRow).append(c);
            
            // If current row is either the first or the last row, toggle the boolean value
            if (currRow == 0 || currRow == numRows - 1)
                down = !down;
            
            // If going down, current row +1, otherwise -1 (going up)
            currRow += down ? 1 : -1;
        }
        
        // To store the final string
        StringBuilder result = new StringBuilder();

        // To store it line by line 
        for (StringBuilder row: rows)
            result.append(row);

        return result.toString();       
    }
}