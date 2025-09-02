// Title: Compute Circumference
// Author: Sam Uong
// Date: 8/28/2025

// Import the scanner utility for Java (Crucial for getting user input)
import java.util.Scanner;

public class ComputeCircumference{
    public static void main (String[] arg){
        // Creates a scanner object
        Scanner input = new Scanner(System.in);

        // Gets the value for radius
        System.out.print("Enter a value for the radius >> ");
        double radius = input.nextDouble();

        // Calculates the circumference
        double circumference = 2 * 3.1415 * radius;

        System.out.println("The circumference of this circle with radius " + radius + " is " + circumference + ".");
    }
}
