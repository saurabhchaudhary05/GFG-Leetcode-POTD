/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

class Solution {
    // Function to return the level order traversal of a tree.
    public ArrayList<ArrayList<Integer>> levelOrder(Node root) {
        if (root == null) return new ArrayList<>();

        // Create an empty queue for level order traversal
        Queue<Node> q = new LinkedList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        // Enqueue Root
        q.add(root);
        int currLevel = 0;

        while (!q.isEmpty()) {
            int len = q.size();
            res.add(new ArrayList<>());

            for (int i = 0; i < len; i++) {
                // Add front of queue and remove it from queue
                Node node = q.poll();
                res.get(currLevel).add(node.data);

                // Enqueue left child
                if (node.left != null) q.add(node.left);

                // Enqueue right child
                if (node.right != null) q.add(node.right);
            }
            currLevel++;
        }
        return res;
    }
}


class Solution {
    public boolean check(int[] nums) {
        int count = 0, n = nums.length;
        for (int i = 0; i < n; i++) 
            if (nums[i] > nums[(i+1) % n] && ++count > 1) return false;
        return count <= 1;
    }
}