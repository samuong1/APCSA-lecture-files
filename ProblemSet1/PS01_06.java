// Title: Sum of digits
// Name: Sam Uong
// Date: 9/2/2025

import java.util.Scanner;

public class PS01_06{
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a positive integer that is less than 1000 >>> ");
        int chosenInteger = input.nextInt();
        int counter = 1;
        int sumOfDigits = 0;
        int digit = 0;
        while (counter < 4){
            digit = chosenInteger % 10;
            sumOfDigits += digit;
            chosenInteger = chosenInteger / 10;
            counter += 1;
        }
        System.out.println("The sum of the digits is " + sumOfDigits);
    }
}