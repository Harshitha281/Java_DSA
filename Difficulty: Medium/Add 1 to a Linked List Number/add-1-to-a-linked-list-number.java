//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class GfG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(str[i]));
                tail = tail.next;
            }
            Solution obj = new Solution();
            head = obj.addOne(head);
            printList(head);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution {
    public Node addOne(Node head) {
        // code here.
        head = reverse(head);
        
        // Step 2: Add 1 to the number
        Node temp = head;
        int carry = 1; // We need to add 1 initially
        
        while (temp != null) {
            temp.data += carry;
            if (temp.data < 10) {
                carry = 0; // No further carry needed
                break;
            } else {
                temp.data = 0; // Reset to 0 (carry propagates)
                carry = 1; // Carry over to next digit
            }
            // If at the last node and carry is still 1, add a new node
            if (temp.next == null && carry == 1) {
                temp.next = new Node(1);
                carry = 0;
            }
            temp = temp.next;
        }

        // Step 3: Reverse the linked list back to original order
        return reverse(head);
    }
    public  Node reverse(Node head) {
        Node prev = null, curr = head;
        while (curr != null) {
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
}