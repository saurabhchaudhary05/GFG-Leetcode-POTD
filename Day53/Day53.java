/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] vals, int k) {
        if (n < 2) return 1;
        
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        int[] degree = new int[n];
        
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        
        long[] nodeVals = new long[n];
        for (int i = 0; i < n; i++) nodeVals[i] = vals[i];
        Queue<Integer> leafQ = new LinkedList<>();
        for (int i = 0; i < n; i++) if (degree[i] == 1) leafQ.add(i);
        
        int compCnt = 0;
        while (!leafQ.isEmpty()) {
            int curr = leafQ.poll();
            degree[curr]--;
            long carry = 0;
            
            if (nodeVals[curr] % k == 0) compCnt++;
            else carry = nodeVals[curr];
            
            for (int nbr : graph.get(curr)) {
                if (degree[nbr] == 0) continue;
                degree[nbr]--;
                nodeVals[nbr] += carry;
                if (degree[nbr] == 1) leafQ.add(nbr);
            }
        }
        
        return compCnt;
    }
}

class Solution {
    // Function to do transpose of mat.
    static void transpose(int mat[][]) {
        for (int i = 0; i < mat.length; i++)
            for (int j = i; j < mat[0].length; j++) {
                // swapping elements at (i,j) and (j,i).
                int temp = mat[j][i];
                mat[j][i] = mat[i][j];
                mat[i][j] = temp;
            }
    }

    // after transposing we swap elements of each column (1st with last, 2nd with
    // second last) one by one for finding left rotation of mat by 90 degree.
    static void reverseColumns(int mat[][]) {
        for (int i = 0; i < mat[0].length; i++)
            for (int j = 0, k = mat[0].length - 1; j < k; j++, k--) {
                // swapping elements in each column.
                int temp = mat[j][i];
                mat[j][i] = mat[k][i];
                mat[k][i] = temp;
            }
    }

    // Function to rotate mat anticlockwise by 90 degrees.
    static void rotateby90(int mat[][]) {
        transpose(mat);
        reverseColumns(mat);
    }
}