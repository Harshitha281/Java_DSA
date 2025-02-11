//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.countOccurence(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to find all elements in array that appear more than n/k times.
    public int countOccurence(int[] arr, int k) {
        // your code here,return the answer
       int n = arr.length;
        if (k <= 0) return 0;

        // Step 1: Find potential candidates (at most k-1 elements)
        HashMap<Integer, Integer> candidates = new HashMap<>();
        for (int num : arr) {
            if (candidates.containsKey(num)) {
                candidates.put(num, candidates.get(num) + 1);
            } else if (candidates.size() < k - 1) {
                candidates.put(num, 1);
            } else {
                // Reduce all counts by 1
                List<Integer> toRemove = new ArrayList<>();
                for (int key : candidates.keySet()) {
                    candidates.put(key, candidates.get(key) - 1);
                    if (candidates.get(key) == 0) {
                        toRemove.add(key);
                 }
                }
                for (int key : toRemove) {
                    candidates.remove(key);
                }
            }
        }

        // Step 2: Verify actual occurrences of candidates
        HashMap<Integer, Integer> actualCount = new HashMap<>();
        for (int num : arr) {
            if (candidates.containsKey(num)) {
                actualCount.put(num, actualCount.getOrDefault(num, 0) + 1);
            }
        }

        // Step 3: Count elements that appear more than n/k times
        int count = 0;
        for (int freq : actualCount.values()) {
            if (freq > n / k) {
                count++;
            }
        }

        return count;
    }
}
