/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

class Solution {

    public int peakElement(int[] arr) {
        int n = arr.length;

        // If there is only one element, then it's a peak
        if (n == 1) return 0;

        // Check if the first element is a peak
        if (arr[0] > arr[1]) return 0;

        // Check if the last element is a peak
        if (arr[n - 1] > arr[n - 2]) return n - 1;

        // Search Space for binary Search
        int lo = 1, hi = n - 2;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            // If the element at mid is a
            // peak element return mid
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) return mid;

            // If next neighbor is greater, then peak
            // element will exist in the right subarray
            if (arr[mid] < arr[mid + 1]) lo = mid + 1;

            // Otherwise, it will exist in left subarray
            else
                hi = mid - 1;
        }

        return 0;
    }
}

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {        
        int n=classes.length;
        PriorityQueue<double[]> pq=new PriorityQueue<>((a,b)->Double.compare(b[0], a[0]));


        double sumVal=0;      
        double result=0;

        for(int i=0; i<n;  i++){
            double val1=(double)classes[i][0]/classes[i][1];
            double val2=(double)(classes[i][0]+1)/(classes[i][1]+1);
            double val=val2-val1;
            pq.add(new double[]{val, i});
            sumVal +=val1;
        }

       

        for(int j=0; j<extraStudents; j++){
            double[] que=pq.poll();
            double val=que[0];
            int i=(int)que[1];
            
            sumVal +=val;
            classes[i][0]+=1;
            classes[i][1]+=1;

            double val1=(double)classes[i][0]/classes[i][1];
            double val2=(double)(classes[i][0]+1)/(classes[i][1]+1);
            val=val2-val1;
            pq.add(new double[]{val, i});

            result=Math.max(result,sumVal);
        }

        return result/n;
    }
}

