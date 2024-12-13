/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

class Solution {
    public long findScore(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];

        for (int i = 0; i < n; i++) {
            dp[i][0] = nums[i];
            dp[i][1] = i;
        }

        Arrays.sort(dp, (a, b) -> a[0] - b[0]);

        boolean[] marked = new boolean[n];
        long result = 0;

        for (int[] arr : dp) {
            int val = arr[0];
            int ind = arr[1];

            if (!marked[ind]) {
                result += val;

                marked[ind] = true;
                if (ind > 0)
                    marked[ind - 1] = true;
                if (ind < n - 1) 
                    marked[ind + 1] = true;
            }
        }

        return result;
    }
}


class Solution {
    public int findMin(int[] arr) {
        int lo = 0, hi = arr.length - 1;

        while (lo < hi) {

            // The current subarray is already sorted,
            // the minimum is at the low index
            if (arr[lo] < arr[hi]) return arr[lo];

            // We reach here when we have at least
            // two elements and the current subarray
            // is rotated

            int mid = (lo + hi) / 2;

            // The right half is not sorted. So
            // the minimum element must be in the
            // right half.
            if (arr[mid] > arr[hi]) lo = mid + 1;

            // The right half is sorted. Note that in
            // this case, we do not change high to mid - 1
            // but keep it to mid. As the mid element
            // itself can be the smallest
            else
                hi = mid;
        }

        return arr[lo];
    }
}