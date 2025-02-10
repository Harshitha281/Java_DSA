//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java
import java.math.BigInteger;
class Solution {
    public static ArrayList<Integer> factorial(int n) {
        // code here
        BigInteger fact = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
        }
        
        // Convert the factorial to a string.
        String factStr = fact.toString();
        
        // Create an ArrayList and add each digit (converted from char to int).
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < factStr.length(); i++) {
            result.add(factStr.charAt(i) - '0');
        }
        
        return result;
    }
}

//{ Driver Code Starts.

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.factorial(N);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends