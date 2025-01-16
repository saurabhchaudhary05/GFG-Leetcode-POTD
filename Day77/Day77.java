/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

class Solution {
    public int maxLen(int[] arr) {

        int n = arr.length;
        // Store the cumulative sum of the array in another array called sum
        int sum[] = new int[arr.length];
        sum[0] = arr[0] == 0 ? -1 : 1; // If element is 0, add -1 to sum, else add 1
        for (int i = 1; i < sum.length; i++)
            sum[i] = sum[i - 1] + (arr[i] == 0 ? -1 : 1);

        // Create a HashMap to store the first occurrence of cumulative sum
        Map<Integer, Integer> pos = new HashMap<Integer, Integer>();
        int maxLen = 0; // Initialize max length of subarray to 0
        int i = 0;      // Initialize variable i to 0
        // Loop through the cumulative sum
        for (int s : sum) {
            // If cumulative sum is 0, update the max length to current index + 1
            if (s == 0) maxLen = Math.max(maxLen, i + 1);

            // If the cumulative sum exists in the HashMap,
            // update the max length to the difference between current index and the
            // first occurrence of the sum
            if (pos.containsKey(s))
                maxLen = Math.max(maxLen, i - pos.get(s));
            else
                pos.put(s, i); // Add the sum and the index to the HashMap

            i++; // Increment i by 1
        }
        return maxLen; // Return the max length of subarray
    }
}


class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n1=0;
        int n2=0;
        if(nums1.length%2!=0){
            for(int i=0; i<nums2.length; i++){
                n1=n1^nums2[i];
            }
        }
        if(nums2.length%2!=0){
            for(int i=0; i<nums1.length; i++){
                n2=n2^nums1[i];
            }
        }
        return n1^n2;
    }
}