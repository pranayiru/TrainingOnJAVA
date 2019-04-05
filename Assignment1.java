class Assignment1
{
private static int salary=20000;

public void conversion()
{
String letter="1000";
int a=Integer.parseInt(letter);
System.out.println("conversion in string to Int="+a);
}
public void allVariables()
{
int a=10;
float b=20;
double c=30;
long d=40;
short e=4;
byte f=1;
char g='P';
boolean h=true;
System.out.println("a="+a);
System.out.println("b="+b);
System.out.println("c="+c);
System.out.println("d="+d);
System.out.println("e="+e);
System.out.println("f="+f);
System.out.println("g="+g);
System.out.println("h="+h);
}

long multiplication(int x, int y)
{
return x*y;
}

void typeCasting()
{
int a=10;
float fl=(float)a;
System.out.println("type Casting in int to float="+fl);
}

public static void main(String arg[])
{
Assignment1 obj=new Assignment1();
obj.allVariables();
obj.typeCasting();
obj.conversion();
long result = obj.multiplication(10,20);
System.out.println("Multiplication with return type method ="+result);
System.out.println("static with private variable salary ="+salary);
}
}
