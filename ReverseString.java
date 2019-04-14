package assignment3;

import java.util.Scanner;


public class ReverseString {

  public static void main(String[] args) {
   String str;
   String reverse="";
   Scanner in=new Scanner(System.in);
   
   System.out.println("Enter the string::");
str=in.nextLine();
for(int i=str.length()-1;i>=0;i--)
{
  
  reverse=reverse+str.charAt(i);
}
System.out.println(reverse);
  }

}
