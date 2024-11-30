/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

class Solution {
    public int[][] validArrangement(int[][] pairs) {
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        Map<Integer, Integer> inOutDegree = new HashMap<>();
        
        // Build graph and count in/out degrees
        for (int[] pair : pairs) {
            adjacencyList.computeIfAbsent(pair[0], k -> new ArrayList<>()).add(pair[1]);
            inOutDegree.merge(pair[0], 1, Integer::sum);  // out-degree
            inOutDegree.merge(pair[1], -1, Integer::sum);  // in-degree
        }
        
        // Find starting node
        int startNode = pairs[0][0];
        for (Map.Entry<Integer, Integer> entry : inOutDegree.entrySet()) {
            if (entry.getValue() == 1) {
                startNode = entry.getKey();
                break;
            }
        }
        
        List<Integer> path = new ArrayList<>();
        Deque<Integer> nodeStack = new ArrayDeque<>();
        nodeStack.push(startNode);
        
        while (!nodeStack.isEmpty()) {
            List<Integer> neighbors = adjacencyList.getOrDefault(nodeStack.peek(), new ArrayList<>());
            if (neighbors.isEmpty()) {
                path.add(nodeStack.pop());
            } else {
                int nextNode = neighbors.get(neighbors.size() - 1);
                nodeStack.push(nextNode);
                neighbors.remove(neighbors.size() - 1);
            }
        }
        
        int pathSize = path.size();
        int[][] arrangement = new int[pathSize - 1][2];
        
        for (int i = pathSize - 1; i > 0; --i) {
            arrangement[pathSize - 1 - i] = new int[]{path.get(i), path.get(i-1)};
        }
        
        return arrangement;
    }
} 



class Solution {
    // Function is to check whether two strings are anagram of each other or not.
    public static boolean areAnagrams(String str1, String str2) {
        int h1[] = new int[26];
        Arrays.fill(h1, 0);

        // an array of size 26, to store count of characters.
        if (str1.length() != str2.length()) {
            return false;
        }

        // storing count of each character in the first string.
        for (int i = 0; i < str1.length(); i++) {
            h1[str1.charAt(i) - 'a']++;
        }

        // decrementing the count of characters encountered in the second string.
        for (int i = 0; i < str2.length(); i++) {
            h1[str2.charAt(i) - 'a']--;
        }

        // iterating over the array to check if count at every index is 0 or not.
        for (int i = 0; i < 26; i++) {
            if (h1[i] != 0) {
                return false;
            }
        }
        // returning the result.
        return true;
    }
}