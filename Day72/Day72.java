/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

import java.util.Arrays;

class Solution {
    public boolean canConstruct(String s, int k) {
        if (s.length() < k) return false;

        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        int oddCount = 0;

        for (int i = 0; i < chars.length; ) {
            char current = chars[i];
            int count = 0;
            while (i < chars.length && chars[i] == current) {
                count++;
                i++;
            }
            if (count % 2 != 0) oddCount++;
        }

        return oddCount <= k;
    }
}

class Solution {
    static final int MAX_CHAR = 26;

    public int longestUniqueSubstr(String s) {
        if (s.length() == 0 || s.length() == 1) return s.length();

        int res = 0;
        boolean[] vis = new boolean[MAX_CHAR];

        // left and right pointer of sliding window
        int left = 0, right = 0;
        while (right < s.length()) {

            // If character is repeated, move left pointer marking
            // visited characters as false until the repeating
            // character is no longer part of the current window
            while (vis[s.charAt(right) - 'a'] == true) {
                vis[s.charAt(left) - 'a'] = false;
                left++;
            }

            vis[s.charAt(right) - 'a'] = true;

            // The length of the current window (right - left + 1)
            // is calculated and answer is updated accordingly.
            res = Math.max(res, (right - left + 1));
            right++;
        }
        return res;
    }
}