/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        
        for (char[] row : box) {
            int dropPos = n - 1;
            
            for (int currPos = n - 1; currPos >= 0; currPos--) {
                if (row[currPos] == '*') {
                    dropPos = currPos - 1;
                }
                else if (row[currPos] == '#') {
                    char temp = row[dropPos];
                    row[dropPos] = row[currPos];
                    row[currPos] = temp;
                    dropPos--;
                }
            }
        }
        
        char[][] rotatedBox = new char[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rotatedBox[j][m - 1 - i] = box[i][j];
            }
        }
        
        return rotatedBox;
    }
}

class Solution {
    public int getMinDiff(int k, int[] arr) {
        int n = arr.length;
        int[][] v = new int[n * 2][2]; // Store all possible heights
        int[] taken = new int[n];

        // Store all possible heights in the array
        for (int i = 0; i < n; i++) {
            v[2 * i] = new int[] {arr[i] - k, i};
            v[2 * i + 1] = new int[] {arr[i] + k, i};
        }

        // Sort the array based on the first element of the sub-array
        Arrays.sort(v, new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                return Integer.compare(p1[0], p2[0]);
            }
        });

        int elementsInRange = 0;
        int left = 0;
        int right = 0;

        // Two-pointer technique to find the minimum difference
        while (elementsInRange < n && right < v.length) {
            if (taken[v[right][1]] == 0) {
                elementsInRange++;
            }
            taken[v[right][1]]++;
            right++;
        }

        int ans = v[right - 1][0] - v[left][0];
        while (right < v.length) {
            if (taken[v[left][1]] == 1) {
                elementsInRange--;
            }
            taken[v[left][1]]--;
            left++;

            while (elementsInRange < n && right < v.length) {
                if (taken[v[right][1]] == 0) {
                    elementsInRange++;
                }
                taken[v[right][1]]++;
                right++;
            }

            if (elementsInRange == n) {
                ans = Math.min(ans, v[right - 1][0] - v[left][0]);
            } else {
                break;
            }
        }
        return ans;
    }
}