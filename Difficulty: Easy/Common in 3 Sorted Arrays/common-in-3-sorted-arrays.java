//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

public class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            List<Integer> brr = new ArrayList<>();
            List<Integer> crr = new ArrayList<>();

            String input1 = sc.nextLine();
            Scanner ss1 = new Scanner(input1);
            while (ss1.hasNextInt()) {
                arr.add(ss1.nextInt());
            }

            String input2 = sc.nextLine();
            Scanner ss2 = new Scanner(input2);
            while (ss2.hasNextInt()) {
                brr.add(ss2.nextInt());
            }

            String input3 = sc.nextLine();
            Scanner ss3 = new Scanner(input3);
            while (ss3.hasNextInt()) {
                crr.add(ss3.nextInt());
            }

            Solution ob = new Solution();
            List<Integer> res = ob.commonElements(arr, brr, crr);

            if (res.size() == 0) System.out.print(-1);
            for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            System.out.println();
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find common elements in three arrays.
    public List<Integer> commonElements(List<Integer> arr1, List<Integer> arr2,
                                        List<Integer> arr3) {
        // Code Here
        List<Integer> result=new ArrayList<>();
        int n1=arr1.size();
        int n2=arr2.size();
        int n3=arr3.size();
        int i=0,j=0,k=0;
        while(i<n1 && j<n2 && k<n3)
        {
            if(i>0 && arr1.get(i-1).equals(arr1.get(i)))
            {
                i++;
                continue;
            }
            if(arr1.get(i).equals(arr2.get(j)) && arr2.get(j).equals(arr3.get(k)))
            {
                result.add(arr1.get(i));
                i++;
                j++;
                k++;
            }
            else if(arr1.get(i).compareTo(arr2.get(j))<0)
            {
                i++;
            }
            else if(arr2.get(j).compareTo(arr3.get(k))<0)
            {
                j++;
            }
            else
            {
                k++;
            }
        }
        return result;
    }
}