class Solution {
    /*
    // 1--ArrayList, add result
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();

        for (int num = 1; num <= n; num++) {
            boolean divisibleBy3 = (num % 3 == 0);
            boolean divisibleBy5 = (num % 5 == 0);
            
            if (divisibleBy3 && divisibleBy5) {
                list.add("FizzBuzz");             // This one goes FIRST
            }else if (divisibleBy3) {
                list.add("Fizz");
            }else if (divisibleBy5) {
                list.add("Buzz");
            }else {
                list.add(Integer.toString(num));  // Or: String.valueOf(num)
            }
        }
        return list;
    }
    */
    
    /*
    // 2--String concatenation
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        
        for (int num = 1; num <= n; num++) {
            boolean divisibleBy3 = (num % 3 == 0);
            boolean divisibleBy5 = (num % 5 == 0);
            
            String result = "";    // empty string to concatenate
            
            if (divisibleBy3) {
                result += "Fizz";
            }
            if (divisibleBy5) {
                result += "Buzz";
            }
            if (result.equals("")) {
                result += Integer.toString(num);
            }
            list.add(result);
        }
        return list;
    }
    */
    
    // 3--HashMap: for a large number of mappings, and modification to mappings
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        
        Map<Integer, String> map = new HashMap<>();
        map.put(3, "Fizz");
        map.put(5, "Buzz");
        
        for (int num = 1; num <= n; num++) {
            String result = "";
            
            for (Integer key: map.keySet()) {
                if (num % key == 0) 
                    result += map.get(key);
            }
            
            if (result.equals(""))
                result += Integer.toString(num);
            
            list.add(result);
        }
        return list;
    }
}