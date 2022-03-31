class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // Sort array according to index 1 in descending order
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        
        int result = 0;
        
        for (int i = 0; i < boxTypes.length; i++) {
            
            // If numberOfBoxes does not exceed the truckSize:
            if (boxTypes[i][0] <= truckSize) {
                result += boxTypes[i][0] * boxTypes[i][1];
                
                // Update the remaining truckSize
                truckSize -= boxTypes[i][0];
                
            // If numberOfBoxes exceeds the truckSize (remaining):
            } else {
                result += boxTypes[i][1] * truckSize;
                // needs to return
                return result;
            }
        }
        return result;
    }
}