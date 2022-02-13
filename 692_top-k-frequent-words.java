class Solution {
    // Time: O(nlogk); Space: O(n)
    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
        if (words == null || words.length == 0)
            return result;
        
        Map<String, Integer> map = new HashMap<>();
        
        for (String word: words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        // MIN heap, with REVERSED lexicographical order
        PriorityQueue<Map.Entry<String, Integer>> heap = new PriorityQueue<>(
            (a, b) -> a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : (a.getValue() - b.getValue()));
        
        // MIN heap, contains k elements, thus logk time
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            heap.offer(entry);
            if(heap.size() > k)
                heap.poll();
        }
        
        while (!heap.isEmpty()) {
            result.add(heap.poll().getKey());
        }
        
        Collections.reverse(result);
        return result;
    }
}