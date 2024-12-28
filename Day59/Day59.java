/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int maxSum =0;
        int []leftMax = new int[n+1];
        int []rightMax = new int[n+1];
        int []leftMaxIndex = new int[n+1];
        int []rightMaxIndex = new int[n+1];
        int [] preSum = new int[n+1];
        int maxResult =0;
        int []ans = new int[3];
        for(int i =1; i<=n ;i++){
            preSum[i] = preSum[i-1]+ nums[i-1];
        }

        for(int i =1, j=k, lowestIndex =1 ; j<=n ; i++, j++){
            int sum = preSum[j] - preSum[i-1];
            if(maxSum < sum){
                maxSum = sum;
                lowestIndex = i;
            }
            leftMaxIndex[j] = lowestIndex-1;
            leftMax[j] = maxSum;           
        }
        maxSum =0;
        for(int i =n, j=n-k+1 , lowestIndex =j; j>0 ; i--, j--){
            int sum = preSum[i] - preSum[j-1];
            if(maxSum <=sum){ // for right we need equal check for low index
                maxSum = sum; 
                lowestIndex =j;
            }
            rightMaxIndex[j] = lowestIndex-1;
            rightMax[j] = maxSum;
        }

        for(int i = k+1, j = k+k ; j<=n-k ; i++, j++){
                int mid = preSum[j] - preSum[i-1];
                int sum = leftMax[i-1] + mid + rightMax[j+1];
                if(maxResult < sum){
                    maxResult = sum;
                    ans[0] = leftMaxIndex[i-1];
                    ans[1] = i-1;
                    ans[2] = rightMaxIndex[j+1];
                }
        }
        return ans;
    }
}

class Solution {
    public List<List<Integer>> findTriplets(int[] arr) {
        // Set to handle duplicates
        Set<List<Integer>> resSet = new HashSet<>();
        int n = arr.length;
        Map<Integer, List<int[]>> mp = new HashMap<>();

        // Store sum of all the pairs with their indices
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = arr[i] + arr[j];
                if (!mp.containsKey(sum)) {
                    mp.put(sum, new ArrayList<>());
                }
                mp.get(sum).add(new int[] {i, j});
            }
        }

        for (int i = 0; i < n; i++) {
            // Find remaining value to get zero sum
            int rem = -arr[i];
            if (mp.containsKey(rem)) {
                List<int[]> pairs = mp.get(rem);
                for (int[] p : pairs) {
                    // Ensure no two indices are same in triplet
                    if (p[0] != i && p[1] != i) {
                        List<Integer> curr = Arrays.asList(i, p[0], p[1]);
                        Collections.sort(curr);
                        resSet.add(curr);
                    }
                }
            }
        }

        return new ArrayList<>(resSet);
    }
}