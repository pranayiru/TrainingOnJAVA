import java.util.Scanner;


public class SubStringDemo {

public static String SubString(String str,int a)
{
String str1="";
int len=str.length();
for(int i=a;i<len;i++)
{
str1=str1+str.charAt(i);
}
return str1;
}

  public static void main(String[] args) {
   String str;
   String reverse="";
   Scanner in=new Scanner(System.in);
   
   System.out.println("Enter the string::");
str=in.nextLine();

reverse=SubString(str,4);
System.out.println("Substring::"+reverse);
  }

}
