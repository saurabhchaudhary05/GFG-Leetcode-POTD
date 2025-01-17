/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int n=derived.length;
        int[] org=new int[n];

     
        for(int i=1; i<n; i++){
            org[i]=derived[i-1]^org[i-1];
        }

       
        for(int i=0; i<n; i++){
            int idx=(i+1)%n;
            if(derived[i]!=(org[i]^org[idx])) return false;
        }

        return true;
    }
}


class Solution {
    public static int[] productExceptSelf(int arr[]) {
        int n = arr.length;
        int[] res = new int[n];

        int product = 1;
        int zeroCount = 0;

        // Calculate product over all array elements and count zeros
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                zeroCount++;
            } else {
                product *= arr[i];
            }
        }

        // Case 1: If there are more than one zero, return an array of zeros
        if (zeroCount > 1) {
            return new int[n]; // All zeros
        }

        // Case 2: If there is exactly one zero, set the product at that index
        if (zeroCount == 1) {
            for (int i = 0; i < n; i++) {
                if (arr[i] == 0) {
                    res[i] = product;
                } else {
                    res[i] = 0;
                }
            }
            return res;
        }

        // Case 3: If there are no zeros, calculate product except self
        for (int i = 0; i < n; i++) {
            res[i] = product / arr[i];
        }

        return res; // Return the resultant product array
    }
}