/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

class Solution {
    int countPairs(int arr[], int target) {
        Arrays.sort(arr);
        int count = 0;
        int left = 0, right = arr.length - 1;
        while (left < right) {
            if (arr[left] + arr[right] < target) {
                count += (right - left);
                left++;
            } else {
                right--;
            }
        }
        return count;
    }
}


class Solution {
    public String shiftingLetters(String s, int[][] Q) {
        int n = s.length();
        int[] A = new int[n];
        for (int[] it : Q) {
            int l = it[0];
            int r = it[1];
            int t = it[2];
            if (t == 1) {
                A[l] += 1;
                if (r + 1 < n) {
                    A[r + 1] -= 1;
                }
            } else {
                A[l] -= 1;
                if (r + 1 < n) {
                    A[r + 1] += 1;
                }
            }
        }
        for (int i = 1; i < n; ++i) {
            A[i] += A[i - 1];
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < n; ++i) {
            int shift = (A[i] % 26 + 26) % 26; 
            int ch = chars[i] - 'a';
            ch = (ch + shift) % 26;
            chars[i] = (char) ('a' + ch);
        }
        return new String(chars);
    }
}