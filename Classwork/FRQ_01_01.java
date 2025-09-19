/* 
INSTRUCTIONS: Read each prompt carefully. Answers must be written legibly. All responses must use proper Java syntax. 
Follow basic Java conventions for class and variable names. Write your programs with an EOL (End Of Line) style with
care to indentation levels. Failure to follow each of these guidelines will result in 0.5 points taken off for each one.
When a problem requires user input, the >> with spaces on both sides denotes a prompt for user input. After the
user inputs the data request the "Enter" key is pressed. This action is denoted with [ENTER] in the sample run.

(10 points) Write a program tha takes two integer values from the user and prints the product of the two numbers using the
method multiply. You must implement the multiply method. Below is a sample run and a program skeleton.

SAMPLE RUN
Enter first number >> 20 [ENTER]
Enter second number >> 4 [ENTER]
The product of 20 and 4 is 80

PROGRAM SKELETON

import java.util.Scanner
public class FRQ_01_01{
    public static int multiply(int num1, int num2){
    // *Your code here *
    }
    public static void main(String[] args){
    // *Your code here*
    }
    
}

*/

import java.util.Scanner;
public class FRQ_01_01{
    public static int multiply(int num1, int num2){ // a. 2 points
        int product = num1 * num2;
        return product;
    }
    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in); // b. 2 points
        System.out.print("Enter first number >> "); // c. 2 points
        int num1 = userInput.nextInt();
        System.out.print("Enter second number >> "); // d. 2 points
        int num2 = userInput.nextInt();
        int answer = multiply(num1, num2); // e. 2 points
        System.out.print("The product of " + num1 + " and " + num2 + " is " + answer); // f. 1 point
    }
}