class WordDistance {
     /* Time: O(n): total number of words; Space:O(n)
        Time: O(max(n1, n2)): n1, n2: # of occurrences of two words. n1 = n2 = O(n).
        Why max: when the minimum element of the shorter list is larger than all elements of the longer list. 
        The pointer for the short list will not progress at all, and the pointer for the longer list will 
        reach to the very end.
     */

    // Map key: String word; Map value: list of indices
    Map<String, List<Integer>> map;

    public WordDistance(String[] wordsDict) {
        this.map = new HashMap<>();
        
        for (int i = 0; i < wordsDict.length; i++) {
            if (!this.map.containsKey(wordsDict[i])) {
                this.map.put(wordsDict[i], new ArrayList<>());
            }
            List<Integer> temp = this.map.get(wordsDict[i]);
            temp.add(i);
            this.map.put(wordsDict[i], temp);
        }  
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> list1 = this.map.get(word1);
        List<Integer> list2 = this.map.get(word2);
        
        if (list1.size() == 1 && list2.size() == 1)
            return Math.abs(list1.get(0) - list2.get(0));
        
        int l1 = 0, l2 = 0, min = Integer.MAX_VALUE;
        
        while (l1 < list1.size() && l2 < list2.size()) {
            min = Math.min(min, Math.abs(list1.get(l1) - list2.get(l2)));
            
            if (list1.get(l1) < list2.get(l2)) {
                l1++;
            } else {
                l2++;
            }
        }
        return min;
    }
}
/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */