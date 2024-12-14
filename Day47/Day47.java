/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

class Solution {
    public long continuousSubarrays(int[] nums) {
        int n = nums.length;
        int j = 0;
        long cnt = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            while ((i - j + 1) > getCount(nums[i], map)) {
                map.put(nums[j], map.get(nums[j]) - 1);

                j++;
            }

            cnt += (i - j + 1);
        }

        return cnt;
    }

    private int getCount(int num, Map<Integer, Integer> map) {
        return map.getOrDefault(num, 0) + map.getOrDefault(num - 1, 0) +
            map.getOrDefault(num + 1, 0) + map.getOrDefault(num - 2, 0) +
            map.getOrDefault(num + 2, 0);
    }
}

class Solution {
    int search(int[] arr, int key) {

        // Initialize two pointers, lo and hi, at the start
        // and end of the array
        int lo = 0, hi = arr.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            // If key found, return the index
            if (arr[mid] == key) return mid;

            // If Left half is sorted
            if (arr[mid] >= arr[lo]) {

                // If the key lies within this sorted half,
                // move the hi pointer to mid - 1
                if (key >= arr[lo] && key < arr[mid]) hi = mid - 1;

                // Otherwise, move the lo pointer to mid + 1
                else
                    lo = mid + 1;
            }

            // If Right half is sorted
            else {

                // If the key lies within this sorted half,
                // move the lo pointer to mid + 1
                if (key > arr[mid] && key <= arr[hi]) lo = mid + 1;

                // Otherwise, move the hi pointer to mid - 1
                else
                    hi = mid - 1;
            }
        }

        // Key not found
        return -1;
    }
}