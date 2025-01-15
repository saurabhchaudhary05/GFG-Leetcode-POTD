/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

class Solution {
    public int longestSubarray(int[] arr, int k) {
        // HashMap to store (sum, index) pairs
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLen = 0;

        // Traverse the given array
        for (int i = 0; i < arr.length; i++) {
            // Accumulate sum
            sum += arr[i];

            // When subarray starts from index 0
            if (sum == k) {
                maxLen = i + 1;
            }

            // If 'sum' is not present in the map, add it with the index 'i'
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }

            // Check if 'sum - k' is present in the map or not
            if (map.containsKey(sum - k)) {
                // Update maxLength if needed
                maxLen = Math.max(maxLen, i - map.get(sum - k));
            }
        }

        // Return the required maximum length
        return maxLen;
    }
}



class Solution {
    public int minimizeXor(int num1, int num2) {
        int bitCount = Integer.bitCount(num2);
        bitCount -= Integer.bitCount(num1);
        int cur = 1;

        while (bitCount != 0) {
            if (bitCount < 0 && (num1 & cur) != 0) {
                num1 ^= cur;
                bitCount++;
            } else if (bitCount > 0 && (num1 & cur) == 0) {
                num1 |= cur;
                bitCount--;
            }
            cur <<= 1;
        }

        return num1;
    }
}