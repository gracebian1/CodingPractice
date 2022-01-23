class Solution {
    /*
    // Iterative:
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) return result;
        
        // Mapping of digit to chars  
        final String[] MAPS = {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        
        // Initialize the result list
        result.add("");
        
        for (int i = 0; i < digits.length(); i++) {
            // Each digit has a new temp list
            List<String> temp = new ArrayList<>();
            
            // int currDigit = Character.getNumericValue(digits[i]);
            int currDigit = digits.charAt(i) - '0'; 
            
            // Get the corresponding string of chars for the current digit
            String chars = MAPS[currDigit];
            
            // Iterate through the string of chars
            for (int charIndex = 0; charIndex < chars.length(); charIndex++) {
                // Iterate through the result list
                for (int resultIndex = 0; resultIndex < result.size(); resultIndex++) {
                    // Add new char to temp list (based on size of result list)
                    temp.add(result.get(resultIndex) + chars.charAt(charIndex));
                }
            }
            // Update result list after each digit
            result = temp;
        }
        return result;  
    }
    */
    
    // Recursive: backtracking
    // Time: O(4^N * N): N: len of digits; 4: max value len in hash map (NOT len of input)
    // Space: O(N)
    
    static final String[] MAPS = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) return result;
        
        StringBuilder sb = new StringBuilder();
        backtrack(sb, 0, digits, result);

        return result;
    }

    private static void backtrack(StringBuilder sb, int index, String digits, List<String> result) {
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }
        // Get the string of chars for the corresponding digit
        String chars = MAPS[digits.charAt(index) - '0'];
        
        for (char c : chars.toCharArray()) {
            sb.append(c);
            
            // Call it recursively
            backtrack(sb, index + 1, digits, result);
            // delete the last char 
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}