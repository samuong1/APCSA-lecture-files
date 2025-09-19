/*
INSTRUCTIONS: Read each prompt carefully. Answers must be written legibly. All responses must use proper Java syntax. 
Follow basic Java conventions for class and variable names. Write your programs with an EOL (End Of Line) style with
care to indentation levels. Failure to follow each of these guidelines will result in 0.5 points taken off for each one.
When a problem requires user input, the >> with spaces on both sides denotes a prompt for user input. After the
user inputs the data request the "Enter" key is pressed. This action is denoted with [ENTER] in the sample run.

This question has multiple parts. Please make sure to answer all of them.

(a) Define method overloading in Java. (1 point)

(b) Overload the method multiply in FRQ_01_01 so that it takes three double parameters and returns their product as a double. (3 points)

(c) Write two versions of a method called subtract:
    i. One that is a void method, which prints the result of subtracting two integers. (3 points)
    ii. One that is a non-void method, which returns the result of subtracting two integers. (3 points)
*/

public class FRQ_01_02{
    // Method overloading is when you create a second method with the same name as the first method, but with different arguments. // a. 1 point
    public static double multiply(double num1, double num2, double num3){ // b. 3 points
        double product = num1 * num2 * num3;
        return product;
    }
    public static void subtract(int num1, int num2){ //c. i. 3 points
        System.out.println(num1 - num2);
    }
    public static int subtractNonVoid(int num1, int num2){ // c. ii. 3 points // Method name should be public static int subtract(int num1, int num2){}, changed for purposes of testing
        int answer = num1 - num2;
        return answer;
    }
    public static void main(String[] args){ // Not required, to show functionality
        double multiplyAnswer = multiply(3.4, 5.6, 4.4);
        System.out.println(multiplyAnswer);
        subtract(3,2);
        System.out.println(subtractNonVoid(3, 2));
    }
}