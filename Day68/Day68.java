/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

class Solution {
    public int[] minOperations(String boxes) {
        int n=boxes.length();
        
        int[] arrBox=new int[n];
        for(int i=0; i<n; i++){
            arrBox[i]=boxes.charAt(i)-'0';
        }

        int[] left=new int[n]; 
        int[] right=new int[n]; 

        int oneCnt=0;
        // Left to right pass moving count
        oneCnt=arrBox[0];
        for(int i=1; i<n; i++){
            left[i]=left[i-1]+oneCnt;
            oneCnt+=arrBox[i];
        }

        // Right to left pass moving count  
        oneCnt=arrBox[n-1];
        for(int i=n-2; i>=0; i--){
            right[i]=right[i+1]+oneCnt;
            oneCnt+=arrBox[i];
        }

        // Sum the left and right 
        for(int i=0; i<n; i++){
            arrBox[i]=left[i]+right[i];
        }        

        return arrBox;
    }
}


class Solution {
    public List<Integer> sumClosest(int[] arr, int target) {
        Arrays.sort(arr); // Sorting the array to use two-pointer approach
        int n = arr.length;
        List<Integer> res = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;

        int left = 0, right = n - 1;

        while (left < right) {
            int currSum = arr[left] + arr[right];

            // Check if this pair is closer than the closest
            // pair so far
            if (Math.abs(target - currSum) < minDiff) {
                minDiff = Math.abs(target - currSum);
                res = Arrays.asList(arr[left], arr[right]);
            }

            // If this pair has less sum, move to greater values
            if (currSum < target) left++;

            // If this pair has more sum, move to smaller values
            else if (currSum > target)
                right--;

            // If this pair has sum = target, return it
            else
                return res;
        }

        return res;
    }
}