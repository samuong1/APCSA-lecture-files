// Title: Gratuity Calculator
// Name: Sam Uong
// Date: 9/2/2025

import java.util.Scanner;

public class PS01_04{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the subtotal (ex. 10.50) >>> ");
        double subtotal = scanner.nextDouble();
        System.out.print("Enter the percent gratuity (ex. 15 for 15%) >>> ");
        double gratuity = scanner.nextDouble();
        double finalGratuity = (gratuity / 100) * subtotal;
        double finalTotal = subtotal * finalGratuity;
        System.out.println("The gratuity is $" + finalGratuity + " and the total is $" + finalTotal);
    }
}