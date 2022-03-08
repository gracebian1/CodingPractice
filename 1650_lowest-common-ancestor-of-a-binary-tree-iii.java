/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/
class Solution {
    /*
    public Node lowestCommonAncestor(Node p, Node q) {
        Set<Node> set = findPath(p);
        
        // Traverse the path: q --> root, the 1st common point is LCA
        while (!set.contains(q)) {
            q = q.parent;
        }
        return q;
    }
    
    // Store the path: p --> root
    private Set<Node> findPath(Node p) {
        Set<Node> set = new HashSet<>();
        
        while (p != null) {
            set.add(p);
            p = p.parent;
        }
        return set;
    }
    */
    
    // A LinkedList question:
    public Node lowestCommonAncestor(Node p, Node q) {
        Node p1 = p, p2 = q;
        while (p1 != p2) {
            p1 = p1 == null ? q : p1.parent;
            p2 = p2 == null ? p : p2.parent;
        }
        return p1;
    }
}