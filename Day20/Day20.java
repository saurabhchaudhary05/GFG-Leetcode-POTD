/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int res = Integer.MAX_VALUE;
        long curSum = 0;
        Deque<Pair<Long, Integer>> q = new ArrayDeque<>();  
        
        for (int r = 0; r < nums.length; r++) {
            curSum += nums[r];
            
            if (curSum >= k) {
                res = Math.min(res, r + 1);
            }
            
            // Find the minimum valid window ending at r
            while (!q.isEmpty() && curSum - q.peekFirst().getKey() >= k) {
                Pair<Long, Integer> front = q.pollFirst();
                res = Math.min(res, r - front.getValue());
            }
            
            // Validate the monotonic deque
            while (!q.isEmpty() && q.peekLast().getKey() > curSum) {
                q.pollLast();
            }
            q.offerLast(new Pair<>(curSum, r));
        }
        
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    
    // Helper class to store pairs
    static class Pair<K, V> {
        private K key;
        private V value;
        
        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
        
        public K getKey() {
            return key;
        }
        
        public V getValue() {
            return value;
        }
    }
}

class Solution {
    public void reverseArray(int arr[]) {
        // Get the length of the input array
        int n = arr.length;

        // Loop through the first half of the array
        for (int i = 0; i < n / 2; i++) {
            // Swap the current element with the corresponding element from the end of
            // the array
            // Temporary variable to hold the current element
            int t = arr[i];
            // Replace the current element with the element from the end
            arr[i] = arr[n - i - 1];
            // Replace the element from the end with the current element
            arr[n - i - 1] = t;
        }
    }
}