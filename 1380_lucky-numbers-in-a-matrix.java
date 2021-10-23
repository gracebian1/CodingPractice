class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        // Distinct numbers
        // Use two sets, min set and max set, get the intersection of the two
        
        List<Integer> list = new ArrayList<>();
        Set<Integer> minSet = new HashSet<>();
        Set<Integer> maxSet = new HashSet<>();
        
        // Get the first of each row to be the min, then find out the real min of each row
        for (int[] row: matrix) {
            int min = row[0];
            for (int n: row) {
                min = Math.min(min, n);
            }
            minSet.add(min);
        }
        
        // Get the first of each col to be the max, then find out the real max of each col
        for (int col = 0; col < matrix[0].length; col++) {
            int max = matrix[0][col];
            for (int row = 0; row < matrix.length; row++) {
                max = Math.max(max, matrix[row][col]);
            }
            maxSet.add(max);
            
            // Check for intersection of two sets
            if(minSet.contains(max))
                list.add(max);
        }
        return list;
    }
}