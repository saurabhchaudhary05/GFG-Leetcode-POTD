/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

class Solution {
    public int minimumLength(String s) {
        int n = s.length();
        int[] freq = new int[26]; 
        for(int i =0; i < n; i++){
            freq[s.charAt(i)- 'a']++;
        } 

        int finalLength = 0;

        for(int i =0; i < 26; i++){
        
            if(freq[i]%2 == 0 && freq[i] != 0)
                finalLength += 2;
            else if(freq[i]%2 == 1)
                finalLength += 1;
        }      

        return finalLength;
    }
}

class Solution {

    public int maxWater(int arr[]) {
        int l = 0;              // left wall of container
        int r = arr.length - 1; // right wall of container
        int area = 0;

        while (l < r) {
            // Calculating the max area
            area = Math.max(area, (int)Math.min(arr[l], arr[r]) * (r - l));

            // maximise height of container
            if (arr[l] < arr[r])
                l += 1;
            else
                r -= 1;
        }
        return area;
    }
}