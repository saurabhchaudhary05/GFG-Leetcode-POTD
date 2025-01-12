/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

class Solution {
    public int maxWater(int arr[]) {
        int left = 1;
        int right = arr.length - 2;

        // lMax : Maximum in subarray arr[0..left-1]
        // rMax : Maximum in subarray arr[right+1..n-1]
        int lMax = arr[left - 1];
        int rMax = arr[right + 1];

        int res = 0;
        while (left <= right) {

            // If rMax is smaller, then we can decide the amount of water for arr[right]
            if (rMax <= lMax) {

                // Add the water for arr[right]
                res += Math.max(0, rMax - arr[right]);

                // Update right max
                rMax = Math.max(rMax, arr[right]);

                // Update right pointer as we have decided the amount of water for this
                right -= 1;
            } else {

                // Add the water for arr[left]
                res += Math.max(0, lMax - arr[left]);

                // Update left max
                lMax = Math.max(lMax, arr[left]);

                // Update left pointer as we have decided water for this
                left += 1;
            }
        }
        return res;
    }
}

class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if (n % 2 != 0) return false;

        int open = 0, close = 0, unlocked1 = 0, unlocked2 = 0;
        for (int i = 0; i < n; i++) {
            // Left-to-right
            if (locked.charAt(i) == '0') unlocked1++;
            else if (s.charAt(i) == '(') open++;
            else if (s.charAt(i) == ')') open--;
            if (open + unlocked1 < 0) return false;

            // Right-to-left
            int j = n - i - 1;
            if (locked.charAt(j) == '0') unlocked2++;
            else if (s.charAt(j) == ')') close++;
            else if (s.charAt(j) == '(') close--;
            if (close + unlocked2 < 0) return false;
        }
        return true;
    }
}