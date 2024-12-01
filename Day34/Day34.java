/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

import java.util.HashSet;

public class Solution {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(num * 2) || (num % 2 == 0 && set.contains(num / 2))) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}

class Solution {
   
    static char nonRepeatingChar(String s) {
        int h[] = new int[26];
        Arrays.fill(h, 0);

        // using hash table to store count of each character.
        for (int i = 0; i < s.length(); i++) {
            h[s.charAt(i) - 'a']++;
        }

        StringBuilder st = new StringBuilder("");

        // iterating over the string.
        for (int i = 0; i < s.length(); i++) {
            // if count of current character is 1, we return it.
            if (h[s.charAt(i) - 'a'] == 1) {
                return (s.charAt(i));
            }
        }
        // if there is no non-repeating character then we return '$'.
        return '$';
    }
}