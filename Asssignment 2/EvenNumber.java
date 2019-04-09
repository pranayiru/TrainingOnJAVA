import java.util.Scanner;
class EvenNumber
{
public static void main(String arg[])
{
		int limit = 100;
		
		System.out.println("Printing Even numbers between 1 and " + limit);
		
		for(int i=1; i <= limit; i++){
			if( i % 2 == 0){
				System.out.print(i + " ");
			}
		}
}
}
