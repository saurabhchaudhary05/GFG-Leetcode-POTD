/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

class Solution {
   public static double  m=1e9+7;
    public static int solve(int low,int high,int z,int o,int y,int[] dp){
        if(high<y){
            return 0;
        }
        int d=0;
        if(dp[y]!=-1){
            return dp[y];
        }
        if(low<=y && y<=high){
           d=1;
        }
        int append_z=solve(low,high,z,o,y+z,dp);
        int append_o=solve(low,high,z,o,y+o,dp);
        return dp[y]=(int)((d+append_z+append_o)%m);
    }
    public int countGoodStrings(int low, int high, int zero, int one) {
        int z=zero;
        int o=one;
        int[] dp=new int[(int)1e5+1];
        Arrays.fill(dp,-1);
        return solve(low,high,z,o,0,dp);
    }
}

class Solution {
    public static int findUnion(int a[], int b[]) {
        // Using HashSet to store the elements.
        HashSet<Integer> s = new HashSet<>();

        // Insert all the elements of the first array into the HashSet.
        for (int i = 0; i < a.length; i++) {
            s.add(a[i]);
        }

        // Insert all the elements of the second array into the HashSet.
        // HashSet automatically handles duplicates.
        for (int i = 0; i < b.length; i++) {
            s.add(b[i]);
        }

        // Returning the size of the HashSet which is the total number
        // of unique elements in the union of both arrays.
        return s.size();
    }
}