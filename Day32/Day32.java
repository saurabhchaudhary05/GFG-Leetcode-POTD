/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

class Solution
{
    private static final int[][] MOVES = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; 
    
    public int minimumTime(int[][] grid)
    {
        int rows = grid.length;
        int cols = grid[0].length;

        
        if (grid[0][1] > 1 && grid[1][0] > 1)
        {
            return -1;  // Both right and down from (0, 0) are not possible
        }

        // Step 2: Initialize the priority queue and the visited array
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);  // Min-heap based on time
        boolean[][] seen = new boolean[rows][cols];

        pq.offer(new int[]{0, 0, 0}); // Start with (0, 0) at time 0
        seen[0][0] = true;

        // Step 3: BFS-like traversal using priority queue
        while (!pq.isEmpty())
        {
            int[] curr = pq.poll(); // Get the current cell with the smallest time
            int time = curr[0];
            int row = curr[1];
            int col = curr[2];

            // Step 4: Explore all four directions
            for (int[] dir : MOVES)
            {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                // Step 5: Skip invalid cells (out of bounds or already visited)
                if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols || seen[newRow][newCol])
                {
                    continue;
                }

                // Step 6: Calculate the time to move to the next cell
                int newTime = time + 1;
                if (grid[newRow][newCol] > newTime)
                {
                    int wait = ((grid[newRow][newCol] - newTime + 1) / 2) * 2;  // Wait if necessary
                    newTime += wait;
                }

                // Step 7: If we reached the target cell, return the current time
                if (newRow == rows - 1 && newCol == cols - 1)
                {
                    return newTime;
                }

                // Step 8: Mark the cell as visited and add it to the priority queue
                seen[newRow][newCol] = true;
                pq.offer(new int[]{newTime, newRow, newCol});
            }
        }

        // Step 9: If no path is found, return -1
        return -1;
    }
} 


class Solution {
    public String addBinary(String s1, String s2) {
        int i = s1.length() - 1, j = s2.length() - 1;

        
        if (i == -1) return s2;
        if (j == -1) return s1;

        StringBuilder res = new StringBuilder();
        char ch1, ch2, carry = '0';
        int temp;

        while (i >= 0 || j >= 0) {
          
            if (i >= 0)
                ch1 = s1.charAt(i);
            else
                ch1 = '0';

            if (j >= 0)
                ch2 = s2.charAt(j);
            else
                ch2 = '0';

            temp = (ch1 - '0') + (ch2 - '0') + (carry - '0');

          
            if (temp == 0) {
                res.append('0');
                carry = '0';
            } else if (temp == 1) {
                res.append('1');
                carry = '0';
            } else if (temp == 2) {
                res.append('0');
                carry = '1';
            } else {
                res.append('1');
                carry = '1';
            }

            i--;
            j--;
        }

        // If carry is still '1' after all the calculations, append it to the result
        if (carry == '1') res.append(carry);

        // Remove any leading zeros in the result
        int len = res.length();
        while (len > 0 && res.charAt(len - 1) == '0') len--;

        // If result is empty after removing leading zeros, return "0"
        if (len == 0) return "0";

        // Reverse the result to get the correct value
        // and return the result
        res.setLength(len);
        return res.reverse().toString();
    }
}