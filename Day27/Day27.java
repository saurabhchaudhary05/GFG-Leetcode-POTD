/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

class Solution {
    public long maxMatrixSum(int[][] matrix) {
    int min = Integer.MAX_VALUE;
    long sum = 0;
    int negCount = 0; 
    for(int i=0; i<matrix.length; i++)
    for(int j=0; j<matrix[0].length; j++)
    {
     if(matrix[i][j]<0)
     negCount++;
     int ab = Math.abs(matrix[i][j]);
     min = Math.min(min, ab);
     sum += ab;    
    }
    if(negCount%2==0)
    return sum; 
    return sum - 2*min;
}
}


class Solution {
    // Function to find the sum of contiguous subarray with maximum sum.
    int maxSubarraySum(int[] arr) {
        int n = arr.length;

        int maxh = 0, maxf = arr[0];

        // Iterating over the array.
        for (int i = 0; i < n; i++) {

            // Updating max sum till current index.
            maxh += arr[i];
            // Storing max sum so far by choosing maximum between max
            // sum so far and max sum till current index.
            if (maxf < maxh) maxf = maxh;

            // If max sum till current index is negative, we do not need to add
            // it to result so we update it to zero.
            if (maxh < 0) maxh = 0;
        }
        // returning the result.
        return maxf;
    }
}