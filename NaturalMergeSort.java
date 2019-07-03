// Java program to illustrate merge sorted
// of linkedList
 
public class NaturalMergeSort 
{
    Node head = null;
    // Node a,b;
    static class Node 
    {
        int val;
        Node next;
 
        public Node(int val) 
        {
            this.val = val;
        }
    }
     
    Node sortedMerge(Node a, Node b) 
    {
        Node result = null;
        /* Base cases */
        if (a == null)
            return b;
        if (b == null)
            return a;
 
        /* Pick either a or b, and recur */
        if (a.val <= b.val) 
        {
            result = a;
            result.next = sortedMerge(a.next, b);
        } 
        else
        {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
 
    }
 
    Node mergeSort(Node h) 
    {
        // Base case : if head is null
        if (h == null || h.next == null)
        {
            return h;
        }
 
        // get the middle of the list
        Node middle = getMiddle(h);
        Node nextofmiddle = middle.next;
 
        // set the next of middle Node to null
        middle.next = null;
 
        // Apply mergeSort on left list
        Node left = mergeSort(h);
 
        // Apply mergeSort on right list
        Node right = mergeSort(nextofmiddle);
 
        // Merge the left and right lists
        Node sortedlist = sortedMerge(left, right);
        return sortedlist;
    }
// System.out.println("Len="+len);
/* for (int sz = 1; sz < len; sz =2*sz) // sz = sub list size
   for (int lo = 0; lo < len-sz; lo+=sz*2) //lo : sub list index
      merge(h, lo, lo+sz-1, Math.min(lo+sz+sz-1, len -1));
*/  
    // Utility function to get the middle of the linked list
    Node getMiddle(Node h) 
    {
        //Base case
        if (h == null)
            return h;
        Node fastptr = h.next;
        Node slowptr = h;
         
        // Move fastptr by two and slow ptr by one
        // Finally slowptr will point to middle Node
        while (fastptr != null)
        {
            fastptr = fastptr.next;
            if(fastptr!=null)
            {
                slowptr = slowptr.next;
                fastptr=fastptr.next;
            }
        }
        return slowptr;
 /*        int half = h.length();
         if (half <= 1) return h;
         half = half/2;
         Node mid = h;
//         System.out.println(half);
         for (int i = 0; i < half; i++)
             mid = mid.next;
//         printList(mid);
         return mid; */
    }
 
    void push(int new_data) 
    {
        /* allocate Node */
        Node new_node = new Node(new_data);
 
        /* link the old list off the new Node */
        new_node.next = head;
 
        /* move the head to point to the new Node */
        head = new_node;
    }
 
    // Utility function to print the linked list
    void printList(Node headref) 
    {
        while (headref != null) 
        {
            System.out.print(headref.val + " ");
            headref = headref.next;
        }
    }
     
    public static void main(String[] args) 
    {
 
        NaturalMergeSort li = new NaturalMergeSort();
        /*
         * Let us create a unsorted linked lists to test the functions Created
         * lists shall be a: 2->3->20->5->10->15
         */
        li.push(15);
        li.push(10);
        li.push(5);
        li.push(20);
        li.push(3);
        li.push(2);
        System.out.println("Linked List without sorting is :");
        li.printList(li.head);
 
        // Apply merge Sort
        li.head = li.mergeSort(li.head);
        System.out.print("\n Sorted Linked List is: \n");
        li.printList(li.head);
    }
}