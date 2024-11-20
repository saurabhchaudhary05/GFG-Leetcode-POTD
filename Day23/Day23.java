/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

class Solution {
    // Function to find the majority elements in the array
    public List<Integer> findMajority(int[] nums) {
        int n = nums.length;
        int num1 = 0, num2 = 0, c1 = 0, c2 = 0;

        // Finding the two most frequent numbers using the Boyer-Moore algorithm
        for (int x : nums) {
            if (x == num1) {
                c1++;
            } else if (x == num2) {
                c2++;
            } else if (c1 == 0) {
                num1 = x;
                c1++;
            } else if (c2 == 0) {
                num2 = x;
                c2++;
            } else {
                c1--;
                c2--;
            }
        }

        // Reset the counts to check if num1 and num2 are indeed the majority
        c1 = 0;
        c2 = 0;
        for (int x : nums) {
            if (x == num1) {
                c1++;
            } else if (x == num2) {
                c2++;
            }
        }

        // Prepare the result list
        List<Integer> result = new ArrayList<>();
        if (c1 > n / 3) result.add(num1);
        if (c2 > n / 3) result.add(num2);

        // Sort the result and convert it to an array
        Collections.sort(result);

        return result;
    }
} 


class Solution {
    public int takeCharacters(String s, int k) {
        // Total counts
        int[] count = new int[3];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        
        if (Math.min(Math.min(count[0], count[1]), count[2]) < k) {
            return -1;
        }
        
        // Sliding Window
        int res = Integer.MAX_VALUE;
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            count[s.charAt(r) - 'a']--;
            
            while (Math.min(Math.min(count[0], count[1]), count[2]) < k) {
                count[s.charAt(l) - 'a']++;
                l++;
            }
            res = Math.min(res, s.length() - (r - l + 1));
        }
        return res;
    }
}