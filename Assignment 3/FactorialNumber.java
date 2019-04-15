package assignment3;

import java.util.Scanner;

public class FactorialNumber {

  public static void main(String[] args) {
int number,addition=1;
   Scanner in=new Scanner(System.in);
   System.out.println("Enter number::");
   number=in.nextInt();
   while(number>0)
   {
     addition=addition*number;
     number--;
   }
   System.out.println("The given number's factorial is::"+addition);
  }

}
