/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

import java.util.*;

class Solution {
    public int minimumObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] distance = new int[m][n];
        for (int[] row : distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        distance[0][0] = 0;

        Deque<int[]> deque = new ArrayDeque<>();
        deque.offerFirst(new int[]{0, 0}); 

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!deque.isEmpty()) {
            int[] cell = deque.pollFirst();
            int x = cell[0], y = cell[1];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k], ny = y + dy[k];
                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;

                int newDist = distance[x][y] + grid[nx][ny];
                if (newDist < distance[nx][ny]) {
                    distance[nx][ny] = newDist;
                    if (grid[nx][ny] == 0) {
                        deque.offerFirst(new int[]{nx, ny});
                    } else {
                        deque.offerLast(new int[]{nx, ny});
                    }
                }
            }
        }

        return distance[m - 1][n - 1];
    }
}

class Solution {
    public int myAtoi(String s) {
        int sign = 1, res = 0, idx = 0;

        // Ignore leading whitespaces
        while (idx < s.length() && s.charAt(idx) == ' ') {
            idx++;
        }

        // Store the sign of number
        if (idx < s.length() && (s.charAt(idx) == '-' || s.charAt(idx) == '+')) {
            if (s.charAt(idx++) == '-') {
                sign = -1;
            }
        }

        // Construct the number digit by digit
        while (idx < s.length() && s.charAt(idx) >= '0' && s.charAt(idx) <= '9') {

            // Handling overflow/underflow test case
            if (res > Integer.MAX_VALUE / 10 ||
                (res == Integer.MAX_VALUE / 10 && s.charAt(idx) - '0' > 7)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            // Append current digit to the result
            res = 10 * res + (s.charAt(idx++) - '0');
        }
        return res * sign;
    }
}