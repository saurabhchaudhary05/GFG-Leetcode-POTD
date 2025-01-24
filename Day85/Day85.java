/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

class Solution {
    // Function to check if the linked list has a loop.
    public static boolean detectLoop(Node head) {

        // using two pointers and moving one pointer(slow) by one node and
        // another pointer(fast) by two nodes in each iteration.
        Node fast = head.next;
        Node slow = head;

        while (fast != slow) {
            // if the node pointed by first pointer(fast) or the node
            // next to it is null, we return false.
            if (fast == null || fast.next == null) return false;

            fast = fast.next.next;
            slow = slow.next;
        }
        // if we reach here it means both the pointers fast and slow point to
        // same node which shows the presence of loop so we return true.
        return true;
    }
}


class Solution {
    public boolean DFS(int i, int visited[], int pathVisited[], int check[], int graph[][]){
        visited[i]=1;
        pathVisited[i]=1;
        check[i]=0;

        for(int node : graph[i]){
            if(visited[node]==0){
                if(DFS(node,visited,pathVisited,check,graph)) return true;
            }
            else if(pathVisited[node]==1){
                return true;
            }
        }

        pathVisited[i]=0;
        check[i]=1;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int visited[] = new int[graph.length];
        int pathVisited[] = new int[graph.length];
        int check[] = new int[graph.length];

        for(int i=0; i<visited.length; i++){
            if(visited[i]==0){
                DFS(i,visited,pathVisited,check,graph);
            }
        }
        List<Integer> safeNodes = new ArrayList<>();
        for(int i=0; i<check.length; i++){
            if(check[i]==1){
                safeNodes.add(i);
            }
        }

        return safeNodes;


    }
}