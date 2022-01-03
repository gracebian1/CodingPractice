class Trie {
    TrieNode head;
  
    public Trie() {
        head = new TrieNode();
    }
    
    class TrieNode {
        // Each node has its own map
        // Map key: char on edge
        
        Map<Character, TrieNode> map;
        boolean isEnd = false;
        
        public TrieNode() {
            map = new HashMap<>();
        }
    }
    
    public void insert(String word) {
        if (word == null)
            return;
        
        TrieNode curr = head;
        
        for (char c: word.toCharArray()) {
            if (!curr.map.containsKey(c)) {
                curr.map.put(c, new TrieNode());
            }
            curr = curr.map.get(c);
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        if (word == null)
            return false;
        
        TrieNode curr = head;
        
        for (char c: word.toCharArray()) {
            if (!curr.map.containsKey(c)) {
                return false;
            }
            curr = curr.map.get(c);
        }
        return curr.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        if (prefix == null)
            return false;
        
        TrieNode curr = head;
        
        for (char c: prefix.toCharArray()) {
            if (!curr.map.containsKey(c)) {
                return false;
            }
            curr = curr.map.get(c);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */