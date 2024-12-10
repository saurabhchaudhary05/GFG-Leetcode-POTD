/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

public class Solution {
    public int maximumLength(String s) {
        int n = s.length();
        int l = 1, r = n;

        if (!helper(s, n, l)) return -1;

        while (l + 1 < r) {
            int mid = (l + r) / 2;
            if (helper(s, n, mid)) l = mid;
            else r = mid;
        }

        return l;
    }

    private boolean helper(String s, int n, int x) {
        int[] cnt = new int[26];
        int p = 0;

        for (int i = 0; i < n; i++) {
            while (s.charAt(p) != s.charAt(i)) p++;
            if (i - p + 1 >= x) cnt[s.charAt(i) - 'a']++;
            if (cnt[s.charAt(i) - 'a'] > 2) return true;
        }

        return false;
    }
}

class Solution {
    static int minRemoval(int intervals[][]) {
        // code here
        int N = intervals.length;
        // if intervals array is empty or null, return 0
        if (intervals == null || intervals.length == 0) return 0;

        // sort the intervals array based on the start time
        // of each interval in ascending order
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // initialize the previous end time with the end time of the first interval
        int prevEnd = intervals[0][1];

        // initialize the count of removals to 0
        int count = 0;

        // iterate through the intervals array starting from the second interval
        for (int i = 1; i < intervals.length; i++) {
            // if the previous end time is greater than the start time of the current
            // interval
            if (prevEnd > intervals[i][0]) {
                // increment the count of removals
                count++;
                // update the previous end time to be the minimum of the end time of the
                // current interval and the previous end time
                prevEnd = Math.min(intervals[i][1], prevEnd);
            } else {
                // update the previous end time to be the end time of the current
                // interval
                prevEnd = intervals[i][1];
            }
        }

        // return the count of removals
        return count;
    }
}