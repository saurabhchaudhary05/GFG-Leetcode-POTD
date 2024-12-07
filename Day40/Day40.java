/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

class Solution {
    public int minimumSize(int[] nums, int maxOps) {
        int low = 1, high = Arrays.stream(nums).max().getAsInt();
        while (low < high) {
            int mid = (low + high) / 2;
            int ops = 0;
            for (int n : nums) {
                ops += (n - 1) / mid;
            }
            if (ops <= maxOps) high = mid;
            else low = mid + 1;
        }
        return high;
    }
}

class Solution {
    // Function to count inversions in the array.
    static int inversionCount(int arr[]) {
        int n = arr.length;
        int temp[] = new int[n];
     
        return _mergeSort(arr, temp, 0, n - 1);
    }

    static int _mergeSort(int arr[], int temp[], int left, int right) {
        int mid, inv_count = 0;
        if (right > left) {
            mid = (right + left) / 2;

            // Calling recursive function to sort left half of the array.
            inv_count = _mergeSort(arr, temp, left, mid);

            // Calling recursive function to sort right half of the array.
            inv_count += _mergeSort(arr, temp, mid + 1, right);

            // Calling merge function which sorts and merges both halves
            // of the array obtained after calling both recursive function.
            inv_count += merge(arr, temp, left, mid + 1, right);
        }
        // returning the count of inversions in the array.
        return inv_count;
    }

    // Function to sort and merge two parts of array and return inversion count.
    static int merge(int arr[], int temp[], int left, int mid, int right) {
        int i, j, k;
        int inv_count = 0;
        // i is pointer for left subarray.
        i = left;
        // j is pointer for right subarray.
        j = mid;
        // k is index for resultant merged subarray.
        k = left;

        // Using two pointers over the array which helps in storing the
        // smaller element and thus merging the subarray.
        while ((i <= mid - 1) && (j <= right)) {

            // Comparing element of the array at pointers i and j and accordingly
            // storing the smaller element and updating the pointers.
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                // Adding the inversions which is the number of elements which
                // are smaller than arr[j] in the left half of the array.
                inv_count = inv_count + (mid - i);
            }
        }

        // Copying the remaining elements of left subarray(if there are any)
        // to temp.
        while (i <= mid - 1) temp[k++] = arr[i++];

        // Copying the remaining elements of right subarray(if there are any)
        // to temp.
        while (j <= right) temp[k++] = arr[j++];

        // Copying back the merged elements to original array.
        for (i = left; i <= right; i++) arr[i] = temp[i];

        return inv_count;
    }
}