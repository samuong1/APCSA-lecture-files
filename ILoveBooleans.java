// Title: Even
// Name: Sam Uong
// Date: 10/24/25

import static java.lang.System.out;
import java.util.Scanner;

public class ILoveBooleans{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        out.print("Enter an Integer >> ");
        int number = scanner.nextInt();
        if (number % 2 == 0){
            out.println("Eric is bad");
        }
        else {
            out.print("Eric is also bad");
        }
    }
}