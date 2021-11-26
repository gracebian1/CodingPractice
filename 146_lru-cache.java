/*
O(1) time required, --> hash map + doubly linked list.

Head of doubly linked list: MOST recently used
Tail of doubly linked list: LEAST recently used
*/

class LRUCache {
    // Instance Variables
    private int capacity;
    private int size;
    private Map<Integer, Node> map;
    private Node head;
    private Node tail;
    
    // Constructor
    public LRUCache(int capacity) {
        map = new HashMap<Integer, Node>();
        this.capacity = capacity;
        size = 0;
    }
    
    // GET
    public int get(int key) {
        if (map.containsKey(key)) {
            Node temp = map.get(key);  
            // Adjust node position based on recent activity
            removeNode(temp);
            insertHead(temp);
    
            return temp.val;      
        } else {
            return -1;
        }  
    }
    
    // PUT
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node temp = map.get(key);
            // Update node value
            temp.val = value;
            map.put(key, temp);
            // Adjust node position
            removeNode(temp);
            insertHead(temp);
        } else {
            // map doesnot contain key
            // Build a new node
            Node temp = new Node(key, value);
            
            if (size == capacity) {
                // Remove LRU cache in both map and linked list
                map.remove(tail.key);
                removeTail();
                // Update in both map and linked list
                map.put(key, temp);
                insertHead(temp);
            } else {
                map.put(key, temp);
                insertHead(temp);
                // Update list size
                size++;
            }
        }
    }
    
    // insertHead
    private void insertHead(Node node) {
        if (head == null) {
            head = node;
            tail = head;
            head.prev = null;
            tail.next = null;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
            head.prev = null;
        }
    }
    
    // removeNode
    private void removeNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        
        // The node to be removed is the head
        if (prevNode == null) {
            head = head.next;
            
            if (head == null)  tail = head;
            else head.prev = null;
        
        // The node to be removed is the tail
        } else if (nextNode == null) {
            tail = tail.prev;
            
            if (tail == null) head = tail;
            else tail.next = null;
        
        // The node to be removed is in the middle of list
        } else {
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }
    }
    
    // removeTail
    private void removeTail() {
        tail = tail.prev;
        if (tail == null) head = tail;
        else tail.next = null;
    }

    // Linked list node class
    private class Node {
        int key;
        int val;
        Node prev;
        Node next;
        
        // Constructor 
        Node (int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */