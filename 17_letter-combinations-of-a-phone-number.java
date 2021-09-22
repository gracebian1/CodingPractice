class Solution {
    public List<String> letterCombinations(String digits) {      
        List<String> result = new ArrayList<>();
        
        if (digits.length() == 0)    return result;
        String[] letterMap =                      {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        result.add("");
        
        for (int i = 0; i < digits.length(); i++){
            List<String> temp = new ArrayList<>();
            //int curr = Character.getNumericValue(digits[i]);
            int curr = digits.charAt(i) - '0';
            String chars = letterMap[curr];
            for (int x = 0; x < chars.length(); x++){
                for(int j = 0; j < result.size(); j++){
                    temp.add(result.get(j) + chars.charAt(x));
                }
            }
            result = temp;
        }
        return result;
    }
}