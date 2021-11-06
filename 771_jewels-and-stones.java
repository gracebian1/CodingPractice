class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int sum = 0;
        for (int i = 0; i < stones.length(); i++) {
            if (jewels.indexOf(stones.charAt(i)) == -1)
                continue;
            sum++;
        }
        return sum;
    }

    /*
    public int numJewelsInStones(String jewels, String stones) {
        int sum = 0;
        Set<Character> set = new HashSet<>();
        
        for (char c: jewels.toCharArray()) {
            set.add(c);
        }
        
        for (char c: stones.toCharArray()) {
            if (set.contains(c))
                sum++;
        }
        return sum;
    }
    */
}