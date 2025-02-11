//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // Read first array
            String input = br.readLine();
            String[] inputArray = input.split(" ");
            int[] arr = Arrays.stream(inputArray).mapToInt(Integer::parseInt).toArray();

            Solution ob = new Solution();
            int res = ob.longestConsecutive(arr);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {

    // Function to return length of longest subsequence of consecutive integers.
    public int longestConsecutive(int[] arr) {
        // code here
        int n=arr.length;
        int longest=1;
        Set<Integer> res=new HashSet<>();
        //to store array elements into the set
        for(int i=0;i<n;i++)
        {
            res.add(arr[i]);
        }
        //then we iterate through the hashset and finding the subsequence
        for(int ele:res)
        {
            if(!res.contains(ele-1))
            {
                int val=ele;
                int count=1;
                while(res.contains(val+1))
                {
                    val=val+1;
                    count=count+1;
                }
                longest=Math.max(longest,count);
            }
            
        }
        return longest;
    }
}