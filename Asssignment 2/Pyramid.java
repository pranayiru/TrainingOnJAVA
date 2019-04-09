import java.util.Scanner;
class Pyramid
{
public static void main(String arg[])
{
int row, space, rows, star=0;
Scanner in = new Scanner(System.in);
rows = in.nextInt(); 
System.out.println("You entered integer "+rows); 
  for(row = 1;row <= rows; row++) {
        for(space = 1; space <= rows-row; space++) {
           System.out.print("  ");
        }
        while(star != (2*row - 1)) {
            System.out.print("* ");
            star++;
        }
        star=0;
        System.out.println();
    }

}
}
