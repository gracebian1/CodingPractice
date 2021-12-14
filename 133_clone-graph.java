/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    // Map key: original graph;  Map value: cloned graph
    private HashMap<Node, Node> visitedMap = new HashMap<>();
    
    public Node cloneGraph(Node node) {
        if (node == null) return node;
        
        // Check visited first, to avoid cycle
        if (visitedMap.containsKey(node))
            return visitedMap.get(node);
        
        // Make new node, (list for neighbors)
        Node cloneNode = new Node(node.val, new ArrayList<>());
        visitedMap.put(node, cloneNode);
        
        for (Node neighbor: node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
        return cloneNode;
    }
}