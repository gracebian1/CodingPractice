class Solution {
    // O((n/2)!) time (recursion)
    // O(n) space (n/2 depth of recursion tree)
    
    public List<String> generatePalindromes(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0)
            return result;
        
        StringBuilder sb = new StringBuilder();
        
        // Count frequency of chars
        int[] bucket = new int[128];
        for (char c: s.toCharArray()) {
            bucket[c]++;
        }
        
        // Append all odd number chars to sb
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] % 2 != 0) 
                sb.append((char) i);
        }
        // If more than 1 odd char, not possible for palindrome
        if (sb.length() > 1)
            return result;
        
        permute(result, sb, bucket, s.length());
        return result;
    }
    
    // Call backtracking recursively
    private static void permute(List<String> result, StringBuilder sb, int[] bucket, int len) {
        if (sb.length() == len) {
            result.add(sb.toString());
            return;
        }
        
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] > 1) {
                bucket[i] -= 2;
                
                // Add char to both front and end
                sb.insert(0, (char) i);
                sb.append((char) i);
                
                permute(result, sb, bucket, len);
                
                sb.deleteCharAt(0);
                sb.deleteCharAt(sb.length() - 1);
                bucket[i] += 2;
            }
        }
    }
}