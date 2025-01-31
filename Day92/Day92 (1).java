/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

import java.util.*;

public class Solution {
    private static final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        List<Integer> key = new ArrayList<>();
        int id = 2;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int size = dfs(grid, i, j, id);
                    key.add(size);
                    id++;
                }
            }
        }

        if (key.isEmpty()) return 1;

        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> seen = new HashSet<>();
                    int sum = 1;
                    for (int[] dir : dirs) {
                        int ni = i + dir[0];
                        int nj = j + dir[1];
                        if (ni >= 0 && ni < n && nj >= 0 && nj < n && grid[ni][nj] >= 2) {
                            int islandId = grid[ni][nj];
                            if (!seen.contains(islandId)) {
                                sum += key.get(islandId - 2);
                                seen.add(islandId);
                            }
                        }
                    }
                    max = Math.max(max, sum);
                }
            }
        }

        return max == 0 ? n * n : max;
    }

    private int dfs(int[][] grid, int i, int j, int id) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = id;
        int count = 1;
        for (int[] dir : dirs) {
            count += dfs(grid, i + dir[0], j + dir[1], id);
        }
        return count;
    }
}


class Solution {
    // Function to find a solved Sudoku.
    static boolean isSafe(int[][] mat, int i, int j, int num, int[] row, int[] col,
                          int[] box) {
        if ((row[i] & (1 << num)) != 0 || (col[j] & (1 << num)) != 0 ||
            (box[i / 3 * 3 + j / 3] & (1 << num)) != 0)
            return false;

        return true;
    }

    static boolean sudokuSolverRec(int[][] mat, int i, int j, int[] row, int[] col,
                                   int[] box) {
        int n = mat.length;

        // base case: Reached nth column of last row
        if (i == n - 1 && j == n) return true;

        // If reached last column of the row go to next row
        if (j == n) {
            i++;
            j = 0;
        }

        // If cell is already occupied then move forward
        if (mat[i][j] != 0) return sudokuSolverRec(mat, i, j + 1, row, col, box);

        for (int num = 1; num <= n; num++) {
            // If it is safe to place num at current position
            if (isSafe(mat, i, j, num, row, col, box)) {
                mat[i][j] = num;

                // Update masks for the corresponding row, column and box
                row[i] |= (1 << num);
                col[j] |= (1 << num);
                box[i / 3 * 3 + j / 3] |= (1 << num);

                if (sudokuSolverRec(mat, i, j + 1, row, col, box)) return true;

                // Unmask the number num in the corresponding row, column and box masks
                mat[i][j] = 0;
                row[i] &= ~(1 << num);
                col[j] &= ~(1 << num);
                box[i / 3 * 3 + j / 3] &= ~(1 << num);
            }
        }

        return false;
    }

    static void solveSudoku(int[][] mat) {
        int n = mat.length;
        int[] row = new int[n];
        int[] col = new int[n];
        int[] box = new int[n];

        // Set the bits in bitmasks for values that are initially present
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != 0) {
                    row[i] |= (1 << mat[i][j]);
                    col[j] |= (1 << mat[i][j]);
                    box[(i / 3) * 3 + j / 3] |= (1 << mat[i][j]);
                }
            }
        }

        sudokuSolverRec(mat, 0, 0, row, col, box);
    }
}