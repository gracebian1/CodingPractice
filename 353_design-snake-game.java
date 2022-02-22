class SnakeGame {
    // Time: O(1); Space: O(w*h + n): w*h: width*height, n: food data structure
    class Node {
        int r;
        int c;
        
        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    Set<Integer> set; 
    Deque<Integer> deque; 
    int score;
    
    int[][] food;
    int foodIndex;
    
    int width;
    int height;
    
    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        
        set = new HashSet<>();
        set.add(0); 
        
        deque = new LinkedList<>();
        deque.offerLast(0);
    }
    
    public int move(String direction) {
        // Case 0: game over
        if (score == -1) {
            return -1;
        }
        
        // 2D format for newHead
        Node newHead = new Node(0, 0);
        
        // Get 2D head position from 1D element in deque 
        // posValue = row * width + col
        newHead.r = deque.peekFirst() / width;
        newHead.c = deque.peekFirst() % width;
        
         switch (direction) {
            case "U":
                newHead.r--;
                break;
            case "D":
                newHead.r++;
                break;
            case "L":
                newHead.c--;
                break;
            case "R":
                newHead.c++;
                break;
        }
        // Get 1D head position 
        int head = newHead.r * width + newHead.c;
        
        // After move, set remove tail
        set.remove(deque.peekLast());
        
        // 3 Cases:
        // Case 1: out of border or eat body
        if (newHead.r < 0 || newHead.r == height || newHead.c < 0 || newHead.c == width || set.contains(head)) {
            return score = -1;
        }
        
        // Add head for case 2 and case 3
        set.add(head); 
        deque.offerFirst(head);
        
        // Case 2: eat food, keep tail
        if (foodIndex < food.length && newHead.r == food[foodIndex][0] && newHead.c == food[foodIndex][1]) {
            set.add(deque.peekLast());   // Old tail not change, so add it back to set
            foodIndex++;
            score++;
            return score;
        }
        
        // Case 3: no food move, deque remove tail
        deque.pollLast();
        return score;   
    }
}
/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */