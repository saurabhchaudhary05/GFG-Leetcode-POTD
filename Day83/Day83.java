/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

class Solution {
    // Function to reverse the linked list.
    static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        Node next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    // Function to add two numbers represented by linked list.
    static Node addTwoLists(Node num1, Node num2) {

        // reversing both lists to simplify addition.
        num1 = reverse(num1);
        num2 = reverse(num2);

        Node sum = null;
        int carry = 0;

        // using a loop till both lists and carry gets exhausted.
        while (num1 != null || num2 != null || carry > 0) {
            // using a variable to store sum of two digits along with carry.
            int newVal = carry;

            // if nodes are left in any list, we add their data in newVal.
            if (num1 != null) newVal += num1.data;
            if (num2 != null) newVal += num2.data;

            // updating carry.
            carry = newVal / 10;

            // using modulus to store only a single digit at that place.
            newVal = newVal % 10;

            // creating new node which gets connected with other nodes that
            // we get after calculating sum of respective digits.
            Node newNode = new Node(newVal);

            // storing the previously made nodes in the link part of new node.
            newNode.next = sum;
            // making the new node as the num1 node of all previously made node.
            sum = newNode;

            // moving ahead in both lists.
            if (num1 != null) num1 = num1.next;
            if (num2 != null) num2 = num2.next;
        }
        while (sum != null && sum.data == 0) {
            Node temp = sum.next;
            sum.next = null;
            sum = temp;
        }
        if (sum == null) return new Node(0);
        return sum;
    }
}


class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m=isWater.length;
        int n=isWater[0].length;

        // Initialize result matrix with same dimensions as input
        int[][] matrix=new int[m][n];

        // Queue to perform BFS
        Queue<int[]> que=new LinkedList<>();


        // Initialize matrix and queue
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(isWater[i][j]==1){
                    // Water cells have height 0 and are added to queue
                    que.add(new int[]{i,j});
                }
                else{
                    // Mark land cells as unvisited (-1)
                    matrix[i][j]=-1;
                }
            }
        }


        // Possible directions: right, left, down, up
        int[][] directions={ {0,1}, {0,-1}, {1,0}, {-1,0} };

        //BFS Traverse
        while(!que.isEmpty()){
            int[] arr=que.poll();
            int r=arr[0];
            int c=arr[1];

            // Check all adjacent cells
            for(int[] dir:directions){
                int nr=r+dir[0];
                int nc=c+dir[1];

                // If adjacent cell is within boundary and unvisited
                if(nr>=0 && nr<m && nc>=0 && nc<n && matrix[nr][nc]==-1){
                    // Set height to 1 more than current cell
                    matrix[nr][nc]=matrix[r][c]+1;  

                    // Add to queue for further exploration
                    que.add(new int[]{nr,nc});      
                } 
            }
        }

        return matrix;
    }
}