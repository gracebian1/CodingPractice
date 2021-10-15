class Solution {
    public List<String> topKFrequent(String[] words, int k) {
  
        Map<String, Integer> map = new HashMap<>();
        for (String word: words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        // Attention: ASCII, a:97, z:122
        // Larger number should go after smaller number for lexicographical order
        // s.compareTo(t) to compare two strings
        // Make max heap
        
        PriorityQueue<Map.Entry<String, Integer>> heap = new PriorityQueue<>
            ((a, b) -> a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());
        
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            heap.offer(entry);
        }
        
        List<String> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(heap.poll().getKey());
        }
        return list;
    }
}