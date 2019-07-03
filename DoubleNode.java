//Taruni Tangirala
public class DoubleNode {
	 private Node next;
	 private Node prev;
	 private static int s;
	
public static void main (String args[])
	 {
		 DoubleNode x = new DoubleNode();
		 x.insertBeg("inserting from beginning");
       System.out.println(x);
		 x.insertEnd("inserting from end");
       System.out.println(x);
		 x.insBefore("inserting before", 0);
       System.out.println(x);
       x.insAfter("inserting after second element", 1);
       System.out.println(x);

             
             
         
	 }

private class Node 
	 {

	     String info;
	     Node next;
	     Node prev;

	     public Node() 
	     {
	       String a = "";
	     }

	     public Node(String info)
	     {
	         this.info = info;
	     }
	 }

	   

public DoubleNode()
	    {
	        this.s = 0;
	    }

public void insertBeg(String x) {
      Node temp;
       temp = this.prev;
	        while (!(temp ==null)) temp = temp.prev;

	        Node t = new Node(x);
	        if (next == null) {
	            next = t;
	            prev = null;
	        } else {
	            t.next = next;
	            next.prev = t;
	            next = t;
	        }
	        s++;
	    }

public void insertEnd(String x)
	    {
       Node temp;
       temp = this.next;
	        while (temp.next != null) temp = temp.next;
           
           Node t = new Node(x);
	        temp.next = t;
	            t.prev = temp;	        
	        s++;
	    }
	   
public void removeBeg() 
	    {
	    	 	this.prev.next = this.next;
            this.next.prev = this.prev;
	         this.next.prev = null;
            this.next.next = null;
	            s--;
        }

public void removeEnd()
		{
	 		prev = prev.prev;
	 		prev.next = null;
	 		s--;	
		}
	  

public void insBefore(String info, int in) 
	    {
	       Node t = new Node(info);
	       if (in == 0) 
	       {
	            insertBeg(info);
	        } 
	       else if (in == s) 
	       {
	            insertEnd(info);
	       }
	       else 
	       {
	            Node current = next;
	            for (int i = 0; i < in; i++) 
	            {
	                current = current.next;
	            }
	            Node previous = current.prev;
	            previous.next = t; t.prev = previous; t.next = current;  current.prev = t;
	            s++;
	        }
	    }
	    
public void insAfter(String info, int in) 
	    {
	       Node t = new Node(info);
	       if (in == 0) 
	       {
	            insertBeg(info);
	        } 
	       else if (in == s) 
	       {
	            insertEnd(info);
	       }
	       else 
	       {
	            Node current = next;
	            for (int i = 0; i < in; i++) 
	            {
	                current = current.next;
	            }
	            Node next1 = current.next;
	            next1.next = t; 
               t.next = next1; 
               t.prev = current; 
               current.next = t;
	            s++;
	        }
	    }
	    

public void remove(int in) 
	    {
	    	if (in == 0) 
	        {
	            next = next.next;
	            next.prev = null;
	            s--;
	        } 
	        else if (in == s - 1) 
	        {
	            prev = prev.prev;
	            prev.next = null;
	            s--;
	        }
	        else
	        {
	            Node current = next;
	            for (int i = 0; i < in; i++) 
	            {
	                current = current.next;
	            }
	            Node previous = current.prev;
	            Node next = current.next;
	            previous.next = current.next;
	            next.prev = previous;
	            s--;
	        }
	    }

public void moveFront( )
		{	
			int n= -1;
		Node t = this.prev.next;
			Node current = next;
			for (int i = 0; i < s; i++) 
            {
				   current = current.next;
				   if ((current.equals(t))||(current == t))
					n = i;
            }
         if(n>0)
			remove(n);
			insertBeg(t.info);
		}

public void moveBack( )
{	
	int n = -1;
	Node t = this.prev.next;
	Node current = next;
	for (int i = 0; i < s; i++) 
    {
		current = current.next;
		if ((current.equals(t))||(current == t))
			n = i;
    }
   if(n>0)
	remove(n);
	insertEnd(t.info);
}


}
	
	

