// Title: Sum of digits
// Name: Sam Uong
// Date: 9/2/2025

import java.util.Scanner;

public class PS01_06{
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a positive integer that is less than 1000 >>> ");
        int chosenInteger = input.nextInt();
        int digitOne = chosenInteger % 10;
        chosenInteger = chosenInteger / 10;
        int digitTwo = chosenInteger % 10;
        chosenInteger = chosenInteger / 10;
        int digitThree = chosenInteger % 10;
        int sumOfDigits = digitOne + digitTwo + digitThree;
        System.out.println("The sum of the digits is " + sumOfDigits);
    }
}