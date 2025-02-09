//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    void nextPermutation(int[] arr) {
        // code here
        int n=arr.length;
        int ind=-1;
        for(int i=n-2;i>=0;i--)
        {
            if(arr[i]<arr[i+1])
            {
                ind=i;
                break;
            }
        }
        if(ind!=-1)
        {
        for(int i=n-1;i>=ind;i--)
        {
            if(arr[i]>arr[ind])
            {
                swap(arr,i,ind);
                break;
            }
        }
        }
    
          reverse(arr,ind+1,n-1);
        
    }
    public void swap(int arr[],int i,int j)
    {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public void reverse(int arr[],int s,int e)
    {
        while(s<e)
        {
            swap(arr,s,e);
            s++;
            e--;
        }
    }
}

//{ Driver Code Starts.

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine()); // Number of test cases
        while (tc-- > 0) {
            String[] inputLine = br.readLine().split(" ");
            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int N = arr.length;
            Solution ob = new Solution();
            ob.nextPermutation(arr); // Generate the next permutation
            StringBuilder out = new StringBuilder();
            for (int i = 0; i < N; i++) {
                out.append(arr[i] + " "); // Corrected: use arr[i] instead of arr.get(i)
            }
            System.out.println(out.toString().trim()); // Print the output

            System.out.println("~");
        }
    }
}
// } Driver Code Ends