/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

class Solution {
    public Node cloneLinkedList(Node head) {
        if (head == null) {
            return null;
        }

        // Step 1: Create new nodes and insert them next to the original nodes
        Node curr = head;
        while (curr != null) {
            Node newNode = new Node(curr.data);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }

        // Step 2: Set the random pointers of the new nodes
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Step 3: Separate the new nodes from the original nodes
        curr = head;
        Node clonedHead = head.next;
        Node clone = clonedHead;
        while (clone.next != null) {
            curr.next = curr.next.next;
            clone.next = clone.next.next;
            curr = curr.next;
            clone = clone.next;
        }
        curr.next = null;
        clone.next = null;

        return clonedHead;
    }
}

class Solution {
    public int countServers(int[][] grid) {
        int[] Rows = new int[grid.length];
        int[] Col = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                Rows[i] += grid[i][j];
                Col[j] += grid[i][j];
            }
        }
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && (Rows[i] > 1 || Col[j] > 1)) {
                    ans++;
                }
            }
        }
        return ans;
    }
}