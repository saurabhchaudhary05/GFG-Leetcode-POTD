/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

class Solution {
    public boolean primeSubOperation(int[] nums) {
        int maxElement = getMaxElement(nums);

        boolean[] sieve = new boolean[maxElement + 1];
        fill(sieve, true);
        sieve[1] = false;
        for (int i = 2; i <= Math.sqrt(maxElement + 1); i++) {
            if (sieve[i]) {
                for (int j = i * i; j <= maxElement; j += i) {
                    sieve[j] = false;
                }
            }
        }

        
        int currValue = 1;
        int i = 0;
        while (i < nums.length) {
            int difference = nums[i] - currValue;

            if (difference < 0) {
                return false;
            }

            
            if (sieve[difference] == true || difference == 0) {
                i++;
                currValue++;
            } else {
                currValue++;
            }
        }
        return true;
    }

    // Helper method to find maximum element in array
    private int getMaxElement(int[] nums) {
        int max = -1;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    // Helper method to initialize boolean array
    private void fill(boolean[] arr, boolean value) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = value;
        }
    }
}


class Solution {
    // Function to calculate the minimum number of increments
    public int minIncrements(int[] arr) {
        // Initialize the answer variable to store the total number of increments
        int ans = 0, N = arr.length;

        // Sort the array in ascending order
        Arrays.sort(arr);

        // Iterate through the array starting from the second element
        for (int i = 1; i < N; i++) {
            // If the current element is less than or equal to the previous element
            if (arr[i] <= arr[i - 1]) {
                // Calculate the difference between the previous element and current
                // element, and add 1 to it This is the minimum number of increments
                // needed to make the current element greater than the previous element
                ans += (arr[i - 1] - arr[i] + 1);

                // Update the current element to be one greater than the previous
                // element
                arr[i] = arr[i - 1] + 1;
            }
        }
        // Return the total number of increments needed to make the array sorted in
        // non-decreasing order
        return ans;
    }
}