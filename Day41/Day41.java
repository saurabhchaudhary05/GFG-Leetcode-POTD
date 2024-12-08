/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

import java.util.*;

class Solution {
    public int maxTwoEvents(int[][] events) {
        int n = events.length;
        
        // Step 1: Sort the events by their start time
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        
        // Step 2: Create the suffix array for the maximum event value from each event onward
        int[] suffixMax = new int[n];
        suffixMax[n - 1] = events[n - 1][2];  // Initialize the last event's value
        
        // Populate the suffixMax array
        for (int i = n - 2; i >= 0; --i) {
            suffixMax[i] = Math.max(events[i][2], suffixMax[i + 1]);
        }
        
        // Step 3: For each event, find the next event that starts after it ends
        int maxSum = 0;
        
        for (int i = 0; i < n; ++i) {
            int left = i + 1, right = n - 1;
            int nextEventIndex = -1;
            
            // Perform binary search to find the next non-overlapping event
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (events[mid][0] > events[i][1]) {
                    nextEventIndex = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            
            // If a valid next event is found, update the max sum
            if (nextEventIndex != -1) {
                maxSum = Math.max(maxSum, events[i][2] + suffixMax[nextEventIndex]);
            }
            
            // Also consider the case where we take only the current event
            maxSum = Math.max(maxSum, events[i][2]);
        }
        
        return maxSum;
    }
}


class Solution {
    public List<int[]> mergeOverlap(int[][] arr) {
        // If there are no arr, return an empty list
        if (arr.length == 0) {
            return new ArrayList<>();
        }

        // Sort arr based on the start time
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        // List to hold the merged arr
        List<int[]> mergedarr = new ArrayList<>();

        // Start with the first interval
        int[] currentInterval = arr[0];
        mergedarr.add(currentInterval);

        for (int[] interval : arr) {
            int currentStart = currentInterval[0];
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if (currentEnd >= nextStart) {
                // There is overlap, so merge the arr
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                // No overlap, add the new interval to the list
                currentInterval = interval;
                mergedarr.add(currentInterval);
            }
        }

        return mergedarr;
    }
}
