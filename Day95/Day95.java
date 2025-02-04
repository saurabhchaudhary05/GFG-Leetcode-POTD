/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/


class Solution {
    int dia = 0;

    // Function to find the diameter of a Binary Tree.
    public int util(Node root) {
        // if node becomes null, we return 0.
        if (root == null) return 0;

        // calling the util function recursively for the left and
        // right subtrees to find their heights.
        int l = util(root.left);
        int r = util(root.right);

        // storing the maximum possible value of l+r+1 in diameter.
        if (l + r + 1 > dia) dia = l + r + 1;

        // returning height of subtree.
        return 1 + Math.max(l, r);
    }

    // Function to return the diameter of a Binary Tree.
    public int diameter(Node root) {
        // calling the function to find the result.
        util(root);
        // returning the result.
        return dia - 1;
    }
}



class Solution {
    public int maxAscendingSum(int[] nums) {
        int curr = nums[0], ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curr = nums[i] > nums[i - 1] ? curr + nums[i] : nums[i];
            ans = Math.max(ans, curr);
        }
        return ans;
    }
}