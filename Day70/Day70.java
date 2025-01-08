/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

class Solution {
    // Function to count the number of possible triangles.
    static int countTriangles(int arr[]) {
        int n = arr.length; // Getting the length of the array

        // Sorting the input array.
        Arrays.sort(arr);
        int count = 0;

        // Traversing the array.
        for (int i = 0; i < n - 2; i++) {
            // Storing the third index starting from ith index in k.
            int k = i + 2;

            // Traversing all the elements after ith index.
            for (int j = i + 1; j < n; j++) {
                // Traversing all the elements after jth index to check if there
                // exists any element which can satisfy the condition of triangle
                // with the elements at ith, jth, and kth index.
                while (k < n && arr[i] + arr[j] > arr[k]) ++k;

                // Incrementing the count of triangles.
                if (k > j) count += k - j - 1;
            }
        }
        // Returning the count of triangles.
        return count;
    }
}


class Solution {
    private boolean isPrefixAndSuffix(String str1, String str2) {
        int n1 = str1.length(), n2 = str2.length();
        if (n1 > n2) {
            return false;
        }
        return str2.substring(0, n1).equals(str1) && str2.substring(n2 - n1).equals(str1);
    }

    public int countPrefixSuffixPairs(String[] words) {
        int n = words.length, count = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (isPrefixAndSuffix(words[i], words[j])) {
                    count++;
                }
            }
        }
        return count;
    }
}