/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        
        // Step 1: Find the longest non-decreasing prefix
        int left = 0;
        while (left + 1 < n && arr[left] <= arr[left + 1]) {
            left++;
        }
        
        // If the entire array is already sorted
        if (left == n - 1) return 0;
        
        // Step 2: Find the longest non-decreasing suffix
        int right = n - 1;
        while (right > 0 && arr[right - 1] <= arr[right]) {
            right--;
        }
        
        // Step 3: Find the minimum length to remove by comparing prefix and suffix
        int result = Math.min(n - left - 1, right);
        
        // Step 4: Use two pointers to find the smallest middle part to remove
        int i = 0, j = right;
        while (i <= left && j < n) {
            if (arr[i] <= arr[j]) {
                result = Math.min(result, j - i - 1);
                i++;
            } else {
                j++;
            }
        }
        
        return result;
    }
}

class Solution {
    public int getSecondLargest(int[] arr) {
        int n = arr.length;
        int first, second;

        // There should be at least two elements
        if (n < 2) {
            return -1;
        }

        first = second = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {

          
            if (arr[i] > first) {
                second = first;
                first = arr[i];
            }

           
            else if (arr[i] > second && arr[i] != first) {
                second = arr[i];
            }
        }
        if (second == Integer.MIN_VALUE)
            return -1;
        else
            return second;
    }
}