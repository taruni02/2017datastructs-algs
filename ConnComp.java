// output: Number of connected components: 25
import java.util.*;
import java.io.*;
public class ConnComp{
   static int arr [][];
   static boolean[] marked;     
   static int[] id;             
   static int count;            
   final static int N = 50;
   public static void main (String args[]) throws IOException
   {
      marked = new boolean[N];
      id = new int[N];
      Scanner s = new Scanner(new File("inputfile.txt"));
      arr = new int[N][N];
      for(int x = 0; x<N;x++)
      {
         int a = s.nextInt();int b = s.nextInt();
         arr[a][b] = 1;
         arr[b][a] = 1;
         arr[a][a] = 1;
         arr[b][b] = 1;
      }
      boolean done = false;
      int numcc = 0;
      int a = 49;
      for(int v= 0; v<N; v++)
      {
         if (!marked[v]) {
                dfs(v);
                count++;}
         for(int i = 0; i<N; i++)
         {
            if (marked[i] == true) {i = N-1;done = false;}
            else {done= true;}
         }
         if(done) continue;
       }
            
   System.out.println("Number of connected components: " + count);
   }
   public static void dfs(int v)
   {
         marked[v] = true;
         id[v] = count;
        
         for(int j = 0; j<N; j++)
         {
            if((arr[v][j] ==1)&&(!marked[j])) dfs(j);
         }
    }}        
            
         
