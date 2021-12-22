class WordDistance {
    
    // Map key: word; Map value: list of indices for the same word
    private Map<String, List<Integer>> map;

    public WordDistance(String[] wordsDict) {
        this.map = new HashMap<String, List<Integer>>();
        
        for (int index = 0; index < wordsDict.length; index++) {
            String word = wordsDict[index]; 
            
            if (map.containsKey(word)) {
                map.get(word).add(index);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(index);
                map.put(word, list);
            }
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        
        int min = Integer.MAX_VALUE;
        int i = 0, j = 0;
        
        while (i < list1.size() && j < list2.size()) {
            int index1 = list1.get(i);
            int index2 = list2.get(j);
            
            min = Math.min(min, Math.abs(index1 - index2));
            
            // Both lists are sorted 
            if (index1 < index2)
                i++;
            else 
                j++;
        } 
        return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */