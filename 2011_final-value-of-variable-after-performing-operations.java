class Solution {
    /*
    public int finalValueAfterOperations(String[] operations) {
        int n = 0;
        for (int i = 0; i < operations.length; i++) {
            if (operations[i].equals("++X") || operations[i].equals("X++"))
                n++;
            else
                n--;
        }
        return n;
    }*/
    
    // Pattern: The 2nd index of each operation is either '+' or '-'
    
    public int finalValueAfterOperations(String[] operations) {
        int n = 0;
        for (int i = 0; i < operations.length; i++) {
            if (operations[i].charAt(1) == '+')
                n++;
            else
                n--;
        }
        return n;
    }
}