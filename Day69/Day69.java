/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

import java.util.*;

class Solution {
    public List<String> stringMatching(String[] words) {
        int n = words.length;
        List<String> ans = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i != j && words[j].contains(words[i])) {
                    ans.add(words[i]);
                    break;
                }
            }
        }

        return ans;
    }
} 

class Solution {
    // Function to count pairs with given sum in the array
    int countPairs(int arr[], int target) {
        int res = 0;
        int n = arr.length;
        int left = 0, right = n - 1;

        while (left < right) {

            // If sum is greater
            if (arr[left] + arr[right] < target) left++;

            // If sum is lesser
            else if (arr[left] + arr[right] > target)
                right--;

            // If sum is equal
            else {
                int cnt1 = 0, cnt2 = 0;
                int ele1 = arr[left], ele2 = arr[right];

                // Count frequency of first element of the pair
                while (left <= right && arr[left] == ele1) {
                    left++;
                    cnt1++;
                }

                // Count frequency of second element of the pair
                while (left <= right && arr[right] == ele2) {
                    right--;
                    cnt2++;
                }

                // If both the elements are same, then count of
                // pairs = the number of ways to choose 2
                // elements among cnt1 elements
                if (ele1 == ele2) res += (cnt1 * (cnt1 - 1)) / 2;

                // If the elements are different, then count of
                // pairs = product of the count of both elements
                else
                    res += (cnt1 * cnt2);
            }
        }
        return res;
    }
}