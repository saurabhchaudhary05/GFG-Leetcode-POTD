/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

class Solution {
    public int maximumBeauty(int[] nums, int k) {
        if (nums.length == 1)
            return 1;

        int maxBeauty = 0;
        int maxValue = 0;

        for (int num : nums)
            maxValue = Math.max(maxValue, num);

        int[] count = new int[maxValue + 1];

        for (int num : nums) {
            count[Math.max(num - k, 0)]++;
            count[Math.min(num + k + 1, maxValue)]--;
        }

        int currentSum = 0;

        for (int val : count) {
            currentSum += val;
            maxBeauty = Math.max(maxBeauty, currentSum);
        }

        return maxBeauty;
    }
}


class Solution {
    // Function to find next gap.
    public int nextGap(int gap) {

        // It returns the ceil value of gap/2 or 0 if gap is 1.
        if (gap <= 1) return 0;
        return (gap / 2) + (gap % 2);
    }

    // Function to merge the arrays.
    public void mergeArrays(int a[], int b[]) {
        int n = a.length;
        int m = b.length;

        int i, j, gap = n + m;
        int tmp;

        for (gap = nextGap(gap); gap > 0; gap = nextGap(gap)) {

            // Comparing elements in the first array itself with difference in
            // index equal to the value of gap.
            for (i = 0; i + gap < n; i++) {
                if (a[i] > a[i + gap]) {

                    // If element at ith index is greater than element at
                    //(i+gap)th index, we swap them.
                    tmp = a[i];
                    a[i] = a[i + gap];
                    a[i + gap] = tmp;
                }
            }

            // Now comparing elements in both arrays with help of two pointers.
            // The loop stops whenever any pointer exceeds the size of its array
            for (j = gap > n ? gap - n : 0; i < n && j < m; i++, j++) {

                // If element in the first array is greater than element in
                // second array, we swap them.
                if (a[i] > b[j]) {
                    tmp = a[i];
                    a[i] = b[j];
                    b[j] = tmp;
                }
            }

            if (j < m) {
                // At last, comparing elements in the second array itself with
                // difference in index equal to the value of gap.
                for (j = 0; j + gap < m; j++) {

                    // If element at jth index is greater than element at
                    //(j+gap)th index, we swap them.
                    if (b[j] > b[j + gap]) {
                        tmp = b[j];
                        b[j] = b[j + gap];
                        b[j + gap] = tmp;
                    }
                }
            }
        }
    }
}