public class Solution {
    // need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            int lastBit = n & 1;
            count += lastBit;
            // Unsigned shift
            n >>>= 1;
        }
        return count;
    }
}