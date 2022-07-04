/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    // Time: O(n): calls to knows API(O(n)) + check if celebrity(O(n))
    // Space: O(1)
    
    private int numOfPeople;
    
    public int findCelebrity(int n) {
        numOfPeople = n;
        int candidate = 0;
        
        for (int i = 0; i < n; i++) {
            // call knows API first, to avoid O(n^2) time
            if (knows(candidate, i)) {
                candidate = i;
            }
        }
        if (isCelebrity(candidate))
            return candidate;
        return -1; 
    }
    
    public boolean isCelebrity(int candidate) {
        for (int i = 0; i < numOfPeople; i++) {
            if (candidate == i)
                continue;
            if (knows(candidate, i) || !knows(i, candidate))
                return false;
        }
        return true;
    }
}