class Solution {
    /*
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int sum = 0;
        
        // Use size(), not length
        // Use equals(), not == 
        
        for (int i = 0; i < items.size(); i++) {
            if (ruleKey.equals("type") && items.get(i).get(0).equals(ruleValue))
                sum++;
            if (ruleKey.equals("color") && items.get(i).get(1).equals(ruleValue))
                sum++;
            if (ruleKey.equals("name") && items.get(i).get(2).equals(ruleValue))
                sum++;
        }
        return sum;
    }
    */

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int index;
        int sum = 0;
        
        // string.startsWith()
        // Must use "", instead of ''
        
        if (ruleKey.startsWith("t"))
            index = 0;
        else if (ruleKey.startsWith("c"))
            index = 1;
        else
            index = 2;
        
        for (List<String> item: items) {
            if (item.get(index).equals(ruleValue))
                sum++;
        }
        return sum; 
    }
}