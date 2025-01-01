/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

class Solution {
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();

        // HashMap to maintain groups of anagrams
        Map<String, ArrayList<String>> umap = new HashMap<>();

        for (String s : arr) {
            char[] charArray = s.toCharArray();

            // Sort each string
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);

            // Add original string to corresponding sorted string in hash map
            umap.computeIfAbsent(sortedStr, k -> new ArrayList<>()).add(s);
        }
        for (ArrayList<String> x : umap.values()) {
            result.add(x);
        }

        return result;
    }
}


class Solution {
    public int maxScore(String s) {
        int totalZeros = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') totalZeros++;
        }
        int ans = -1, zeros = 0, n = s.length();
        for (int i = 1; i < n; i++) {
            if (s.charAt(i - 1) == '0') {
                zeros++;
                totalZeros--;
            }
            ans = Math.max(ans, zeros + (n - totalZeros - i));
        }
        return ans;
    }
}