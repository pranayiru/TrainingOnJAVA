package assignment3;

public class FibonacciNumber {

  public static void main(String[] args) {
int a=0,b=1,addition;
   for(int i=1; i<=100;i++)
   {
     System.out.print(a+" ");
     addition = a + b;
      a = b;
      b = addition;
      
   }
   
  }

}
