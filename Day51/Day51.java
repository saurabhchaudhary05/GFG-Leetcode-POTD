/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

class Solution {
    public int[] finalPrices(int[] prices) {
        int n=prices.length;
        Stack<Integer> st=new Stack();

        for(int i=n-1; i>=0; i--){
            
            while(!st.isEmpty() && st.peek()>prices[i]){
                st.pop();
            }
            
            // Get the discount from the stack or 0 if no valid discount
            int discount=st.isEmpty()?0:st.peek();
            
            // Push the original value before updating
            st.push(prices[i]);

            // Update the current price with the discount
            prices[i]-=discount;           
        }

        return prices;
    }
}

class Solution {
    // Function to check if the current minimum value is feasible or not.
    public static boolean isPossible(int[] arr, int n, int k, int curMin) {
        int studentsRequired = 1;
        int curSum = 0;

        // Iterating over all the books.
        for (int i = 0; i < n; i++) {
            // If current number of pages are greater than curMin, return false.
            if (arr[i] > curMin) return false;

            // Counting number of students required to distribute curMin pages.
            if (curSum + arr[i] > curMin) {
                // Incrementing student count and updating curSum.
                studentsRequired++;
                curSum = arr[i];

                // If students required becomes greater than the given number of
                // students, return false.
                if (studentsRequired > k) return false;
            } else {
                // Else updating curSum.
                curSum += arr[i];
            }
        }
        return true;
    }

    // Function to find the minimum number of pages.
    public static int findPages(int[] arr, int k) {
        int n = arr.length;
        int sum = 0;

        // Returning -1 if the number of books is less than the number of students.
        if (n < k) return -1;

        // Counting total number of pages.
        for (int i = 0; i < n; i++) sum += arr[i];

        // Initializing start as 0 pages and end as total pages.
        int start = 0;
        int end = sum;
        int ans = Integer.MAX_VALUE;

        while (start <= end) {
            int mid = (start + end) / 2;

            // Checking if it is possible to distribute books using mid as the current
            // minimum.
            if (isPossible(arr, n, k, mid)) {
                // If yes, then we find the minimum distribution.
                ans = Math.min(ans, mid);

                // As we are finding minimum and books are sorted, reducing end as end =
                // mid - 1.
                end = mid - 1;
            } else {
                // If not possible, pages should be increased so updating start = mid
                // + 1.
                start = mid + 1;
            }
        }
        // Returning minimum number of pages.
        return ans;
    }
}