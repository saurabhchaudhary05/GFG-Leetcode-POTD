/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

class Solution {
    public long gridGame(int[][] grid) {
        long minResult = Long.MAX_VALUE;
        long row1Sum = 0;
        for (int i = 0; i < grid[0].length; ++i) {
            row1Sum += grid[0][i];
        }
        long row2Sum = 0;

        for (int i = 0; i < grid[0].length; ++i) {
            row1Sum -= grid[0][i];
            minResult = Math.min(minResult, Math.max(row1Sum, row2Sum));
            row2Sum += grid[1][i];
        }

        return minResult;
    }
}


class Solution {
    public static Node reverseKGroup(Node head, int k) {
        if (head == null) {
            return head;
        }

        Node curr = head;
        Node newHead = null;
        Node tail = null;

        while (curr != null) {
            Node groupHead = curr;
            Node prev = null;
            Node nextNode = null;
            int count = 0;

            // Reverse the nodes in the current group
            while (curr != null && count < k) {
                nextNode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextNode;
                count++;
            }

            // If newHead is null, set it to the
            // last node of the first group
            if (newHead == null) {
                newHead = prev;
            }

            // Connect the previous group to the
            // current reversed group
            if (tail != null) {
                tail.next = prev;
            }

            // Move tail to the end of the
            // reversed group
            tail = groupHead;
        }

        return newHead;
    }
}