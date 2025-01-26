/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

class Solution {
    // Function to remove a loop in the linked list.
    public static void removeLoop(Node head) {
        // If list is empty or has only one node
        // without loop
        if (head == null || head.next == null) return;

        Node slow = head, fast = head;

        // Move slow and fast 1 and 2 steps
        // ahead respectively.
        slow = slow.next;
        fast = fast.next.next;

        // Search for loop using slow and fast pointers
        while (fast != null && fast.next != null) {
            if (slow == fast) break;

            slow = slow.next;
            fast = fast.next.next;
        }

        // If loop exists
        if (slow == fast) {
            slow = head;
            if (slow != fast) {
                while (slow.next != fast.next) {
                    slow = slow.next;
                    fast = fast.next;
                }

                // since fast->next is the looping point
                // remove loop
                fast.next = null;
            }
            // This case is added if fast and slow
            // pointer meet at first position.
            else {
                while (fast.next != slow) {
                    fast = fast.next;
                }
                fast.next = null;
            }
        }
    }
}


class Solution {
    public static int maximumInvitations(int[] favorite) {
        int n = favorite.length;

        // Step 1: Initialize arrays
        int[] ins = new int[n];  // Array to store in-degrees
        int[] queue = new int[n];  // Queue for topological sorting
        int[] deep = new int[n];  // Depth array to store chain lengths

        // Step 2: Count in-degrees
        for (int i = 0; i < n; i++) {
            ins[favorite[i]]++;
        }

        // Step 3: Process chains using topological sorting
        int l = 0, r = 0;  // Pointers for the queue
        for (int i = 0; i < n; i++) {
            if (ins[i] == 0) queue[r++] = i;  // Add nodes with in-degree 0
        }

        while (l < r) {
            int cur = queue[l++];  // Remove node from queue
            int next = favorite[cur];  // Follow the edge to the next node
            deep[next] = Math.max(deep[next], deep[cur] + 1);  // Update chain length
            if (--ins[next] == 0) {  // Reduce in-degree of the next node
                queue[r++] = next;
            }
        }

        // Step 4: Process cycles and calculate results
        int smallCircle = 0;  // Sum of lengths of chains and 2-cycles
        int bigCircle = 0;  // Maximum cycle length for larger cycles

        for (int i = 0; i < n; i++) {
            if (ins[i] != 0) {  // Node is part of a cycle
                ins[i] = 0;  // Mark node as visited
                int count = 1;  // Count the cycle size
                for (int j = favorite[i]; j != i; j = favorite[j]) {
                    count++;
                    ins[j] = 0;  // Mark all nodes in the cycle as visited
                }

                if (count == 2) {  // Special case: 2-cycle
                    smallCircle += deep[i] + deep[favorite[i]] + 2;
                } else {  // Larger cycles
                    bigCircle = Math.max(bigCircle, count);
                }
            }
        }

        return Math.max(bigCircle, smallCircle);  // Return the maximum result
    }
}