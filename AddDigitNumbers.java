package assignment3;

import java.util.Scanner;


public class AddDigitNumbers {

  public static void main(String[] args) {
   
   int number,addition=0,addDigit;
   Scanner in=new Scanner(System.in);
   System.out.println("Enter any more than two digit number::");
   number=in.nextInt();
   while(number>0)
   {
     addDigit=number%10;
     addition=addition+addDigit;
     number= number/10;
   }
   System.out.println("The given number digit addition is::"+addition);
  }
}
