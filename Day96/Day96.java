/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/


class Solution {
    // Function to convert a binary tree into its mirror tree.
    void mirror(Node node) {
        if (node == null) return;
        Node temp;

        // calling mirror function recursively for left and right subtrees.
        mirror(node.left);
        mirror(node.right);

        // swapping the left and right subtree.
        temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}


class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int i=-1, j=-1;
        int cnt=0;

        for(int k=0; k<s1.length(); k++){
            if(s1.charAt(k)!=s2.charAt(k)){
                cnt++;
                if(i==-1) i=k;
                else if(j==-1) j=k;
            }
        }

        if(cnt==0) return true;
        else if(cnt==2 && s1.charAt(i)==s2.charAt(j) && s1.charAt(j)==s2.charAt(i)){
            return true;
        }


        return false;
    }
}