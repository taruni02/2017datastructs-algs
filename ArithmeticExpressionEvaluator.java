import java.util.Scanner;
import java.util.Stack;

/**
 * author Taruni Tangirala
 */

public class ArithmeticExpressionEvaluator
{
	 private static Scanner scanner;
	 static Stack<String> stack = new Stack<String>();

	public static void main(String args[])
	{
	    Scanner scanner = new Scanner(System.in);
		 Scanner s = scanner.useDelimiter("\\s*");
	    String c = s.nextLine();
	    System.out.println(evaluatePostfix(infixToPostfix(c)));
	      
	}
	    
	public static String infixToPostfix(String inp )
	{ 
	    String outp = "";
	    String temp;
       boolean number = false;
       int num = 0;
	    for (int i = 0; i< inp.length(); i++)
	    {

	    // System.out.println("Inp="+inp+" i= "+i+" char="+inp.charAt(i));
	    	
	     if (Character.isDigit(inp.charAt(i)))
        {
            number = true;
            num = num*10 + (Character.getNumericValue(inp.charAt(i)));
		  } 
	     else
        { 
        if (number)
        {
            number = false;
            outp += String.valueOf(num)+" ";
            num = 0;
        }
        if (inp.substring(i,i+1).equals(")")) 
	     {
	         temp = stack.pop();
            //System.out.println("Popped="+temp);
	         while (!(temp.equals("(")))
	         {     
               outp = outp + temp+ " ";
	            temp=stack.pop();
                     //System.out.println("Popped="+temp);
	         }
        }
	     else if (inp.substring(i,i+1).equals("+")) stack.push(inp.substring(i,i+1));
	     else if (inp.substring(i,i+1).equals("*")) stack.push(inp.substring(i,i+1));
	     else if (inp.substring(i,i+1).equals("/")) 
        {
            if (!stack.empty())
            {
               temp = stack.pop();
               if (temp.equals("*")) outp = outp + temp + " ";
               else stack.push(temp);
            }
        stack.push(inp.substring(i,i+1));
        }
	     else if (inp.substring(i,i+1).equals("-")) stack.push(inp.substring(i,i+1));
	     else if (inp.substring(i,i+1).equals("(")) stack.push(inp.substring(i,i+1));
	     else outp = outp + inp.charAt(i);   
	     }
	     }
	     while (!(stack.empty()))
	     {       
            temp = stack.pop();
            outp = outp + temp + " ";
	     }
        System.out.println("Returning ="+outp);
   	  return outp;
   }

public static long evaluatePostfix(String postfix)
	{
      Stack<String> stack1 = new Stack<String>();
      long j = 0;
      String temp = "";
      String[] parts = postfix.split(" ");
      for (String s:parts)
      {
         if(!(s.equals("+")|| s.equals("/") || s.equals("*") || s.equals("-")))
      {
  
      stack1.push(s);
      }
      else 
      if (s.equals("+"))
      {
      j = Integer.parseInt(stack1.pop()) + Integer.parseInt(stack1.pop());
      stack1.push(String.valueOf(j));
      }
      else if (s.equals("*"))
      {
      j = Integer.parseInt(stack1.pop()) * Integer.parseInt(stack1.pop());
      stack1.push(String.valueOf(j));   
      }
      else if (s.equals("-"))
      {
      j = -Integer.parseInt(stack1.pop()) + Integer.parseInt(stack1.pop());
      stack1.push(String.valueOf(j));   
      }
      else if (s.equals("/"))
      {
      j = Integer.parseInt(stack1.pop());
      j= Integer.parseInt(stack1.pop())/j;
      stack1.push(String.valueOf(j));   
      }

      }

	   return j;
   }


}
	

