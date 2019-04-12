package assignment3;

public class PalindromeNumber {

 static  boolean palimdrom(int num)
  {
    int temp,addDigit,addition=0;
    temp=num;    
    while(num>0)
   {
     addDigit=num%10;
     addition=(addition*10)+addDigit;
     num= num/10;
   }
   if(temp==addition)    
      return true;   
  else    
      return false;    
  
  }

  public static void main(String[] args) {
   int number;
   boolean flag= false ;
   for(number=1;number<=1000;number++)
   {
     flag = palimdrom(number);
     if(flag)
     {
       System.out.print(number+" ");
       flag=false ;
     }
   }
  }

}
