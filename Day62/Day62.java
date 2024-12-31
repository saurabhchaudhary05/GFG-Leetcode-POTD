/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

class Solution {

    // Function to return length of longest subsequence of consecutive integers.
    public int longestConsecutive(int[] arr) {
        int n = arr.length;
        int[] arr2 = new int[1000001];
        int count = 0;
        int maximum = -1;
        int ans = Integer.MIN_VALUE;

        // Populate the frequency array and find maximum element in arr
        for (int i = 0; i < n; i++) {
            arr2[arr[i]]++;
            maximum = Math.max(maximum, arr[i]);
        }

        // Traverse the frequency array to find the longest consecutive subsequence
        for (int i = 0; i <= maximum; i++) {
            if (arr2[i] >= 1) {
                count++;
            } else {
                ans = Math.max(ans, count);
                count = 0;
            }
            ans = Math.max(ans, count);
        }

        return ans;
    }
} 


class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int maxDay = days[days.length - 1];
        boolean[] travelDay = new boolean[maxDay + 1];

        for (int day : days)
            travelDay[day] = true;

        int[] dp = new int[maxDay + 1];
        dp[0] = 0;

        for (int i = 1; i <= maxDay; i++) {
            if (!travelDay[i]) {
                dp[i] = dp[i - 1];
                continue;
            }

            dp[i] = costs[0] + dp[i - 1];
            dp[i] = Math.min(dp[Math.max(0, i - 7)] + costs[1], dp[i]);
            dp[i] = Math.min(dp[Math.max(0, i - 30)] + costs[2], dp[i]);
        }

        return dp[maxDay];
    }
}