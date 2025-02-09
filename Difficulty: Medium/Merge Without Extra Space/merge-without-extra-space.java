//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases

        while (t-- > 0) {
            String arr1[] = br.readLine().trim().split(" ");
            String arr2[] = br.readLine().trim().split(" ");

            int a[] = new int[arr1.length];
            int b[] = new int[arr2.length];

            for (int i = 0; i < a.length; i++) a[i] = Integer.parseInt(arr1[i]);
            for (int i = 0; i < b.length; i++) b[i] = Integer.parseInt(arr2[i]);

            Solution ob = new Solution();
            ob.mergeArrays(a, b);

            StringBuffer str = new StringBuffer();
            for (int i = 0; i < a.length; i++) {
                str.append(a[i] + " ");
            }
            System.out.println(str);
            str = new StringBuffer();
            for (int i = 0; i < b.length; i++) {
                str.append(b[i] + " ");
            }
            System.out.println(str);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to merge the arrays.
    public void mergeArrays(int a[], int b[]) {
        // code here
         int n = a.length, m = b.length;
        int gap = (n + m) / 2 + (n + m) % 2; // Ceil function without using Math.ceil()

        while (gap > 0) {
            int i = 0, j = gap;

            // Compare elements within a[]
            while (j < n) {
                if (a[i] > a[j]) {
                    swap(a, i, j);
                }
                i++;
                j++;
            }

            // Compare elements between a[] and b[]
            j = j - n;
            while (i < n && j < m) {
                if (a[i] > b[j]) {
                    swap(a, b, i, j);
                }
                i++;
                j++;
            }

            // Compare elements within b[]
            i = 0;
            while (j < m) {
                if (b[i] > b[j]) {
                    swap(b, i, j);
                }
                i++;
                j++;
            }

            // Reduce the gap
            if (gap == 1) break;
            gap = (gap / 2) + (gap % 2); // Ceil(gap/2)
    }
}
    public  void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
     public  void swap(int[] a, int[] b, int i, int j) {
        int temp = a[i];
        a[i] = b[j];
        b[j] = temp;
    }

}
