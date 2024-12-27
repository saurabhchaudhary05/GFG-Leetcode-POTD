/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

class Solution {

    int countPairs(int arr[], int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < arr.length; i++) {

            // Check if the complement (target - arr[i]) exists in the map
            // If yes, increment count
            if (map.containsKey(target - arr[i])) {
                count += map.get(target - arr[i]);
            }

            // Increment the frequency of arr[i]
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        return count;
    }
}


class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int ans = Integer.MIN_VALUE;
        int m = values[0];

        for (int i = 1; i < values.length; i++) {
            if (values[i] - i + m > ans) 
                ans = values[i] - i + m;
            
            if (values[i] + i > m) 
                m = values[i] + i;
        }

        return ans;
    }
}