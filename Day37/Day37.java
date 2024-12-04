/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

class Solution {

    public boolean KMPSearch(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();

        // create lps[] that will hold the longest prefix suffix
        // values for pattern
        int[] lps = new int[M];

        // Preprocess the pattern (calculate lps[] array)
        computeLPSArray(pat, M, lps);

        int i = 0; // index for txt[]
        int j = 0; // index for pat[]
        while ((N - i) >= (M - j)) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }

            if (j == M) {
                return true;
            } else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                // mismatch after j matches
                // Do not match lps[0..lps[j-1]] characters,
                // they will match anyway
                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }
        return false;
    }

    // Fills lps[] for given pattern pat[0..M-1]
    void computeLPSArray(String pat, int M, int[] lps) {
        // length of the previous longest prefix suffix
        int len = 0;

        lps[0] = 0; // lps[0] is always 0

        // the loop calculates lps[i] for i = 1 to M-1
        int i = 1;
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else { // (pat.charAt(i) != pat.charAt(len))
                if (len != 0) {
                    len = lps[len - 1];

                    // Also, note that we do not increment
                    // i here
                } else { // if (len == 0)
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }

    // Function to check if two strings are rotations of each other or not.
    public boolean areRotations(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        else {
            // we concatenate first string to itself and check if other
            // string occurs in it as substring. If yes, then it
            // is rotated version and we return true else false.
            String concatenated = s1 + s1;
            if (KMPSearch(s2, concatenated))
                return true;
            else
                return false;
        }
    }
}


class Solution {
    public boolean canMakeSubsequence(String source, String target) {
        int targetIdx = 0, targetLen = target.length();
        
        for (char currChar : source.toCharArray()) {
            if (targetIdx < targetLen && (target.charAt(targetIdx) - currChar + 26) % 26 <= 1) {
                targetIdx++;
            }
        }
        return targetIdx == targetLen;
    }
}