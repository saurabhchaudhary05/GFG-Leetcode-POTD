/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

class Solution {
    public int prefixCount(String[] words, String pref) {
        int c = 0;
        int n = pref.length();
        for (String w : words) {
            if (w.length() >= n && w.startsWith(pref)) {
                c++;
            }
        }
        return c;
    }
}

class Solution {
    // Function to find a continuous sub-array which adds up to a given number
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        int s = 0, e = 0;
        int curr = 0;
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            curr += arr[i];

            // If current sum becomes more or equal,
            // set end and try adjusting start
            if (curr >= target) {
                e = i;

                // While current sum is greater,
                // remove starting elements of current window
                while (curr > target && s < e) {
                    curr -= arr[s];
                    s++;
                }

                // If we found a subarray
                if (curr == target) {
                    res.add(s + 1); // Convert to 1-based indexing
                    res.add(e + 1);
                    return res;
                }
            }
        }
        // If no subarray is found
        res.add(-1);
        return res;
    }
}
