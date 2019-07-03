// Taruni Tangirala
public class fibo1
{
static long[] arr = new long[101];
public static void main(String[] args)
{
fibo(100);
 for (int i = 0; i<=92; i++)//long data type does not support numbers beyond the 92nd fibonacci number
{
   System.out.println( i +" = " + arr[i]);
}
}
public static void fibo(int n)
{
	arr[0] = 0;
	arr[1] = 1;
      for(int k = 2; k<=n; k++)
      { 
      arr[k] = arr[k-1]+arr[k-2];
      }  
   
}
}

 /* 
Last number reached before an hour when original program given in the problem is run:
54
*/