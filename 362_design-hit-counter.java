class HitCounter {
    // For follow-up: several hits happen at the same timestamp:
    /* Time: O(1): For the ith timestamp with k REPETITIONS, time is O(1). Instead of removing all k                repetitions, we only remove a single entry from the deque.
    
       Space: O(n) or O(1): total n elements. For k repetitions, O(1) for storing those k.
    */
    
    private int hitCount;
    // Pair key: timestamp; Pair value: hitCount at this timestamp
    private Deque<Pair<Integer, Integer>> deque;
    
    public HitCounter() {
        this.hitCount = 0;
        this.deque = new LinkedList<>();
    }
    
    public void hit(int timestamp) {
        if (this.deque.isEmpty() || this.deque.getLast().getKey() != timestamp) {
            this.deque.add(new Pair<Integer, Integer>(timestamp, 1));
        } else {
            int prevCount = this.deque.getLast().getValue();
            this.deque.removeLast();
            this.deque.add(new Pair<Integer, Integer>(timestamp, prevCount + 1));
        }
        this.hitCount++;
    }
    
    public int getHits(int timestamp) {
        while (!this.deque.isEmpty()) {
            int gap = timestamp - this.deque.getFirst().getKey();
            if (gap >= 300) {
                this.hitCount -= this.deque.getFirst().getValue();
                this.deque.removeFirst();
            } else
                break;
        }
        return this.hitCount;
    }
}

/*
public final class Pair<K, V> {
    public final K k;
    public final V v;
    
    public Pair(K k, V v) {
        this.k = k;
        this.v = v;
    }
    
    public K getKey() {
        return k;
    }
    
    public V getValue() {
        return v;
    }
}
*/
/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */