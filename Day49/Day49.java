/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

class Solution {
    public int kthElement(int a[], int b[], int k) {
        int n = a.length, m = b.length;

        // If a[] has more elements, then call kthElement
        // with reversed parameters
        if (n > m) return kthElement(b, a, k);

        // Binary Search on the number of elements we can
        // include in the first set from a[]
        int lo = Math.max(0, k - m), hi = Math.min(k, n);

        while (lo <= hi) {
            int mid1 = (lo + hi) / 2;
            int mid2 = k - mid1;

            // Find elements to the left and right of partition in a[]
            int l1 = (mid1 == 0 ? Integer.MIN_VALUE : a[mid1 - 1]);
            int r1 = (mid1 == n ? Integer.MAX_VALUE : a[mid1]);

            // Find elements to the left and right of partition in a[]
            int l2 = (mid2 == 0 ? Integer.MIN_VALUE : b[mid2 - 1]);
            int r2 = (mid2 == m ? Integer.MAX_VALUE : b[mid2]);

            // If it is a valid partition
            if (l1 <= r2 && l2 <= r1) {
                // Find and return the maximum of l1 and l2
                return Math.max(l1, l2);
            }

            // Check if we need to take lesser elements from a[]
            if (l1 > r2) hi = mid1 - 1;

            // Check if we need to take more elements from a[]
            else
                lo = mid1 + 1;
        }

        return 0;
    }
}


class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int[] arr = new int[2];

        for (int i = 0; i < k; i++) {
            arr = getMin(nums);
            nums[arr[1]] = arr[0] * multiplier;
        }

        return nums;
    }

    private int[] getMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        int idx = 0;

        for (int i = 0; i < nums.length; i++)
            if (nums[i] < min) {
                min = nums[i];
                idx = i;
            }

        return new int[] { min, idx };
    }

}