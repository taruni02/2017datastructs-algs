//Taruni Tangirala
import java.util.*;

public class BinSearchClient
{
   static int[] arr1 = new int [1000];
   static int[] arr2 = new int [1000];
   static int[] arr3 = new int [10000];
   static int[] arr4 = new int [10000];
   static int[] arr5 = new int [100000];
   static int[] arr6 = new int [100000];
   static int[] arr7 = new int [1000000];
   static int[] arr8 = new int [1000000];
   static int c1, c1tot = 0;
   static int c2, c2tot = 0;
   static int c3, c3tot =0;
   static int c4, c4tot = 0;
   
   public static void main(String [] args)
   {
      Scanner s = new Scanner(System.in);
      int t = s.nextInt();
      int[][] counts = new int[t][4];
      for (int i = 0; i < t; i++)
      {
      c1=c2=c3=c4=0;
      gen();
      search1();
      counts[i][0]= c1;
      counts[i][1]= c2;
      counts[i][2]= c3;
      counts[i][3]= c4;
      System.out.println("Trials = " + t);
      System.out.println("Run = "+i+" 10^3: "+c1);
      System.out.println("Run = "+i+" 10^4: "+c2);
      System.out.println("Run = "+i+" 10^5: "+c3);
      System.out.println("Run = "+i+" 10^6: "+c4);
      c1tot +=c1;
      c2tot +=c2;
      c3tot +=c3;
      c4tot +=c4;

      }
      c1 =c1tot/t;
      c2 =c2tot/t;
      c3 =c3tot/t;
      c4 =c4tot/t;
      System.out.println("Average counts:");
      System.out.println(" 10^3=> "+c1);
      System.out.println(" 10^4=> "+c2);
      System.out.println(" 10^5=> "+c3);
      System.out.println(" 10^6=> "+c4);
      
   }

   public static void gen()
   {
      
      for(int i = 0; i<1000; i++)
      { 
         arr1[i] = (int)(Math.random()*899999) + 100000;
         arr2[i] = (int)(Math.random()*899999) + 100000;
      }

      for(int i = 0; i<10000; i++)
      { 
         arr3[i] = (int)(Math.random()*899999) + 100000;
         arr4[i] = (int)(Math.random()*899999) + 100000;
      }

      for(int i = 0; i<100000; i++)
      { 
         arr5[i] = (int)(Math.random()*899999) + 100000;
         arr6[i] = (int)(Math.random()*899999) + 100000;
      }

      for(int i = 0; i<1000000; i++)
      { 
         arr7[i] = (int)(Math.random()*899999) + 100000;
         arr8[i] = (int)(Math.random()*899999) + 100000;
      }
      
      Arrays.sort(arr1);
      Arrays.sort(arr2);
      Arrays.sort(arr3);
      Arrays.sort(arr4);
      Arrays.sort(arr5);
      Arrays.sort(arr6);
      Arrays.sort(arr7);
      Arrays.sort(arr8);
   }
   
   public static void search1()
   {
      for(int i = 0; i<1000; i++)
      {
         if(Arrays.binarySearch(arr1, arr2[i])>=0)
         c1++;
      }
      
      for(int i = 0; i<10000; i++)
      {
         if(Arrays.binarySearch(arr3, arr4[i])>=0)
         c2++;
      }

      for(int i = 0; i<100000; i++)
      {
         if(Arrays.binarySearch(arr5, arr6[i])>=0)
         c3++;
      }

      for(int i = 0; i<1000000; i++)
      {
         if(Arrays.binarySearch(arr7, arr8[i])>=0)
         c4++;
      }

   }}
   
   
   /*
    Trials =  4
 Run = 0 10^3: 1
 Run = 0 10^4: 126
 Run = 0 10^5: 10569
 Run = 0 10^6: 670583
 Run = 1 10^3: 3
 Run = 1 10^4: 106
 Run = 1 10^5: 10595
 Run = 1 10^6: 671533
 Run = 2 10^3: 2
 Run = 2 10^4: 129
 Run = 2 10^5: 10562
 Run = 2 10^6: 671573
 Run = 3 10^3: 0
 Run = 3 10^4: 118
 Run = 3 10^5: 10524
 Run = 3 10^6: 670714
 Average counts:
  10^3=> 1
  10^4=> 119
  10^5=> 10562
  10^6=> 671100
  */
