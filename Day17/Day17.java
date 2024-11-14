/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

class Solution {
    public void nearlySorted(int[] arr, int k) {
        int num = arr.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i <= k && i < num; i++) {
            pq.add(arr[i]);
        }

        int id = 0;
        for (int i = k + 1; i < num; i++) {
            arr[id++] =
                pq.poll(); 
            pq.add(arr[i]); 
        }

        while (!pq.isEmpty()) {
            arr[id++] = pq.poll(); 
        }
    }
}

class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int low = 1, high = Arrays.stream(quantities).max().getAsInt();
        while (low < high) {
            int mid = (low + high) / 2, needed = 0;
            for (int q : quantities) needed += (q + mid - 1) / mid;
            if (needed <= n) high = mid;
            else low = mid + 1;
        }
        return low;
    }
}