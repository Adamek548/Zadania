package hello;
import java.util.Scanner;
public class PrimeFactorsCalculator {
public static void main (String[] args){
Scanner scanner = new Scanner (System.in);
System.out.println("Wprowadź liczbę:");
int Firstnumber = scanner.nextInt();
System.out.print("Czynniki pierwsze liczby " + Firstnumber + "to:" +"\n");
int count;
for(int x=2; x<=(Firstnumber); x++){
count =0;
while (Firstnumber % x ==0){
int Check=(Firstnumber /= x);
count++;
if (count != 0){
System.out.print(Check +"|"+ x +"\n");
}
}
}}}

