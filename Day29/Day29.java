/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

class Solution {

    // Function to find maximum circular subarray sum.
    public int circularSubarraySum(int a[]) {
        int n = a.length;
        int count = 0;
        int maxx = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            // Storing the maximum element in the array.
            if (a[i] > maxx) maxx = a[i];
            // Counting total number of negative numbers in the array.
            if (a[i] < 0) count++;
        }
        if (count == n) return maxx;

        // Case 1:We get the maximum sum using standard Kadane's algorithm.
        int max_kadane = kadane(a);

        // Case 2:We now find the maximum sum that includes corner elements.
        int max_wrap = 0;
        for (int i = 0; i < n; i++) {
            // Calculating total sum of array elements.
            max_wrap += a[i];
            // Inverting the sign of array elements.
            a[i] = -a[i];
        }

        // Maximum sum with corner elements will be:
        // Total sum of array elements-(-max subarray sum after changing
        // sign of array elements).
        max_wrap = max_wrap + kadane(a);

        // The maximum circular subarray sum will be maximum of two sums.
        return (max_wrap > max_kadane) ? max_wrap : max_kadane;
    }

    // Standard Kadane's algorithm to find maximum subarray sum.
    public int kadane(int a[]) {
        int n = a.length;
        int max_so_far = 0, max_ending_here = 0;
        for (int i = 0; i < n; i++) {
            // Storing max sum till current index.
            max_ending_here = max_ending_here + a[i];

            // If max sum till current index is negative, we update it to 0.
            if (max_ending_here < 0) max_ending_here = 0;

            // Storing the max sum so far.
            if (max_so_far < max_ending_here) max_so_far = max_ending_here;
        }
        return max_so_far;
    }
}


class Solution {
    public int findChampion(int n, int[][] edges) {
        boolean[] championExist=new boolean[n];
        for(int[] edge:edges){
            championExist[edge[1]]=true;
        }
        int count=0,falseidx=0;
        for(int i=0;i<championExist.length;i++){
            if(!championExist[i]){
                count++;
                falseidx=i;
            }
        }
        if(count>1){
            return -1;
        }
        return falseidx;
    }
}