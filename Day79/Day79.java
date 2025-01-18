/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/


class Solution {
    private int bfs(List<List<int[]>> adj) {
        int n = adj.size();
        Deque<int[]> q = new ArrayDeque<>();
        q.offerFirst(new int[] { 0, 0 });
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[0] = 0;

        while (!q.isEmpty()) {
            int[] current = q.pollFirst();
            int curNode = current[0], curCost = current[1];

            for (int[] edge : adj.get(curNode)) {
                int nbr = edge[0], nbrCost = edge[1];
                if (curCost + nbrCost < dis[nbr]) {
                    dis[nbr] = curCost + nbrCost;
                    if (nbrCost == 0) {
                        q.offerFirst(new int[] { nbr, dis[nbr] });
                    } else {
                        q.offerLast(new int[] { nbr, dis[nbr] });
                    }
                }
            }
        }
        return dis[n - 1];
    }

    public int minCost(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n * m; i++) {
            adj.add(new ArrayList<>());
        }

        int nodeCnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == n - 1 && j == m - 1)
                    continue;

                if (j + 1 < m) {
                    if (grid[i][j] == 1) {
                        adj.get(nodeCnt).add(new int[] { nodeCnt + 1, 0 });
                    } else {
                        adj.get(nodeCnt).add(new int[] { nodeCnt + 1, 1 });
                    }
                }
                if (j - 1 >= 0) {
                    if (grid[i][j] == 2) {
                        adj.get(nodeCnt).add(new int[] { nodeCnt - 1, 0 });
                    } else {
                        adj.get(nodeCnt).add(new int[] { nodeCnt - 1, 1 });
                    }
                }
                if (i + 1 < n) {
                    if (grid[i][j] == 3) {
                        adj.get(nodeCnt).add(new int[] { nodeCnt + m, 0 });
                    } else {
                        adj.get(nodeCnt).add(new int[] { nodeCnt + m, 1 });
                    }
                }
                if (i - 1 >= 0) {
                    if (grid[i][j] == 4) {
                        adj.get(nodeCnt).add(new int[] { nodeCnt - m, 0 });
                    } else {
                        adj.get(nodeCnt).add(new int[] { nodeCnt - m, 1 });
                    }
                }
                nodeCnt++;
            }
        }

        return bfs(adj);
    }
}


class Solution {
    // Function to reverse a linked list.
    Node reverseList(Node head) {
        if (head == null) return null;

        // taking three pointers to store the current, previous and next nodes.
        Node prev = null;
        Node current = head;
        Node next = current.next;

        while (current != null) {
            // taking the next node as next.
            next = current.next;

            // storing the previous node in link part of current node.
            current.next = prev;

            // updating prev from previous node to current node.
            prev = current;

            // updating current node to next node.
            current = next;
        }

        return prev;
    }
}