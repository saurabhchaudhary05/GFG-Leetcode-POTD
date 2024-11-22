/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

class Solution {
    public int maxEqualRowsAfterFlips(int[][] mat) {
        Map<String, Integer> patFreq = new HashMap<>();
        
        for (int[] row : mat) {
            StringBuilder pattern = new StringBuilder();
            if (row[0] == 0) {
                for (int bit : row) pattern.append(bit);
            } else {
                for (int bit : row) pattern.append(bit ^ 1);
            }
            patFreq.merge(pattern.toString(), 1, Integer::sum);
        }
        
        return Collections.max(patFreq.values());
    }
} 

class Solution {
    // This function calculates the maximum possible profit from a given array of stock
    // prices
    public int maximumProfit(int prices[]) {
        // Initialize the minimum buy price as the first price in the array
        int buyPrice = prices[0];

        // Initialize the maximum profit as 0
        int maxProfit = 0;

        // Iterate through the array of prices starting from the second price (index 1)
        for (int i = 1; i < prices.length; i++) {
            // Update the maximum profit if the current profit (prices[i] - buyPrice) is
            // greater
            maxProfit = Math.max(maxProfit, prices[i] - buyPrice);

            // Update the minimum buy price if the current price is lower
            buyPrice = Math.min(buyPrice, prices[i]);
        }

        // Return the maximum possible profit
        return maxProfit;
    }
}