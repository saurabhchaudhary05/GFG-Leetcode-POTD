/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        Set<Integer> elements = new HashSet<>();
        long currentSum = 0;
        long maxSum = 0;
        int begin = 0;
        
        for (int end = 0; end < n; end++) {
            if (!elements.contains(nums[end])) {
                currentSum += nums[end];
                elements.add(nums[end]);
                
                if (end - begin + 1 == k) {
                    maxSum = Math.max(maxSum, currentSum);
                    currentSum -= nums[begin];
                    elements.remove(nums[begin]);
                    begin++;
                }
            } else {
                while (nums[begin] != nums[end]) {
                    currentSum -= nums[begin];
                    elements.remove(nums[begin]);
                    begin++;
                }
                begin++;
            }
        }
        
        return maxSum;
    }
}

class Solution {
    // Function to swap elements in the array
    void swap(int i, int j, int[] arr) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

  
    void nextPermutation(int[] arr) {
        int N = arr.length;
        // Initializing variables
        int ind = 0;

        // Finding the largest index i such that arr[i] < arr[i+1]
        for (int i = N - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                ind = i;
                break;
            }
        }

        // Swapping the element at ind with the smallest element greater than it to its
        // right side
        for (int i = N - 1; i > ind; i--) {
            if (arr[i] > arr[ind]) {
                swap(i, ind, arr);
                ind++;
                break;
            }
        }

        // Reversing the elements from ind+1 to N-1 to get the next permutation
        for (int i = 0; i < (N - ind) / 2; i++) {
            swap(i + ind, N - i - 1, arr);
        }
    }
}