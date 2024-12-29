/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

class Solution {
    public int numWays(String[] words, String target) {
        int mod = 1000000007;
        int n = words[0].length();
        int[][] freq = new int[n][26]; // freq[i][j] = frequency of j+'a' in the ith column of the matrix
        
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < n; j++) {
                freq[j][words[i].charAt(j) - 'a']++;
            }
        }
        
        int[][] dp = new int[n+1][target.length()+1]; // dp[i][j] = number of ways to form the prefix of target with length j using the first i columns of the matrix
        
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target.length(); j++) {
                int charCount = freq[i-1][target.charAt(j-1) - 'a'];
                dp[i][j] = (dp[i-1][j] + (int)((long)charCount * dp[i-1][j-1] % mod)) % mod;
            }
        }
        
        return dp[n][target.length()];
    }
}

class Solution {
    public ArrayList<Integer> intersectionWithDuplicates(int[] a, int[] b) {
        // Put all elements of a in a HashSet
        Set<Integer> setA = new HashSet<>();
        for (int num : a) {
            setA.add(num);
        }

        ArrayList<Integer> result = new ArrayList<>();

        // Traverse through b
        for (int num : b) {
            // If the element is in setA
            // a) Add it to the result list
            // b) Remove it from setA to avoid duplicates
            if (setA.contains(num)) {
                result.add(num);
                setA.remove(num);
            }
        }

        return result;
    }
}