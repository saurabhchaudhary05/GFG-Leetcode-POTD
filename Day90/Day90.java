/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

class Solution {
    double power(double b, int e) {
        // Base case: any number raised to the power of 0 is 1
        if (e == 0) {
            return 1.0;
        }

        // If the exponent is negative, compute the reciprocal of the base
        // raised to the positive exponent
        if (e < 0) {
            return 1.0 / power(b, -e);
        }

        // Recursively compute the power for half of the exponent
        double halfPower = power(b, e / 2);

        // If the exponent is odd, multiply the base once more
        if ((e & 1) != 0) {
            return b * halfPower * halfPower;
        }
        // If the exponent is even, simply square the half power
        else {
            return halfPower * halfPower;
        }
    }
}


class Solution {
    private int[] parent;
    private int[] rank;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];
        rank = new int[n + 1];

        // Initialize each node as its own parent
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            if (find(u) == find(v)) {
                return edge; // Cycle detected
            }
            join(u, v); // Merge sets
        }

        return new int[0]; // Unreachable for valid inputs
    }

    private int find(int i) {
        if (parent[i] != i) {
            parent[i] = find(parent[i]); // Path compression
        }
        return parent[i];
    }

    private void join(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);

        if (rootU != rootV) {
            // Union by rank
            if (rank[rootU] > rank[rootV]) {
                parent[rootV] = rootU;
            } else if (rank[rootU] < rank[rootV]) {
                parent[rootU] = rootV;
            } else {
                parent[rootV] = rootU;
                rank[rootU]++;
            }
        }
    }
}
