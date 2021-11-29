class Solution {
    public int hammingDistance(int x, int y) {
        int count = 0;
        
        while (x != 0 || y != 0) {
            int xLastBit = x & 1;
            int yLastBit = y & 1;
            
            count += xLastBit ^ yLastBit;
            
            x >>>= 1; 
            y >>>= 1;
        }
        return count;
    }
}