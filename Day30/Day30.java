/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

class Solution {
  
    public int segregateArr(int[] arr) {
        int n = arr.length;
        int j = 0, i;
        for (i = 0; i < n; i++) {
            if (arr[i] <= 0) {
                
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
              
                j++;
            }
        }
        return j;
    }


    public int findMissingPositive(int[] arr, int st, int end) {
        
        for (int i = st; i < end; i++) {
            int val = Math.abs(arr[i]) + st - 1;
            if (val < end && arr[val] > 0) {
                arr[val] = -arr[val];
            }
        }

        for (int i = st; i < end; i++) {
            if (arr[i] > 0) {
             
                return i - st + 1;
            }
        }
        return end - st + 1;
    }

    // Function to find the smallest positive number missing from the array.
    public int missingNumber(int[] arr) {
        // first separating positive and negative numbers.
        int size = arr.length;
        int shift = segregateArr(arr);

        // shifting the array to access only positive part.
        // calling function to find result and returning it.
        return findMissingPositive(arr, shift, size);
    }
}

class Solution {
    private void updateDistances(List<List<Integer>> graph, int current, int[] distances) {
        int newDist = distances[current] + 1;
        
        for (int neighbor : graph.get(current)) {
            if (distances[neighbor] <= newDist) continue;
            
            distances[neighbor] = newDist;
            updateDistances(graph, neighbor, distances);
        }
    }
    
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int[] distances = new int[n];
        for (int i = 0; i < n; ++i) {
            distances[i] = n - 1 - i;
        }
        
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i + 1 < n; ++i) {
            graph.get(i + 1).add(i);
        }
        
        int[] answer = new int[queries.length];
        int queryIdx = 0;
        
        for (int[] query : queries) {
            int source = query[0];
            int target = query[1];
            
            graph.get(target).add(source);
            distances[source] = Math.min(distances[source], distances[target] + 1);
            updateDistances(graph, source, distances);
            
            answer[queryIdx++] = distances[0];
        }
        
        return answer;
    }
}
