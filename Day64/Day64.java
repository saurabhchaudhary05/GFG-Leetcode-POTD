/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

class Solution {
    public int countSubarrays(int arr[], int k) {
        // HashMap to store prefix sums frequencies
        Map<Integer, Integer> prefixSums = new HashMap<>();
        int res = 0;
        int currSum = 0;

        for (int i = 0; i < arr.length; i++) {
            // Add current element to sum so far.
            currSum += arr[i];

            // If currSum is equal to desired sum, then a new subarray is found.
            if (currSum == k) res++;

            // Check if the difference exists in the prefixSums map.
            if (prefixSums.containsKey(currSum - k)) res += prefixSums.get(currSum - k);

            // Add currSum to the set of prefix sums.
            prefixSums.put(currSum, prefixSums.getOrDefault(currSum, 0) + 1);
        }

        return res;
    }
}

class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] Prefix = new int[n + 1];
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        for (int i = 0; i < n; i++) {
            Prefix[i + 1] = Prefix[i];
            if (vowels.contains(words[i].charAt(0)) && vowels.contains(words[i].charAt(words[i].length() - 1))) {
                Prefix[i + 1]++;
            }
        }

        int[] ANS = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ANS[i] = Prefix[queries[i][1] + 1] - Prefix[queries[i][0]];
        }
        return ANS;
    }
}
