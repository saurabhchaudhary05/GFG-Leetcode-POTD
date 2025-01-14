/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] freq = new int[n + 1];
        int[] ans = new int[n];
        int common = 0;

        for (int i = 0; i < n; i++) {
            if (++freq[A[i]] == 2) common++;
            if (++freq[B[i]] == 2) common++;
            ans[i] = common;
        }
        return ans;
    }
}

class Solution {
    // Function to find equilibrium point in the array.
    public static int findEquilibrium(int arr[]) {
        int n = arr.length;

        // We store the sum of all array elements in a long to prevent overflow.
        long sum = 0;
        for (int i = 0; i < n; i++) sum += arr[i];

        // sum2 is used to store the prefix sum.
        long sum2 = 0;

        for (int i = 0; i < n; i++) {

            // Leaving out the value of the current element from the suffix sum.
            sum = sum - arr[i];

            // Checking if suffix and prefix sums are the same.
            if (sum2 == sum) {
                // Returning the index or equilibrium point.
                return i;
            }

            // Adding the value of the current element to the prefix sum.
            sum2 = sum2 + arr[i];
        }
        return -1;
    }
}