/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        int[] arr=new int[10001];
        for(int i=0; i<banned.length; i++){
            arr[banned[i]]=1;
        }

        long sum=0;
        int cnt=0;
        for(int i=1; i<=n; i++){
            if(arr[i]==1){continue;}
            sum+=i;
            if(sum>maxSum){
               break;
            }
            cnt++;
        }

        return cnt;
    }
}

class Solution {
    public int hIndex(int[] citations) {
        // Get the total number of papers
        int papers = citations.length;
        // Create an array to store the count of citations in each bucket
        int[] citationBuckets = new int[papers + 1];

        // Count the number of papers in each bucket
        for (int citation : citations) {
            citationBuckets[Math.min(citation, papers)]++;
        }

        // Calculate the cumulative number of papers
        int cumulativePapers = 0;
        // Iterate from the highest possible h-index to 0
        for (int hIndex = papers; hIndex >= 0; hIndex--) {
            cumulativePapers += citationBuckets[hIndex];
            // Check if the current h-index is satisfied
            if (cumulativePapers >= hIndex) {
                return hIndex;
            }
        }
        // Return 0 if no valid h-index is found
        return 0;
    }
}