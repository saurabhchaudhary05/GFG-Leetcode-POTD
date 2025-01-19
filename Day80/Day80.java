/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

import java.util.PriorityQueue;

class Solution {
    public int trapRainWater(int[][] height) {
        int n = height.length;
        int m = height[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[][] vis = new boolean[n][m];

        // Add first and last column
        for (int i = 0; i < n; i++) {
            vis[i][0] = true;
            vis[i][m - 1] = true;
            pq.offer(new int[]{height[i][0], i, 0});
            pq.offer(new int[]{height[i][m - 1], i, m - 1});
        }

        // Add first and last row
        for (int i = 0; i < m; i++) {
            vis[0][i] = true;
            vis[n - 1][i] = true;
            pq.offer(new int[]{height[0][i], 0, i});
            pq.offer(new int[]{height[n - 1][i], n - 1, i});
        }

        int ans = 0;
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, -1, 0, 1};

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int h = curr[0], r = curr[1], c = curr[2];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && !vis[nr][nc]) {
                    ans += Math.max(0, h - height[nr][nc]);
                    pq.offer(new int[]{Math.max(h, height[nr][nc]), nr, nc});
                    vis[nr][nc] = true;
                }
            }
        }

        return ans;
    }
}




class Solution {
    // Function to rotate a linked list.
    public Node rotate(Node head, int k) {
        // If the linked list is empty or no rotations are
        // needed, then return the original linked list
        if (k == 0 || head == null) return head;

        Node curr = head;
        int len = 1;

        // Find the length of linked list
        while (curr.next != null) {
            curr = curr.next;
            len += 1;
        }

        // Modulo k with length of linked list to handle
        // large values of k
        k %= len;

        if (k == 0) return head;

        // Make the linked list circular
        curr.next = head;

        // Traverse the linked list to find the kth node
        curr = head;
        for (int i = 1; i < k; i++) curr = curr.next;

        // Update the (k + 1)th node as the new head
        head = curr.next;

        // Break the loop by updating next pointer of kth node
        curr.next = null;
        return head;
    }
}