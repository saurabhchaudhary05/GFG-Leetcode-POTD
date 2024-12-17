/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

class Solution {
    // Helper method to perform a binary search for the smallest number >= x
    static int ceilSearch(int[] arr, int low, int high, int x) {
        int mid;

        if (x <= arr[low]) return low;
        if (x > arr[high]) return -1;

        mid = (low + high) / 2;

        if (arr[mid] == x)
            return mid;
        else if (arr[mid] < x) {
            if (mid + 1 <= high && x <= arr[mid + 1])
                return mid + 1;
            else
                return ceilSearch(arr, mid + 1, high, x);
        } else {
            if (mid - 1 >= low && x > arr[mid - 1])
                return mid;
            else
                return ceilSearch(arr, low, mid - 1, x);
        }
    }

    // Method to validate if cows can be placed with a minimum distance x
    static boolean valid(int[] a, int c, int x) {
        int n = a.length;
        int pos = a[0];
        int cow = 1;
        while (pos <= a[n - 1]) {
            pos += x;
            int ind = ceilSearch(a, 0, n - 1, pos);
            if (ind == -1) return false;
            pos = a[ind];
            cow++;
            if (cow >= c) return true;
        }
        return cow >= c;
    }

    // Main solution method to find the maximum minimum distance between cows
    public int aggressiveCows(int[] a, int k) {
        int n = a.length; // Compute the length of the array
        Arrays.sort(a);

        int low = 0, high = (int)1e9;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (valid(a, k, mid))
                low = mid;
            else
                high = mid;
        }
        return low;
    }
}


class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        StringBuilder result = new StringBuilder();
        
        int freq = 1;
        int pointer = chars.length - 1;

        for (int i = chars.length - 1; i >= 0; --i) {
            if (result.length() > 0 && result.charAt(result.length() - 1) == chars[i]) {
                if (freq < repeatLimit) {
                    result.append(chars[i]);
                    freq++;
                } else {
                    while (pointer >= 0 && (chars[pointer] == chars[i] || pointer > i)) {
                        pointer--;
                    }

                    if (pointer >= 0) {
                        result.append(chars[pointer]);
                        char temp = chars[i];
                        chars[i] = chars[pointer];
                        chars[pointer] = temp;
                        freq = 1;
                    } else {
                        break;
                    }
                }
            } else {
                result.append(chars[i]);
                freq = 1;
            }
        }
        return result.toString();
    }
}