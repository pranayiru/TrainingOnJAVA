import java.util.Scanner;
class MaxNumArray
{
    
     public int largest(int[] arr) 
     { 
         int i;  
         int max = arr[0];    
         for (i = 1; i < arr.length; i++) 
             if (arr[i] > max) 
                 max = arr[i]; 
        
         return max; 
     } 
       
     public static void main(String[] args)  
     { 
	MaxNumArray max=new MaxNumArray();
	Scanner in = new Scanner(System.in);
	int[] arr=new int[5];
	for(int i=0;i<5;i++)
	{
		arr[i]=in.nextInt();
	}
	System.out.println("Largest in given array is " + max.largest(arr)); 
     } 
}
